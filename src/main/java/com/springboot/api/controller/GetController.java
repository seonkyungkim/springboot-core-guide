package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String getHello(){
        LOGGER.info("getHello 메서드가 호출되었습니다.");
        return "Hello World";
    }
    // 그러나 스프링 4.3 버전 이후로는 새로 나온 아래의 어노테이션을 사용하기 때문에 @RequestMapping 어노테이션은 더 이상 사용되지 않는다.
    // 각 HTTP 메서드에 맞는 어노테이션을 사용해야 한다. -> @GetMapping @PostMapping @PutMapping @DeleteMapping

    //http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName(){
        LOGGER.info("getName 메서드가 호출되었습니다.");
        return "Flature";
    }

    // 웹 통신의 기본 목적은 데이터를 주고받는 것이다.
    // 아래는 URL 자체에 값을 담아 전달되는 요청을 처리하는 방법이다.
    //http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value="/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        LOGGER.info("@PathVariable을 통해 들어온 값 : {}", variable);
        return variable;
    }

    //http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value="/variable2/{variable}")
    public String getVariable2(@PathVariable(value = "variable") String var){
        return var;
    }

    //http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    // Swagger 명세 추가
    @ApiOperation(value = "GET 메서드 예제", notes="@RequestParam을 활용한 GET 메서드") // 대상 API의 설명을 작성하기 위한 어노테이션
    @GetMapping(value="/request1")
    public String getRequestParam1(
            // @ApiParam - 매개변수에 대한 설명 및 설정을 위한 어노테이션. DTO를 매개변수로 사용할 경우 DTO 클래스 내의 매개변수에도 정의할 수 있음
            @ApiParam(value="이름", required=true) @RequestParam String name,
            @ApiParam(value="이메일", required = true) @RequestParam String email,
            @ApiParam(value="회사", required = true) @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    /*
    * 이 형태로 코드를 작성하면 값에 상관없이 요청을 받을 수 있다.
    * 예를 들어, 회원가입 API 사용자는 회원가입을 하면서 선택 항목에 대해서는 값을 기입하지 않을 수 있다.
    * 이처럼 매개변수의 항목이 일정하지 않은 경우에 대비해 Map 객체로 받는 것이 효율적이다.
    * */
    //http://localhost:8080/api/v1/get-api/variable2?kay1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

//        param.entrySet().forEach(map -> {
//            sb.append(map.getKey() + " : " + map.getValue() + "\n");
//        });
        param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
        
//        for(Map.Entry<String, String> entry : param.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            sb.append(key).append(" : ").append(value).append("\n");
//        }

        return sb.toString();
    }

    //http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }

}

