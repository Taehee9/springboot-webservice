package com.th.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * SpringBootApplication
 * 스프링부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
 * 여기서부터 설정을 읽어가기 때문에 항상 프로젝트의 최상단에 위치
 *
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-19
 * Time : 오후 4:28
 * Contact : kwonth9509@gmail.com
 */
@EnableJpaAuditing // JPA Auditing 기능 활성화 - 감시 기능
@SpringBootApplication
public class Application {

    /**
     * 메인
     * @param args args
     */
    public static void main(String[] args) {
        // 내장 WAS를 실행(서버에 톰캣 설치 필요 없이 스프링 부트로 만들어진 Jar 파일 실행하면 됨)
        SpringApplication.run(Application.class, args);
    }

}
