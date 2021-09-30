package test;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client2 {

	public static void main(String[] args) {
		

		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		 CBean cBean=(CBean)factory.getBean("cb");
	     /*
		 List<String> list = cBean.getList();
	     
	     for(String v : list) {
	    	 System.out.println(v);
	     }
		 */
		 
		 Map<String,String> map = cBean.getMap();
		 
		 System.out.println(map);
		 
	      factory.close();
		
		
	}

}
