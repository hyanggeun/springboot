package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.OrderGroup;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.OrderGroupApiRequest;
import com.example.study.model.network.response.OrderGroupApiResponse;
import com.example.study.repository.OrderGroupRepository;
import com.example.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderGroupApiLogicService implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
        OrderGroupApiRequest orderGroupApiRequest = request.getData();
        OrderGroup orderGroup = OrderGroup.builder()
                .status(orderGroupApiRequest.getStatus())
                .orderType(orderGroupApiRequest.getOrderType())
                .revAddress(orderGroupApiRequest.getRevAddress())
                .revName(orderGroupApiRequest.getRevName())
                .paymentType(orderGroupApiRequest.getPaymentType())
                .totalPrice(orderGroupApiRequest.getTotalPrice())
                .totalQuantity(orderGroupApiRequest.getTotalQuantity())
                .orderAt(LocalDateTime.now())
                .user(userRepository.getOne(orderGroupApiRequest.getUserId()))
                .build();
        orderGroupRepository.save(orderGroup);
        return response(orderGroup);
    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {
        //1. select 하기
        Optional<OrderGroup> orderGroup = orderGroupRepository.findById(id);
        //return하기
        return orderGroup.map(this::response)
        .orElseGet(()->Header.Error("데이터가 없습니다."));

    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
        //1. 데이터 Select하기
        OrderGroupApiRequest orderGroupApiRequest = request.getData();
        Optional<OrderGroup> orderGroup = orderGroupRepository.findById(orderGroupApiRequest.getId());
        //2. 데이터 Update하기
        //3. return Response
        return orderGroup.map(select ->{
            return select.setStatus(orderGroupApiRequest.getStatus())
                    .setOrderType(orderGroupApiRequest.getOrderType())
                    .setRevAddress(orderGroupApiRequest.getRevAddress())
                    .setRevName(orderGroupApiRequest.getRevName())
                    .setPaymentType(orderGroupApiRequest.getPaymentType())
                    .setTotalPrice(orderGroupApiRequest.getTotalPrice())
                    .setTotalQuantity(orderGroupApiRequest.getTotalQuantity())
                    .setOrderAt(LocalDateTime.now())
                    .setArrivalDate(LocalDateTime.now().plusDays(3))
                    .setUser(userRepository.getOne(orderGroupApiRequest.getUserId()));
        }).map(s ->{
            orderGroupRepository.save(s);
            return s;
        }).map(sel -> response(sel))
        .orElseGet(()->Header.Error("데이터가 없습니다."));
    }

    @Override
    public Header delete(Long id) {
        //1. 삭제될 데이터 선택
        Optional<OrderGroup> orderGroup = orderGroupRepository.findById(id);
        return orderGroup.map(sel -> {
            orderGroupRepository.delete(sel);
            return Header.Ok();
        })
        .orElseGet(()->Header.Error("데이터가 없습니다"));
    }


    private Header<OrderGroupApiResponse> response(OrderGroup orderGroup){
        OrderGroupApiResponse orderGroupApiResponse =  OrderGroupApiResponse.builder()
                .id(orderGroup.getId())
                .status(orderGroup.getStatus())
                .orderType(orderGroup.getOrderType())
                .revAddress(orderGroup.getRevAddress())
                .revName(orderGroup.getRevName())
                .paymentType(orderGroup.getPaymentType())
                .totalPrice(orderGroup.getTotalPrice())
                .totalQuantity(orderGroup.getTotalQuantity())
                .orderAt(orderGroup.getOrderAt())
                .arrivalDate(orderGroup.getArrivalDate())
                .userId(orderGroup.getUser().getId())
                .build();
        return Header.Ok(orderGroupApiResponse);
    }
}
