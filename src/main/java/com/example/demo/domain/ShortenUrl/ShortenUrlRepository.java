package com.example.demo.domain.ShortenUrl;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortenUrlRepository extends JpaRepository<ShortenUrl, Long>{
	Optional<ShortenUrl> findByNewUrl(String newUrl);
}
