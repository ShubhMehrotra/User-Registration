package com.shubh.user.repo;

import com.shubh.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo  extends JpaRepository<User, UUID> {
}
