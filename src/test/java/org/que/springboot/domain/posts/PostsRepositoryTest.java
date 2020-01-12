package org.que.springboot.domain.posts;

import java.util.List;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

/**
 * PostsRepositoryTest
 */
@Slf4j
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    private PostsRepository pr;

    public void cleanup(){
        pr.deleteAll();
    }

    @Test
    public void prTest(){
        // pr.save(Posts.builder().author("writer....").content("content.....").title("제목....").build());


        List<Posts> list = pr.findAll();

        Posts posts = list.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo("제목....");
        Assertions.assertThat(posts.getContent()).isEqualTo("content.....");

    }

    @Test
    public void insertTest(){

        IntStream.range(1, 101).forEach( i -> {
            Posts posts = Posts.builder().title("title"+i).content("content"+i).author("author"+i).build();
            pr.save(posts);
        });

    }

    @Test
    public void readTest(){

        List<Posts> list = pr.findAll();
        list.forEach(posts -> {
            log.info("title: "+posts.getTitle());
            log.info("content: "+posts.getContent());
            log.info("author: "+posts.getAuthor());
        });
    }
}