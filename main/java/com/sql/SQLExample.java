package com.sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {
public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session s=factory.openSession();
	  //SQL query
	String query="select * from Emp";
    NativeQuery nq=s.createSQLQuery(query);
    List<Object[]> list=nq.list();
    for(Object[] emp2:list)
    {
    System.out.println(Arrays.deepToString(emp2));	
    }
	
	s.close();
	factory.close();
}
}
