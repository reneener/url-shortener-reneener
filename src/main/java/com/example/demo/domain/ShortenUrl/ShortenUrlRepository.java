package com.example.demo.domain.ShortenUrl;

//왜 service를 interface로 만들지 않고 repository를 만드는지

import com.example.demo.domain.ShortenUrl.ShortenUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortenUrlRepository extends JpaRepository<ShortenUrl, Long>{

}
