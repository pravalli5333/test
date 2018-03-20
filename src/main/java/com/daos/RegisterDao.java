package com.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.dao.IRegisterDao;
import com.pojo.Customers;

public class RegisterDao implements IRegisterDao {

	public void  details(Customers customers){
		System.out.println("Executing details dao method");
		Session session2 = getSession();
		
		session2.save(customers);
		Transaction transaction = session2.beginTransaction();
		transaction.commit();
		
		session2.close();
		System.out.println("Exiting details dao method");
	}
	
	public void updateCust(Customers cust) {
		Session session = getSession();
		cust.setPswd1(cust.getPswd());
		session.update(cust);
		session.beginTransaction().commit();
	}
	
	public List<Customers> getCustomers() {
		Session session = getSession();
		Query query = session.createQuery("from Customers");
		List<Customers> list = query.list();
		session.beginTransaction().commit();
		return list;
	}

	public void deleteRow(Customers customer) {
		Configuration configure = new AnnotationConfiguration().configure();
		SessionFactory factory = configure.buildSessionFactory();
		Session session2 = factory.openSession();
		//delete operation query
		Query deletequery2 = session2.createQuery("delete from Customers where mail=:email");
		deletequery2.setParameter("email", customer.getMail());
		deletequery2.executeUpdate();
		session2.beginTransaction().commit();
		session2.close();
	}
	
	private Session getSession() {
		Configuration configure = new AnnotationConfiguration().configure();
		SessionFactory factory = configure.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}
}
