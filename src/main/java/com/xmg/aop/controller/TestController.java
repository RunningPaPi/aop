package com.xmg.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmg.aop.ResultUtil;
import com.xmg.aop.domain.Result;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

	@GetMapping("/aop1")
	public Result aopTest(@RequestParam String id) {
		log.info("aopTest");
		return ResultUtil.success("ojbk");
	}

	@GetMapping("/aop2")
	public Result aopTest2(@RequestParam String id) {
		log.info("aopTest");
		return ResultUtil.success("madan");
	}

	@GetMapping("/aop3")
	public Result aopTest3(@RequestParam int id) {
		log.info("aopTest");
		if (id != 1) {
			throw new RuntimeException("来啊，快活啊!!!");
		}
		return ResultUtil.success("madan");
	}
}
