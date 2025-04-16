package com.shubh.user.dto;
import java.time.LocalDateTime;


public record UserCreatedEvent(java.util.UUID userId, String userName, String email, LocalDateTime createdAt) {
}
