package com.hybrid.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.hybrid.dao.CityDao;
import com.hybrid.exception.CityRegisterException;
import com.hybrid.model.City;
import com.hybrid.model.CityPage;
import com.hybrid.util.Pagination;

public class CityRegisterService {
	static Log log = LogFactory.getLog(CityRegisterService.class);
	CityDao cityDao;
	
	public void setCityDao(CityDao dao) {
		this.cityDao = dao;
	}
	
	@Transactional
	public int regist(City city) {
		
		int id = 0;
		try{
			id = cityDao.insert(city);
			
		}catch (DataIntegrityViolationException e){
			throw new CityRegisterException();
		}
		return id;
	}

}
