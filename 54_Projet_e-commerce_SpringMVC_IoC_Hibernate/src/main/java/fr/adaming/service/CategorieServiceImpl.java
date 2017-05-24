package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;

@Service
@Transactional
public class CategorieServiceImpl implements ICategorieService {

	@Autowired
	private ICategorieDao categorieDao;

	@Override
	public void addCategorie(Categorie c) {

		categorieDao.addCategorie(c);
	}

	@Override
	public List<Categorie> getAllCategories() {

		return categorieDao.getAllCategories();
	}

	@Override
	public Categorie getCategorieById(int id) {

		return categorieDao.getCategorieById(id);
	}

	@Override
	public void updateCategorie(Categorie c) {

		categorieDao.updateCategorie(c);

	}

	@Override
	public void deleteCategorie(Categorie c) {

		categorieDao.deleteCategorie(c);

	}

}
