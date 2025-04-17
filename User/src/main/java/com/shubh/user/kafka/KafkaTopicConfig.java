package com.shubh.user.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${app.kafka.topic}")
    private String topicName;

    @Bean
    public NewTopic userCreatedTopic(){

        return TopicBuilder.name(topicName)
                .partitions(3)
                .replicas(1)
                .build();
    }


    @Bean
    public NewTopic deadLetterTopic()
    {

        return TopicBuilder.name(topicName+"_DLQ")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
