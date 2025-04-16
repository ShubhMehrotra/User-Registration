package com.shubh.user.service;

import com.shubh.user.dto.UserRequest;
import com.shubh.user.entity.User;
import com.shubh.user.kafka.UserProducer;
import com.shubh.user.dto.UserCreatedEvent;
import com.shubh.user.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserProducer userProducer;

    @Override
    public void registerUser(UserRequest request) {
      User user = new User();
      BeanUtils.copyProperties(request,user);
      userRepo.save(user);
      userProducer.sendUserCreatedEvent(new UserCreatedEvent(user.getUserId(),user.getUserName(),user.getEmail(),user.getCreatedAt()));



    }
}
