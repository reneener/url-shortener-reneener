package com.example.demo.presentation;
import com.example.demo.application.UrlShortenerService;
import com.example.demo.domain.dto.ShortenUrlDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    @GetMapping(path = "/url")
    public List<ShortenUrlDto> getUrl(){
        return urlShortenerService.getShortenUrl();
    }
    @RequestMapping(path = "/url" ,method = RequestMethod.POST)
    public void create(@RequestBody String destination){
       urlShortenerService.createUrl(destination);
    }
    @GetMapping(path = "/url/{encodedId}")
    public String searchDestination(@PathVariable String encodedId) {
        return urlShortenerService.decodingId(encodedId).getNewUrl();
    }
}
