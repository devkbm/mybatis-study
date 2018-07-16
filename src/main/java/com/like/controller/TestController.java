package com.like.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.repository.TestMapper;

@RestController
public class TestController {

	@Resource
	private TestMapper mapper;
	
	@GetMapping("/test1")
	public ResponseEntity<String> test1() {
		
		mapper.getUseXml();
		mapper.getUseAnnotation();
		
		return new ResponseEntity<String>("test1", HttpStatus.OK);
	}
	
	@GetMapping("/test2/{id}")
	public ResponseEntity<String> test2(@PathVariable(value="id") String id) {
		
		Map<String, String> param = new HashMap();		
		
		param.put("userid", id);
		
		List<Map<String,String>> list = mapper.getUseDynamicSql1(param);
		
		String rtn = list.get(0).get("user_id");
		
		return new ResponseEntity<String>(rtn, HttpStatus.OK);
	}
	
	@GetMapping("/test3/{id}")
	public ResponseEntity<String> test3(@PathVariable(value="id") String id) {
		
		Map<String, String> param = new HashMap();		
		
		param.put("userid", id);
		
		List<Map<String,String>> list = mapper.getUseDynamicSql2(param);
		
		String rtn = list.get(0).get("user_id");		
		
		return new ResponseEntity<String>(rtn, HttpStatus.OK);
	}
	
	@GetMapping("/test4/{id}")
	public ResponseEntity<String> test4(@PathVariable(value="id") String id) {
		
		List<String> userList = new ArrayList();		
		
		userList.add("1");
		userList.add("2");
		userList.add("3");
		
		List<Map<String,String>> list = mapper.getUseDynamicSql3(userList);
		
		String rtn = list.get(0).get("user_id");		
		
		return new ResponseEntity<String>(rtn, HttpStatus.OK);
	}
}
