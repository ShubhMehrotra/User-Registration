package com.shubh.notification.Notification.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendNotification(String to, String subject, String message) {

        try{
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(to);
            email.setSubject(subject);
            email.setText(message);
            email.setFrom("ShubhMehro@gmail.com");
            mailSender.send(email);
            System.out.println("Mail sent to: " + to);
        }catch (Exception e){
            System.out.println("Error sending email: " + e.getMessage());
        }

    }
}
