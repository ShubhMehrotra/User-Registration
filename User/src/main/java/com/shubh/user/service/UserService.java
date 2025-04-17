package com.shubh.user.service;

import com.shubh.user.dto.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void registerUser(UserRequest request);
}
