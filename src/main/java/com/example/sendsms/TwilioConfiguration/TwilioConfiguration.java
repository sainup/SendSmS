package com.example.sendsms.TwilioConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfiguration {


    @Value("${twilio.accountSid}")
    private   String accountSid;
    @Value("${twilio.auth_token}")
    private  String authToken ;
    @Value("${twilio.phoneNumber}")
    private String trialPhoneNumber  ;


    public TwilioConfiguration(){}

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getTrialPhoneNumber() {
        return trialPhoneNumber;
    }

    public void setTrialPhoneNumber(String trialPhoneNumber) {
        this.trialPhoneNumber = trialPhoneNumber;
    }
}
