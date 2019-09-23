package com.example.study.controller.api;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
//로그를 보기 위한 어노테이션
@Slf4j
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("") //api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{},{}",request,"ABC"); //request, ABC라고 로그가 찍히게 됨.
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") //api/user/{id}
    public Header<UserApiResponse> read(@PathVariable Long id) {
        log.info("Id : {}",id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("") // /api/user/{id}
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        log.info("{}",request);
        return userApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}") //api/user/{id}
    public Header delete(@PathVariable Long id) {

        return userApiLogicService.delete(id);
    }

}
