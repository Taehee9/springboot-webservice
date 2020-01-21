package com.th.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Getter = 선언된 모든 필드의 get 메소드 생성
 * RequiredArgsConstructor = 선언된 모든 final 필드가 포함된 생성자 생성(final 없는건 제외)
 *
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-21
 * Time : 오후 11:38
 * Contact : kwonth9509@gmail.com
 */
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
