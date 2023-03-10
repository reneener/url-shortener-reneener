package com.example.demo.service;

import com.example.demo.application.UrlShortenerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ShortenUrlServiceTest {

    @Autowired
    UrlShortenerService urlShortenerService;

    @Test
    void shortenUrlTest() { // create와 getDestination 모두 테스트

    }
}
