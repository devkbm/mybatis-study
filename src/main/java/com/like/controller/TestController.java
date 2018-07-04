package com.like.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.repository.TestMapper;

@RestController
public class TestController {

	@Resource
	private TestMapper mapper;
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		
		mapper.getUseXml();
		mapper.getUseAnnotation();
		
		return new ResponseEntity<String>("test", HttpStatus.OK);
	}
}
