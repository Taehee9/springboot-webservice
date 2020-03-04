package com.th.springboot.config.auth;

import com.th.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;

/**
 * EnableWebSecurity - Spring Security 설정들 활성화
 *
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-03-03
 * Time : 오후 9:27
 * Contact : kwonth9509@gmail.com
 */
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    /**
     * url별 권한관리, 로그아웃, 로그인 시 처리 등 설정
     *
     * @param http
     * @throws Exception 예외처리
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/css/**", "/images/**",
                            "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }
}
