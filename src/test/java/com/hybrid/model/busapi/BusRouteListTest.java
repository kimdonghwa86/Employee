package com.hybrid.model.busapi;

import java.net.URLDecoder;

import org.springframework.web.client.RestTemplate;

public class BusRouteListTest {

	public static void main(String[] args) {

		RestTemplate rest = new RestTemplate();
		
		String url = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList?strSrch={strSrch}&serviceKey={serviceKey}";
		String strSrch = "6628";
		String serviceKey = URLDecoder.decode("AaxqTg02PVW%2BZhaIkh4fVAIiknK6EU6ZkfT1lQEHEo2PRlldpzfhjoBwE63YKQGpiY4JdZCjCktTW2yatRX%2FgA%3D%3D");
		
//		String result = rest.getForObject(url, String.class, strSrch, serviceKey);
		ServiceResult result = rest.getForObject(url, ServiceResult.class, strSrch, serviceKey);
		
		System.out.println(result.getMsgHeader().getHeaderMsg());
		
		System.out.println(result.getMsgBody().getItemList().get(0).getBusRouteId());
		
	}

}
