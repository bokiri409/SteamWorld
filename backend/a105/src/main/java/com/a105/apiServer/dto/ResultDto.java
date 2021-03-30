package com.a105.apiServer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResultDto {
	private int resultid;
	private int appid;
	private String name;
	private double predictions;
	private String userid;
}
