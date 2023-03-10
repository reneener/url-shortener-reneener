package com.example.demo.domain.ShortenUrl;
import com.example.demo.domain.Audit;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
<<<<<<< Updated upstream
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;

@Getter
@Entity
=======
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "url")
@NoArgsConstructor
@AllArgsConstructor
@Builder
>>>>>>> Stashed changes
public class ShortenUrl extends Audit {

    @Id @GeneratedValue
    private Long id;

    @URL
    private String destination;

    @URL
    private String newUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    private int cnt;
<<<<<<< Updated upstream

    @Builder
    public ShortenUrl(String destination, String newUrl){
        this.destination = destination;
        this.newUrl = newUrl;
        this.cnt = 0;
    }

    public ShortenUrl() {
    }

    public void setMember(Member member){
        this.member = member;
        member.getUrls().add(this);
    }

    public void countUp() {
        this.cnt = this.cnt + 1;
    }

=======
    public void cntUp() {
        this.cnt = this.cnt + 1;
    }
>>>>>>> Stashed changes
};
