package com.example.demo.presentation;

import com.example.demo.application.UrlShortenerService;
<<<<<<< Updated upstream
=======
import com.example.demo.domain.ShortenUrl.ShortenUrl;
import com.example.demo.domain.dto.ShortenUrlDto;
import java.util.List;
>>>>>>> Stashed changes
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UrlShortenerController {
    //		다음 요구사항을 만족하는 단축 URL 생성 API 개발
    //		- 단축 URL 생성 기능
    //		- 생성된 단축 URL로 요청시 원래 URL로 리다이렉트
    private final UrlShortenerService urlShortenerService;

<<<<<<< Updated upstream
    // 특정 자원에 대해 생성, 조회(id -> 단축된 문자열)
    //Q. 왜 requestParam 인쓰고 @RequestBody
    //Q. Interface 쓰는 이유
    @RequestMapping(path = "/url" ,method = RequestMethod.POST)
    public String create(@RequestBody String destination){
        String shortUrl = urlShortenerService.createUrl(destination);

        //ops.set(key, shortUrl);

        return shortUrl;
    }

    //		- 생성된 단축 URL로 요청시 원래 URL로 리다이렉트
    @RequestMapping(path = "/url/{newUrl}", method = RequestMethod.GET)
    public String search(@PathVariable(value = "newUrl") String newUrl){
        String destination = urlShortenerService.getDestination(newUrl);
        //ops.get("key");
        return destination;
=======
    @GetMapping(path = "/url")
    public List<ShortenUrlDto> getUrl(){
        return urlShortenerService.getShortenUrl();
    }
    @RequestMapping(path = "/url" ,method = RequestMethod.POST)
    public void create(@RequestBody String destination){
       urlShortenerService.createUrl(destination);
    }
    @GetMapping(path = "/url/{encodedId}")
    public String searchDestination(@PathVariable String encodedId){
        return urlShortenerService.decodingId(encodedId).getNewUrl();
>>>>>>> Stashed changes
    }

};
