package com.sagar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sagar.model.AadharCard;
import com.sagar.model.Person;

public class TestHibernate {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();

			AadharCard ac = new AadharCard(101, "284419768170");

			Person person = new Person(1, "Sagar Dahibhate", "7415138836", ac);

			session.save(ac);
			session.save(person);
			System.out.println("record is saved into db ");

			Person person2 = session.get(Person.class, 1);
			if (person2 != null) {
				System.out.println(person2);
			}

			transaction.commit();
			session.close();
			factory.close();

		} catch (Exception e) {
			System.out.println("exception occured due to " + e);
		}
	}

}
