package com.howie.domain.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.howie.domain.annotation.Cluster;
import com.howie.domain.mapper.User;
import com.howie.domain.service.UserService;

@Controller
@RestController
@RequestMapping("/user")
@Api(tags="用戶管理接口")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/addUser.json",method=RequestMethod.GET)
	@ApiOperation(value="添加用戶",notes="添加用戶")
	int addUser(String id,String name,String pass){
		return userService.insert(id, name, pass);
	}
	
	@RequestMapping(value="/queryUser.json",method=RequestMethod.GET)
	@ApiOperation(value="查詢用戶",notes="查詢用戶")
	User queryUser(String name){
		return userService.findByName(name);
	}
	
}
