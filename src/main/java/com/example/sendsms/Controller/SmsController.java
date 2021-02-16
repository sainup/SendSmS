package com.example.sendsms.Controller;

import com.example.sendsms.Exception.SmsException;
import com.example.sendsms.Model.SmsRequest;
import com.example.sendsms.SmsService.SmsService;
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
@RequestMapping("/sendSms")
public class SmsController {

    private final SmsService smsService;

    @Autowired
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    //To show the form for sending message
    @GetMapping()
    public String showSmsForm(Model theModel) {

        SmsRequest smsRequest = new SmsRequest();

        theModel.addAttribute("sms", smsRequest);
        return "send-form";
    }


    //sends message and if errors occurs, handles it
    @PostMapping()
    public String sendSms(@Valid @ModelAttribute("sms") SmsRequest smsRequest,
                          BindingResult theBindingResult, RedirectAttributes redirectAttributes) {

        if (!theBindingResult.hasErrors()) {
            try {
                smsService.sendSms(smsRequest);
                redirectAttributes.addFlashAttribute("statusMessage", "Message sent successfully!");

            } catch (SmsException e) {
                System.out.println("Error: " + e);
                redirectAttributes.addFlashAttribute("statusMessage", e.getMessage());
            }
        } else {
            redirectAttributes.addFlashAttribute("statusMessage", "Error sending message!");
            return "send-form";
        }
        return "redirect:/sendSms";
    }
}
