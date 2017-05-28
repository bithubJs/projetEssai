package fr.adaming.controllers;

import java.io.*;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@Controller
@RequestMapping("/sith-e-commerce")
public class SithECommerceController {

	@Autowired
	private ICategorieService categorieService;

	/**
	 * @param categorieService
	 *            the categorieService to set
	 */
	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String accueilSith(ModelMap model) {

		model.addAttribute("msg1", "Que la force soit avec ton panier");
		model.addAttribute("msg2", "Ne jamais oublier, panier vide je te plein, panier plein je te ... plein plus !");

		return "accueil";

	}

}
