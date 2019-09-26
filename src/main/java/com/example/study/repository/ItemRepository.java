package com.example.study.repository;

import com.example.study.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//JpaRepository에서는<Item, Long> 이 나오는데 첫번째는 어떤 값을 넘길건지, 두번쨰는
// PK의 자료형을 넘겨주게 된다.

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    public List<Item> findTop6ByOrderByIdDesc();
}
