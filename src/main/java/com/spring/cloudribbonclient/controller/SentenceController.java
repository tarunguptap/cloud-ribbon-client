package com.spring.cloudribbonclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {

	@Autowired
	RestTemplate client;

	@GetMapping("/sentence")
	public @ResponseBody String getSentence() {
		return getWord("CLOUD-EUREKA-CLIENT1") + " " + getWord("CLOUD-EUREKA-CLIENT2") + ".";
	}

	public String getWord(String service) {
		return client.getForObject("http://" + service, String.class);
	}
}
