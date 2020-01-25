package com.th.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * save, findAll 기능 테스트
 *
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-25
 * Time : 오후 4:52
 * Contact : kwonth9509@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    /**
     * After = 단위 테스트 끝날 때마다 수행되는 메소드
     * 배포 전 전체 테스트 수행할 때 테스트간 데이터 침범을 막기 위해 사용
     * 테스트가 동시에 수행되면 h2에 데이터 그대로 남아있어 다음 테스트시 실패 가능
     */
    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void postSave_loading() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // save = 테이블 posts에 insert/update 실행 = id 있으면 update, 없으면 insert
        postsRepository.save(Posts.builder()
            .title(title)
            .content(content)
            .author("kwonth9509@gmail.com")
            .build());

        // findAll = 모든 데이터 조회
        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
