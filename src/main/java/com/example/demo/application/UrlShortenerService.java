package com.example.demo.application;

import com.example.demo.domain.ShortenUrl.ShortenUrl;

import com.example.demo.domain.exception.ManyDuplicationException;
import com.example.demo.domain.ShortenUrl.ShortenUrlRepository;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service // UrlShortenerService 빈이 생성이 되어 관리된다.
@Slf4j
@RequiredArgsConstructor
public class UrlShortenerService {

    private final ShortenUrlRepository shortenUrlRepository;
    private final Base62Service base62Service;

    @Value("${url.shortener.base.url}")
    private String baseUrl;
    public String createUrl(String destination) { //단축 url 생성

        ShortenUrl shortenUrl = ShortenUrl.builder()
                .destination(destination)
                .build();
        shortenUrlRepository.save(shortenUrl);
        return setEncodedUrl(shortenUrl);
    }

    public String setEncodedUrl(ShortenUrl shortenUrl){
        String encodedId = base62Service.encodedId(shortenUrl.getId());
        shortenUrl.setNewUrl(encodedId); //이렇게 하면 db도 자동업데이트가 되나??
        return encodedId;
    }
    public String getDestination(String newUrl){// 리다이렉트
        return decodingId(newUrl).getDestination();
    }
    public ShortenUrl decodingId (String encodedId){
        Long decodedId =  base62Service.decodedId(encodedId);
        return shortenUrlRepository.findById(decodedId).orElse(null);
    }



}
