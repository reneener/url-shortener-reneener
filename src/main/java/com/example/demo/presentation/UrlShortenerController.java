package com.example.demo.presentation;
import com.example.demo.application.UrlShortenerService;
import com.example.demo.domain.dto.ShortenUrlDto;
import com.example.demo.presentation.dto.UrlDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@Slf4j
@RestController
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    @GetMapping(path = "/url")
    public List<ShortenUrlDto> getUrl(){
        return urlShortenerService.getShortenUrl();
    }
    @PostMapping(path="/url")
    public UrlDto create(@RequestBody UrlDto request){
        log.error(request.getDestination());
        return urlShortenerService.createUrl(request.getDestination());
    }
    @GetMapping(path = "/url/{encodedId}")
    public String searchDestination(@PathVariable String encodedId) {
        return urlShortenerService.decodingId(encodedId).getNewUrl();
    }
}
