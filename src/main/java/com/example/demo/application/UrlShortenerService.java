package com.example.demo.application;
import com.example.demo.domain.ShortenUrl.ShortenUrl;
import com.example.demo.domain.ShortenUrl.ShortenUrlRepository;
import com.example.demo.domain.dto.ShortenUrlDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service // UrlShortenerService 빈이 생성이 되어 관리된다.
@Slf4j
@RequiredArgsConstructor
public class UrlShortenerService {

    private final ShortenUrlRepository shortenUrlRepository;
    private final Base62Service base62Service;

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
    public String getDestination(String newUrl){
        //cnt up
        return decodingId(newUrl).getDestination();
    }
    public ShortenUrl decodingId (String encodedId){
        Long decodedId =  base62Service.decodedId(encodedId);
        return shortenUrlRepository.findById(decodedId).orElse(null);
    }
}
