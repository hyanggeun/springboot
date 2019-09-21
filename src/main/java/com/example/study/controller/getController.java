package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //localhost:8080/api까지 매핑되었다.
public class getController {
    @RequestMapping(method= RequestMethod.GET, path="/getMethod") //localhost:8080/api/getMethod
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("/getParameter")  //localhost:8080/getParameter?id=1234&pw=abcd
    public String getParameter(@RequestParam String id, @RequestParam String pw){
        System.out.println(id+" "+pw);
        return id+pw;
    }

    @GetMapping("/getParameter2") // 요청받는 이름에 pw말고 password를 사용할 수도 있다.
    public String getParameter2(@RequestParam String id, @RequestParam(name = "password") String pw){
        String password = "bbbb";
        return id+pw;
    }

    //localhost:8080/api/multiParameter?account=abcd&email=study.co.kr&page=10

    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
//        System.out.println(searchParam.getAccount());
//        System.out.println(searchParam.getEmail());
//       System.out.println(searchParam.getPage());
        // {"account": "" , "email": "", "page": 0}
        return searchParam;
    }

}
