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
	
	@GetMapping("/select1")
	public ResponseEntity<String> select1() {
		
		mapper.getUseXml();
		mapper.getUseAnnotation();
		
		return new ResponseEntity<String>("test1", HttpStatus.OK);
	}
	
	@GetMapping("/select2/{id}")
	public ResponseEntity<String> select2(@PathVariable(value="id") String id) {
		
		Map<String, String> param = new HashMap();		
		
		param.put("userid", id);
		
		List<Map<String,String>> list = mapper.getUseDynamicSql1(param);
		
		String rtn = list.get(0).get("user_id");
		
		return new ResponseEntity<String>(rtn, HttpStatus.OK);
	}
	
	@GetMapping("/select3/{id}")
	public ResponseEntity<String> select3(@PathVariable(value="id") String id) {
		
		Map<String, String> param = new HashMap();		
		
		param.put("userid", id);
		
		List<Map<String,String>> list = mapper.getUseDynamicSql2(param);
		
		String rtn = list.get(0).get("user_id");		
		
		return new ResponseEntity<String>(rtn, HttpStatus.OK);
	}
	
	@GetMapping("/select4/{id}")
	public ResponseEntity<String> select4(@PathVariable(value="id") String id) {
		
		List<String> userList = new ArrayList();		
		
		userList.add("1");
		userList.add("2");
		userList.add("3");
		
		List<Map<String,String>> list = mapper.getUseDynamicSql3(userList);
		
		String rtn = list.get(0).get("user_id");		
		
		return new ResponseEntity<String>(rtn, HttpStatus.OK);
	}
	
	@GetMapping("/insert")
	public ResponseEntity<String> insert() {
		
		Map<String,String> user = new HashMap<String, String>();
		
		user.put("user_id",		"test");
		user.put("user_name", 	"테스트");
		user.put("password", 	"1234");
		
		int rtn = mapper.insertUser(user);
		
		System.out.println(rtn);		
		
		return new ResponseEntity<String>("등록되었습니다.", HttpStatus.OK);
	}
	
	@GetMapping("/update")
	public ResponseEntity<String> update() {
		
		Map<String,String> user = new HashMap<String, String>();
		
		user.put("user_id",		"test");
		user.put("user_name", 	"테스트22");
		user.put("password", 	"1234555");
		
		int rtn = mapper.updateUser(user);
		
		System.out.println(rtn);		
		
		return new ResponseEntity<String>("수정되었습니다.", HttpStatus.OK);
	}
	
	@GetMapping("/delete")
	public ResponseEntity<String> delete() {
		
		Map<String,String> user = new HashMap<String, String>();
		
		user.put("user_id",	"test");
	
		int rtn = mapper.deleteUser(user);
		
		System.out.println(rtn);		
		
		return new ResponseEntity<String>("삭제되었습니다.", HttpStatus.OK);
	}
	
	
	
	
	
}
