package fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;

@Service
@Transactional
public class PanierServiceImpl implements IPanierService {

	private Panier listeCommandeP = new Panier();

	@Override
	public void addCommande(LigneCommande lc) {
		listeCommandeP.addLigneCommande(lc);

	}

	@Override
	public void deleteCommande(Long id) {
		listeCommandeP.getListeCommandeP().remove(id);

	}

	@Override
	public List<LigneCommande> getCommande() {

		return listeCommandeP.getListeCommandeP();
	}

	@Override
	public int getSize() {

		return listeCommandeP.getListeCommandeP().size();
	}

	@Override
	public double getMontant() {

		double total = 0;
		List<LigneCommande> ligneCommande = listeCommandeP.getListeCommandeP();

		for (LigneCommande lc : ligneCommande) {
			total += lc.getQuantite() * lc.getProduit().getPrix();
		}
		return total;
	}

}
