package com.a105.apiServer.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.a105.apiServer.dao.UserDao;
import com.a105.apiServer.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	UserDao userDao;
	
	PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
		// TODO Auto-generated constructor stub
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public UserDto login(Map map) throws Exception {
		// TODO Auto-generated method stub
		UserDto user = userDao.getUser(map.get("userid").toString());
		System.out.println(user.getPassword());
		System.out.println(passwordEncoder.matches((String) map.get("password"), user.getPassword()));
		if(passwordEncoder.matches((String) map.get("password"), user.getPassword())) {
			map.put("password", user.getPassword());
			return userDao.login(map);			
		}
		else {
			return null;
		}
	}

	@Override
	public int join(UserDto user) throws Exception {
		// TODO Auto-generated method stub
		String securePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(securePassword);
		return userDao.insertUser(user);
	}

	@Override
	public UserDto info(String userid) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("userid : " + userid);

		return userDao.getUser(userid);
	}

	@Override
	public int modify(Map map) throws Exception {
		// TODO Auto-generated method stub
		return userDao.updateUser(map);
	}

	@Override
	public int modifyPassword(Map map) throws Exception {
		// TODO Auto-generated method stub
		return userDao.updatePassword(map);
	}

	@Override
	public int secede(Map map) throws Exception {
		// TODO Auto-generated method stub
		return userDao.deleteUser(map);
	}

}
