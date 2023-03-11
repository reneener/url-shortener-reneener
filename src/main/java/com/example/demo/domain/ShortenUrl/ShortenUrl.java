package com.example.demo.domain.ShortenUrl;

import com.example.demo.domain.Audit;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "url")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShortenUrl extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destination;
    private String newUrl;
    private int cnt;
    public void cntUp() {
        this.cnt = this.cnt + 1;
    }
}
