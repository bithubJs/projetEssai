package fr.adaming.controllers;

import java.io.*;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/sith-e-commerce")
@SessionAttributes("panier")
public class SithECommerceController {

	@Autowired
	private ICategorieService categorieService;

	@Autowired
	private IProduitService produitService;

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

	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String accueilSith(ModelMap model) {

		model.addAttribute("msg1", "Que la force soit avec ton panier");
		model.addAttribute("msg2", "Ne jamais oublier, panier vide je te plein, panier plein je te ... plein plus !");

		return "accueil";

	}

	@RequestMapping(value = "/accueil")
	public String accueil(ModelMap model) {
		if (model.get("panier") == null) {
			model.addAttribute("panier", new Panier());
		}
		model.addAttribute("categoriesListe", categorieService.getAllCategories());
		model.addAttribute("produitsListe", produitService.produitsSelectionnes());
		return "accueil";
	}

	@RequestMapping(value = "/produitsByCat")
	public String produitsByCat(@RequestParam Long idCat, ModelMap model) {
		model.addAttribute("categoriesListe", categorieService.getAllCategories());
		model.addAttribute("produitsListe", produitService.produitsByCategorie(idCat));
		return "accueil";
	}

	@RequestMapping(value = "/produitsByKW")
	public String produitByKW(@RequestParam String m, ModelMap model) {
		model.addAttribute("m", m);
		model.addAttribute("categoriesListe", categorieService.getAllCategories());
		model.addAttribute("produitsListe", produitService.getProduitsByKeyWord(m));
		return "accueil";
	}

	@RequestMapping(value = "/photoProduit", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoProd(@RequestParam("idP") Long idP) throws Exception {
		Produit pro_rec = produitService.getProduitById(idP);
		String path = System.getProperty("java.io.tmpdir") + "/" + pro_rec.getIdProduit();
		return IOUtils.toByteArray(new FileInputStream(path));
	}

	@RequestMapping(value = "/ajouterPanier")
	public String ajouterAuPanier(@RequestParam Long idProduit, @RequestParam int quantite, ModelMap model) {
		Panier panier = null;
		if (model.get("panier") == null) {
			panier = new Panier();
			model.addAttribute("panier", panier);
		} else {
			panier = (Panier) model.get("panier");
			panier.addProduitPanier(produitService.getProduitById(idProduit), quantite);
			model.addAttribute("categoriesListe", categorieService.getAllCategories());
			model.addAttribute("produitsListe", produitService.produitsSelectionnes());
			return "accueil";
		}
		return "accueil";
	}

}
