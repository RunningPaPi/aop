package com.xmg.aop;

import com.xmg.aop.domain.Result;

public class ResultUtil {
	
	public static Result success(Object object) {
		return Result.of().code(0).msg("成功").data(object);
	}
	
	public static Result success() {
		return success(null);
	}
	
	public static Result error(int code, String msg) {
		return Result.of().code(code).msg(msg);
	}
}
