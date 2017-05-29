package fr.adaming.service;

import java.util.List;

import fr.adaming.model.LigneCommande;

public interface IPanierService {

	public void addCommande(LigneCommande lc);

	public void deleteCommande(Long id);

	public List<LigneCommande> getCommande();

	public int getSize();

	public double getMontant();
}
