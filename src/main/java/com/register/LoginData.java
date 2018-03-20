package com.register;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.objectweb.asm.attrs.Annotation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.Customers;

@Controller
public class LoginData {


	@RequestMapping(value = "loginform", method = RequestMethod.GET)
	public String getdata(Customers customers, Model model) {
		Configuration configure = new AnnotationConfiguration().configure();
		SessionFactory factory = configure.buildSessionFactory();
		Session session = factory.openSession();
		if (customers.getMail().isEmpty() || customers.getPswd().isEmpty()) {
			model.addAttribute("msg", "Username and password should be given");
			return "login";
		} else {

			Query query = session.createQuery("from Customers where mail=:mail and pswd=:pswd");
			query.setParameter("mail", customers.getMail());
			query.setParameter("pswd", customers.getPswd());
			List<Customers> list = query.list();
			if (list != null) {
				//Customers customers2 = list.get(0);
				
				for (Customers customers2 : list) {
				model.addAttribute("tellme", customers2.getName());

				}
				return "success";
			} else {
				model.addAttribute("msg", "Username and password invalid");
				return "login";
			}
		}
	}

}
