package org.que.springboot.controller.dto;

import org.que.springboot.domain.posts.Posts;

import lombok.Getter;

/**
 * PostsResponseDto
 */
@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
    
}