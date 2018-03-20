package com.register;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pojo.Ordered;

@Controller
public class OrderController {
	
	@RequestMapping(value="order", method=RequestMethod.GET)
	public String orderplace(Ordered orders,Model model){
		Configuration configure = new AnnotationConfiguration().configure();
		SessionFactory factory = configure.buildSessionFactory();
		Session session = factory.openSession();
		Serializable dbStoredId = session.save(orders);
		session.beginTransaction().commit();
		System.out.println("the db id is: "+dbStoredId);
		
		model.addAttribute("generatedvalue", dbStoredId);
		System.out.println("succesfully ordered");
		session.close();
		
		return "placed";
	}
	@RequestMapping(value= "mainorder")
	public String orderupdate(){
		return "OrderslistController";
	}
	
	@RequestMapping(value="updateaction" ,method=RequestMethod.GET)
	public String fulldetails(Model model){
		Configuration cf = new AnnotationConfiguration().configure();
		SessionFactory sf = cf.buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from Ordered");
		List<Ordered> list = query.list();
		for (Ordered ordered : list) {
			/*System.out.println(ordered.getItemid());
			System.out.println(ordered.getCurrentcity());*/
			model.addAttribute("collected", list);
		}
		
		return "dbDetails";
		
	}
}
