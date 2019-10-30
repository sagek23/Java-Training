package com.bit.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProfilingAdvice {
	
	@Pointcut("execution(public * com.bit.dao..*(..))")
	public void profileTarget()
	{
		
	}
	@Around("profileTarget()")
	public Object pro(ProceedingJoinPoint joinPoint)
	{
		Object ret = null;
		try {
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println(methodName+"�� �����ϱ� ��");
			long start = System.currentTimeMillis();
			ret=joinPoint.proceed();
			long end = System.currentTimeMillis();
			System.out.println(methodName+" ���� �Ϸ�");
			System.out.println("�ɸ��ð� "+(end-start));
		} catch (Throwable e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return ret;
	}
}
