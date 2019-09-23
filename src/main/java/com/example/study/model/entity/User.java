package com.example.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user") //만약 class와 table의 이름이 동일하다면 굳이 선언하지 않아도 된다.
@ToString(exclude = {"orderGroupList"})
@EntityListeners(value = {AuditingEntityListener.class})
//롬복에서 생성자를 코드로 생성해주는 어노테이션
@Builder
// chaining된 형태로 setter을 생성해줄수 있다
// user.setEmain().setPhoneNumber.. 등등
//또한 Chain pattern을 통해서 생성자를 만들어주지 않아도 chain을 통해 set을 할 수 있다.
@Accessors(chain=true)
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
    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;
//    //1:N mappedBy에서 설정해준 이름과 같게 설정해야 한다.
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//    private List<OrderDetail> orderDetailList;
}
