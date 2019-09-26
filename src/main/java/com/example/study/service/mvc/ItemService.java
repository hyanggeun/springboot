package com.example.study.service.mvc;

import com.example.study.ifs.ItemInterface;
import com.example.study.model.entity.Item;
import com.example.study.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements ItemInterface {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item viewDetail(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        return optionalItem.map(select ->{
            Item i = select;
            return i;
        })
        .orElse(null);
    }

    @Override
    public List<Item> selectTopBanner() {
        return itemRepository.findTop6ByOrderByIdDesc();
    }

//    public List<Item> selectAllItem(){
//        return itemRepository.findTop6ByOrderByIdDesc();
//    }
}
