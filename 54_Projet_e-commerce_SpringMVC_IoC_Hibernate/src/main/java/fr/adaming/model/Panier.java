package fr.adaming.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<Long, LigneCommande> items = new HashMap<Long, LigneCommande>();

	public void addProduitPanier(Produit p, int quantite) {
		LigneCommande lc = items.get(p.getIdProduit());
		if (lc == null) {
			LigneCommande lc1 = new LigneCommande();
			lc1.setProduit(p);
			lc1.setQuantite(quantite);
			lc1.setPrix(p.getPrix());
			items.put(p.getIdProduit(), lc1);
		} else {
			lc.setQuantite(lc.getQuantite() + quantite);
		}
	}

	public Collection<LigneCommande> getLigneCommande() {
		return items.values();
	}

	public int getSize() {
		return items.size();
	}

	public double getTotal() {
		double total = 0;
		for (LigneCommande lc : items.values()) {
			total += lc.getPrix() * lc.getQuantite();
		}
		return total;
	}

	public void deleteItem(Long idproduit) {
		items.remove(idproduit);
	}

	/**
	 * @return the items
	 */
	public Map<Long, LigneCommande> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(Map<Long, LigneCommande> items) {
		this.items = items;
	}

}
