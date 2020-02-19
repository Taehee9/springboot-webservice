package com.th.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * User의 CRUD
 *
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-02-17
 * Time : 오후 11:16
 * Contact : kwonth9509@gmail.com
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 사용자 중복 체크
     * @param email 사용자 이메일
     * @return 이미 생성된 사용자인지 체크
     */
    Optional<User> findByEmail(String email);
}
