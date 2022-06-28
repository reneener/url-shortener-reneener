package com.example.demo.infrastructure;

import com.example.demo.domain.Base58;
import com.example.demo.domain.NewUrlNotFoundException;
import com.example.demo.domain.ShortenUrl;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Repository는 데이터를 저장/조회하는 일만 해야함

@Repository
public class ShortenUrlListRepository {

    private List<ShortenUrl> urls = new ArrayList<>();

    public boolean checkUrl(String newUrl){
        for(ShortenUrl url : urls){
            if(url.getNewUrl().equals(newUrl))
                return false;
        }
        return true;
    }

    public void cntUp(String id){
        for(ShortenUrl url : urls){
            if(url.getId().equals(id)){
                url.setCnt(url.getCnt() + 1);
            }
        }
    }

    public String createUrl(String prevUrl){
        // URL인지 확인하는 정규 표현식
        // URL이 아니면 -> 예외를 던진다.

//        String newUrl = Base58.encode(prevUrl.getBytes());


// 중복되는지 체크
        while (true) {
            byte[] uuidBinary = UUID.randomUUID().toString().getBytes();
            String newUrl = Base58.encode(uuidBinary);

            if(checkUrl(newUrl)) {
                ShortenUrl entity = new ShortenUrl(prevUrl, newUrl);
                urls.add(entity);
            }else{
                // 랜덤으로 바꿔주는
            }
        }


        return newUrl;
    }


    public String getUrl(String newUrl){
        ShortenUrl findedUrl = urls.stream()
                .filter(url -> url.getNewUrl().equals(newUrl))
                .findFirst()
                .orElseThrow(() -> new NewUrlNotFoundException());

        findedUrl.countUp();

        return findedUrl.getPrevUrl();
    }
};
