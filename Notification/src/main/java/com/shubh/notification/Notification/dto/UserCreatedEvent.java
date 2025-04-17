package com.shubh.notification.Notification.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserCreatedEvent(UUID userId,
                               String userName,
                               String email,
                               LocalDateTime createdAt) {


    @JsonCreator
    public UserCreatedEvent(
            @JsonProperty("userId") UUID userId,
            @JsonProperty("userName") String userName,
            @JsonProperty("email") String email,
            @JsonProperty("createdAt") LocalDateTime createdAt
    ) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;

    }
}
