package com.sagar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sagar.model.BankAccount;
import com.sagar.model.Person;

public class TestHibernate {
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();

			BankAccount b1 = new BankAccount(101, "salary", "1234567890");
			BankAccount b2 = new BankAccount(102, "saving", "7415138836");

			Person p1 = new Person();
			p1.setpId(1);
			p1.setName("sagar dahibhate");
			p1.getBankAcc().add(b1);
			p1.getBankAcc().add(b2);

			session.save(b1);
			session.save(b2);
			session.save(p1);

			transaction.commit();
			session.close();
			factory.close();

		} catch (Exception e) {
			System.out.println("exception occured due to " + e);
		}
	}
}
