package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {


    // @RequestMapping을 이용하는 방법은 GET API와 크게 다르지 않다.
    // 별도의 리소스를 받지 않고 POST 요청만 받는 메서드를 구현
    @RequestMapping(value="/domain", method= RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

    //RequestBody를 활용한 POST 메서드 구현
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));

        return sb.toString();
    }

    @PostMapping(value="/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

}


