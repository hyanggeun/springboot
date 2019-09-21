package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class postController {
    //HTML <form>
    // ajax 검색에 사용된다.
    // http post body -> data
    // json, xml, multipart-form / text-plain
    //@RequestMapping(method = RequestMethod.POST, path="/postMethod")

    @PostMapping(value = "/postMethod", produces = {"application/json"})
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put(){

    }

    @PatchMapping("/patchMethod")
    public void patch()
    {

    }
}
