package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Produit;

@Service
@Transactional
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	private IProduitDao pDao;

	@Override
	public List<Produit> getAllProduits() {

		return pDao.getAllProduits();
	}

	@Override
	public List<Produit> getProduitsByKeyWord(String kw) {

		return pDao.getProduitsByKeyWord(kw);
	}

	@Override
	public List<Produit> produitsByCategorie(Long idCategorie) {

		return pDao.produitsByCategorie(idCategorie);
	}

	@Override
	public List<Produit> produitsSelectionnes() {

		return pDao.produitsSelectionnes();
	}

	@Override
	public void addProduit(Produit p) {

		pDao.addProduit(p);
	}

	@Override
	public Produit getProduitById(Long id) {

		return pDao.getProduitById(id);
	}

	@Override
	public void updateProduit(Produit p) {

		pDao.updateProduit(p);
	}

	@Override
	public void deleteProduit(Produit p) {

		pDao.deleteProduit(p);
	}

}
