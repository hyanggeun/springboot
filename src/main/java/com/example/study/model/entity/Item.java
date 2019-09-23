package com.example.study.model.entity;

import jdk.vm.ci.meta.Local;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderDetailList","partner"})
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String name;
    private String title;
    private String content;
    private BigDecimal price;
    private String brandName;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    List<OrderDetail> orderDetailList;
    @ManyToOne
    private Partner partner;
    //서로 연관되어 참조하는 객체에 대해서는 상호참조를 계속 하기 때문에 exclude를 시켜줘야 한다.
    //fetch 타입에는 LAZY= 지연로딩, EAGER=즉시로딩 타입 둘다 존재한다.
    //LAZY = select * from item where id = ?
    //EAGER =
    //item_id= order_detail.item_id
    //user_id= order_detail.user_id
    //연관관계가 설정된 모든 데이터를 조인해서 가져오게 된다.
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
//    private List<OrderDetail> orderDetailList;
}
