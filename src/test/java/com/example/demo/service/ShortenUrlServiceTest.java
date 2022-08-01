package com.example.demo.service;

import com.example.demo.application.UrlShortenerService;
<<<<<<< HEAD
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
=======
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShortenUrlServiceTest {

    @Autowired
    UrlShortenerService urlShortenerService;

    @Test
    void createUrlTest() {
        String expectedDestination = "https://www.naver.com/";

        String newUrl = urlShortenerService.createUrl(expectedDestination);
        String destination = urlShortenerService.getDestination(newUrl);

        assertTrue(expectedDestination.equals(destination));
    }
//
//    @Test
//    void getUrl() {
//
//    }
>>>>>>> 38baed91c446b4ad6b0e809ad930dee68cbd0631

}
