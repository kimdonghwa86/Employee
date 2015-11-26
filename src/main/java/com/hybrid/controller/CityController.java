package com.hybrid.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.model.City;
import com.hybrid.model.CityList;

@Controller
@RequestMapping("/city")
public class CityController {
	static Log log = LogFactory.getLog(CityController.class);
	
	@RequestMapping("/city.html")
	public String getView() {
		log.info("getView()...");
		
		return "city/city"; // /WEB-INF/view/city/city.jsp
	}
	
	@RequestMapping(value={"", "/"})
	@ResponseBody
	public CityList getCityAll() {
		CityList list = new CityList();
		
		List<City> citys = new ArrayList<City>();
		City city = new City();
		city.setId(100);
		city.setName("seoul");
		citys.add(city);
		
		City city2 = new City();
		city2.setId(200);
		city2.setName("pusan");
		citys.add(city2);
		
		list.setCitys(citys);
		
		return list;
	}
	
	
}
