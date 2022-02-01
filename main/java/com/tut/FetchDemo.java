package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class FetchDemo {
public static void main(String[] args)  {
	//get and load method Example
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory factory=cfg.buildSessionFactory();
Session session=factory.openSession();
//using get method
 Student student=(Student)session.load(Student.class,100);
 System.out.println(student);
 factory.close();
 session.close();
}
}
