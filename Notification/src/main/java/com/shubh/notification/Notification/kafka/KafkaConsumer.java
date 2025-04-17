package com.shubh.notification.Notification.kafka;

import com.shubh.notification.Notification.Service.NotificationServiceImpl;
import com.shubh.notification.Notification.dto.UserCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private NotificationServiceImpl service;

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "userCreatedEventListener")
    public void consumeUserCreatedEvent(UserCreatedEvent event) {
        String to = event.email();
        String subject = "Welcome to our service!";
        String message = "Hello " + event.userName()+ ",\n\nThank you for registering with us!\n\nBest regards,\nYour Company";
        service.sendNotification(to, subject, message);
    }

}
