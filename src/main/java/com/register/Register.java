package com.register;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.IRegisterDao;
import com.pojo.Customers;
import com.pojo.Passport;
import com.pojo.Student;

@Controller
public class Register {	

	@Autowired
	IRegisterDao dao;
	
//	Student std1 = new Student();
	@Autowired
	private Student std1;
	
	@Autowired
	private Student std2;
	
	@Autowired
	private Student student;
		
	@RequestMapping(value="fulldetails", method=RequestMethod.GET)
	public String getalldetails(Model model){
		
		System.out.println("***********************************************************************88");
		
		std1.setName("Raju");
		std1.setBranch("ECE");
		std1.setStdId("101");
		std1.getPassport().setPptId("12345");
		
		std2.setName("Chiranjeevi");
		std2.setBranch("EEE");
		std2.setStdId("102");
		std2.getPassport().setPptId("23986");
		
		student.setName("Nani");
		student.setBranch("CSE");
		student.setStdId("1065");
		student.getPassport().setPptId("96878");
		
		System.out.println(std1.getName());
		System.out.println(std1.getStdId());
		System.out.println(std1.getCollegeName());
		System.out.println(std1.getPassport().getLocation());
		System.out.println(std1.getPassport().getPptId());
		System.out.println("--------------------");
		
		System.out.println(std2.getName());
		System.out.println(std2.getStdId());
		System.out.println(std2.getCollegeName());
		System.out.println(std2.getPassport().getLocation());
		System.out.println(std2.getPassport().getPptId());
		System.out.println("--------------------");
		
		System.out.println(student.getName());
		System.out.println(student.getStdId());
		System.out.println(student.getCollegeName());
		System.out.println(student.getPassport().getLocation());
		System.out.println(student.getPassport().getPptId());
		
		System.out.println("***********************************************************************88");
		Configuration configure = new AnnotationConfiguration().configure();
		SessionFactory factory = configure.buildSessionFactory();
		Session session2 = factory.openSession();
		
		Query query = session2.createQuery("from Customers");
		List<Customers> list = query.list();
		session2.beginTransaction().commit();
		/*for (Customers customers : list) {
			System.out.println("line entered in to delete details");
			System.out.println(customers.getName());
			System.out.println(customers.getMail());
			System.out.println(customers.getId());
			
		}*/
		model.addAttribute("selecteddetails", list);
		return "result";
	}
	
	@RequestMapping (value="Registrationpage", method=RequestMethod.GET)
	public String  details(Customers customers, Model model ){
		System.out.println(customers.getMail());
		System.out.println(customers.getCity());
		System.out.println("----------------------");
		dao.details(customers);
		System.out.println("----------------------");
		System.out.println(customers.getName());
		//model.addAttribute("name", customers.getName());
		model.addAttribute("success", "successfully registered");
		return "Register";
		
	}
	
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	
	public String deleterow(Customers customer, Model model){
		System.out.println("line entered to delete ");
		System.out.println("----------------------");
		dao.deleteRow(customer);
		List<Customers> list = dao.getCustomers();
		System.out.println("----------------------");
		for (Customers customers : list) {
			System.out.println("line entered in to delete details");
			System.out.println(customers.getName());
			System.out.println(customers.getMail());
			System.out.println(customers.getId());
		}
		model.addAttribute("selecteddetails", list);
		return "result";
	}
	
	
	
	
	
	
	@RequestMapping(value="openEditMode", method=RequestMethod.POST)
	public String openEditModeCustomer(@RequestParam("emailId") String email, Model model) {
		System.out.println(email);
		Configuration configure = new AnnotationConfiguration().configure();
		SessionFactory factory = configure.buildSessionFactory();
		Session session3 = factory.openSession();
		
		Customers customer = (Customers) session3.get(Customers.class, email);
		System.out.println(customer.getMail());
		System.out.println(customer.getName());
		model.addAttribute("customer", customer);
		/*Query query = session3.createQuery("from Customers where mail=:mail");
		query.setParameter("mail", email);*/
		
		//Fetch details based on mail
		//And forward that to jsp using model object
		return "updateCust";
	}
	
	
	@RequestMapping(value="updateCustomer", method=RequestMethod.POST) 
	public String updateCust(Customers cust, Model model) {
		
		dao.updateCust(cust);
		List<Customers> listCust = dao.getCustomers();
		
		for (Customers customers : listCust) {
			System.out.println("line entered in to delete details");
			System.out.println(customers.getName());
			System.out.println(customers.getMail());
			System.out.println(customers.getId());
		}
		model.addAttribute("selecteddetails", listCust);
		return "result";
	}
	
	
	
	/*@RequestMapping(value="order")
	public String orderplace(Ordered order, Model model){
		Session session2 = sf.openSession();
		session2.save(order);
		session2.beginTransaction().commit();
		Transaction transaction = session2.beginTransaction();
		transaction.commit();
		System.out.println("succesfully executed");
		return "login";
		
	}*/
}