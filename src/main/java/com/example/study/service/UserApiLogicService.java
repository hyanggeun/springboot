package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.User;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.repository.UserRepository;
import jdk.javadoc.internal.doclets.formats.html.markup.Head;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    //1. request Data 가져오기
    //2. user 생성
    //3. 생성된 데이터 -> UserApiResponse return
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        //request Data 가져오기
        UserApiRequest userApiRequest = request.getData();
        //user 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = userRepository.save(user);
        //생성된 데이더 return
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        //1. repository로부터 데이터 읽어오기
        Optional<User> optionalUser = userRepository.findById(id);



        //2. 생성된 데이터 return
        //map을 이용하면 다른 return형태로 바꾸어서 출력할수 있다.
        return optionalUser
                .map(u -> response(u))
                .orElseGet(()-> Header.Error("에러입니다.")
                );
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        //1.select문으로 데이터를 가져온다.
        UserApiRequest userApiRequest = request.getData();
        Optional<User> optionalUser = userRepository.findById(userApiRequest.getId());
        return optionalUser.map(u ->{
            u.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());
            return u;
        })//데이터가 있다면 user 리턴.
        .map(u -> userRepository.save(u)) //update -> newUser
        .map(newUser -> response(newUser)) //userAPiresponse return
        .orElseGet(()->Header.Error("에러입니다.")); //이중 하나라도 없다면 에러 출력한다.

    }

    @Override
    public Header<Object> delete(Long id) {
        //repository로부터 id에 맞는 user를 가져온다.
        Optional<User> optionalUser = userRepository.findById(id);
        //2. repository -> delete
        return optionalUser
                .map(user ->{
            userRepository.delete(user);
            return Header.Ok();
        }).orElseGet(()->Header.Error("데이터 없음"));

    }

    private Header<UserApiResponse> response(User user){
        //User => userapiResonse
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword()) //Todo 암호화, 길이
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();
        // Header + data
        return Header.Ok(userApiResponse);
    }
}
