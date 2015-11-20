package com.hybrid.transfer;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import org.apache.commons.logging.Log;
import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;
import com.hybrid.util.Pagination;
//mysql에있는 city를 oracle에 불러온다.
public class CityTransfer {
	static Log log = LogFactory.getLog(CityTransfer.class);
	public static void main(String[] args) {
	
		GenericXmlApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("spring/beans_mysql.xml","spring/beans_oracle.xml");

		CityMapper mysqlCityMapper = (CityMapper) ctx.getBean("mysqlCityMapper");
		CityMapper oracleCityMapper = (CityMapper) ctx.getBean("oracleCityMapper");
		
		oracleCityMapper.deleteAll();
		
		List<City> list = mysqlCityMapper.selectAll();
//		Pagination paging = new Pagination();
//		paging.setTotalItem(4079);
//		paging.setPageNo(2);
//		List<City> list = mysqlCityMapper.selectPage(paging);
	
		log.info("city size = " + list.size());
		
		System.out.println();
		list.forEach(new Consumer<City>() {

			@Override
			public void accept(City t) {				
				System.out.print(".");
				System.out.flush();
				int rtn = oracleCityMapper.insert(t);
				log.info("rtn = " + rtn);
				
			}
		});
		ctx.close();
	}
}