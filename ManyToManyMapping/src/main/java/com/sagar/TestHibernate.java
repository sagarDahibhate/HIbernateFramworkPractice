package com.sagar;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sagar.model.Collage;
import com.sagar.model.Teacher;

public class TestHibernate {
	public static void main(String[] args) {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSf().openSession())
		{
		tx=ses.beginTransaction();
		
		Collage c1=new Collage(1, "SSMV");
		Collage c2=new Collage(2, "SDITS");
		Collage c3=new Collage(3, "Sinhagad");
		
		Teacher t1=new Teacher();
		t1.setId(1);
		t1.setName("tushar");
		t1.getCollages().add(c1);
		t1.getCollages().add(c2);
		t1.getCollages().add(c3);
	
		Teacher t2=new Teacher();
		t2.setId(2);
		t2.setName("santosh");
		t2.getCollages().add(c1);
		t2.getCollages().add(c3);
	
	    ses.save(t1);ses.save(t2);
        ses.save(c1);ses.save(c2);ses.save(c3);
        
    
		
		tx.commit();
		ses.close();
		
		System.out.println("data is saved to the db");
		}
	}
}
