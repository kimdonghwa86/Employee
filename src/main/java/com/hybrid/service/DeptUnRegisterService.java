package com.hybrid.service;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hybrid.dao.DeptDao;
import com.hybrid.dao.EmpDao;
import com.hybrid.model.Dept;
import com.hybrid.model.Emp;


public class DeptUnRegisterService {

	static Log log = LogFactory.getLog(DeptUnRegisterService.class);
	
	DeptDao deptDao;
	EmpDao empDao;
	DataSource dataSource;
	
	
	public void setDeptDao(DeptDao dao) {
		log.info("#########################");
		log.info("setDeptDao()......");
		log.info("#####################");		
		this.deptDao = dao;
	}
	
	public void setEmpDao(EmpDao dao) {
		this.empDao = dao;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}	
	
	@Transactional
	public void unregist(Dept dept) {
		List<Emp> emps = empDao.selectByDeptno(dept.getDeptno());
		
		for(Emp emp : emps){
			empDao.delete(emp);
		}
		deptDao.delete(dept);						
	}
	@Transactional
	public void unregist(int deptno){
		List<Dept> depts = deptDao.selectGreaterThan(deptno);
		
		for(Dept d : depts){
			unregist(d);
		}
		
//		deptDao.deleteGreaterThan( deptno);
	}
	
}