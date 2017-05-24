package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieDao {

	public void addCategorie(Categorie c);

	public List<Categorie> getAllCategories();

	public Categorie getCategorieById(int id);

	public void updateCategorie(Categorie c);

	public void deleteCategorie(Categorie c);

}
