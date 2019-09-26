package com.example.study.ifs;

import com.example.study.model.entity.Item;

import java.util.List;

public interface ItemInterface {
    public Item viewDetail(Long id);
    public List<Item> selectTopBanner();

}
