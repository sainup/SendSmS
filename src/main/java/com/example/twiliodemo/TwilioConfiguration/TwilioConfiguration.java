package com.example.twiliodemo.TwilioConfiguration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfiguration {


    private   String accountSid = "ACc4ec1797d898b0e3fbcadc2f2df5ca75";

    private  String authToken = "3a29e5b3046204972e631b42ed911700";
    private String trialPhoneNumber = "+12023189705" ;


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
