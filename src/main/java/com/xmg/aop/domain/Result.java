package com.xmg.aop.domain;

import lombok.Data;

@Data
public class Result {
	
	private int code;
	
	private String msg;
	
	private Object data;
	
	
	public  static Result of() {
		return new Result();
	}
	
	public Result code(int code) {
		this.code = code;
		return this;
	}
	
	public Result msg(String msg) {
		this.msg = msg;
		return this;
	}
	
	public Result data(Object data) {
		this.data = data;
		return this;
	}
}
