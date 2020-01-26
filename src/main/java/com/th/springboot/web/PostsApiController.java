package com.th.springboot.web;

import com.th.springboot.service.posts.PostsService;
import com.th.springboot.web.dto.PostsResponseDto;
import com.th.springboot.web.dto.PostsSaveRequestDto;
import com.th.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 등록, 수정, 삭제 기능
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-25
 * Time : 오후 7:32
 * Contact : kwonth9509@gmail.com
 */
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    /**
     * 게시글 등록
     * @param requestDto 게시글 저장 dto
     * @return 게시글 id
     */
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    /**
     * 게시글 수정
     * @param id 게시글 id
     * @param requestDto 게시글 업데이트 dto
     * @return 게시글 id
     */
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    /**
     * 게시글 조회
     * @param id 게시글 id
     * @return 게시글 응답 dto
     */
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

}
