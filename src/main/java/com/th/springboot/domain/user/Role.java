package com.th.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-02-17
 * Time : 오후 11:12
 * Contact : kwonth9509@gmail.com
 */
@Getter
@RequiredArgsConstructor
public enum Role {

    // 스프링 시큐리티에서 권한 코드에는 항상 ROLE 이 앞에 있어야함
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
