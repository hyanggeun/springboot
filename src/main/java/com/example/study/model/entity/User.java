package com.example.study.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user") //만약 class와 table의 이름이 동일하다면 굳이 선언하지 않아도 된다.
public class User {
    //@Column(name = "id") 만약 동일하다면 구지 선언해주지 않는다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //BIGINT
    private String password;
    private String status;
    private String account;
    private String email;
    private String phoneNumber; //JPA에서는 camel 과 snake 타입을 자동으로 변환시켜줘서 변환시킬필요 없다.
    private LocalDateTime registeredAt;
    private String unregisteredAt;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
//    //1:N mappedBy에서 설정해준 이름과 같게 설정해야 한다.
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//    private List<OrderDetail> orderDetailList;
}
