package com.example.study.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private String account;
    private String email;
    private String phoneNumber; //JPA에서는 camel 과 snake 타입을 자동으로 변환시켜줘서 변환시킬필요 없다.
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;

}
