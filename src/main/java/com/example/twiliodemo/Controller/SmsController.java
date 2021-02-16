package com.example.twiliodemo.Controller;

import com.example.twiliodemo.Exception.SmsException;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/sender")
public class SmsController {

    private final SmsService smsService;

    @Autowired
    public SmsController(SmsService smsService) {
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
                          BindingResult theBindingResult, RedirectAttributes redirectAttributes){


            if(!theBindingResult.hasErrors()){

                try{
                    smsService.sendSms(smsRequest);
                    redirectAttributes.addFlashAttribute("statusMessage","Message sent successfully!");

                }catch (SmsException e){
                    System.out.println(e);
                    redirectAttributes.addFlashAttribute("statusMessage",e.getMessage());
                }

            }else {

                redirectAttributes.addFlashAttribute("statusMessage","Error sending message!");
                return "sms-sender";
            }


        return "redirect:/sender/sendSms";

    }
}
