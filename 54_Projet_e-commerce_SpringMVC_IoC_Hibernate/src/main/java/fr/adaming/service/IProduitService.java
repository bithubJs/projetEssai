package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitService {

	public List<Produit> getAllProduits();

	public void addProduit(Produit p);

	public List<Produit> getProduitsByKeyWord(String kw);

	public List<Produit> produitsByCategorie(Long idCategorie);

	public List<Produit> produitsSelectionnes();

	public Produit getProduitById(Long id);

	public void updateProduit(Produit p);

	public void deleteProduit(Produit p);

	// public Commande saveCommande(Panier panier, Client c);
}
