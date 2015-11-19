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
	
		Dept dept = new Dept();
		dept.setDeptno(74);
		dept.setDname("총무부");
		dept.setLoc("seoul");
		
		Emp emp = new Emp();
		emp.setEmpno(30);
		emp.setEname("홍길동");
		emp.setJob("xxx");
		emp.setHiredate(new Date());
		emp.setMgr(100);
		emp.setSal(999.9f);
		emp.setComm(null);
		emp.setDept(dept);
		List<Emp> emps = new ArrayList<Emp>();
		
		emps.add(emp);
		
		dept.setEmps(emps);
		service.regist(dept);
		
	}

}
