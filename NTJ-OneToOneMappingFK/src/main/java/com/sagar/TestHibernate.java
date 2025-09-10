package com.sagar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sagar.model.DrivingLicense;
import com.sagar.model.Person;

public class TestHibernate {
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			
			Person p1=new Person(1, "sagar dahibhate", "burhanpur");
			
			DrivingLicense dl1=new DrivingLicense(101, "bike", "abc", p1);
			
			session.save(p1);
			session.save(dl1);
			
			transaction.commit();
			session.close();
			factory.close();

		} catch (Exception e) {
			System.out.println("exception occured due to " + e);
		}
	}
}
