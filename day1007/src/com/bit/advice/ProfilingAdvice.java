package com.bit.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
/*
AroundAdvice를 제외한 나머지 어드바이스들은 JoinPoint를 선택적을 받는다
핵심타깃이 되는 메소드의 정보가 필요하다면 JoinPoint를 매개변수로 갖는다.
그렇지 않다면 생략할 수 있다. 
그러나 AroundAdvice는 타겟이 되는 메소드가 동작하기 전에 처리할 일도 있고
타깃이 되는 메소드 동작한 후에 할일도 있기 때문에 Advice 안에서 타깃이 되는 
메소드를 호출해줘야한다. 
JoinPoint를 통해서 타깃이 되는 메소드를 호출한다. 따라서 AroundAdvice는
반드시 JoinPoint를 매개변수로 가져야한다. 
*/
public class ProfilingAdvice {
	public void after(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().toString();
		String aa = joinPoint.getTarget().toString();
		String param = joinPoint.getArgs().toString();
		//System.out.println(param);
		//System.out.println(aa);
		System.out.println("타깃메소드 "+methodName+"이 완료됨");
	}
	//public void after_returning()
	//public void after_returning(JoinPoint joinPoint)
	public void after_returning(JoinPoint joinPoint, Object ret)
	{
		String methodName = joinPoint.getSignature().toString();;
		System.out.println("타깃메소드 "+methodName +"가 정상완료 됨");
		System.out.println("타깃메소드가 반환한 값: "+ret);
	}
	
	//public void afterthrowing()
	//public void afterthrowing(JoinPoint joinPoint)
	//public void afterthrowing(Throwable ex)
	public void afterthrowing(JoinPoint joinPoint, Throwable ex) 
	//JoinPoint와 Throwble 이 둘다 필요한 경우 JoinPoint가 먼저 와야함
	{
		//System.out.println("타깃메소드 수행 중"+ex.getMessage()+"예외 발생");
		String methodName = joinPoint.getSignature().toString();
		System.out.println(methodName+" 수행 중 예외 발생"+ex.getMessage()+"예외 발생");
		//System.out.println(methodName+"수행 중 예외 발생");
	}
	
	public void before(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().toLongString();
		System.out.println( methodName+" 동작 전");
	}
	
	public Object pro(ProceedingJoinPoint joinPoint)//aop Around
	{
		Object re = null;
		try {
			//타깃이 되는 메소드 동작하기 전에 할일들
			long start = System.currentTimeMillis();
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println(methodName+"이 동작하기 전");
			re = joinPoint.proceed();
			long end=  System.currentTimeMillis();
			//타깃이 되는 메소드 동작한 후에 할일들
			System.out.println(methodName+"이 동작한 후");
			System.out.println("걸린시간: "+(end-start));
		} catch (Throwable e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
}
