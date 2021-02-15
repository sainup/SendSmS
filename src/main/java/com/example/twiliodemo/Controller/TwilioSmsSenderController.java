package com.example.twiliodemo.Controller;

import com.example.twiliodemo.Model.SmsRequest;
import com.example.twiliodemo.SmsService.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/sender")
public class TwilioSmsSenderController {

    private final SmsService smsService;

    @Autowired
    public TwilioSmsSenderController(SmsService smsService) {
        this.smsService = smsService;
    }

    @GetMapping("/sendSms")
    public String showSmsForm(Model theModel){

        SmsRequest smsRequest =  new SmsRequest();

        theModel.addAttribute("sms",smsRequest);
        return "sms-sender";
    }

    @PostMapping("/sendingSms")
    public String sendSms(@Valid @ModelAttribute("sms")SmsRequest smsRequest,
                          BindingResult theBindingResult, Model theModel){

        if(theBindingResult.hasErrors()){
           theModel.addAttribute("errorMsg","Error sending message!");
            return "sms-sender";
        }else {
            smsService.sendSms(smsRequest);
            theModel.addAttribute("successMsg","Message sent successfully!");
            return "redirect:/sender/sendSms";
        }

    }
}
