package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect //����ó���� ��� == ����Ʈ��+�����̽� ����
public class BeforeAdvice {
	
	@Before("PointcutCommon.bPointcut()")
	public void printLog() {
		System.out.println("������ ����� ���۵˴ϴ�!");
	}
}
