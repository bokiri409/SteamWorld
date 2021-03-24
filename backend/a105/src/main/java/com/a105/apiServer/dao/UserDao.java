package com.a105.apiServer.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.a105.apiServer.dto.UserDto;

@Mapper
public interface UserDao {
	public UserDto login(Map map) throws Exception;
	public int insertUser(UserDto user) throws Exception;
	public UserDto getUser(String userid) throws Exception;
	public int updateUser(Map map) throws Exception;
	public int updatePassword(Map map) throws Exception;
	public int deleteUser(Map map) throws Exception;
}
