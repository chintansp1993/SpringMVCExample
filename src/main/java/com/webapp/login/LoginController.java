package com.webapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.webapp.login.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String afterLogin(@RequestParam String name, @RequestParam String password, ModelMap model) {
		//System.out.println(name);
		if(service.validateUser(name, password)) {
		model.put("name", name); 
		model.put("password", password);
		return "welcome";
		}
		
		else {
			model.put("errorMessage", "Authorization failed!");
			return "login";
		}
	}

}

