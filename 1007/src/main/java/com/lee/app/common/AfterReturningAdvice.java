package com.lee.app.common;

import org.aspectj.lang.JoinPoint;

import model.member123.Member123VO;

public class AfterReturningAdvice {
	public void printLog(JoinPoint jp,Object obj) {
		String name=jp.getSignature().getName();
		System.out.println("�޼����: "+name);
		if(obj instanceof Member123VO) {
			Member123VO data=(Member123VO)obj;
			if(data.getRole().equals("ADMIN")) {
				System.out.println("������ �α���");
			}
			else {
				System.out.println("�Ϲݻ���� �α���");
			}
		}
		System.out.println("get()�� ���յǴ� returning");
	}
}
