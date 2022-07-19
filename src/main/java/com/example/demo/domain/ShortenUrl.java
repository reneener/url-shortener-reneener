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
    private String destination;
    private String newUrl;
    private int cnt;

    public ShortenUrl(String destination, String newUrl){
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.destination = destination;
        this.newUrl = newUrl;
        this.cnt = 0;
    }

    public void countUp() {
        this.cnt = this.cnt + 1;
    }

};
