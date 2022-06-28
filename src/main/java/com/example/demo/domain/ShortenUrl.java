package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class ShortenUrl {
    private String id;
    private String prevUrl;
    private String newUrl;
    private int cnt;

    public ShortenUrl(String prevUrl, String newUrl, int cnt){
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.prevUrl = prevUrl;
        this.newUrl = newUrl;
        this.cnt = cnt;
    }

};
