package com.hybrid.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.hybrid.dao.CityDao;
import com.hybrid.model.City;

public class CityModifyService {
	static Log log = LogFactory.getLog(CityModifyService.class);
	CityDao cityDao;
	
	public void setCityDao(CityDao dao) {
		this.cityDao = dao;
	}
	
	@Transactional
	public int modify(City city) {
		
		int rtn = cityDao.update(city);
		
		return city.getId();
	}

}
