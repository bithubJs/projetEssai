package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/categories")
public class CategorieController {

	@Autowired
	private ICategorieService categorieService;

	/**
	 * @param categorieService
	 *            the categorieService to set
	 */
	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

	@RequestMapping(value = "/listeCategoriesAdmin", method = RequestMethod.GET)
	public String afficherListeCategories(ModelMap model) {

		List<Categorie> listeCategories = categorieService.getAllCategories();
		model.addAttribute("categoriesListe", listeCategories);

		return "categories";
	}

	@RequestMapping(value = "/formulaireAdd", method = RequestMethod.GET)
	public ModelAndView formulaireAjoutCat() {

		return new ModelAndView("formulaireAdd", "mCategorie", new Categorie());
	}

	@RequestMapping(value = "/addCategorie", method = RequestMethod.POST)
	public String addCategorie(Categorie cCategorie, ModelMap model, MultipartFile file) throws Exception {

		if (!file.isEmpty()) {
			cCategorie.setPhoto(file.getBytes());

		}
		if (cCategorie.getIdCategorie() == null) {
			categorieService.addCategorie(cCategorie);
		} else {
			categorieService.updateCategorie(cCategorie);
		}
		model.addAttribute("categoriesListe", categorieService.getAllCategories());

		return "categories";
	}

	@RequestMapping(value = "/updateCategorie", method = RequestMethod.GET)
	public ModelAndView formulaireUpdateCat(Long catId) {

		Categorie cat_rec = categorieService.getCategorieById(catId);
		String viewName = "formulaireAdd";

		return new ModelAndView(viewName, "mCategorie", cat_rec);
	}

	@RequestMapping(value = "/deleteCategorie/{idCategorie}", method = RequestMethod.GET)
	public String formulaireDeleteCat(ModelMap model, @PathVariable("idCategorie") Long catId) {

		Categorie cat_rec = categorieService.getCategorieById(catId);
		categorieService.deleteCategorie(cat_rec);
		model.addAttribute("categoriesListe", categorieService.getAllCategories());

		return "categories";
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
