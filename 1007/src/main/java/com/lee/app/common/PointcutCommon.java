package com.lee.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	// ���� �޼���
		// �����̽��� ����Ʈ���� "�ĺ�"�ϱ����� �ۼ�
		// ������ �ۼ����ʿ�xxx. {}�ٵ���� �������
	
	@Pointcut("execution(* model.board123.*Impl.get*(..))")
	public void aPointcut() {}
	
	@Pointcut("execution(* model.board123.*Impl.*(..))")
	public void bPointcut() {}
	
	@Pointcut("execution(* model.member123.*Impl.*(..))")
	public void cPointcut() {}
	
}
