package com.example.demo.application;

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

    public UrlShortenerService(ShortenUrlListRepository ShortenUrlListRepository){
        this.shortenUrlListRepository = ShortenUrlListRepository;
    }

    public boolean isDuplicated(String newUrl){
         if(shortenUrlListRepository.checkUrl(newUrl))
             return false;
         else
             return true;
    }
    public static boolean isUrl(String text) {
        Pattern p = Pattern.compile("^(?:https?:\\/\\/)?(?:www\\.)?[a-zA-Z0-9./]+$");
        Matcher m = p.matcher(text);
        if(m.matches())
            return true;
        else
            return false;
    }

    public String createUrl(String prevUrl) {
        String newUrl = "";
        if (isUrl(prevUrl)){//URL형식확인
            newUrl = UUID.randomUUID().toString().substring(0, 7); //랜덤 문자열 생성
            while (true) { //중복인지 확인
                if (!isDuplicated(newUrl)) {
                    shortenUrlListRepository.createUrl(prevUrl, newUrl);
                    return newUrl;
                }
            }
        }else {
            throw new IllegalArgumentException("URL 형식이 맞지 않습니다.");
        }
    }

    public String getUrl(String newUrl){
        String prevUrl = shortenUrlListRepository.searchUrl(newUrl);
        return prevUrl;
    }
};
