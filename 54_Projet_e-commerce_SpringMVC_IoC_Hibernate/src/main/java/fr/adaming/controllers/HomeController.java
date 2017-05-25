package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sith-e-commerce")
public class HomeController {
	
	@RequestMapping(value="/accueil", method=RequestMethod.GET)
	public String welcomePersonne(ModelMap model){
		
		model.addAttribute("msg1", "APPLICATION DE GESTION DES PERSONNES");
		model.addAttribute("msg2","Avec Spring MVC, @Autheur Nomane");
		
		return "accueil"; // renvoie vers 'accueil.jsp'
		
	}

}
