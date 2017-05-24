package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitDao {
	
	public void addProduit(Produit p);
	public List<Produit> getAllProduits();
	public Produit getProduitById(int id);
	public void updateProduit(Produit p);
	public void deleteProduit(Produit p);
	
}
