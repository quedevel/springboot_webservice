package org.que.springboot.controller;

import org.que.springboot.controller.dto.PostsControllerDto;
import org.que.springboot.service.posts.PostsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * PostsController
 */
@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService ps;

    @PostMapping("/register")
    public Long save(@RequestBody PostsControllerDto dto){
        return ps.save(dto);
    }


    
}