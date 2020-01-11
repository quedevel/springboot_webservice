package org.que.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 */

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    
}