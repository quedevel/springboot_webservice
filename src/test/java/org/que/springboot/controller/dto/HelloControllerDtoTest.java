package org.que.springboot.controller.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * HelloControllerDtoTest
 */
public class HelloControllerDtoTest {

    @Test
    public void helloDtoTest(){
        String name = "name";
        int amount = 10000;

        HelloControllerDto dto = new HelloControllerDto(name, amount);

        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);
    }
}