package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setAccount("TestUser04");
        user.setEmail("songsogu@gmail.com");
        user.setPhoneNumber("010-11-122");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("hyanggeun");
        user.setUpdatedAt(LocalDateTime.now());
        User newUser =  userRepository.save(user);
        System.out.println("new User" + newUser);
    }

    @Test
    public void read(){
        //user 테이블에 있는 값을 모두 가져오겠다 findById라는 옵션은 어떤 id를 통해 가져오겠다 라는 함수이다.
       Optional<User> user =  userRepository.findById(2L);
       //Optional이라는 옵션은 있을수도 있고 없을 수도 있다는 뜻이다 그래서 if문으로 존재여부를 알아야한다.
        user.ifPresent(selectUser ->{
            System.out.println("user :"+selectUser);
            System.out.println("email:"+selectUser.getEmail());
        });

    }

    @Test
    @Transactional
    public void update(){
        Optional<User> user = userRepository.findById(2L);
          user.ifPresent(selectUser ->{
                selectUser.setAccount("hello world");
                selectUser.setUpdatedAt(LocalDateTime.now());
                selectUser.setUpdatedBy("update method()");
                userRepository.save(selectUser);
            });
       }
    @Test
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(1L);
        Assert.assertTrue(user.isPresent());
        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });
        Optional<User> deleteUser = userRepository.findById(1L);

        Assert.assertFalse(deleteUser.isPresent());
    }
}
