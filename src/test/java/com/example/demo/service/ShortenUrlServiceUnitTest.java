package com.example.demo.service;

import com.example.demo.application.Base62Service;
import com.example.demo.application.UrlShortenerService;

import com.example.demo.domain.ShortenUrl.ShortenUrl;
import com.example.demo.presentation.exception.AlreadyExistShortenUrlException;
import com.example.demo.domain.ShortenUrl.ShortenUrlRepository;
import com.example.demo.presentation.exception.NewUrlNotFoundException;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ShortenUrlServiceUnitTest {

    @MockBean
    ShortenUrlRepository shortenUrlRepository;

    @Autowired
    Base62Service base62Service;
    @Autowired
    UrlShortenerService urlShortenerService;

    @Test
    @DisplayName("shortener url 생성 요청 성공 테스트")
    void urlCreateTest(){
        when(shortenUrlRepository.findByDestination(anyString())).thenReturn(Optional.empty());
        when(shortenUrlRepository.save(any())).thenReturn(mock(ShortenUrl.class));

        Assertions.assertDoesNotThrow(() -> urlShortenerService.createUrl("http://naver.com"));
    }
    @Test
    @DisplayName("이미 있는 destination으로 url create를 요청한 경우 실패 테스트")
    void testAlreadyExistShortenUrlException() {
        ShortenUrl existedUrl = mock(ShortenUrl.class);
        //when
        when(shortenUrlRepository.findByDestination(any())).thenReturn(Optional.of(existedUrl)); //
        //then
        assertThrows(AlreadyExistShortenUrlException.class, () -> {
            urlShortenerService.createUrl("https://www.naver.com");
        });
    }

    @Test
    @DisplayName("shortener url 리다이렉트 성공 테스트")
    void urlRedirectTest(){
        when(shortenUrlRepository.findByNewUrl(any())).thenReturn(Optional.of(mock(ShortenUrl.class)));

        Assertions.assertDoesNotThrow( () -> urlShortenerService.getDestination(any()));
    }

    @Test
    @DisplayName("shortener url로 요청이 왔을 시 destination을 리턴해야하는데 해당 url이 없는 경우 실패 테스트")
    void testNewUrlNotFoundException(){
        when(shortenUrlRepository.findByNewUrl((any()))).thenReturn(Optional.empty());

        assertThrows(NewUrlNotFoundException.class, () -> {
            urlShortenerService.getDestination("http://localhost:8080/dkj4wkdj");
        });
    }

    @Test
    @DisplayName("shortener url 삭제 요청 성공 테스트")
    void urlDeleteTest(){
        when(shortenUrlRepository.findByNewUrl(any())).thenReturn(Optional.of(mock(ShortenUrl.class)));
        Assertions.assertDoesNotThrow( () -> urlShortenerService.deleteUrl(any()));
    }
    @Test
    @DisplayName("shortener url로 삭제 요청이 왔을 시 삭제 할 엔티티를 찾지 못한 경우 실패 테스트")
    void testNewUrlNotFoundExceptionCausedByDelete(){
        when(shortenUrlRepository.findByNewUrl((any()))).thenReturn(Optional.empty());

        assertThrows(NewUrlNotFoundException.class, () -> {
            urlShortenerService.deleteUrl("http://localhost:8080/dkj4wkdj");
        });
    }
};
