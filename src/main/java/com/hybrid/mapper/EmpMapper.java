package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.City;
import com.hybrid.model.Emp;

public interface EmpMapper {
	List<Emp> selectAll();
	Emp selectByEmpno();
	
	List<Emp> selectAllWithDept();
	Emp selectByEmpnoWithDept();
		
	}

