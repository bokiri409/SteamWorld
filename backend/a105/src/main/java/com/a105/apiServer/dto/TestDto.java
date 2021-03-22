package com.a105.apiServer.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestDto {
	private int testId;
	private String testDesc;
	public TestDto(int testId, String testDesc) {
		super();
		this.testId = testId;
		this.testDesc = testDesc;
	}
	
	
	
	
}
