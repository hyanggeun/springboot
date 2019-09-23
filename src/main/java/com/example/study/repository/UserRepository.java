package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //가장 최근에 들어온 쿼리만 처리해준다.
    Optional<User> findFirstByPhoneNumber(String phoneNumber);
//
//    Optional<User> findByEmail(String email);
//    Optional<User> findByAccount(String account);
//    Optional<User> findByEmailAndAccount(String email, String account);
}
