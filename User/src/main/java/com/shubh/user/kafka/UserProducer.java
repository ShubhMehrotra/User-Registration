package com.shubh.user.kafka;

import com.shubh.user.dto.UserCreatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    private final KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;

    @Value("${app.kafka.topic}")
    private String topic;

    public UserProducer(KafkaTemplate<String, UserCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserCreatedEvent(UserCreatedEvent userCreatedEvent) {
        kafkaTemplate.send(topic, userCreatedEvent);
    }
}
