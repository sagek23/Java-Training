package com.bit.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
/*
AroundAdvice�� ������ ������ �����̽����� JoinPoint�� �������� �޴´�
�ٽ�Ÿ���� �Ǵ� �޼ҵ��� ������ �ʿ��ϴٸ� JoinPoint�� �Ű������� ���´�.
�׷��� �ʴٸ� ������ �� �ִ�. 
�׷��� AroundAdvice�� Ÿ���� �Ǵ� �޼ҵ尡 �����ϱ� ���� ó���� �ϵ� �ְ�
Ÿ���� �Ǵ� �޼ҵ� ������ �Ŀ� ���ϵ� �ֱ� ������ Advice �ȿ��� Ÿ���� �Ǵ� 
�޼ҵ带 ȣ��������Ѵ�. 
JoinPoint�� ���ؼ� Ÿ���� �Ǵ� �޼ҵ带 ȣ���Ѵ�. ���� AroundAdvice��
�ݵ�� JoinPoint�� �Ű������� �������Ѵ�. 
*/
public class ProfilingAdvice {
	public void after(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().toString();
		String aa = joinPoint.getTarget().toString();
		String param = joinPoint.getArgs().toString();
		//System.out.println(param);
		//System.out.println(aa);
		System.out.println("Ÿ��޼ҵ� "+methodName+"�� �Ϸ��");
	}
	//public void after_returning()
	//public void after_returning(JoinPoint joinPoint)
	public void after_returning(JoinPoint joinPoint, Object ret)
	{
		String methodName = joinPoint.getSignature().toString();;
		System.out.println("Ÿ��޼ҵ� "+methodName +"�� ����Ϸ� ��");
		System.out.println("Ÿ��޼ҵ尡 ��ȯ�� ��: "+ret);
	}
	
	//public void afterthrowing()
	//public void afterthrowing(JoinPoint joinPoint)
	//public void afterthrowing(Throwable ex)
	public void afterthrowing(JoinPoint joinPoint, Throwable ex) 
	//JoinPoint�� Throwble �� �Ѵ� �ʿ��� ��� JoinPoint�� ���� �;���
	{
		//System.out.println("Ÿ��޼ҵ� ���� ��"+ex.getMessage()+"���� �߻�");
		String methodName = joinPoint.getSignature().toString();
		System.out.println(methodName+" ���� �� ���� �߻�"+ex.getMessage()+"���� �߻�");
		//System.out.println(methodName+"���� �� ���� �߻�");
	}
	
	public void before(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().toLongString();
		System.out.println( methodName+" ���� ��");
	}
	
	public Object pro(ProceedingJoinPoint joinPoint)//aop Around
	{
		Object re = null;
		try {
			//Ÿ���� �Ǵ� �޼ҵ� �����ϱ� ���� ���ϵ�
			long start = System.currentTimeMillis();
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println(methodName+"�� �����ϱ� ��");
			re = joinPoint.proceed();
			long end=  System.currentTimeMillis();
			//Ÿ���� �Ǵ� �޼ҵ� ������ �Ŀ� ���ϵ�
			System.out.println(methodName+"�� ������ ��");
			System.out.println("�ɸ��ð�: "+(end-start));
		} catch (Throwable e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
}
