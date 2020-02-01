package com.th.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Taehee Kwon,
 * User : Taehee
 * Date : 2020-01-26
 * Time : 오후 5:19
 * Contact : kwonth9509@gmail.com
 */
@Controller
public class IndexController {

    /**
     * index 반환 = index.mustache로 전환되어 View Resolver가 처리
     *
     * index 머스테치에 URL 매핑
     * @return index index
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 글 등록 버튼 누를시 이동할 페이지
     * @return posts-save 페이지
     */
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

}
