package com.example.demo.infrastructure;

import com.example.demo.domain.exception.NewUrlNotFoundException;
import com.example.demo.domain.ShortenUrl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// Repository는 데이터를 저장/조회하는 일만 해야함

@Repository
@Primary
public class ShortenUrlListRepository implements ShortenUrlRepository{

    private List<ShortenUrl> urls = new ArrayList<>();

    public void createShortenUrl(ShortenUrl shortenUrl) {
        urls.add(shortenUrl);
    }

    public String getDestination (String newUrl){ // 리다이렉트
        ShortenUrl findedUrl = urls.stream()
                .filter(url -> url.getNewUrl().equals(newUrl))
                .findFirst()
                .orElseThrow(() -> new NewUrlNotFoundException("이전 url 정보를 찾을 수 없습니다."));


        findedUrl.countUp();
        return findedUrl.getDestination();
    }

    public boolean checkUrl(String newUrl){
        for(ShortenUrl url : urls){
            if(url.getNewUrl().equals(newUrl))
                return true;
        }
        return false;
    }

    public String getNewUrl(String destination){ //중복 확인
        ShortenUrl findedUrl = urls.stream()
                .filter(url -> url.getNewUrl().equals(destination))
                .findFirst()
                .orElse(null);

        return findedUrl.getNewUrl();
    }

};
