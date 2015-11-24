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
public class CityTransferOracle {
	static Log log = LogFactory.getLog(CityTransferOracle.class);
	public static void main(String[] args) {
	
		GenericXmlApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("spring/beans_mysql.xml",
											   "spring/beans_oracle.xml");
		
		/*
		 *  Oracle==>Mysql
		 */
		
		
		CityMapper mysqlCityMapper = (CityMapper) ctx.getBean("mysqlCityMapper");
		CityMapper oracleCityMapper = (CityMapper) ctx.getBean("oracleCityMapper");
		
		int deleteCount = mysqlCityMapper.deleteAll(); 
		
		log.info("MySQL city Delete Count = " + deleteCount);
		List<City> list = oracleCityMapper.selectAll();

//		
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
				
				if(t.getDistrict() == null)   //null때문에 에러가나기때문에 null값에 nullString으로 넣어준다.
					t.setDistrict(" ");
				
				int rtn = mysqlCityMapper.insert(t);
				log.info("rtn = " + rtn);
				
			}
		});
		
		int cityCount = mysqlCityMapper.selectCount();
		log.info("MySQL city total count = " + cityCount);
		ctx.close();
		List<String> xx;
	}
}