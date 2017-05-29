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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IPanierService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/sith-e-commerce")
@SessionAttributes("panier")
public class SithECommerceController {

	@Autowired
	private ICategorieService categorieService;

	@Autowired
	private IProduitService produitService;

	@Autowired
	private IClientService clientService;

	@Autowired
	private IPanierService panierService;

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

	/**
	 * @param clientService
	 *            the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	/**
	 * @param panierService
	 *            the panierService to set
	 */
	public void setPanierService(IPanierService panierService) {
		this.panierService = panierService;
	}

	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String accueilSith(ModelMap model) {

		List<Categorie> listeCategories = categorieService.getAllCategories();
		model.addAttribute("categoriesListe", listeCategories);
		List<Produit> listeProduits = produitService.getAllProduits();
		model.addAttribute("produitsListe", listeProduits);

		return "accueil";

	}

	// @RequestMapping(value = "/afficherCategories", method =
	// RequestMethod.GET)
	// public String afficherListeCategories(ModelMap model) {
	//
	// List<Categorie> listeCategories = categorieService.getAllCategories();
	// model.addAttribute("categoriesListe", listeCategories);
	//
	// return "categoriesClient";
	// }
	//
	// @RequestMapping(value = "/afficherProduits", method = RequestMethod.GET)
	// public String afficherListeProduits(ModelMap model) {
	//
	// List<Produit> listeProduits = produitService.getAllProduits();
	// model.addAttribute("produitsListe", listeProduits);
	//
	// return "produitsClient";
	// }

	@RequestMapping(value = "/accueil")
	public String accueil(ModelMap model) {
		if (model.get("panier") == null) {
			model.addAttribute("panier", new Panier());
		}
		model.addAttribute("categoriesListe", categorieService.getAllCategories());
		model.addAttribute("produitsListe", produitService.produitsSelectionnes());
		return "accueil";
	}

	@RequestMapping(value = "/produitsByCat/{idP}")
	public String produitsByCat(@PathVariable("idP") Long idCat, ModelMap model) {
		model.addAttribute("categoriesListe", categorieService.getAllCategories());
		model.addAttribute("produitsListe", produitService.produitsByCategorie(idCat));
		return "accueil";
	}

	@RequestMapping(value = "/produitsByKW")
	public String produitByKW(@RequestParam String m, ModelMap model) {
		model.addAttribute("m", m);
		model.addAttribute("categoriesListe", categorieService.getAllCategories());
		model.addAttribute("produitsListe", produitService.getProduitsByKeyWord(m));
		return "produitsByKW";
	}

	@RequestMapping(value = "/photoProduit", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long proId) throws IOException {

		Produit pro_rec = produitService.getProduitById(proId);

		if (pro_rec.getPhoto() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(pro_rec.getPhoto()));
		}
	}

	@RequestMapping(value = "/photoCategorie", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto2(Long catId) throws IOException {

		Categorie cat_rec = categorieService.getCategorieById(catId);

		if (cat_rec.getPhoto() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(cat_rec.getPhoto()));
		}
	}

	@RequestMapping(value = "/panier", method = RequestMethod.GET)
	public String afficherPanier(ModelMap model) {
		model.addAttribute("pListe", panierService.getCommande());
		return "panier";
	}

	@RequestMapping(value = "/panier/add/{idP}", method = RequestMethod.GET)
	public String ajouterItems(ModelMap model, @PathVariable("idP") Long pId, @RequestParam("qt") int quantite) {
		LigneCommande lc = new LigneCommande(produitService.getProduitById(pId), quantite);
		panierService.addCommande(lc);
		;
		model.addAttribute("pListe", panierService.getCommande());
		return "panier";
	}

	@RequestMapping(value = "/panier/delete", method = RequestMethod.GET)
	public ModelAndView deleteItems(@RequestParam("Id") Long id) {
		panierService.deleteCommande(id);
		return new ModelAndView("panier", "pListe", panierService.getCommande());
	}

	@RequestMapping(value = "/panier/q+", method = RequestMethod.GET)
	public ModelAndView addArticleQuantite(@RequestParam("Id") int id) {
		panierService.getCommande().get(id).setQuantite(panierService.getCommande().get(id).getQuantite() + 1);
		return new ModelAndView("panier", "pListe", panierService.getCommande());
	}

	@RequestMapping(value = "/panier/q-", method = RequestMethod.GET)
	public ModelAndView supprimerArticlePanier(@RequestParam("Id") int id) {
		panierService.getCommande().get(id).setQuantite(panierService.getCommande().get(id).getQuantite() - 1);
		return new ModelAndView("panier", "pListe", panierService.getCommande());
	}

}
