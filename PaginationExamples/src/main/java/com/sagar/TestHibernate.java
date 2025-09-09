package com.sagar;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sagar.model.Student;

public class TestHibernate {
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			
			
			int pageSize = 5;  // हर पेज पर 10 records
	        int totalRecords = 20; // DB में 100 students
	        int totalPages = (int) Math.ceil((double) totalRecords / pageSize);
	        
	        
	        for (int pageNo = 1; pageNo <= totalPages; pageNo++) {
	            List<Student> students = getStudentsByPage(session, pageNo, pageSize);
	            System.out.println("\n--- Page " + pageNo + " ---");
	            for (Student s : students) {
	                System.out.println(s.getRollNo() + " - " + s.getName()+" - "+s.getStandard());
	            }
	        }

	        
	        
	        transaction.commit();
			session.close();
			factory.close();

		} catch (Exception e) {
			System.out.println("exception occured due to " + e);
		}
	}
	
	 // Pagination helper method
    public static List<Student> getStudentsByPage(Session session, int pageNo, int pageSize) {
        Query<Student> query = session.createQuery("from Student order by rollNo", Student.class);

        int startIndex = (pageNo - 1) * pageSize; // offset निकालना
        query.setFirstResult(startIndex);        // कहाँ से शुरू करना है
        query.setMaxResults(pageSize);           // कितने लेने हैं

        return query.list();
    }
}
