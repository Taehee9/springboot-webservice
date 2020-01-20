package com.th.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  RequestController
 *  JSON을 반환하는 컨트롤러로 변환 / @ResponseBody를 각 메소드마다 선언했던 것을 한 번에 사용할 수 있게 도와줌
 *
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-19
 * Time : 오후 4:46
 * Contact : kwonth9509@gmail.com
 */
@RestController
public class HelloController {

    /**
     * hello
     * GetMapping Get의 요청을 받을 수 있는 API 만들어줌 - 예전 = @RequestMapping(method=RequestMethod.GET)
     * @return hello
     */
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
