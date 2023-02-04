package study.assignment.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * MultipleMappingController 설명
 *
 * Controller 메소드에 다중 매핑 실습
 * @author cyh68
 * 작성일 2023-02-04
 **/
@Slf4j
@RestController
public class MultipleMappingController {

    /**
     * updateDeleteUser 설명
     *
     * RequestMapping에 배열로 다중 매핑 URL 설정
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping(value = {"/userUpdate", "/userDelete"})
    public String updateDeleteUser(HttpServletRequest request){
        String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        var retVal = "";

        if(requestUrl.equals("/userUpdate")){
            retVal =  "userUpdate";
        } else {
            retVal =  "userDelete";
        }

        log.info("requested Url : {}", retVal);

        return retVal;
    }

}
