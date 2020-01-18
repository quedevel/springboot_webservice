package org.que.springboot.service.posts;

import org.que.springboot.controller.dto.PostsControllerDto;
import org.que.springboot.controller.dto.PostsResponseDto;
import org.que.springboot.domain.posts.Posts;
import org.que.springboot.domain.posts.PostsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * PostsService
 */
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository pr;

    @Transactional
    public Long save(PostsControllerDto dto){
        return pr.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsControllerDto dto){
        Posts posts = pr.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = "+ id));
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = pr.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = "+id));
        return new PostsResponseDto(entity);
    }
    
}