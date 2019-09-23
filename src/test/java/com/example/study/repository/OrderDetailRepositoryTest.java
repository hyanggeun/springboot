package com.example.study.repository;
//
//import com.example.study.StudyApplicationTests;
//
//import com.example.study.model.entity.OrderDetail;
//import org.junit.Assert;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.time.LocalDateTime;
//
//public class OrderDetailRepositoryTest extends StudyApplicationTests {
//
//    @Autowired
//    OrderDetailRepository orderDetailRepository;
//
//    @Test
//    public void create(){
//        OrderDetail orderDetail = new OrderDetail();
//        orderDetail.setOrderAt(LocalDateTime.now());
//        //orderDetail.setUserId(8L);
//        //orderDetail.setItemId(1L);
//
//        orderDetailRepository.save(orderDetail);
//        Assert.assertNotNull(orderDetailRepository);
//    }
//
//    @Test
//    public void read(){
//
//    }
//}

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import com.example.study.repository.OrderDetailRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    @Transactional
    public void create(){
        OrderDetail orderDetail = new OrderDetail();
        String status = "testStatus";
        Integer quantity = 10;
        BigDecimal totalPrice = new BigDecimal("100.23");
        BigDecimal totalPrice2 = BigDecimal.valueOf(10000.23);
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "Admin";

        orderDetail.setStatus(status);
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(quantity);
        orderDetail.setTotalPrice(totalPrice2);
        orderDetail.setCreatedAt(createdAt);
        orderDetail.setCreatedBy(createdBy);
//        orderDetail.setOrderGroupId(1L);
//        orderDetail.setItemId(1L);
        OrderDetail newOrderDetail =  orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);
    }

    @Test
    public void read(){

    }
}