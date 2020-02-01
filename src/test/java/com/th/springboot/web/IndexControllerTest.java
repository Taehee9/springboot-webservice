package com.th.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-26
 * Time : 오후 5:21
 * Contact : kwonth9509@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * URL 호출 시 페이지의 내용이 제대로 호출되는지 test
     */
    @Test
    public void mainPage_loading() {
       // when
       String body = this.restTemplate.getForObject("/", String.class);

       // then
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
}
