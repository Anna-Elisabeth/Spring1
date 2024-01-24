package com.lbg.project1.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

	@GetMapping("/hello")

	public String greeting() {

		return "Hello, World";
	}

	@GetMapping("/hi")
	public String catGreeting() {
		return "Miaowsome. Cats will rule the world for ever";
	}

//	@GetMapping("/hi")
//	public int catAge() {
//		return 100;
//	}

}
