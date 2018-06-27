package com.xmg.aop.core;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class HttpAspect {

	@Pointcut("execution(public * com.xmg.aop.controller.*.*(..))")
	private void log() {
	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// url
		log.info("ip={};url={};method={};class_method={}.{};args={}", request.getRemoteAddr(), request.getRequestURI(),
				request.getMethod(), joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), joinPoint.getArgs());
	}

	@After("log()")
	public void doAfter() {
		log.info("after");
	}

	@AfterReturning(returning = "object", pointcut = "log()")
	public void afterReturning(Object object) {
		log.info("response={}", object);
	}
}
