package com.hybrid.aspect;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
public class TransactionAspect {

	static Log log = LogFactory.getLog(TransactionAspect.class);
	DataSource dataSource;
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
	}
	
	@Around("execution(public * com.hybrid.service.*Service.*(..))")  //비포 에프터 그 이외 다른것을처리하는것
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		//before
		log.info("### before");
		
		DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource);
		TransactionDefinition td = new DefaultTransactionDefinition();
		TransactionStatus ts =  tm.getTransaction(td);
		
		log.info("### 트랜젝션 시작");
		Object rtn = null;
		try{
			rtn = pjp.proceed();
			tm.commit(ts);
			log.info("### commit");
		}catch (Throwable t){
			tm.rollback(ts);
			log.info("### rollback");
			throw t;
		}finally {
		
		}
		
		return rtn;
		
		
	}
}
