package com.sagar;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sagar.model.Employee;


public class TestHibernate {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();

			Employee emp = new Employee();
			emp.setEmpId(101);
			emp.setEmpName("Sagar Dahibhate");
			LocalDate localDate = LocalDate.of(1996, 5, 16); 
			Date dob = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			emp.setDob(dob);
			FileInputStream fis = new FileInputStream(
					"G:\\Personal Data pics\\pendrive Data\\Images\\1553937416273.jpg");
			byte[] arr = new byte[fis.available()];
			fis.read(arr);
			emp.setPic(arr);
			
			
			
		   session.update(emp);
		   transaction.commit();
		   session.close();
		   factory.close();

		} catch (Exception e) {
			System.out.println("exception occured due to "+e);
		}
	}

}
