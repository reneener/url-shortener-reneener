package com.example.demo.presentation;
import com.example.demo.application.UrlShortenerService;
import com.example.demo.domain.dto.ShortenUrlDto;
import com.example.demo.presentation.dto.UrlDto;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@Slf4j
@RestController
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    @GetMapping(path = "/url")
    public List<UrlDto> getAllUrl(){
        return urlShortenerService.getShortenUrl();
    }

    @PostMapping(path="/url")
    public UrlDto create(@RequestBody UrlDto request){
        return urlShortenerService.createUrl(request.getDestination());
    }

    @GetMapping(path = "/{newUrl}")
    public void redirect(@PathVariable String newUrl, HttpServletResponse httpServletResponse) throws IOException {
        String destination = urlShortenerService.getDestination(newUrl);
        httpServletResponse.sendRedirect(destination);
    }

    @DeleteMapping(path="/url")
    public List<UrlDto> delete(@RequestBody UrlDto request){
       return urlShortenerService.deleteUrl(request.getNewUrl());
    }
}
