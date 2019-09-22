package com.example.study.repository;

import com.example.study.StudyApplicationTests;

import com.example.study.model.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());
        //orderDetail.setUserId(8L);
        //orderDetail.setItemId(1L);

        orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(orderDetailRepository);
    }

    @Test
    public void read(){

    }
}
