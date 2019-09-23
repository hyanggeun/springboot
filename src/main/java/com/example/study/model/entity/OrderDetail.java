package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"orderGroup","item"})
//서로 연관되어 참조하는 객체에 대해서는 상호참조를 계속 하기 때문에 exclude를 시켜줘야 한다.
//@ToString(exclude = {"user","item"})
public class OrderDetail {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String status;
        private LocalDateTime arrivalDate;
        private Integer quantity;
        private BigDecimal totalPrice;
        private LocalDateTime createdAt;
        private String createdBy;
        private LocalDateTime updatedAt;
        private String updatedBy;
       //private Long itemId;
        //orderDetail N : orderGroup 1
        @ManyToOne
        private OrderGroup orderGroup;
        @ManyToOne
        private Item item;
        //N:1 반드시
        // 객체의 이름을 지정해줘야 한다.
        // 그러면 Hibernate에서 자동으로 user_id를 찾아가게 된다.
//        @ManyToOne
//        private User user;
//        @ManyToOne
//        //private Long itemId;
//        private Item item;

}
