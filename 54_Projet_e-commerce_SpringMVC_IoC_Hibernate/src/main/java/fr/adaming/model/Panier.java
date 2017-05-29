package fr.adaming.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Panier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<LigneCommande> listeCommandeP = new ArrayList<LigneCommande>();
	private double total;

	/**
	 * 
	 */
	public Panier() {
		super();
	}

	/**
	 * @param listeCommandeP
	 * @param total
	 */
	public Panier(List<LigneCommande> listeCommandeP, double total) {
		super();
		this.listeCommandeP = listeCommandeP;
		this.total = total;
	}

	/**
	 * @return the listeCommandeP
	 */
	public List<LigneCommande> getListeCommandeP() {
		return listeCommandeP;
	}

	/**
	 * @param listeCommandeP
	 *            the listeCommandeP to set
	 */
	public void setListeCommandeP(List<LigneCommande> listeCommandeP) {
		this.listeCommandeP = listeCommandeP;

		total = 0;
		for (LigneCommande lc : listeCommandeP) {
			total += lc.getPrix();
		}
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Panier [listeCommandeP=" + listeCommandeP + ", total=" + total + "]";
	}

	// Others Method

	public void addLigneCommande(LigneCommande lc) {
		listeCommandeP.add(lc);

		total = 0;
		for (LigneCommande lc1 : listeCommandeP) {
			total += lc1.getPrix();
		}
	}
}
