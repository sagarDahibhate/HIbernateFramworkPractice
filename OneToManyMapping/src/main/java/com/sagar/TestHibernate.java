package com.sagar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sagar.model.Mobile;
import com.sagar.model.People;

public class TestHibernate {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();

			Mobile m1 = new Mobile(1, "Motorola");
			Mobile m2 = new Mobile(2, "Apple");
			Mobile m3 = new Mobile(3, "Samsung");

			People p = new People();
			p.setId(101);
			p.setName("sagar Dahibhate");
			p.getMobiles().add(m1);
			p.getMobiles().add(m2);
			p.getMobiles().add(m3);

			session.save(m1);
			session.save(m2);
			session.save(m3);
			session.save(p);

			transaction.commit();
			session.close();
			factory.close();

		} catch (Exception e) {
			System.out.println("exception occured due to " + e);
		}
	}
}
