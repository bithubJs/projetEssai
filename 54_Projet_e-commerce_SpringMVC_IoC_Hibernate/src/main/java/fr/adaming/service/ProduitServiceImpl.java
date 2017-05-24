package fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Produit;

@Service
@Transactional
public class ProduitServiceImpl implements IProduitService {

	@Override
	public void addProduit(Produit p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit getProduitById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduit(Produit p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduit(Produit p) {
		// TODO Auto-generated method stub
		
	}

}
