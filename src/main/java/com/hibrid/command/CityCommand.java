package com.hibrid.command;

import java.util.Date;
import com.hybrid.exception.PasswordNotMatchingException;



public class CityCommand { 
	private long id;          //private는 나만 접근할수있도록 만들겠다.  
	private String name;
	private String countryCode;
	private String district;
	private Integer population;   //인티져를가지고잇는 객체화시킨것 (레퍼클래스)
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	
	
}	