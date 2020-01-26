package com.th.springboot.web.dto;

import com.th.springboot.domain.posts.Posts;
import lombok.Getter;

/**
 * Entity의 일부만 사용하므로 Entity를 받아 처리
 *
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-25
 * Time : 오후 11:26
 * Contact : kwonth9509@gmail.com
 */
@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    /**
     * entity의 필드 중 일부만 사용하므로 Entity를 받아 필드에 값을 넣음
     * @param entity
     */
    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
