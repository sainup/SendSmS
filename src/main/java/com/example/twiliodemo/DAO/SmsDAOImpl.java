package com.example.twiliodemo.DAO;

import com.example.twiliodemo.TwilioConfiguration.TwilioConfiguration;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.example.twiliodemo.Model.SmsRequest;

import javax.persistence.EntityManager;
import java.net.URI;

@Repository
public class SmsDAOImpl implements SmsDAO {

    private final TwilioConfiguration twilioConfiguration;
    private final EntityManager entityManager;
    private Environment environment;

    @Autowired
    public SmsDAOImpl(TwilioConfiguration twilioConfiguration, EntityManager entityManager) {
        this.twilioConfiguration = twilioConfiguration;
        this.entityManager = entityManager;
    }


    @Override
    public void sendSms(SmsRequest smsRequest) {

        try{
            Session session = entityManager.unwrap(Session.class);

            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber((twilioConfiguration.getTrialPhoneNumber()));
            String message  = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to,from,message);
            creator.create();


            session.saveOrUpdate(smsRequest);
        }catch (ApiException e){
            System.out.println("Error Occurred : - " + e.getMessage());
        }


    }
}
