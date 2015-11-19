package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.City;
import com.hybrid.model.Emp;

public interface EmpMapper {
	List<Emp> selectAll();
	Emp selectByEmpno();
	List<Emp> selectByDeptno(int deptno);
	
	List<Emp> selectAllWithDept();
	Emp selectByEmpnoWithDept();
	
	int insert(Emp emp);
	int delete(Emp emp);

	}

