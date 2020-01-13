package org.que.springboot.controller;

import org.junit.jupiter.api.Test;
import org.que.springboot.controller.dto.PostsControllerDto;
import org.que.springboot.domain.posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * PostsControllerTest
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsControllerTest {

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

        String url = "http://localhost:"+port+"/register";

        log.info("before restTemplate-----------------");
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, dto, Long.class);

        log.info("After restTemplate-----------------");


        

        // Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        // Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);

        // List<Posts> list = pr.findAll();
        // Assertions.assertThat(list.get(0).getTitle()).isEqualTo("제목쓰");
    }
    
}