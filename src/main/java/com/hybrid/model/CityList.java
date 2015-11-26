package com.hybrid.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {
	
	@XmlElementWrapper(name="citys")
	@XmlElement(name="city")
	List<City> citys;

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	

}
