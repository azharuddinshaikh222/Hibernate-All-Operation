package com.tut;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args)throws IOException {
		System.out.println("project started");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		//creating student object
		Student st = new Student();
		st.setId(100);
		st.setName("Azhar");
		st.setCity("Mumbai");
		System.out.println(st);
        //creating address object
		Address ad=new Address();
		ad.setId(106);
		ad.setStreet("street1");
		ad.setCity("delhi");
        ad.setOpen(true);
        ad.setAddDate(new Date());
        ad.setX(123456);
        //Reading image
        FileInputStream fis=new FileInputStream("src/main/java/pic.jpg");
        byte [] data=new byte[fis.available()];
        ad.setImage(data);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(ad);
		tx.commit();
		session.close();
		factory.close();

	}
}
