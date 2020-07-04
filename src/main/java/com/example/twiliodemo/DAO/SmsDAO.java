package com.example.twiliodemo.DAO;

import com.example.twiliodemo.Model.SmsRequest;

public interface SmsDAO {
    void sendSms(SmsRequest smsRequest);
}
