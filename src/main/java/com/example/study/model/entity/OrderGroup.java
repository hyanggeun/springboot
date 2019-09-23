package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString(exclude = {"user","orderDetailList"})
public class OrderGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String orderType;
    private String revAddress;
    private String revName;
    private String paymentType; //카드 또는 현금
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    @ManyToOne
    private User user;
    // orderGroup 1 : orderDetail N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;

}
