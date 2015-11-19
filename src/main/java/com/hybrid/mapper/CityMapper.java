package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.City;
import com.hybrid.model.Member;
import com.hybrid.util.Pagination;

public interface CityMapper {
	
	int selectCount();
	List<City> selectAll();
	List<City> selectPage(Pagination paging);
	List<City> selectByCountryCode(String countryCode);
	
	int insert(City city);
	
}
