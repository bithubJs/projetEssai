package fr.adaming.controllers;

import java.io.*;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@RequestMapping(method = RequestMethod.GET)
	public String afficherListeCategories(ModelMap model) {

		List<Categorie> listeCategories = categorieService.getAllCategories();
		model.addAttribute("categoriesListe", listeCategories);

		return "accueil";
	}

	@RequestMapping(value = "/formulaireAdd", method = RequestMethod.GET)
	public ModelAndView formulaireAjoutCat() {

		return new ModelAndView("formulaireAdd", "mCategorie", new Categorie());
	}

	@RequestMapping(value = "/addCategorie", method = RequestMethod.POST)
	public String addCategorie(ModelMap model, @Valid @ModelAttribute("mCategorie") Categorie cCategorie,
			BindingResult result) {

		if (result.hasErrors()) {

			return "formulaireAdd";

		} else {
			if (cCategorie.getIdCategorie() == null) {
				categorieService.addCategorie(cCategorie);
			} else {
				categorieService.updateCategorie(cCategorie);
			}
			model.addAttribute("categoriesListe", categorieService.getAllCategories());

			return "accueil";
		}
	}

	@RequestMapping(value = "/updateCategorie")
	public ModelAndView formulaireUpdateCat(@RequestParam("idCategorie") Long catId) {

		Categorie cat_rec = categorieService.getCategorieById(catId);
		String viewName = "formulaireAdd";

		return new ModelAndView(viewName, "mCategorie", cat_rec);
	}

	@RequestMapping(value = "/deleteCategorie/{idCategorie}")
	public String formulaireDeleteCat(ModelMap model, @PathVariable("idCategorie") Long catId) {

		Categorie cat_rec = categorieService.getCategorieById(catId);
		categorieService.deleteCategorie(cat_rec);
		model.addAttribute("categoriesListe", categorieService.getAllCategories());

		return "accueil";
	}

	@RequestMapping(value = "/photoCategorie", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long catId) throws IOException {

		Categorie cat_rec = categorieService.getCategorieById(catId);

		if (cat_rec.getPhoto() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(cat_rec.getPhoto()));
		}
	}

}
