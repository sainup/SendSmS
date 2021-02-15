package com.example.twiliodemo.SMSHandler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MessageStatus", urlPatterns = {"/MessageStatus"})
public class MessageStatus extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String messageSid = request.getParameter("MessageSid");
        String messageStatus = request.getParameter("MessageStatus");

        System.out.println("SID: " + messageSid + ", Status:" + messageStatus);
    }
}