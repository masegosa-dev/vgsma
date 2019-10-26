package com.masegosadev.boot.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public final class CreatePlatformRestIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void given_A_Platform_When_The_Create_Platform_Controller_Is_Called_Then_The_Created_Platform_Is_Retrived() throws Exception {
        //given
        final String name = "PS4";
        final String imageUrl = "http://myps4logo.com";

        //when
        mockMvc.perform(
                post(new URI("/api/1/platform"))
                        .param("name", name)
                        .param("imageUrl", imageUrl))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.imageUrl").value(imageUrl))
                .andReturn();
    }
}
