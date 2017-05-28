package fr.adaming.model;

import java.util.Calendar;
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

	@OneToMany(mappedBy = "commande", cascade = CascadeType.REMOVE)
	private List<LigneCommande> listeLignesCommande;

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
	 * @return the listeLignesCommande
	 */
	public List<LigneCommande> getListeLignesCommande() {
		return listeLignesCommande;
	}

	/**
	 * @param listeLignesCommande
	 *            the listeLignesCommande to set
	 */
	public void setListeLignesCommande(List<LigneCommande> listeLignesCommande) {
		this.listeLignesCommande = listeLignesCommande;
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
