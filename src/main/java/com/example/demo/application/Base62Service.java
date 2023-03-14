package com.example.demo.application;

import io.seruco.encoding.base62.Base62;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Base62Service {

	private static final Base62 base62Instance = Base62.createInstance();

	public String encodedId(String destination){
		String newUrl = new String(base62Instance.encode(destination.getBytes()));
		return newUrl;
	}
	public Long decodedId(String encodedId){
		String id = new String(base62Instance.decode(encodedId.getBytes()));
		return Long.valueOf(id);
	}

}
