package study.assignment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ControllerAnnotationController 설명
 * @Controller 사용 실습
 * @author cyh68
 * 작성일 2023-02-04
 **/
@Slf4j
@Controller
public class ControllerAnnotationController {

    /**
     * sampleView 설명
     *
     * View 리턴 예제
     * 기본적으로 RequestMapping Value 와 View 이름이 같으면 오류 발생함
     * 해결 방법은 아래 링크 참고.
     * https://www.baeldung.com/spring-circular-view-path-error
     * @author cyh68
     * 작성일 2023-02-04
     **/
    @RequestMapping("/sampleView")
    public String sampleView(){
        log.info("sampleView.html returned");
        return "sampleView";
    }

}
