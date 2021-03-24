package com.a105.apiServer.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
	private String userid;
	private String password;
	private String nickname;
	private int steamid;
		
	public UserDto(String userid, String password, String nickname, int steamid) {
		super();
		this.userid = userid;
		this.password = password;
		this.nickname = nickname;
		this.steamid = steamid;
	}
	
	
}
