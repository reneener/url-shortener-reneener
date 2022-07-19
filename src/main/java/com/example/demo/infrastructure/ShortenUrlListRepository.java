package com.example.demo.infrastructure;

import com.example.demo.domain.exception.NewUrlNotFoundException;
import com.example.demo.domain.ShortenUrl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// Repository는 데이터를 저장/조회하는 일만 해야함

@Repository
public class ShortenUrlListRepository {

    private List<ShortenUrl> urls = new ArrayList<>();

    public boolean checkUrl(String newUrl){
        for(ShortenUrl url : urls){
            if(url.getNewUrl().equals(newUrl))
                return true;
        }
        return false;
    }

    public void createUrl(String destination, String newUrl){
        // URL인지 확인하는 정규 표현식
        // URL이 아니면 -> 예외를 던진다.

         ShortenUrl entity = new ShortenUrl(destination, newUrl);
         urls.add(entity);

         System.out.println("entity save");
    }

    public String searchUrl(String newUrl){
        ShortenUrl findedUrl = urls.stream()
                .filter(url -> url.getNewUrl().equals(newUrl))
                .findFirst()
                .orElseThrow(() -> new NewUrlNotFoundException("url 정보를 찾을 수 없습니다."));

        findedUrl.countUp();
        findedUrl.toString();
        return findedUrl.getDestination();
    }
};
