package com.example.demo.application;
import com.example.demo.domain.ShortenUrl.ShortenUrl;
import com.example.demo.domain.ShortenUrl.ShortenUrlRepository;
import com.example.demo.domain.dto.ShortenUrlDto;
import com.example.demo.domain.exception.AlreadyExistShortenUrlException;
import com.example.demo.domain.exception.ManyDuplicationException;
import com.example.demo.domain.exception.NewUrlNotFoundException;
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

    public List<UrlDto> getShortenUrl(){
        return shortenUrlRepository.findAll()
            .stream()
            .map(UrlDto::fromUrl)
            .collect(Collectors.toList());
    }

    public UrlDto createUrl(String destination) {
        shortenUrlRepository.findByDestination(destination).ifPresent(it -> {
            throw new AlreadyExistShortenUrlException("Already exists this URL");
        });
        String newUrl = generateUniqueUrl(destination);
        ShortenUrl shortenUrl = saveShortenUrl(destination, newUrl);
        return UrlDto.fromUrl(shortenUrl);
    }

    public String getDestination(String newUrl) {
        ShortenUrl shortenUrl = shortenUrlRepository.findByNewUrl(baseUrl + newUrl)
            .orElseThrow(() -> new NewUrlNotFoundException("Not found request URL"));
        shortenUrl.cntUp();
        return shortenUrl.getDestination();
    }

    public List<UrlDto> deleteUrl(String newUrl){
        ShortenUrl shortenUrl = shortenUrlRepository.findByNewUrl(newUrl)
            .orElseThrow(() -> new NewUrlNotFoundException("Not found request URL"));
        shortenUrlRepository.deleteById(shortenUrl.getId());
        return getShortenUrl();
    }

    private String generateUniqueUrl(String destination) {
        String newUrl;
        int cnt = 0;
        do {
            if (cnt > 5) {
                throw new ManyDuplicationException("Failed to generate unique URL after 5 attempts");
            }
            newUrl = baseUrl + base62Service.encoding(destination).substring(0, 7);
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

}
