package com.bit.bookStore.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bit.bookStore.dao.MethodLogDao;
import com.bit.bookStore.vo.MethodLog;
@Component
@Aspect
public class ProfilingAspect {
	@Autowired
	private MethodLogDao dao = new MethodLogDao();
	
	public void setDao(MethodLogDao dao) {
		this.dao = dao;
	}

	@Pointcut("execution(public * com.bit.bookStore.dao..*(..))")
	public void profileTarget()
	{
		
	}
	
	@Around("profileTarget()")
	public Object pro(ProceedingJoinPoint joinPoint)
	{
		Object ret = null;
		try {
				long start = System.currentTimeMillis();
				ret = joinPoint.proceed();
				long end = System.currentTimeMillis();
				long requiredTime = end - start;
				String methodName = joinPoint.getSignature().toShortString();
				
				MethodLog log = new MethodLog(0, methodName, null, (int)requiredTime);
				dao.insert(log);
				System.out.println(log+"�쓽 �젙蹂대�� 湲곕줉�븯���뒿�땲�떎.");
		} catch (Throwable e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return ret;
	}
}
