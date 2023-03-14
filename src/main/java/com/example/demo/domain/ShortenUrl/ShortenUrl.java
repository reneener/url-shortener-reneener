package com.example.demo.domain.ShortenUrl;

import java.sql.Timestamp;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity(name = "url")
@Table(name = "\"url\"")
@NoArgsConstructor
@Builder
@Getter
@AllArgsConstructor
@SQLDelete(sql = "UPDATE url SET deleted_at = NOW() where id = ?")
@Where(clause = "deleted_at is NULL")
public class ShortenUrl{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "destination", length = 2100)
    private String destination;
    @Column(name = "new_url")
    private String newUrl;
    @Column(name = "cnt")
    private int cnt;
    @Column(name = "register_at")
    private Timestamp registeredAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @PrePersist
    void registeredAt() {
        this.registeredAt = Timestamp.from(Instant.now());
    }
    @PreUpdate
    void updatedAt() {
        this.updatedAt = Timestamp.from(Instant.now());
    }
    public void cntUp() {
        this.cnt = this.cnt + 1;
    }

}
