package com.example.demo.infrastructure;

import com.example.demo.domain.Base58;
import com.example.demo.domain.ShortenUrl;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        String newUrl = Base58.encode(prevUrl.getBytes());
        if(checkUrl(newUrl)) {
            ShortenUrl entity = new ShortenUrl(prevUrl, newUrl, 1);
            urls.add(entity);
        }else{
            // 랜덤으로 바꿔주는
        }
        return newUrl;
    }


    public String getUrl(String requestUrl){
        try{ //parameter null체크 ??
            byte[] parse = Base58.decode(requestUrl);
            String newUrl = new String(parse);

            for(ShortenUrl url : urls){
                if(url.getNewUrl().equals(newUrl))
                    cntUp(url.getId()); //안됨
                    return url.getPrevUrl();
            }
            return requestUrl;

            /*
            Stream 쓰고싶은데 에러남
            Optional<ShortenUrl> findUrl = urls.stream()
                    .filter(url -> url.getNewUrl().equals(newUrl))
                    .findFirst();
            findUrl.get().getnewUrl() */
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestUrl;
    }
};
