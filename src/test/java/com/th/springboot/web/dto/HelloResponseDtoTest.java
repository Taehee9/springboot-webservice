package com.th.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-21
 * Time : 오후 11:40
 * Contact : kwonth9509@gmail.com
 */
public class HelloResponseDtoTest {

    @Test
    public void lombokTest() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        // assertThat = assertj 라는 테스트 검증 라이브러리의 검증 메소드 -> 메소드 체이닝 지원되 isEqualTo 사용 가능
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
