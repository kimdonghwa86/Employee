package com.hybrid.service;



import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hybrid.dao.DeptDao;
import com.hybrid.dao.EmpDao;
import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public class DeptRegisterService {

	DeptDao deptDao;
	EmpDao empDao;

	public void setDeptDao(DeptDao dao) {
		this.deptDao = dao;
	}
	
	public void setEmpDao(EmpDao dao){
		this.empDao = dao;
	}

	DataSource dataSource;

	public void setDataSource(DataSource ds) {

		this.dataSource = ds;
	}
@Transactional
	public void regist(Dept dept) {

		deptDao.insert(dept);
		List<Emp> emps = dept.getEmps();
		
		if(emps != null)
		for (Emp e : emps){
			empDao.insert(e);
		}
	}
}