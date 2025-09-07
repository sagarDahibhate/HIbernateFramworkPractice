package com.sagar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sagar.model.Customer;
import com.sagar.model.Student;

public class CustomerOperation {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Customer c = new Customer();
			c.setCustId(1001);
			c.setCustName("mohan");
			c.getCustData().add("D1");
			c.getCustData().add("D2");
			c.getData().put(10, "M1");
			c.getData().put(11, "M2");
			session.save(c);

			Customer cust = session.get(Customer.class, 1001);
			if (cust != null) {
				System.out.println("Customer informated fetched is : " + cust);
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
