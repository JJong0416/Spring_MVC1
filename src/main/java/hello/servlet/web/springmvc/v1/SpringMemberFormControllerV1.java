package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 1. Component 스캔의 대상이 되고, Spring MVC에서 애노테이션 기반의 컨트롤러로 인식한다. (RequestMappingHandlerMapping
/**
 * @Component // 스프링 빈으로 들어간다
 * @RequestMapping("/springmvc/v1/members/new-form") 두개 합 => @Controller
 */
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }
}
