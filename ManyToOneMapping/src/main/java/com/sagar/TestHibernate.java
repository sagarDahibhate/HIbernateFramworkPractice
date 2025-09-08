package com.sagar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sagar.model.Address;
import com.sagar.model.Student;

public class TestHibernate {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			
			Address addr=new Address();
			addr.setAddrId(01);
			addr.setLoc("Burhanpur");
			addr.setPin("450331");
			
			Student st = new Student();
			st.setRollNo(101);
			st.setName("sagar Dahibhate");
			st.setStandard(10);
			st.setAddr(addr);

			Student st2 = new Student();
			st2.setRollNo(102);
			st2.setName("mansi Dahibhate");
			st2.setStandard(10);
			st2.setAddr(addr);
			session.save(addr);
			session.save(st);
			session.save(st2);
			

			Student student = session.get(Student.class, 101);
			if (student != null) {
				System.out.println("Student informated fetched is : " + student);
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
