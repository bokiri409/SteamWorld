package com.a105.apiServer.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a105.apiServer.dao.UserDao;
import com.a105.apiServer.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public UserDto login(Map map) throws Exception {
		// TODO Auto-generated method stub
		return userDao.login(map);
	}

	@Override
	public int join(UserDto user) throws Exception {
		// TODO Auto-generated method stub
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
