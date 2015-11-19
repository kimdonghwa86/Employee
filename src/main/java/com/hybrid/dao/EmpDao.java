package com.hybrid.dao;

import java.util.List;

import com.hybrid.mapper.EmpMapper;
import com.hybrid.model.City;
import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public class EmpDao {
	EmpMapper empMapper;
	
	public void setEmpMapper(EmpMapper mapper){
		this.empMapper = mapper;
	}
	
	public List<Emp> selectAll(){
		return empMapper.selectAll();
	}
	public Emp selectByEmpno(){
		return empMapper.selectByEmpno();
	}
	
	public List<Emp> selectByDeptno(int deptno){
		return empMapper. selectByDeptno(deptno);
	}
	
	
	
	public List<Emp> selectAllWithDept(){
		return empMapper.selectAllWithDept();
	}
	public Emp selectByEmpnoWithDept(){
		return empMapper.selectByEmpnoWithDept();
	}
		
	public int insert(Emp emp){
		return empMapper.insert(emp);
	}
	
	public int delete(Emp emp){
		return empMapper.delete(emp);
		
	}

	
	}

