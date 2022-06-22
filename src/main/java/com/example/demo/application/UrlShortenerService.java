package com.example.demo.application;

import com.example.demo.infrastructure.ShortenUrlListRepository;
import org.springframework.stereotype.Service;

@Service // UrlShortenerService 빈이 생성이 되어 관리된다.
public class UrlShortenerService {

    private ShortenUrlListRepository ShortenUrlListRepository;

    public UrlShortenerService(ShortenUrlListRepository ShortenUrlListRepository){
        this.ShortenUrlListRepository = ShortenUrlListRepository;
    }

    public String create(String prevUrl){

        return "";
    }
};
