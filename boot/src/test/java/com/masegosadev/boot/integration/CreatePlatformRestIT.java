package com.masegosadev.boot.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masegosadev.infrastructure.rest.platform.request.CreatePlatformRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void given_A_Platform_When_The_Create_Platform_Controller_Is_Called_Then_The_Created_Platform_Is_Retrieved() throws Exception {
        //given
        final String name = "PS4";
        final String imageUrl = "http://myps4logo.com";
        final CreatePlatformRequest createPlatformRequest = new CreatePlatformRequest(name, imageUrl);


        //when
        mockMvc.perform(
                post(new URI("/api/v1/platform"))
                    .content(toJson(createPlatformRequest))
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.imageUrl").value(imageUrl))
                .andReturn();
    }

    private String toJson(CreatePlatformRequest createPlatformRequest) throws JsonProcessingException {
        return objectMapper.writeValueAsString(createPlatformRequest);
    }
}
