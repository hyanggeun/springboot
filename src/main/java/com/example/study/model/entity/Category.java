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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"partnerList"})
//여기있는 Entitiy들을 감시하겠다는 annotation AuditingEntityListener 클래스의 값으로 저장해주겠다는 의미
@EntityListeners(value = {AuditingEntityListener.class})
@Builder
@Accessors(chain=true)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String title;
    //감시되는 항목이다.
    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Partner> partnerList;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
//    private List<Partner> partnerList;
}
