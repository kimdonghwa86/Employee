package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.Dept;

public interface DeptMapper {
	
	List<Dept> selectAll();
	List<Dept> selectAllWithEmps();
	
	Dept selectByDeptno(int deptno);
	Dept selectByDeptnoWithEmps(int deptno);
	
	int insert(Dept dept);
	
}
