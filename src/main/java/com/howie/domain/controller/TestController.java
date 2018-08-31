package com.howie.domain.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/test")
@Api(tags="測試接口")
public class TestController {

	@Value("${test_variable}")
	private int test_variable;
	
	@RequestMapping(value="/test.json",method=RequestMethod.GET)
	@ApiOperation(value="测试接口",notes="返回问候信息")
	String index(){
		return "Hello,This is SpringBoot!";
	}
	
	
	@RequestMapping(value="/now.json",method=RequestMethod.GET)
	@ApiOperation(value="测试时间接口",notes="返回当前时间")
	String now(){
		return "現在是北京時間："+LocalDateTime.now().toString();
	}
	
	@RequestMapping(value="/getVar.json",method=RequestMethod.GET)
	@ApiOperation(value="获取yml配置变量",notes="获取配置文件变量")
	int getVar(){
		return test_variable;
	}
	
}
