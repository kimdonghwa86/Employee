package com.hybrid.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hybrid.mapper.DeptMapper;
import com.hybrid.model.Dept;

public class DeptDao {
	
	static Log log = LogFactory.getLog(DeptDaoTest.class);
	
	DeptMapper mapper;
	
	public void setDeptMapper(DeptMapper mapper){
		this.mapper = mapper;
	}
	
	public List<Dept> selectAll(){

		List<Dept> list =  mapper.selectAll();
		log.info("Dept size = " + list.size());
		return list;
	
	}
	public List<Dept> selectAllWithEmps(){

		List<Dept> list = mapper.selectAllWithEmps();
		log.info("Dept size = " + list.size());
		return list;
	}
	
	
	public Dept selectByDeptno(int deptno){
		
		return mapper.selectByDeptno(deptno);
	}
	public Dept selectByDeptnoWithEmps(int deptno){
		
		return mapper.selectByDeptnoWithEmps(deptno);
	}
	
	public int insert(Dept dept){
		return mapper.insert(dept);
	}
	
	public int delete(Dept dept){
		return mapper.delete(dept);
		
	}
	public List<Dept> selectGreaterThan(int deptno){
		return mapper.selectGreaterThan(deptno);
		
	}
	public int deleteGreaterThan(int deptno){
		return mapper.deleteGreaterThan(deptno);
		
	}
	
	
	
}
