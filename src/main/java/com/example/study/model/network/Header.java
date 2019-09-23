package com.example.study.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.vm.ci.meta.Local;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain=true)
public class Header<T> {
    //api 통신 시간
    //Json반환할 때 아래이름으로 설정해주겠다.
    //하지만 모든 변수들을 아래 방식으로 설정하는 것은 귀찮기 때문에 resource/application.properties아래 설정을 해준다.
   // @JsonProperty("transaction_time")
    private LocalDateTime transactionTime; //ISO, YYYY-mm-dd, HH:mm:ss 등 여러 포맷에 맞추기 위해서 String으로 넘겨주기도 함
    //api 응답 코드
    private String resultCode;
    //api 부가 설명
    private String description;

    //Data 부분 설명
    private T data;

    //OK 요청이 왔을떄 Data가 없는 Ok인 것을 처리해주는 메소드
    public static <T> Header<T> Ok(){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    //Data OK Data가 있는 Ok를 처리해주는 메소드
    public static <T> Header<T> Ok(T data){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    //Error Error의 Ok를 처리해주는 메소드
    public static <T> Header<T> Error(String description){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }
}
