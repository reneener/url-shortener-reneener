package com.example.demo.controller;

<<<<<<< HEAD
import com.example.demo.application.UrlShortenerService;
import com.example.demo.domain.ShortenUrl;
import com.example.demo.presentation.UrlShortenerController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UrlShortenerControllerTest {

    @Mock
    private UrlShortenerController controller;

    private MockMvc mockMvc;

    @InjectMocks
    private UrlShortenerService service;

    @Test
    @DisplayName("단축 url 생성")
    public void test() throws Exception {

        //given
        ShortenUrl url = new ShortenUrl("http://naver.com", null);

        mockMvc.perform(MockMvcRequestBuilders.post("/url")
                .content(url.getDestination())
                .contentType(MediaType.TEXT_PLAIN_VALUE)
        ).andExpect(status().isOk());
    }

=======
public class UrlShortenerControllerTest {
>>>>>>> 38baed91c446b4ad6b0e809ad930dee68cbd0631
}
