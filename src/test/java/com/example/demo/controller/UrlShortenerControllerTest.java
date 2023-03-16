package com.example.demo.controller;

import com.example.demo.application.UrlShortenerService;
import com.example.demo.presentation.UrlShortenerController;
import com.example.demo.presentation.dto.UrlDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UrlShortenerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UrlShortenerService service;

    @Test
    @DisplayName("단축 url 생성 성공 테스트")
    public void createUrlTest() throws Exception{

        mockMvc.perform(post("/url")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(new UrlDto("https://naver.com", "")))
            ).andDo(print())
            .andExpect(status().isOk());
    }
    @Test
    @DisplayName("단축 url 요청 시 destination을 찾고 리다이렉트 성공 테스트")
    public void getUrlTest() throws Exception{
        given(service.getDestination("abcdefg")).willReturn("http://naver.com");

        mockMvc.perform(get("/{newUrl}","abcdefg"))
                .andExpect(status().is3xxRedirection())
                .andDo(print());

    }
    @Test
    @DisplayName("단축 url 삭제 요청 성공 테스트")
    public void deleteUrlTest() throws Exception{

        mockMvc.perform(delete("/url")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(new UrlDto("https://naver.com", "http://localhost:8080/A4SJERF")))
        ).andDo(print())
        .andExpect(status().isOk());
    }

}
