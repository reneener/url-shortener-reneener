package com.example.demo.infrastructure;

import com.example.demo.domain.ShortenUrl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ShortenUrlListRepository {
    // 직접 URL이 저장될 수 있고, 조회될 수 있는 클래스를 만들어야함.

    private List<ShortenUrl> shortenUrls = new ArrayList<>();

    // 생성 할 수 있는 메서드
    // BASE58 어려우면 UUID로 해보셔도됨.

    // 조회 할 수 있는 메서드

};
