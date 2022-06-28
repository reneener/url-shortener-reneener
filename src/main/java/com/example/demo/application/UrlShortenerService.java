package com.example.demo.application;

import com.example.demo.infrastructure.ShortenUrlListRepository;
import org.springframework.stereotype.Service;

@Service // UrlShortenerService 빈이 생성이 되어 관리된다.
public class UrlShortenerService {

    private ShortenUrlListRepository ShortenUrlListRepository;

    public UrlShortenerService(ShortenUrlListRepository ShortenUrlListRepository){
        this.ShortenUrlListRepository = ShortenUrlListRepository;
    }

    public String createUrl(String prevUrl){
        String newUrl = ShortenUrlListRepository.createUrl(prevUrl);
        return newUrl;
    }

    public String getUrl(String newUrl){
        String prevUrl = ShortenUrlListRepository.getUrl(newUrl);
        return prevUrl;
    }
};
