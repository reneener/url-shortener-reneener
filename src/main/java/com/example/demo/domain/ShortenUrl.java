package com.example.demo.domain;

import com.example.demo.domain.user.User;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.UUID;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@ToString
@Entity
public class ShortenUrl {

    @Id @GeneratedValue
    private long id;
    @URL
    private String destination;
    @URL
    private String newUrl;
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    private int cnt;

    @Builder
    public ShortenUrl(String destination, String newUrl, String userId){
        this.destination = destination;
        this.newUrl = newUrl;
        this.cnt = 0;
        this. = userId;
    }

    public void countUp() {
        this.cnt = this.cnt + 1;
    }

};
