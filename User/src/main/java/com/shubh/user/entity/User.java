package com.shubh.user.entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long userId;
    @Column(unique = true, nullable = false)
    private String userName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private LocalDateTime createdAt;


    @PrePersist
    protected void onCreate(){
        this.createdAt=LocalDateTime.now();
    }
}
