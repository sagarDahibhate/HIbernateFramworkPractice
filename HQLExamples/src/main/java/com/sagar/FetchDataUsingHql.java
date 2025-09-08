package com.sagar;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sagar.model.Student;

public class FetchDataUsingHql {
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		String hql = "from com.sagar.model.Student";

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			List<Student> list = query.list();

			for (Student s : list) {
				System.out.println(s);
			}

			transaction.commit();
			session.close();
			factory.close();

		} catch (Exception e) {
			System.out.println("exception occured due to " + e);
		}
	}
}
