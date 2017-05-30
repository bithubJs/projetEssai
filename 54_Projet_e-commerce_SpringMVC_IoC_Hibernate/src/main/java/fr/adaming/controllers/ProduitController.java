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
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/produits")
public class ProduitController {

	@Autowired
	private IProduitService produitService;

	@Autowired
	private ICategorieService categorieService;

	/**
	 * @param categorieService
	 *            the categorieService to set
	 */
	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

	/**
	 * @param produitService
	 *            the produitService to set
	 */
	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	@RequestMapping(value = "/listeProduitsAdmin", method = RequestMethod.GET)
	public String afficherListeProduits(ModelMap model) {
		List<Produit> listeProduits = produitService.getAllProduits();
		model.addAttribute("produitsListe", listeProduits);

		return "produits";
	}

	@RequestMapping(value = "/formulaireAddPro", method = RequestMethod.GET)
	public ModelAndView formulaireAjoutPro(ModelMap model) {
		List<Categorie> listeCategories = categorieService.getAllCategories();
		model.addAttribute("categoriesListe", listeCategories);
		return new ModelAndView("formulaireAddPro", "mProduit", new Produit());
	}

	@RequestMapping(value = "/addProduit", method = RequestMethod.POST)
	public String addProduit(Produit pProduit, ModelMap model, MultipartFile file) throws Exception {

		if (!file.isEmpty()) {
			pProduit.setPhoto(file.getBytes());

		}
		if (pProduit.getIdProduit() == null) {
			produitService.addProduit(pProduit);
		} else {
			produitService.updateProduit(pProduit);
		}
		model.addAttribute("produitsListe", produitService.getAllProduits());

		return "produits";
	}

	@RequestMapping(value = "/updateProduit", method = RequestMethod.GET)
	public ModelAndView formulaireUpdatePro(Long proId) {

		Produit pro_rec = produitService.getProduitById(proId);
		String viewName = "formulaireAddPro";

		return new ModelAndView(viewName, "mProduit", pro_rec);
	}

	@RequestMapping(value = "/deleteProduit/{idProduit}", method = RequestMethod.GET)
	public String formulaireDeletePro(ModelMap model, @PathVariable("idProduit") Long proId) {

		Produit pro_rec = produitService.getProduitById(proId);
		produitService.deleteProduit(pro_rec);
		model.addAttribute("produitsListe", produitService.getAllProduits());

		return "produits";
	}

	@RequestMapping(value = "/photoProduit", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long proId) throws IOException {
		System.out.println("Id photo: " +proId.toString() );
		Produit pro_rec = produitService.getProduitById(proId);
		System.out.println(pro_rec.toString());
		if (pro_rec.getPhoto() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(pro_rec.getPhoto()));
		}
	}
}
