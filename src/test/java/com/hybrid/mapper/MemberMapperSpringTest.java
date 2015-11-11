package com.hybrid.mapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.model.Member;

public class MemberMapperSpringTest {
	
	static Log log = LogFactory.getLog(MemberMapperSpringTest.class);
	
	public static void main(String[] args) throws SQLException {
//		test1();
//		test2();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml"); //공장
		MemberMapper memberMapper = ctx.getBean(MemberMapper.class);
		
		List<Member> list =memberMapper.selectAll();
		
		list.forEach(new Consumer<Member>() {

			@Override
			public void accept(Member t) {
				log.info("Email = " + t.getEmail());
				log.info(t.getId());
				log.info("name = " + t.getName());
			}
		});
	}
	static void test2(){
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");//공장
		
		SqlSessionFactory sqlSessionFactory = ctx.getBean(SqlSessionFactory.class);
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		
		List<Member> list = sqlSession.selectList("com.hybrid.mapper.MemberMapper.selectAll");
		
		list.forEach(new Consumer<Member>() {

			@Override
			public void accept(Member m) {
				log.info("id = " + m.getId());
				log.info("name = " + m.getName());
				
			}
			
		});
		
		
		
	}
	
	static void test1() throws SQLException{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");//공장
		
	  //BasicDataSource dataSource = (BasicDataSource) ctx.getBean("dataSource");
		BasicDataSource dataSource = ctx.getBean("dataSource",BasicDataSource.class);
		log.info("className = " + dataSource.getDriverClassName());
		log.info("url = " + dataSource.getUrl());
		log.info("username = " + dataSource.getUsername());
		log.info("password = " + dataSource.getPassword());
		System.out.println(dataSource.getUrl());
		
		Connection con = dataSource.getConnection();
		
		String productName = con.getMetaData().getDatabaseProductName();
		String productVersion = con.getMetaData().getDriverVersion();
		
		log.info("productName" + productName);
		log.info("productVersion" + productVersion);
		
		
	}

}
