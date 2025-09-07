package com.sagar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sagar.model.Employee;

public class DeleteRecord {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		try (Session session = factory.openSession()) {
			Transaction transaction=session.beginTransaction();
			
			Employee employee = session.get(Employee.class, 101);
			
			session.delete(employee);
			
			transaction.commit();
			
			session.close();
			factory.close();
			System.out.println("Record is delted sucesfully ");

		} catch (Exception e) {
			System.out.println("exception occured due to " + e);
		}

	}
}
