package com.sagar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sagar.model.Employee;

public class UpdateRecord {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();

			Employee employee = session.get(Employee.class, 101);

			if (employee != null) {
				employee.setEmpName("Lekhraj Dahibhate");
				session.update(employee);
				//session.saveOrUpdate(employee);   this method will save if record not exist and if exist then it will update. both work in same method
			} else {
				System.out.println("Record is not found ");
			}
			transaction.commit();
			session.close();
			factory.close();

		} catch (Exception e) {
			System.out.println("exception occured due to " + e);
		}
	}
}
