package com.th.springboot.service.posts;

import com.th.springboot.domain.posts.Posts;
import com.th.springboot.domain.posts.PostsRepository;
import com.th.springboot.web.dto.PostsListResponseDto;
import com.th.springboot.web.dto.PostsResponseDto;
import com.th.springboot.web.dto.PostsSaveRequestDto;
import com.th.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * 게시글 목록 조회
     * Transactional = 트랜잭션 범위는 유지하되 조회기능만 남겨두어 조회 속도 개선
     *  -> 등록, 수정, 삭제 기능 전혀 없는 곳에서 사용 추천
     * @return PostsListResponseDto -> List로 변환
     */
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAll().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    /**
     * 게시글 삭제
     * @param id 게시글 id
     */
    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        postsRepository.delete(posts);
    }
}
