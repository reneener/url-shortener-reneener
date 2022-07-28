package com.example.demo.service;

import com.example.demo.application.UrlShortenerService;
import com.example.demo.domain.ShortenUrl;
import com.example.demo.infrastructure.ShortenUrlMapRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ShortenUrlServiceTest {
    @InjectMocks
    private UrlShortenerService service;

    @Mock
    private ShortenUrlMapRepository repository;
    private ShortenUrl url;

    @Test
    @DisplayName("단축 url 생성")
    public void test(){

        //given
        //url 샘플 생성

        //when
        //service.createUrl(url.getDestination());

    }

}
