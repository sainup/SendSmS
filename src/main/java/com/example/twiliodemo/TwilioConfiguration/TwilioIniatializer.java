package com.example.twiliodemo.TwilioConfiguration;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioIniatializer {

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioIniatializer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;

        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
    }
}
