package com.example.demo.domain.ShortenUrl;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
<<<<<<< Updated upstream
public interface ShortenUrlRepository {
    void createUrl(ShortenUrl url);
    String getDestination (String newUrl);
    boolean checkUrl(String newUrl);
=======
public interface ShortenUrlRepository extends JpaRepository<ShortenUrl, Long>{
>>>>>>> Stashed changes
=======
public interface ShortenUrlRepository extends JpaRepository<ShortenUrl, Long>{

>>>>>>> 5361025982cdd4df6aaa8b155ce98ddbd71cda2a
}
