package com.example.study.controller.mvc;

import com.example.study.model.entity.Item;
import com.example.study.service.mvc.ItemService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mvc")
public class Usercontroller {

    @Autowired
    ItemService itemService;

    @RequestMapping("")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView();
        List<Item> items = itemService.selectTopBanner();

        mav.addObject("items",items);
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "content";
    }

    @RequestMapping("/single/{id}")
    public ModelAndView detail(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
        Item selectItem = itemService.viewDetail(id);
        if(selectItem==null){
            mav.setViewName("error");
        } else{
            mav.addObject("select_item",selectItem);
            mav.setViewName("single");
        }
        return mav;
    }
}