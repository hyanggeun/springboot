package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
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
    public void create() {
        String Account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test@gmail.com";
        String phoneNumber = "010-111-111";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "Admin";
        User user = new User();
        user.setAccount(Account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);
        User newUser = userRepository.save(user);
        System.out.println("new User" + newUser);
        Assert.assertNotNull(newUser);
    }

    @Test
    public void read(){
        String Account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test@gmail.com";
        String phoneNumber = "010-111-111";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "Admin";
        Optional<User> optionalUser = userRepository.findFirstByPhoneNumber(phoneNumber);
        Assert.assertNotNull(optionalUser);
        optionalUser.ifPresent(s ->{
            Assert.assertEquals(s.getAccount(), Account);
            Assert.assertEquals(s.getCreatedBy(),createdBy);
            Assert.assertEquals(s.getPassword(),password);
            System.out.println(s.getAccount()+" "+s.getEmail());
        });
    }
}
//    @Test
//    @Transactional
//    public void read(){
        //user 테이블에 있는 값을 모두 가져오겠다 findById라는 옵션은 어떤 id를 통해 가져오겠다 라는 함수이다.
//       Optional<User> user =  userRepository.findById(8L);
       //Optional이라는 옵션은 있을수도 있고 없을 수도 있다는 뜻이다 그래서 if문으로 존재여부를 알아야한다.
//        user.ifPresent(selectUser ->{
//            System.out.println("user :"+selectUser);
//            System.out.println("email:"+selectUser.getEmail());
//        });
//        Optional<User> user= userRepository.findById(8L);
//        Optional<User> user = userRepository.findByAccount("TestUser04");
//        user.ifPresent(selectUser-> {
//            selectUser.getOrderDetailList().stream().forEach(detail ->{
//                Item item = detail.getItem();
//                System.out.println(item);
//            });
//        });
//    }
//
//    @Test
//    public void update(){
//        Optional<User> user = userRepository.findById(2L);
//          user.ifPresent(selectUser ->{
//                selectUser.setAccount("hello world");
//                selectUser.setUpdatedAt(LocalDateTime.now());
//                selectUser.setUpdatedBy("update method()");
//                userRepository.save(selectUser);
//            });
//       }
//    @Test
//    @Transactional
//    public void delete(){
//        Optional<User> user = userRepository.findById(1L);
//        Assert.assertTrue(user.isPresent());
//        user.ifPresent(selectUser -> {
//            userRepository.delete(selectUser);
//        });
//        Optional<User> deleteUser = userRepository.findById(1L);
//
//    @Test
//    public void update(){
//        Optional<User> user = userRepository.findById(2L);
//          user.ifPresent(selectUser ->{
//                selectUser.setAccount("hello world");
//                selectUser.setUpdatedAt(LocalDateTime.now());
//                selectUser.setUpdatedBy("update method()");
//                userRepository.save(selectUser);
//            });
//       }
//    @Test
//    @Transactional
//    public void delete(){
//        Optional<User> user = userRepository.findById(1L);
//        Assert.assertTrue(user.isPresent());
//        user.ifPresent(selectUser -> {
//            userRepository.delete(selectUser);
//        });
//        Optional<User> deleteUser = userRepository.findById(1L);
//
//        Assert.assertFalse(deleteUser.isPresent());
//    }
//        Assert.assertFalse(deleteUser.isPresent());
//    }
//}
//    @Test
//    public void update(){
//        Optional<User> user = userRepository.findById(2L);
//          user.ifPresent(selectUser ->{
//                selectUser.setAccount("hello world");
//                selectUser.setUpdatedAt(LocalDateTime.now());
//                selectUser.setUpdatedBy("update method()");
//                userRepository.save(selectUser);
//            });
//       }
//    @Test
//    @Transactional
//    public void delete(){
//        Optional<User> user = userRepository.findById(1L);
//        Assert.assertTrue(user.isPresent());
//        user.ifPresent(selectUser -> {
//            userRepository.delete(selectUser);
//        });
//        Optional<User> deleteUser = userRepository.findById(1L);
//
//        Assert.assertFalse(deleteUser.isPresent());
//    }
