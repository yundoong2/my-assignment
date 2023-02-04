package study.assignment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestControllerAnnotationController 설명
 * 
 * @RestController 사용 실습
 * @author cyh68
 * 작성일 2023-02-04
 **/
@Slf4j
@RestController
public class RestControllerAnnotationController {

    /**
     * sampleViewRest 설명
     *
     * @RestController 사용 예제
     * View가 리턴되지 않고, 해당 String이 직접 반환 됨
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping("/sampleView-rest")
    public String sampleViewRest(){
        log.info("String 'sampleView' returned directly as is ");
        return "sampleView";
    }
}
