package com.example.demo.presentation;

import com.example.demo.application.UrlShortenerService;
import com.example.demo.domain.ShortenUrl.ShortenUrl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    @RequestMapping(path = "/url" ,method = RequestMethod.POST)
    public String create(@RequestBody String destination){
        String shortUrl = urlShortenerService.createUrl(destination);
        return shortUrl;
    }

    //		- 생성된 단축 URL로 요청시 원래 URL로 리다이렉트
    @GetMapping(path = "/url/{encodedId}")
    public String searchDestination(@PathVariable String encodedId){
        ShortenUrl shortenUrl = urlShortenerService.decodingId(encodedId);
        return shortenUrl.getNewUrl();
    }

};
