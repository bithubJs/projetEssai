package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String afficherPageLogin() {
		return "loginPage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutMethode() {
		return "accueil";
	}

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String deniedMethode() {
		return "denied";
	}

	@RequestMapping(value = "/loginEchec", method = RequestMethod.GET)
	public String loginEchecdMethode(ModelMap model) {
		model.addAttribute("erreur", "true");
		return "loginPage";
	}
}
