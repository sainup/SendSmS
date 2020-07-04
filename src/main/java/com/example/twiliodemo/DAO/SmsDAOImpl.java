package com.example.twiliodemo.DAO;

import com.example.twiliodemo.TwilioConfiguration.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.twiliodemo.Model.SmsRequest;

import javax.persistence.EntityManager;

@Repository
public class SmsDAOImpl implements SmsDAO {

    private final TwilioConfiguration twilioConfiguration;
    private final EntityManager entityManager;

    @Autowired
    public SmsDAOImpl(TwilioConfiguration twilioConfiguration, EntityManager entityManager) {
        this.twilioConfiguration = twilioConfiguration;
        this.entityManager = entityManager;
    }


    @Override
    public void sendSms(SmsRequest smsRequest) {

        Session session = entityManager.unwrap(Session.class);

        PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber((twilioConfiguration.getTrialPhoneNumber()));
        String message  = smsRequest.getMessage();
        MessageCreator creator = Message.creator(to,from,message);
        creator.create();

        session.saveOrUpdate(smsRequest);

    }
}
