package com.example.demo.application;

import com.example.demo.domain.ShortenUrl;
import com.example.demo.infrastructure.ShortenUrlListRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
비즈니스 로직은 service에 repository는 db접근 로직만 작성
 */

@Service // UrlShortenerService 빈이 생성이 되어 관리된다.
public class UrlShortenerService {

    private ShortenUrlListRepository shortenUrlListRepository;

    public UrlShortenerService(ShortenUrlListRepository shortenUrlListRepository){
        this.shortenUrlListRepository = shortenUrlListRepository;
    }

    public String createUrl(String destination) {
        checkValidation(destination);

        String newUrl = UUID.randomUUID().toString().substring(0, 7); //랜덤 문자열 생성

        while (true) { //중복인지 확인
            if (!isDuplicated(newUrl)) {
                ShortenUrl shortenUrl = new ShortenUrl(destination, newUrl);
                shortenUrlListRepository.createUrl(shortenUrl);
                return newUrl;
            }
        }
    }

    public String getUrl(String newUrl){
        String destination = shortenUrlListRepository.searchUrl(newUrl);
        return destination;
    }

    private boolean isDuplicated(String newUrl){
        if(shortenUrlListRepository.checkUrl(newUrl))
            return false;
        else
            return true;
    }

    private void checkValidation(String text) {
        Pattern p = Pattern.compile("^(?:https?:\\/\\/)?(?:www\\.)?[a-zA-Z0-9./]+$");
        Matcher m = p.matcher(text);

        if(Boolean.FALSE == m.matches())
            throw new IllegalArgumentException("URL 형식이 맞지 않습니다.");
    }
};
