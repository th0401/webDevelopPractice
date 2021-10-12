package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

	@Pointcut("execution(* model..*Impl.*(..))")
	public void aPointcut() {}
	
	@Pointcut("execution(* model..*Impl.get*(..))")
	public void bPointcut() {}

	
}
