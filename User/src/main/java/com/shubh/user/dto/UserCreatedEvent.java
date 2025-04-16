package com.shubh.user.dto;

import java.time.LocalDateTime;

public record UserCreatedEvent(Long userId, String fullName, String email, LocalDateTime createdAt) {
}
