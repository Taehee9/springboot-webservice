package com.th.springboot.config.auth.dto;

import com.th.springboot.domain.user.User;

import java.io.Serializable;

/**
 * 인증된 사용자 정보 들어있는 DTO
 * User 클래스와 차이점은 직렬화 여부
 *
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-03-03
 * Time : 오후 10:23
 * Contact : kwonth9509@gmail.com
 */
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
