package com.example.demo.domain.ShortenUrl;
import com.example.demo.domain.Audit;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< Updated upstream
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Getter
<<<<<<< HEAD
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
=======
@Entity(name = "url")
@NoArgsConstructor
@Builder
@AllArgsConstructor
>>>>>>> 5361025982cdd4df6aaa8b155ce98ddbd71cda2a
public class ShortenUrl extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destination;
    private String newUrl;
    private int cnt;
<<<<<<< HEAD
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

=======
>>>>>>> 5361025982cdd4df6aaa8b155ce98ddbd71cda2a
    public void countUp() {
        this.cnt = this.cnt + 1;
    }

<<<<<<< HEAD
=======
    public void cntUp() {
        this.cnt = this.cnt + 1;
    }
>>>>>>> Stashed changes
=======
    public void setNewUrl(String newUrl){
        this.newUrl = newUrl;
    }

>>>>>>> 5361025982cdd4df6aaa8b155ce98ddbd71cda2a
};
