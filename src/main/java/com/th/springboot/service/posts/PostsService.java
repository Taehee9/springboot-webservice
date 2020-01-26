package com.th.springboot.service.posts;

import com.th.springboot.domain.posts.Posts;
import com.th.springboot.domain.posts.PostsRepository;
import com.th.springboot.web.dto.PostsResponseDto;
import com.th.springboot.web.dto.PostsSaveRequestDto;
import com.th.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 트랜잭션과 도메인 간의 순서 보장
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-25
 * Time : 오후 7:32
 * Contact : kwonth9509@gmail.com
 */
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    /**
     * 게시글 등록
     * @param requestDto 게시글 저장 dto
     * @return 게시글 id
     */
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    /**
     * 게시글 수정
     * 쿼리 날리는 부분 x -> JPA의 영속성 컨텍스트(Entity를 영구 저장하는 환경)떄문
     *
     * @param id 해당 id
     * @param requestDto 게시글 수정 dto
     * @return 게시글 id
     */
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = "+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    /**
     * 게시글 조회
     * @param id 게시글 id
     * @return 게시글 응답 dto
     */
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()-> new
                        IllegalArgumentException("해당 사용자가 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }
}
