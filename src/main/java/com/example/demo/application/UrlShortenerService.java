package com.example.demo.application;

import com.example.demo.domain.ShortenUrl.ShortenUrl;

<<<<<<< Updated upstream
import com.example.demo.domain.exception.ManyDuplicationException;
import com.example.demo.domain.ShortenUrl.ShortenUrlRepository;
<<<<<<< HEAD
=======
import com.example.demo.domain.dto.ShortenUrlDto;

import com.example.demo.domain.ShortenUrl.ShortenUrlRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
=======
import java.util.Objects;
import java.util.Optional;
>>>>>>> 5361025982cdd4df6aaa8b155ce98ddbd71cda2a
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
<<<<<<< HEAD
>>>>>>> Stashed changes
=======
>>>>>>> 5361025982cdd4df6aaa8b155ce98ddbd71cda2a
import org.springframework.stereotype.Service;

@Service // UrlShortenerService 빈이 생성이 되어 관리된다.
@Slf4j
@RequiredArgsConstructor
public class UrlShortenerService {

    private final ShortenUrlRepository shortenUrlRepository;
    private final Base62Service base62Service;

<<<<<<< HEAD
<<<<<<< Updated upstream
=======
    @Value("${url.shortener.base.url}")
    private String baseUrl;
>>>>>>> 5361025982cdd4df6aaa8b155ce98ddbd71cda2a
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
<<<<<<< HEAD
        return shortenUrlRepository.getDestination(newUrl);
=======
    //@Value("${url.shortener.base.url}")
    //private String baseUrl;

    public List<ShortenUrlDto> getShortenUrl(){
        return shortenUrlRepository.findAll()
            .stream()
            .map(ShortenUrlDto::fromEntity)
            .collect(Collectors.toList());
    }
    public void createUrl(String destination) { //단축 url 생성
        ShortenUrl shortenUrl = ShortenUrl.builder()
                .newUrl(base62Service.encodedId(destination))
                .destination(destination)
                .build();
        shortenUrlRepository.save(shortenUrl);
    }

    public String getDestination(String newUrl){// 리다이렉트
        //cnt up
        return decodingId(newUrl).getDestination();
>>>>>>> Stashed changes
=======
        return decodingId(newUrl).getDestination();
>>>>>>> 5361025982cdd4df6aaa8b155ce98ddbd71cda2a
    }
    public ShortenUrl decodingId (String encodedId){
        Long decodedId =  base62Service.decodedId(encodedId);
        return shortenUrlRepository.findById(decodedId).orElse(null);
    }




}
