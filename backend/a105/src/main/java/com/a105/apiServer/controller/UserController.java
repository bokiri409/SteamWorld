package com.a105.apiServer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.a105.apiServer.dto.UserDto;
import com.a105.apiServer.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//로그인
	@PostMapping(value = "/login")
	private ResponseEntity login(@RequestBody Map map) {
		Map result = new HashMap();
		ResponseEntity entity = null;
		try {
			UserDto user = userService.login(map);
			if(user != null) {
				result.put("success", "success");
				result.put("data", user);
			}
			else {
				result.put("success", "fail");
				
			}
			entity = new ResponseEntity(result, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("success", "error");
			entity = new ResponseEntity(result, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@PostMapping(value="/join")
	private ResponseEntity join(@RequestBody UserDto user) {
		Map result = new HashMap();
        ResponseEntity entity = null;
        try {
        	if (userService.join(user) == 1) {
        		result.put("success", "success");
        		entity = new ResponseEntity<>(result, HttpStatus.OK);
        		
        	}
        	else {
        		result.put("success", "fail");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
        	}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error"); 
	        entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping(value = "")
	private ResponseEntity profile(@RequestParam String userid) {
		ResponseEntity entity = null;
		Map result = new HashMap();
		try {
			UserDto member = userService.info(userid);
			if (member != null) {
				result.put("success", "success");
				result.put("data", member);
				entity = new ResponseEntity<>(result, HttpStatus.OK);
				
			}
			else {
				result.put("success", "fail");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error");
			entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			
		}
		return entity;
	}
	
	@PutMapping(value = "")
	private ResponseEntity update(@RequestBody Map user) {
		ResponseEntity entity = null;
		Map result = new HashMap();
		try {
			if (userService.modify(user) == 1) {
				result.put("success", "success");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
				
			}
			else {
				result.put("success", "fail");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error");
			entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			
		}
		return entity;
	}
	
	@PutMapping(value="/password")
	private ResponseEntity updatePw(@RequestBody Map map) {
		ResponseEntity entity = null;
		Map result = new HashMap();
		try {
			if (userService.modifyPassword(map) == 1) {
				result.put("success", "success");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
			}
			else {
				result.put("success", "fail");
				entity = new ResponseEntity<>(result, HttpStatus.OK);			
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error");
			entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			
		}
		return entity;
	}
	
	
	@DeleteMapping(value="")
	private ResponseEntity delete(@RequestHeader Map map) {
		ResponseEntity entity = null;
		Map result = new HashMap();
		try {
			if (userService.secede(map)== 1) {
				result.put("success", "success");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
				
			}
			else {
				result.put("success", "fail");
				entity = new ResponseEntity<>(result, HttpStatus.OK);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "error");
			entity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			
		}
		return entity;
	}
}
