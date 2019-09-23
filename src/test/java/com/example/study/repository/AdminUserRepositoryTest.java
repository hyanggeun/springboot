package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.AdminUser;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AdminUserRepositoryTest extends StudyApplicationTests {

    @Autowired
    AdminUserRepository adminUserRepository;

    @Test
    public void create(){
        AdminUser adminUser = new AdminUser();
        String account = "TestAccount";
        String password = "Password";
        String status = "Status";
        String role = "role";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "Admin";
        adminUser.setAccount(account);
        adminUser.setPassword(password);
        adminUser.setStatus(status);
        adminUser.setRole(role);
        adminUser.setCreatedAt(createdAt);
        adminUser.setCreatedBy(createdBy);
        AdminUser testAdminUser = adminUserRepository.save(adminUser);
        Assert.assertNotNull(testAdminUser);
    }
}
