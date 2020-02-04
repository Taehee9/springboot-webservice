package com.th.springboot.web.dto;

import com.th.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-02-03
 * Time : 오후 11:43
 * Contact : kwonth9509@gmail.com
 */
@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
