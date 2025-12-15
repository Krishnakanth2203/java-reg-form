package com.example.RegForm.repository;

import com.example.RegForm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {
    boolean existsByEmail (String email);
    boolean existsByNumber (String number);
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
    Optional<UserEntity> findByNumberAndPassword(String number, String password);

}