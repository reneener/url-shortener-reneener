package com.example.demo.application;
import com.example.demo.domain.ShortenUrl.ShortenUrl;
import com.example.demo.domain.ShortenUrl.ShortenUrlRepository;
import com.example.demo.domain.dto.ShortenUrlDto;
import com.example.demo.domain.exception.ManyDuplicationException;
import com.example.demo.presentation.dto.UrlDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service // UrlShortenerService 빈이 생성이 되어 관리된다.
@Slf4j
@RequiredArgsConstructor
public class UrlShortenerService {

    private final ShortenUrlRepository shortenUrlRepository;
    private final Base62Service base62Service;
    @Value("${demo.base-url}")
    private String baseUrl;

    public List<ShortenUrlDto> getShortenUrl(){
        return shortenUrlRepository.findAll()
            .stream()
            .map(ShortenUrlDto::fromEntity)
            .collect(Collectors.toList());
    }

    public UrlDto createUrl(String destination) {
        String newUrl = generateUniqueUrl(destination);
        ShortenUrl shortenUrl = saveShortenUrl(destination, newUrl);
        return UrlDto.fromUrl(shortenUrl);
    }

    public String getDestination(String newUrl){
        //cnt up
        return decodingId(newUrl).getDestination();
    }

    public ShortenUrl decodingId (String encodedId){
        Long decodedId =  base62Service.decodedId(encodedId);
        return shortenUrlRepository.findById(decodedId).orElse(null);
    }

    private String generateUniqueUrl(String destination) {
        String newUrl;
        int cnt = 0;
        do {
            if (cnt > 5) {
                throw new ManyDuplicationException("Failed to generate unique URL after 5 attempts");
            }
            newUrl = baseUrl + base62Service.encodedId(destination).substring(0, 7);
            cnt++;
        } while (shortenUrlRepository.findByNewUrl(newUrl).isPresent());
        return newUrl;
    }

    private ShortenUrl saveShortenUrl(String destination, String newUrl) {
        ShortenUrl shortenUrl = ShortenUrl.builder()
            .newUrl(newUrl)
            .destination(destination)
            .cnt(0)
            .build();
        return shortenUrlRepository.save(shortenUrl);
    }

    private String encodingUrl(String destination){
        return base62Service.encodedId(destination);
    }

}
