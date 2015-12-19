package com.hybrid.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.hybrid.dao.CityDao;

public class CityUnRegisterService {
	static Log log = LogFactory.getLog(CityUnRegisterService.class);
	static CityDao cityDao;
	
	public void setCityDao(CityDao dao) {
		this.cityDao = dao;
	}
	
	@Transactional
	public static int unregist(int id) {
		
		cityDao.deleteById(id);
		
		return id;
	}

}
