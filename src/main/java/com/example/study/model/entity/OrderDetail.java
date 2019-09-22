package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="order_detail")
//서로 연관되어 참조하는 객체에 대해서는 상호참조를 계속 하기 때문에 exclude를 시켜줘야 한다.
@ToString(exclude = {"user","item"})
public class OrderDetail {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private LocalDateTime orderAt;
        //N:1 반드시
        // 객체의 이름을 지정해줘야 한다.
        // 그러면 Hibernate에서 자동으로 user_id를 찾아가게 된다.
        @ManyToOne
        private User user;
        @ManyToOne
        //private Long itemId;
        private Item item;

}
