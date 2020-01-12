package org.que.springboot.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * HelloControllerDto
 */
@Getter
@RequiredArgsConstructor
public class HelloControllerDto {

    private final String name;
    private final int amount;
}