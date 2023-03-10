package com.example.demo.domain.ShortenUrl;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< Updated upstream
public interface ShortenUrlRepository {
    void createUrl(ShortenUrl url);
    String getDestination (String newUrl);
    boolean checkUrl(String newUrl);
=======
public interface ShortenUrlRepository extends JpaRepository<ShortenUrl, Long>{
>>>>>>> Stashed changes
}
