package com.hybrid.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WrapperTest {

	public static void main(String[] args) {
		
		List<Map<String, List<Integer>>> list = new ArrayList<>();
		
		for (int i=1; i<10; i++) {
			for (int j=1; j<10; j++) {
				for (int k=1; k<10; k++) {
					for (int l=1; l<10; l++) {
						for (int x=1; x<10; x++) {
							
						}
					}
				}
			}
		}
	}
	
	static void test1() { 
		// Primitive Type(원시타입)
		byte b = 20;		// 1byte
		short s = 10;		// 2byte
		char c = 30;		// 2byte
		int i = 30;			// 4byte
		long l = 200;		// 8byte
		float f = 10.5f;	// 4byte
		double d = 10.6;	// 8byte
		String string=null;
		// Wrapper Class
		Byte b1 = Byte.valueOf("10");		// Boxing
		Short s1 = 10;
		Character c1 = 30;
		Integer i1 = 200;
		Long l1 = 200L;
		Float f1 = 200f;
		Double d1 = 300.;
		
		d = d1;  // UnBoxing
		

	}

}
