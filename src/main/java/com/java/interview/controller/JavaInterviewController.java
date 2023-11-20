package com.java.interview.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JavaInterviewController {

	@RequestMapping("/echo/{name}")
	public String echo(@PathVariable String name) {
		return "Hello, " + name;
	}
}
