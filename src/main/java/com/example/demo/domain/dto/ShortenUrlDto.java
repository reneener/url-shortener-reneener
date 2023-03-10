package com.example.demo.domain.dto;

import com.example.demo.domain.ShortenUrl.ShortenUrl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShortenUrlDto {
	private Long id;
	private String destination;
	private String newUrl;

	public static ShortenUrlDto fromEntity(ShortenUrl shortenUrl){
		return new ShortenUrlDto(
			shortenUrl.getId(),
			shortenUrl.getDestination(),
			shortenUrl.getNewUrl()
		);
	}
}
