package com.hql;
import java.util.Arrays;
import java.util.List;
import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.map1.Emp;
public class HQLExample {
public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session s=factory.openSession();
	//HQL
	String query="from Emp where name='ram'";
	Query q=s.createQuery(query);
	    //single-(unique)
		//multiple-list
	List<Emp> list=q.list();
	for(Emp emp:list)
	{
		System.out.println(emp.getName());
		//deleting from database using HQL
		Transaction tx=s.beginTransaction();
		System.out.println("_______________________________________");
		Query q1=s.createQuery("Delete from Emp n where n.name=:n");
		q1.setParameter("n", "ram");
		int r=q1.executeUpdate();
		System.out.println("deleted Succsesfully");
		System.out.println(r);
		//update query
		Query q3=s.createQuery("update Emp set name=:n where name=:n1");
		q3.setParameter("n1", "azhar");
		int r1=q3.executeUpdate();
		System.out.println("updated succsesfully");
		System.out.println(r1);
		//how to execute join Query
		Query q4=s.createQuery("select q.question,q.questionId,a.answer from Question as inner join q.answers as a ");
	List<Object []> list3=q4.getResultList();
	for(Object[] arr:list3)
	{
		System.out.println(Arrays.toString(arr));
	}
		tx.commit();
	}
	s.close();
	factory.close();
}
}