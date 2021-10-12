package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect //위빙처리의 대상 == 포인트컷+어드바이스 결합
public class BeforeAdvice {
	
	@Before("PointcutCommon.bPointcut()")
	public void printLog() {
		System.out.println("데이터 출력이 시작됩니다!");
	}
}
