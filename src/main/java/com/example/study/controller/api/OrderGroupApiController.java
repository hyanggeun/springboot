package com.example.study.controller.api;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.OrderGroupApiRequest;
import com.example.study.model.network.response.OrderGroupApiResponse;
import com.example.study.service.OrderGroupApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@Slf4j
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    OrderGroupApiLogicService orderGroupApiLogicService;

    @Override
    @PostMapping("")
    public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> request) {
        log.info("{}",request);
        return orderGroupApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<OrderGroupApiResponse> read(@PathVariable Long id) {
        log.info("ID: {}",id);
        return orderGroupApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> request) {
        log.info("{}",request);
        return orderGroupApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        log.info("ID: {}",id);
        return orderGroupApiLogicService.delete(id);
    }
}
