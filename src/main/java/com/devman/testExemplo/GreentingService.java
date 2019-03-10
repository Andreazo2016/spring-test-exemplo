package com.devman.testExemplo;

import org.springframework.stereotype.Service;

@Service
public class GreentingService {

	public String hello() {
		return "Hello, boy";
	}
}
