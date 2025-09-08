package com.sagar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sagar.model.Student;

public class TestHibernate {
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Student st = new Student();
			 st.setRollNo(101);
			 st.setName("sagar");
			 st.setStandard(10);
			
			 Student st1 = new Student();
			 st1.setRollNo(102);
			 st1.setName("mansi");
			 st1.setStandard(10);
			
			 Student st2 = new Student();
			 st2.setRollNo(103);
			 st2.setName("bhakti");
			 st2.setStandard(1);
			
			 
			 session.save(st);
			 session.save(st1);
			 session.save(st2);
			 

			 // same as previous example we can update and delete the record 
			transaction.commit();
			session.close();
			factory.close();

		} catch (Exception e) {
			System.out.println("exception occured due to " + e);
		}
	}
}
