package fr.adaming.model;

import java.io.Serializable;

public class LigneCommande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Produit produit;
	private int quantite;
	private double prix;

	/**
	 * 
	 */
	public LigneCommande() {
		super();
	}

	/**
	 * @param produit
	 * @param quantite
	 */
	public LigneCommande(Produit produit, int quantite) {
		super();
		this.produit = produit;
		this.quantite = quantite;
		this.prix = produit.getPrix() * quantite;
	}

	/**
	 * @return the produit
	 */
	public Produit getProduit() {
		return produit;
	}

	/**
	 * @param produit
	 *            the produit to set
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite
	 *            the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LigneCommande [produit=" + produit + ", quantite=" + quantite + ", prix=" + prix + "]";
	}

}
