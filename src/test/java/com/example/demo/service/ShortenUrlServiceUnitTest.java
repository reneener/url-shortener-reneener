package com.example.demo.service;

import com.example.demo.application.UrlShortenerService;
import com.example.demo.domain.exception.ManyDuplicationException;
import com.example.demo.infrastructure.ShortenUrlRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ShortenUrlServiceUnitTest {

    @Mock
    ShortenUrlRepository shortenUrlRepository;

    @InjectMocks
    UrlShortenerService urlShortenerService;

    @Test
    void testDuplicatedRuntimeException() {
        when(shortenUrlRepository.checkUrl(any())).thenReturn(true);

        assertThrows(ManyDuplicationException.class, () -> {
            urlShortenerService.createUrl("https://www.naver.com/");
        });
    }


};
