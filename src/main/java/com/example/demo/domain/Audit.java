package com.example.demo.domain;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Getter
@EntityListeners(value = AuditingEntityListener.class)
public abstract class Audit {
	@CreatedDate
	@Column(name="created_at")
	protected LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name="updated_at")
	protected LocalDateTime updatedAt;

	@Column(name = "deleted_at")
	protected LocalDateTime deletedAt;

	@PrePersist
	void createdAt() {
		this.createdAt = LocalDateTime.from(Instant.now());
	}

	@PreUpdate
	void updatedAt() {
		this.updatedAt = LocalDateTime.from(Instant.now());
	}

}
