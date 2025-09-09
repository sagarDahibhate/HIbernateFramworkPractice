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
		

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			
			//  simiple select  operation for fetching all columns data
			String hql = "from com.sagar.model.Student";
			Query query = session.createQuery(hql);
			List<Student> list = query.list();

			for (Student s : list) {
				System.out.println(s);
			}

			
			// select  operation for fetching more than one column but not all columns of table.
			String hql2 = "select rollNo,name from com.sagar.model.Student";
			Query q = session.createQuery(hql2);
			List<Object[]> list2 = q.list();
			for (Object[] ob : list2) {
				System.out.println(ob[0] + "," + ob[1]);
			}

			
			// select  operation for fetching only one column of table.
			String hql3 = "select name from com.sagar.model.Student";
			Query query2 = session.createQuery(hql3);
			List<String> list3 = query2.list();
			for(String s:list3) {
				System.out.println("name of employees : "+s);
			}
			
			
			// Hibernate 6 ne positional parameters ka pura style change kar diya hai.
			// Hibernate 6 me ?1 style hata diya gaya hai, ab sirf named parameters hi use karne padte hain.
			
			String hql4="from com.sagar.model.Student where rollNo=:roll or name=:name";
			Query query4=session.createQuery(hql4);
			query4.setParameter("roll", 101);
			query4.setParameter("name", "sagar");
			
			List<Student> studList=query4.list();
			for (Student s : studList) {
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
