package com.hybrid.service;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public class DeptRegisterServiceTest {
	
	static Log log = LogFactory.getLog(DeptRegisterServiceTest.class);
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx=null;
		ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml");

		DeptRegisterService service = ctx.getBean(DeptRegisterService.class);
		DeptUnRegisterService uservice = ctx.getBean(DeptUnRegisterService.class);
	
		Dept dept = ctx.getBean(Dept.class);
		
		uservice.unregist(dept);
		
		service.regist(dept);
		
	}

}
