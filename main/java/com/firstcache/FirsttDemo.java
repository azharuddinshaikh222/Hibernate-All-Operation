package com.firstcache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.map1.Emp;
public class FirsttDemo {
public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session s=factory.openSession();
	//FIRST LEVEL CACHE
	Emp emp=s.get(Emp.class,35);
	System.out.println(emp.getName());
	
	System.out.println("working on something");
	
	      Emp e1=s.get(Emp.class,35);
	      System.out.println(e1.getName());
	s.close();
}
}
