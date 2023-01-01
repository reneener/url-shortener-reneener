package com.example.demo.domain.ShortenUrl;

import com.example.demo.domain.Audit;
import com.example.demo.domain.Member.Member;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

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
    public void countUp() {
        this.cnt = this.cnt + 1;
    }

    public void setNewUrl(String newUrl){
        this.newUrl = newUrl;
    }

};
