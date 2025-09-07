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
			st.setStdId(1001);
			st.setStdName("Ram");
			st.getStdData().add("D1");
			st.getStdData().add("D2");
			//session.save(st);
			
			Student student = session.get(Student.class, 1001);
			if(student!=null) {
				System.out.println("Student informated fetched is : "+student);
			}

			 // same as previous example we can update and delete the record 
			transaction.commit();
			session.close();
			factory.close();

		} catch (Exception e) {
			System.out.println("exception occured due to " + e);
		}
	}

}
