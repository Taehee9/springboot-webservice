package com.th.springboot.config.auth.dto;

import com.th.springboot.domain.user.Role;
import com.th.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

/**
 * OAuth2User의 속성(attribute)을 담을 클래스
 *
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-03-03
 * Time : 오후 10:18
 * Contact : kwonth9509@gmail.com
 */
@Getter
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey, String name,
                           String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    /**
     *
     * @param registrationId 등록 ID
     * @param userNameAttributeName
     * @param attributes tkdydwk wjdqh
     * @return 사용자 정보
     */
    public static OAuthAttributes of(String registrationId, String userNameAttributeName,
                                     Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    /**
     *
     * @param userNameAttributeName
     * @param attributes 사용자 정보
     * @return 사용자 정보
     */
    private static OAuthAttributes ofGoogle(String userNameAttributeName,
                                            Map<String, Object> attributes) {
         return OAuthAttributes.builder()
                 .name((String) attributes.get("name"))
                 .email((String) attributes.get("email"))
                 .picture((String) attributes.get("picture"))
                 .attributes(attributes)
                 .nameAttributeKey(userNameAttributeName)
                 .build();
    }

    /**
     * User Entity -> 처음 가입할 때
     * 기본 권한은 GUEST
     * @return 처음 가입시의 User Entity
     */
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }

}
