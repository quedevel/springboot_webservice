package org.que.springboot.controller;

import org.que.springboot.controller.dto.PostsControllerDto;
import org.que.springboot.service.posts.PostsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * PostsController
 */
@RequestMapping("/posts")
@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService ps;

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsControllerDto dto){
        return ps.update(id, dto);
    }

    @PostMapping("/register")
    public Long save(@RequestBody PostsControllerDto dto) {
        return ps.save(dto);
    }

}