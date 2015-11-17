package com.hybrid.employee;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.EmpMapper;
import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public class EmpMapperTest {

	static Log log = LogFactory.getLog(EmpMapperTest.class);
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("spring/beans_oracle.xml");
		
		EmpMapper empMapper = ctx.getBean(EmpMapper.class);
		
//		List<Emp> list = empMapper.selectAll();          //자동매핑
		List<Emp> list = empMapper.selectAllWithDept();  //수동매핑
		
		list.forEach(new Consumer<Emp>() {

			@Override
			public void accept(Emp e) {
				String msg = null;
				msg = e.getEmpno() + " "
						   + e.getEname() + " "
						   + e.getJob() + " "
						   + e.getMgr() + " "
						   + e.getHiredate() + " "
						   + e.getSal() + "  "
						   + e.getComm();
				log.info(msg);
								
				Dept d = e.getDept();
				
				msg =  "\t\t"
						 + d.getDeptno() + " "
				  	     + d.getDname() + " "
				  	     + d.getLoc();
					 	 
					log.info(msg);
				}
			
		});
		
/*		Dept emp = empMapper.selectByEmpno(20);
		Dept emp = empMapper.selectByEmpnoWithDept(10);
		String msg = emp.geEmptno() + " "
				   + emp.getEname() + " "
				   + emp.getsal();
		log.info(msg);
		
		List<Emp> dept = emp.getDeptno();
		
		if (dept != null )
		for (Emp d : dept){
			msg =  "\t\t"
				 + e.getEmpno() + " "
		  	     + e.getEname() + " "
		  	     + e.getJob() + " "
			 	 + e.getMgr() + " "
			 	 + e.getHiredate() + " "
			 	 + e.getSal() + " "
			 	 + e.getDept().getDeptno() + " "
			 	 + e.getDept().getDname() + " ";
			log.info(msg);
		}
		
		
*/
	}

}
