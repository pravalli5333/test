package com.register;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.Ordered;

@Controller
public class OrderslistController {
	@RequestMapping(value="location",method=RequestMethod.GET)
	public String placed(@RequestParam("city") String city ,@RequestParam("itemid") String item ,Model model){
		Configuration cf = new AnnotationConfiguration().configure();
		SessionFactory sf = cf.buildSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("update Ordered set currentcity=? where itemid=?");
		System.out.println("inseret city");
		query.setParameter(0, city);
		query.setParameter(1, item);
		System.out.println("inseret item");
		
		int update = query.executeUpdate();
	 session.beginTransaction().commit();
		session.close();
						
		return "updateitem";
	}
	

}
