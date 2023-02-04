package study.assignment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import study.assignment.DTO.SampleData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * RequestParameterController 설명
 *  
 * 여러가지 Request parameter 사용 방법 실습
 * @author cyh68
 * 작성일 2023-02-04
 **/
@Slf4j
@RestController
public class RequestParameterController {

    /**
     * getUser 설명
     *
     * @Pathvariable 사용
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping("/mapping/users/{userId}")
    public String getUser(@PathVariable(value = "userId") String userId){
        log.info("userId = {}", userId);

        return "userId = " + userId;
    }

    /**
     * getUsersOrder 설명
     *
     * 다중 PathVariable 사용
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping("/mapping/users/{userId}/orders/{orderId}")
    public String getUsersOrder(@PathVariable String userId, @PathVariable Long orderId){
        log.info("userId={}, orderId={}", userId, orderId);

        return String.format("userId = %s, orderId = %s", userId, orderId);
    }

    /**
     * getUser 설명
     *
     * 리턴 타입이 없는 경우, response에 값을 직접 넣으면 View가 아닌 객체 데이터를 직접 반환
     * Servlet 방식
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping("/mapping/users-v1")
    public void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", userName, age);

        response.getWriter().write(String.format("username=%s, age=%s", userName, age));
    }

    /**
     * getUser 설명
     *
     * @RequestParam 어노테이션 사용
     * HTTP 파라미터 이름이 변수 이름과 같으면 @RequestParam(name="xx") 생략 가능
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping("/mapping/users-v2")
    public String getUser(@RequestParam("username") String userName,
                          @RequestParam("age") int userAge){
        log.info("username={}, age={}", userName, userAge);

        return String.format("userId = %s, orderId = %s", userName, userAge);
    }

    /**
     * getUserDefault 설명
     * 
     * @RequestParam에 required, defaultValue 필드 사용 / defaultValue가 있으면 사실상 required는 의미 없음
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping("/mapping/users-v3")
    public String getUserDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = true, defaultValue = "-1") int age
    ){
        log.info("username = {}, age = {}", username, age);
        return String.format("userId = %s, orderId = %s", username, age);
    }

    /**
     * getUserMap 설명
     *
     * @RequestParam을 Map을 사용하여 Key, Value 값으로 묶을 수도 있음
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping("/mapping/users-v4")
    public String getUserMap(@RequestParam Map<String, Object> paramMap){
        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));

        return String.format("userId = %s, orderId = %s", paramMap.get("username"), paramMap.get("age"));
    }

    /**
     * getUserModelAttr 설명
     *
     * @ModelAttribute 사용
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping("/mapping/users-v5")
    public String getUserModelAttr(@ModelAttribute SampleData data){
        log.info("username = {}, age = {}", data.getUsername(), data.getAge());

        return String.format("userId = %s, orderId = %s", data.getUsername(), data.getAge());
    }

    /**
     * addUser 설명
     *
     * HttpEntity 사용
     * getBody()를 통해 Message Body 내용을 가져 올 수 있음
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @PostMapping("/mapping/users-v6")
    public HttpEntity<String> addUser(HttpEntity<String> httpEntity){
        String messageBody = httpEntity.getBody();
        log.info("messageBody={}", messageBody);

        return new HttpEntity<>(messageBody);
    }

    /**
     * adduser 설명
     *
     * @RequestBody 사용
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @PostMapping("/mapping/user-v7")
    public String adduserString(@RequestBody String messageBody){
        log.info("messageBody={}", messageBody);

        return messageBody;
    }

    /**
     * addUserJson 설명
     * 
     * @RequestBody로 객체 데이터를 받음
     * 주의 점: @RequestBody 어노테이션을 생략하면 안됨,
     * 생략하면 @AttributeModel 이 적용되어 객체 데이터를 Json 형태로 변환할 수 업음
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @PostMapping("/mapping/user-v8")
    public SampleData addUserJson(@RequestBody SampleData data){
        log.info("username={}, age={}", data.getUsername(), data.getAge());

        return data;
    }


}
