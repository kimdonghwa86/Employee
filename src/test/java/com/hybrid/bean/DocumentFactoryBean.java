package com.hybrid.bean;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;



public class DocumentFactoryBean implements FactoryBean<Document> {
	
	DocumentBuilderFactory factory;
	Document document;
	
	ClassPathResource resource;
	
	
	public DocumentFactoryBean(DocumentBuilderFactory factory) {
		this.factory = factory;
	}
	
	public void setPath(String path){
		resource = new ClassPathResource(path);
	}
	
	@Override
	public Document getObject() throws Exception {
		if(document == null){
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(resource.getInputStream());
		}
		return document;
	}

	@Override
	public Class<?> getObjectType() {
		return Document.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
