package com.hybrid.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TransactionAspect {

	static Log log = LogFactory.getLog(TransactionAspect.class);
	@Around("execution(public * com.hybrid.service.*Service.*(..))")  //비포 에프터 그 이외 다른것을처리하는것
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		//before
		log.info("### before");
		Object rtn = null;
		try{
		rtn = pjp.proceed();
		//afterReturnnig
		log.info("### afterReturnnig");
		}catch (Throwable t){
		//afterThrowing
		log.info("### afterThrowing");
			throw t;
		}finally {
		//after
		log.info("### after");
		}
		
		return rtn;
		
		
	}
}
