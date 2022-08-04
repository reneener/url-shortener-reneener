package com.example.demo.controller;

import com.example.demo.application.UrlShortenerService;
import com.example.demo.domain.ShortenUrl;
import com.example.demo.presentation.UrlShortenerController;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UrlShortenerController.class)
public class UrlShortenerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UrlShortenerService service;

    @Test
    @DisplayName("단축 url 생성")
    public void createUrlTest() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/url")
                .contentType(MediaType.APPLICATION_JSON)
                .content("http://naver.com")
        ).andExpect(status().isOk());
    }

    @Test
    @DisplayName("기존 url 가져오기")
    public void getUrlTest() throws Exception{
        given(service.getDestination("abcdefg")).willReturn("http://naver.com");
        mockMvc.perform(MockMvcRequestBuilders.get("/url/{newUrl}","abcdefg"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
