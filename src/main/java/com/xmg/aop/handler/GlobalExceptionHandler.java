package com.xmg.aop.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.aop.ResultUtil;
import com.xmg.aop.domain.Result;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if(e instanceof RuntimeException) {
			return ResultUtil.error(100, e.getMessage());
		}
		return ResultUtil.error(-1, e.getMessage());
	}
}
