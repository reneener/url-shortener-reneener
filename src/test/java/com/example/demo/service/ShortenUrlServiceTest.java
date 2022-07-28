package com.example.demo.service;

import com.example.demo.application.UrlShortenerService;
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

}
