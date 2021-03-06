package com.example.sendsms.SmsService;

import com.example.sendsms.DAO.SmsDAO;
import com.example.sendsms.Model.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SmsServiceImpl implements  SmsService{

    private final SmsDAO smsDAO;

    @Autowired
    public SmsServiceImpl(SmsDAO smsDAO) {
        this.smsDAO = smsDAO;
    }


    @Override
    @Transactional
    public void sendSms(SmsRequest smsRequest) {
        smsDAO.sendSms(smsRequest);
    }


}
