package com.example.sendsms.DAO;

import com.example.sendsms.Exception.SmsException;
import com.example.sendsms.TwilioConfiguration.TwilioConfiguration;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;

import com.twilio.type.PhoneNumber;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sendsms.Model.SmsRequest;

import javax.persistence.EntityManager;


@Repository
public class SmsDAOImpl implements SmsDAO {

    private final TwilioConfiguration twilioConfiguration;
    private final EntityManager entityManager;

    //Injects the dependencies
    @Autowired
    public SmsDAOImpl(TwilioConfiguration twilioConfiguration, EntityManager entityManager) {
        this.twilioConfiguration = twilioConfiguration;
        this.entityManager = entityManager;
    }

    //sends message and if errors occurs throws exception
    @Override
    public void sendSms(SmsRequest smsRequest) {
        try{
            handleSms(smsRequest);
        }catch (ApiException e){
            if(e.getCode() == 21408){
                throw new SmsException("Permission to send an SMS has not been enable for the number : " + smsRequest.getPhoneNumber());
            }else{
                e.printStackTrace();
                System.out.println(e.getCode());
                throw new SmsException("500 Internal Server Error. Please try again later");

            }
        }

    }

    //handles the sms request
    private void handleSms(SmsRequest smsRequest) {
        Session session = entityManager.unwrap(Session.class);

        PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber((twilioConfiguration.getTrialPhoneNumber()));
        String message  = smsRequest.getMessage();
        MessageCreator creator = Message.creator(to,from,message);
        creator.create();

        session.saveOrUpdate(smsRequest);
    }


}
