package com.hybrid.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.hybrid.dao.CityDao;
import com.hybrid.model.City;
import com.hybrid.model.CityPage;
import com.hybrid.util.Pagination;

public class CityPageService {
	static Log log = LogFactory.getLog(CityPageService.class);
	CityDao cityDao;
	
	public void setCityDao(CityDao dao) {
		this.cityDao = dao;
	}
	
	@Transactional
	public CityPage getPage(int pageNo) {
		
		Pagination paging = new Pagination();
		paging.setPageNo(pageNo);
		paging.setTotalItem(cityDao.selectCount());
		
		log.info("count = " + cityDao.selectCount());
		
		List<City> list =cityDao.selectPage(paging);
		
		CityPage page = new CityPage();
		page.setPaging(paging);
		page.setCitys(list);
		
		return page;
	}

}
