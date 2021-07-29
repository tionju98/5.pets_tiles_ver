package kr.or.pets.common.log;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {
	private static final Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Before("execution(* kr.or.pets.*.service.*.*(..)) or "
			+ "execution(* kr.or.pets.*.dao.*.*(..))")				/* kr.or.shi.*.service 하위 패키지와 kr.or.shi.*.dao 패키지  하위의 모든 클래스의 메소드 호출전 advice를 적용하도록 설정함. */	
	public void startLog(JoinPoint jp) {
		logger.info("------------------------------------------------");
		logger.info("------------------------------------------------");
		logger.info("1: " + Arrays.toString(jp.getArgs()));			//전달되는 모든 파라미터들을 Object의 배열로 가져옴.
		logger.info("2: " + jp.getKind());							//해당 Advice의 타입을 알아냄.
		logger.info("3: " + jp.getSignature().getName());			//실행하는 대상 객체의 메소드에 대한 정보를 알아낼때 사용함.
		logger.info("4: " + jp.getTarget().toString()); 			//target 객체를 알아낼때 사용함.
		logger.info("5: " + jp.getThis().toString()); 				//Advice를 행하는 객체를 알아낼때 사용함.		
	}
	
	@After("execution(* kr.or.pets.*.service.*.*(..)) or "
			+ "execution(* kr.or.pets.*.dao.*.*(..))")				/* kr.or.shi.*.service 하위 패키지와 kr.or.shi.*.dao 패키지  하위의 모든 클래스의 메소드 호출후 advice를 적용하도록 설정함. */	
	public void after(JoinPoint jp) {
		logger.info("------------------------------------------------");
		logger.info("------------------------------------------------");
		logger.info("1: " + Arrays.toString(jp.getArgs()));			//전달되는 모든 파라미터들을 Object의 배열로 가져옴.
		logger.info("2: " + jp.getKind());							//해당 Advice의 타입을 알아냄.
		logger.info("3: " + jp.getSignature().getName());			//실행하는 대상 객체의 메소드에 대한 정보를 알아낼때 사용함.
		logger.info("4: " + jp.getTarget().toString()); 			//target 객체를 알아낼때 사용함.
		logger.info("5: " + jp.getThis().toString()); 				//Advice를 행하는 객체를 알아낼때 사용함.			
	}
	
	@Around("execution(* kr.or.pets.*.service.*.*(..)) or "
			+ "execution(* kr.or.pets.*.dao.*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		logger.info(Arrays.toString(pjp.getArgs()));	 			//전달되는 모든 파라미터들을 Object의 배열로 가져옴.
		
		Object result = pjp.proceed();								//실제 타겟을 실행하는 부분임. 이부분이 없으면 advice가 적용된 메소드가 동작하지 않음.
		
		long endTime = System.currentTimeMillis();
		
		logger.info(pjp.getSignature().getName() + " : "+ (endTime - startTime));   //target 메소드의 동작 시간 출력함.
		logger.info("------------------------------------------------");
		
		return result;
	}
}
