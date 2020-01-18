package org.que.springboot.controller;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.que.springboot.controller.dto.PostsControllerDto;
import org.que.springboot.domain.posts.Posts;
import org.que.springboot.domain.posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * PostsControllerTest
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsControllerTest {

    //임의의 로컬서버 포트
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate; 

    @Autowired
    private PostsRepository pr;

    // @AfterEach
    // public void tearDown(){
    //     pr.deleteAll();
    // }

    @Test
    public void registerTest(){
        PostsControllerDto dto = PostsControllerDto.builder().title("제목쓰22").content("내용쓰").author("작성자스").build();

        // 임의의 포트번호
        String url = "http://localhost:"+port+"/register";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, dto, Long.class);

        // Test
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);

        
        List<Posts> list = pr.findAll();
        list.forEach(post -> log.info("list: "+ post.getTitle()));
        
        Assertions.assertThat(list.get(0).getTitle()).isEqualTo("제목쓰22");
    }
    
}