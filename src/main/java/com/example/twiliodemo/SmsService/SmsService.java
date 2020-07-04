package com.example.twiliodemo.SmsService;

import com.example.twiliodemo.Model.SmsRequest;

public interface SmsService {

    void sendSms(SmsRequest smsRequest);
}
