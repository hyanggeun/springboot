package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Category;
import jdk.vm.ci.meta.Local;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends StudyApplicationTests {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void create(){
        Category category = new Category();
        String type ="컴퓨터";
        String title="Computer";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "Admin";
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);
        Category newCategory = categoryRepository.save(category);
        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(),type);
        Assert.assertEquals(newCategory.getCreatedAt(),createdAt);
        Assert.assertEquals(newCategory.getCreatedBy(),createdBy);
        Assert.assertEquals(newCategory.getTitle(),title);
    }

    @Test
    public void read(){
        Category category = new Category();
        String type ="컴퓨터";
        String title="Computer";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "Admin";
        // select * from category where id=?
        Optional<Category> findCategory = categoryRepository.findByType(type);
        findCategory.ifPresent(read ->{
            Assert.assertEquals(read.getTitle(),title);
            Assert.assertEquals(read.getType(),type);
            Assert.assertEquals(read.getCreatedBy(),createdBy);
            System.out.println(read.getTitle());
        });
    }
}
