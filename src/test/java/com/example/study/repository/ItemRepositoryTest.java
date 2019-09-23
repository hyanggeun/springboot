//package com.example.study.repository;
//
//import com.example.study.StudyApplicationTests;
//import com.example.study.model.entity.Item;
//import com.example.study.model.entity.OrderDetail;
//import com.example.study.model.entity.User;
//import org.hibernate.criterion.Order;
//import org.junit.Assert;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Optional;
//
////    private Long id;
////
////    private String name;
////
////    private Integer price;
////
////    private String content;
//
////무조건 StudyApplicationTests를 상속받아줘야한다.. 헷갈리지 말자..
//public class ItemRepositoryTest extends StudyApplicationTests {
//
//    @Autowired
//    private ItemRepository itemRepository;
//    @Test
//    public void create(){
//         Item item = new Item();
//
//         item.setName("노트북");
//         item.setPrice(100000);
//         item.setContent("삼성 노트북");
//
//         Item newItem = itemRepository.save(item);
//         Assert.assertNotNull(newItem);
//    }
//
//    @Test
//    @Transactional
//    public void read(){
//        Long id = 1L;
////
////        Optional<Item> item = itemRepository.findById(id);
////        Assert.assertTrue(item.isPresent());
////        item.ifPresent(i -> {//package com.example.study.repository;
////
////import com.example.study.StudyApplicationTests;
////import com.example.study.model.entity.Item;
////import com.example.study.model.entity.OrderDetail;
////import com.example.study.model.entity.User;
////import org.hibernate.criterion.Order;
////import org.junit.Assert;
////import org.junit.Test;
////import org.springframework.beans.factory.annotation.Autowired;
////
////import javax.transaction.Transactional;
////import java.util.List;
////import java.util.Optional;
////
//////    private Long id;
//////
//////    private String name;
//////
//////    private Integer price;
//////
//////    private String content;
////
//////무조건 StudyApplicationTests를 상속받아줘야한다.. 헷갈리지 말자..
////public class ItemRepositoryTest extends StudyApplicationTests {
////
////    @Autowired
////    private ItemRepository itemRepository;
////    @Test
////    public void create(){
////         Item item = new Item();
////
////         item.setName("노트북");
////         item.setPrice(100000);
////         item.setContent("삼성 노트북");
////
////         Item newItem = itemRepository.save(item);
////         Assert.assertNotNull(newItem);
////    }
////
////    @Test
////    @Transactional
////    public void read(){
////        Long id = 1L;
//////
//////        Optional<Item> item = itemRepository.findById(id);
//////        Assert.assertTrue(item.isPresent());
//////        item.ifPresent(i -> {
//////            System.out.println(i);
//////        });
////        Optional<Item> item = itemRepository.findById(1L);
////        item.ifPresent(presentItem ->{
////            presentItem.getOrderDetailList().stream().forEach(st -> {
////                User user = st.getUser();
////                System.out.println(user.getAccount());
////            });
////        });
////    }
////
////}
////            System.out.println(i);
////        });
//        Optional<Item> item = itemRepository.findById(1L);
//        item.ifPresent(presentItem ->{
//            presentItem.getOrderDetailList().stream().forEach(st -> {
//                User user = st.getUser();
//                System.out.println(user.getAccount());
//            });
//        });
//    }
//
//}
