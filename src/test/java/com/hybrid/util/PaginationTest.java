package com.hybrid.util;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;

public class PaginationTest {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("spring/beans_mysql.xml");
		ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml");
		
		CityMapper cityMapper = ctx.getBean(CityMapper.class);
		
		int totalItem =  cityMapper.selectCount();
		System.out.println("totalItem = " + totalItem);
		Pagination paging = new Pagination();
					
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("pageNo = ");
			int pageNo = scan.nextInt();
			
			paging.setPageNo(pageNo);
			paging.setTotalItem(totalItem);
			
			List<City> list =cityMapper.selectPage(paging);
			
			for(int i = 0; i < paging.getLength(); i++){
				City c = list.get(i);
				String line = c.getId() + " " + c.getName() + " " + c.getCountryCode();
				System.out.println("item index = " + list.get(i).getId());
			}

//			for(int i = 0; i < paging.getLength(); i++){
//				City c = list.get(i); 또다른 로직?

			
			for(int i = 0; i < paging.getLength(); i++){
				City c = list.get(i);
				String line = c.getId() + " " + c.getName() + " " + c.getCountryCode();
				System.out.println("item index = " + list.get(i).getId());
			}
			
			if(!paging.isFirstGroup())
				System.out.print("[이전]");
			else
				System.out.print("    ");
			
			for(int q = paging.getFirsPage(); q <= paging.getLastPage(); q++){
				System.out.printf("[%03d] ", q);
			}
			
			if(!paging.isLastGroup())
				System.out.print("[다음]");
			else
				System.out.print("    ");
			
			System.out.println();
			
		}
	}
		static void test1() {
		Pagination paging = new Pagination();
		
		for(int i=-2; i<22; i++){
		paging.setPageNo(i);
		paging.setTotalItem(195);
		
		String line = "totalPage = " +paging.getTotalPage()
				    + ", FirstGroup = " + paging.isFirstGroup()
					+ ", firstItem = " + paging.getFirstItem()
					+ ", lastItem = " + paging.getLastItem()
					+ ", pageNo = " + paging.getPageNo()
					+ ", firstPage = " + paging.getFirsPage()
					+ ", lastPage = " + paging.getLastPage()
					+ ", lastGoup = " + paging.isLastGroup();
		System.out.println(line);

	}

}
}
