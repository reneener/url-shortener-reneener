package com.example.demo.domain.Member;

import com.example.demo.domain.ShortenUrl;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	private String userId;

	private String name;

	@OneToMany(mappedBy="member")
	private List<ShortenUrl> urls = new ArrayList<>();
}
