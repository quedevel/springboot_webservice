package org.que.springboot.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import lombok.extern.slf4j.Slf4j;

/**
 * HelloControllerTest
 */
@WebMvcTest
@Slf4j
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello() throws Exception{
        String str = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(str));
    }
    
    @Test
    public void helloDto() throws Exception{
        String name = "helloDto";
        int amount = 10000;

        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", is(name)))
        .andExpect(jsonPath("$.amount", is(amount)));
    }
}