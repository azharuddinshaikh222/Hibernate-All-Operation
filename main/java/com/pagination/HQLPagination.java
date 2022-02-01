package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;

import com.map1.Emp;
public class HQLPagination {
public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	//craeting session
	Session s=factory.openSession();
	Query q=s.createQuery("from Emp");
	//implementing pagination
	q.setFirstResult(0);
	q.setMaxResults(2);
	
	List<Emp> list=q.list();
	for(Emp e1:list)
	{
	System.out.println(e1.getName());	
	}
	
	
}
}
