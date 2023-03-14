package com.example.demo.presentation.dto;

import com.example.demo.domain.ShortenUrl.ShortenUrl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UrlDto {
	private String destination;
	private String newUrl;

	public static UrlDto fromUrl(ShortenUrl url){
		return new UrlDto(
			url.getDestination(),
			url.getNewUrl()
		);
	}
}
