package com.th.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Posts 클래스로 DB 접근하기 위한 Repository -> DAO라고 불리는 DB Layer 접근자
 * JpaRepository<Entity 클래스, PK타입> 생성시 자동으로 CRUD 메소드 생성
 * 주의 = 기본 Entity Repository는 함께 위치
 *
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-25
 * Time : 오후 4:49
 * Contact : kwonth9509@gmail.com
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
