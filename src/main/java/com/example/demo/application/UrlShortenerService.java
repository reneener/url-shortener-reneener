package com.example.demo.application;

import com.example.demo.domain.ShortenUrl.ShortenUrl;

<<<<<<< Updated upstream
import com.example.demo.domain.exception.ManyDuplicationException;
import com.example.demo.domain.exception.UrlFormatException;
import com.example.demo.domain.ShortenUrl.ShortenUrlRepository;
=======
import com.example.demo.domain.dto.ShortenUrlDto;

import com.example.demo.domain.ShortenUrl.ShortenUrlRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
>>>>>>> Stashed changes
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service // UrlShortenerService 빈이 생성이 되어 관리된다.
public class UrlShortenerService {

    private ShortenUrlRepository shortenUrlRepository;

    public UrlShortenerService(ShortenUrlRepository shortenUrlRepository){
        this.shortenUrlRepository = shortenUrlRepository;
    }

<<<<<<< Updated upstream
    public String createUrl(String destination) { //단축 url 생성
        checkValidation(destination);
        String newUrl =  UUID.randomUUID().toString().substring(0, 7);

        int count = 0;

        while (count++ < 10) {
            if (notExistedUrl(newUrl)) { //랜덤 문자열 중복 체크
                ShortenUrl shortenUrl = new ShortenUrl(destination, newUrl);
                shortenUrlRepository.createUrl(shortenUrl);
                return newUrl;
            }
        }
        throw new ManyDuplicationException("요청 횟수 초과");

    }

    public String getDestination(String newUrl){// 리다이렉트
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
    }

    private boolean notExistedUrl(String newUrl){
        if(shortenUrlRepository.checkUrl(newUrl))
            return false;
        else
            return true;
    }

    private void checkValidation(String text) {
        Pattern p = Pattern.compile("^((http|https)://)?(www.)?([a-zA-Z0-9]+)\\.[a-z]+([a-zA-Z0-9.?#]+)?");
        Matcher m = p.matcher(text);

        if(Boolean.FALSE == m.matches())
            throw new UrlFormatException("URL 형식이 맞지 않습니다.");
    }


}
