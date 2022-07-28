package com.example.demo.infrastructure;

import com.example.demo.domain.ShortenUrl;
import com.example.demo.domain.exception.NewUrlNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ShortenUrlMapRepository implements ShortenUrlRepository{

    private Map<String, ShortenUrl> urls = new HashMap<>();

    public void createShortenUrl(ShortenUrl shortenUrl) {
        urls.put(shortenUrl.getDestination(), shortenUrl);
    }

    public boolean checkUrl(String newUrl){
        for(ShortenUrl url : urls.values()){
            if(url.getNewUrl().equals(newUrl))
                return true;
        }
        return false;
    }

    public String getDestination (String newUrl){ // 리다이렉트
        Optional<ShortenUrl> findUrl = Optional.ofNullable(urls.entrySet().stream()
                .filter(url -> url.getValue().getNewUrl().equals(newUrl))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new NewUrlNotFoundException("이전 url 정보를 찾을 수 없습니다.")));

        findUrl.get().countUp();
        return findUrl.get().getDestination();
    }

    public String getNewUrl(String destination){ //중복 확인
        Optional<ShortenUrl> findUrl = urls.entrySet().stream()
                .filter(url -> url.getKey().equals(destination))
                .map(Map.Entry::getValue)
                .findFirst();

        return findUrl.get().getNewUrl();
    }

};
