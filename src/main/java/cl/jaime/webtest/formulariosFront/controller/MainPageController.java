package cl.jaime.webtest.formulariosFront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {
	
	@GetMapping("/index") 
	public String   index(Model model) {
		System.out.println(" estoy en el index saludos");
        
		return "index" ;
	}
	
}
