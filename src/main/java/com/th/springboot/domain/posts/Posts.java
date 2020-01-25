package com.th.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Entity 클래스에서는 절대 Setter 메소드 만들지 않음 -> 값 변경이 필요하면 명확히 목적, 의도를 나타낼 수 있는 메소드 추가
// DB에 추가할 때는 생성자를 통해, 값 변경이 필요할 때는 해당 이벤트에 맞는 public 메소드 호출 -> this.status = false; 이런 함수

/**
 * Entity는 JPA 어노테이션, Getter, NoARgsConstructor는 롬복 어노테이션
 * 롬복은 필수가 아니므로 주요 어노테이션을 클래스에 가깝게
 * Entity = 테이블과 링크될 클래스로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름 매칭
 * ex) SalesManager.java -> sales_manager table
 *
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-25
 * Time : 오전 12:30
 * Contact : kwonth9509@gmail.com
 */
@Getter // 클래스 내 모든 필드 Getter 자동 생성
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity
public class Posts {
    @Id // 해당 테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙, IDENTITY 추가해줘야지 auto_increament
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼, 굳이 선언 안해도 됨 / 기본값 외에 추가사항 있을 때만 선언
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /**
     * Builder = 어느 필드에 어떤 값을 채워야할지 명확하게 인지 가능(ex. Ex.builder().a(a).b(b).build();)
     *
     * 생성자
     * @param title 제목
     * @param content 내용
     * @param author 작가
     */
    @Builder // 해당 클래스의 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
