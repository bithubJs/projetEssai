package fr.adaming.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commandes")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_co")
	private Long idCommande;

	@Temporal(TemporalType.DATE)
	private Calendar dateCommande;

	private double prixCommande;

	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id_cl")
	private Client client;

	/**
	 * 
	 */
	public Commande() {
		super();
	}

	/**
	 * @param dateCommande
	 */
	public Commande(Calendar dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	/**
	 * @param idCommande
	 * @param dateCommande
	 */
	public Commande(Long idCommande, Calendar dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	/**
	 * @return the idCommande
	 */
	public Long getIdCommande() {
		return idCommande;
	}

	/**
	 * @param idCommande
	 *            the idCommande to set
	 */
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	/**
	 * @return the dateCommande
	 */
	public Calendar getDateCommande() {
		return dateCommande;
	}

	/**
	 * @param dateCommande
	 *            the dateCommande to set
	 */
	public void setDateCommande(Calendar dateCommande) {
		this.dateCommande = dateCommande;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the prixCommande
	 */
	public double getPrixCommande() {
		return prixCommande;
	}

	/**
	 * @param prixCommande
	 *            the prixCommande to set
	 */
	public void setPrixCommande(double prixCommande) {
		this.prixCommande = prixCommande;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + "]";
	}

}
