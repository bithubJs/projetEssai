package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lignecommande")
public class LigneCommande {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lc")
	private int id;
	
	private int quantite;
	private int prix;
	
	@OneToMany
	private List<Produit> listeProduits;
	
	@ManyToOne
	@JoinColumn(name = "commande_id", referencedColumnName = "id_co")
	private Commande commande;

	/**
	 * 
	 */
	public LigneCommande() {
		super();
	}

	/**
	 * @param quantite
	 * @param prix
	 * @param listeProduits
	 */
	public LigneCommande(int quantite, int prix, List<Produit> listeProduits) {
		super();
		this.quantite = quantite;
		this.prix = prix;
		this.listeProduits = listeProduits;
	}

	/**
	 * @param id
	 * @param quantite
	 * @param prix
	 * @param listeProduits
	 */
	public LigneCommande(int id, int quantite, int prix, List<Produit> listeProduits) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prix = prix;
		this.listeProduits = listeProduits;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the prix
	 */
	public int getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}

	/**
	 * @return the listeProduits
	 */
	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	/**
	 * @param listeProduits the listeProduits to set
	 */
	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", quantite=" + quantite + ", prix=" + prix + ", listeProduits="
				+ listeProduits + "]";
	}
	
	
	
	
	
}
