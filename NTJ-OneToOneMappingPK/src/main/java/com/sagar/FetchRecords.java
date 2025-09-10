package com.sagar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sagar.model.LibraryManage;
import com.sagar.model.Student;

public class FetchRecords {
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			
			Student student = session.get(Student.class, Integer.valueOf(1));
			
			if(student!=null) {
				System.out.println(student.getId()+" "+student.getName()+"  "+student.getStandard());
				LibraryManage lic = student.getLic();
				System.out.println(lic.getId()+" "+lic.getLibraryManage());
			}
		 
			transaction.commit();
			session.close();
			factory.close();

		} catch (Exception e) {
			System.out.println("exception occured due to " + e);
		}
	}
}
