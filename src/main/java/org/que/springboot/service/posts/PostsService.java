package org.que.springboot.service.posts;

import org.que.springboot.controller.dto.PostsControllerDto;
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
    
}