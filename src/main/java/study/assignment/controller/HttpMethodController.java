package study.assignment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * HttpMethodController 설명
 * 각 HTTP Mehtod 모두 사용해보기 실습
 * 여기서는 기본적인 방식만 사용
 * @author cyh68
 * 작성일 2023-02-04
 **/
@RestController
public class HttpMethodController {

    /**
     * httpGetMethod 설명
     *
     * GET request mapping (쿼리 파라미터 없는 기본 구조)
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(){
        return "get users";
    }

    /**
     * httpMethodPost 설명
     *
     * POST request mapping
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @PostMapping("/users")
    public String addUser(){
        return "post user";
    }

    /**
     * updateUser 설명
     *
     * PUT request mapping
     * 단순히 메소드 구조만 나타내기 위해 식별자는 하드코딩 함(userA)
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @PutMapping("/users/userA")
    public String updateUserPut(){
        return "update user(put)";
    }

    /**
     * updateUserPatch 설명
     *
     * PATCH request mapping
     * 단순히 메소드 구조만 나타내기 위해 식별자는 하드코딩 함(userA)
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @PatchMapping("/users/userA")
    public String updateUserPatch(){
        return "update user(patch)";
    }

    /**
     * deleteUser 설명
     *
     * DELTE request mapping
     * 단순히 메소드 구조만 나타내기 위해 식별자는 하드코딩 함(userA)
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @DeleteMapping("/users/userA")
    public String deleteUser(){
        return "delete user";
    }

    /**
     * getUsersHead 설명
     * HEAD request mapping
     * /users에 대한 GET Method가 실행되나, 응답 헤더 정보만 존재. (Body 없음)
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping(value = "/users", method = RequestMethod.HEAD)
    public String getUsersHead(){
        return "get users only HEADER info";
    }

    /**
     * getUsersOptions 설명
     *
     * OPTIONS request mapping
     * /user 리소스에 지원 가능한 메소드 정보 확인
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping(value = "/users", method = RequestMethod.OPTIONS)
    public String getUsersOptions(){
        return "verify users available method";
    }

    /**
     * traceUsers 설명
     *
     * TRACE request mapping
     * 원격 서버에 Loopback 메세지를 호출하기 위해 사용
     * 요청 패킷이 서버에 도달 했을 떄의 최동 요청 패킷 내용을 응답 받음
     * 요청 패킷과 응답 패킷을 비교하여 변조 유무 확인 가능
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping(value = "/users", method = RequestMethod.TRACE)
    public String traceUsers(){
        return "trace users request";
    }

}
