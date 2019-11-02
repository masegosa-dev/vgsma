package com.masegosadev.boot.integration.videogame;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.masegosadev.infrastructure.model.videogame.VideoGameRequest;
import com.masegosadev.usecase.platform.CreatePlatform;
import com.masegosadev.usecase.videogame.CreateVideogame;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CreateVideoGameControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void given_A_Request_To_Save_Videogame_When_The_Request_Is_Send_Then_Return_The_Saved_Videogame() throws Exception {
        Set<String> platformsName = new HashSet<>();
        platformsName.add("PS4");
        VideoGameRequest videoGameRequest = new VideoGameRequest("COD", "https://cod_logo.com", platformsName);

        mockMvc.perform(post("/createVideoGame")
                .content(objectMapper.writeValueAsString(videoGameRequest))
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isCreated());
    }
}