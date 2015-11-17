package com.hybrid.service;



import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.hybrid.dao.DeptDao;
import com.hybrid.model.Dept;

public class DeptRegisterService {

	DeptDao deptDao;

	public void setDeptDao(DeptDao dao) {
		this.deptDao = dao;
	}

	DataSource dataSource;

	public void setDataSource(DataSource ds) {

		this.dataSource = ds;
	}

	public void regist(Dept dept) {

		DataSourceTransactionManager transactionManager = null;
		transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);

		TransactionDefinition td = new DefaultTransactionDefinition();
		TransactionStatus ts = transactionManager.getTransaction(td);

		try {
			deptDao.insert(dept);
			transactionManager.commit(ts);
		} catch (RuntimeException ex) {
			transactionManager.rollback(ts);
		}
	}
}