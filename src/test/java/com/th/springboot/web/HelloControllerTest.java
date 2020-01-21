package com.th.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * RunWith(SpringRunner.class)
 * 테스트를 진행할 때 JUnit에 내장된 실행자 외의 다른 실행자를 실행 = SpringRunner
 * 스프링 부트 테스트와 JUnit 사이의 연결자 역할
 *
 * WebMvcTest
 * Web(Spring MVC)에 집중할 수 있는 어노테이션
 * Controller, ControllerAdvice 어노테이션 사용 가능 / Service, Component, Repository 사용 불가능
 *
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-19
 * Time : 오후 5:36
 * Contact : kwonth9509@gmail.com
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    /*
     * Autowired
     * 스프링이 관리하는 Bean 주입받음
     *
     * MockMvc 웹 API 테스트 할 때 사용(HTTP GET, POST 등)
     * 스프링 MVC 테스트의 시작점
     */
    @Autowired
    private MockMvc mvc;

    /**
     * hello 리턴
     * @throws Exception perform에서 발생할 수 있는 예외처리
     */
    @Test
    public void hello() throws Exception {
        String hello = "hello";

        /*
        * MockMvc를 통해 /hello 주소로 HTTP GET 요청
        * mvc.perform 결과 검증 / HTTP Header Status 검증(200, 400 등의 status)을 통해 OK인지 아닌지(200)
        * 응답 본문 내용 검증(hello 리턴하는지 아닌지)
        */
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

}
