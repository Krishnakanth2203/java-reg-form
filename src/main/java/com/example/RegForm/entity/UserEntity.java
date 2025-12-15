package com.example.RegForm.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String number;
    private String address;
    @Column(nullable = false)
    private String password;

}