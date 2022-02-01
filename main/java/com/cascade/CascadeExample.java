package com.cascade;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.map.Answer;
import com.map.Question;
public class CascadeExample {
public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session s=factory.openSession();
	   
	Question q1=new Question();
	q1.setQuestionId(56789098);
	q1.setQuestion("what is jdbc");
	
	Answer a1=new Answer(7738,"this is answer no 1");
	Answer a2=new Answer(8928,"this is answer no 2");
	Answer a3=new Answer(9699,"this is answer no 3");
	
	List<Answer> list=new ArrayList();
	list.add(a1);
	list.add(a2);
	list.add(a3);
	q1.setAnswers(list);
	Transaction tx=s.beginTransaction();
	s.save(q1);
	tx.commit();
	s.close();
	factory.close();
	}
}
