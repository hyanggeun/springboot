package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderGroup;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderGroupRepositoryTest extends StudyApplicationTests {

    @Autowired
    OrderGroupRepository orderGroupRepository;

    @Test
    public void create(){
        OrderGroup orderGroup = new OrderGroup();
        String status = "testStatus";
        String orderType = "testType";
        String revAddress = "testAddress";
        String revName = "testName";
        String paymentType = "testType";
        BigDecimal totalPrice = new BigDecimal(100.23);
        Integer totalQuantity = 100;
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "Admin";
        Long userId = 1L;

        orderGroup.setStatus(status);
        orderGroup.setOrderType(orderType);
        orderGroup.setRevAddress(revAddress);
        orderGroup.setRevName(revName);
        orderGroup.setPaymentType(paymentType);
        orderGroup.setTotalPrice(totalPrice);
        orderGroup.setTotalQuantity(totalQuantity);
        orderGroup.setCreatedAt(createdAt);
        orderGroup.setCreatedBy(createdBy);
        orderGroup.setUserId(userId);
        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
        Assert.assertNotNull(newOrderGroup);
    }



}
