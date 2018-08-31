package com.howie.domain.service;

import org.springframework.stereotype.Service;

import com.howie.domain.annotation.Cluster;
import com.howie.domain.mapper.User;

public interface UserService {

	User findByName(String name);
	
	int insert(String id,String name,String pass);
		
}