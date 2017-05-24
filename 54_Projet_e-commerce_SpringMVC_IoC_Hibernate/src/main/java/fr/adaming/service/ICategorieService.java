package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieService {

	public void addCategorie(Categorie c);

	public List<Categorie> getAllCategories();

	public Categorie getCategorieById(int id);

	public void updateCategorie(Categorie c);

	public void deleteCategorie(Categorie c);

}
