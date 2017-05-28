package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;

@Repository
public class ClientDaoImpl implements IClientDao {

	@Autowired
	private SessionFactory sf;
	private Session s;

	/**
	 * @param sf
	 *            the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	// --------------------------------------------------------------- //
	// Methodes pour gestion (enregistrement) du client après commande //
	// --------------------------------------------------------------- //

	@Override
	public List<Client> getAllClients() {

		s = sf.getCurrentSession();
		String req_GetAllClients = "FROM Client";
		Query query = s.createQuery(req_GetAllClients);

		return query.list();
	}

	@Override
	public Commande saveCommande(Panier panier, Client c) {

		s = sf.getCurrentSession();
		s.save(c);
		Commande commande = new Commande();
		commande.setClient(c);
		commande.setListeLignesCommande((List<LigneCommande>) panier.getLigneCommande());
		s.save(commande);
		return commande;
	}

	// @Override
	// public void addClient(Client c) {
	//
	// s = sf.getCurrentSession();
	// s.save(c);
	//
	// }
	//
	// @Override
	// public Client getClientById(Long id) {
	//
	// s = sf.getCurrentSession();
	//
	// Client c_rec = (Client) s.get(Client.class, id);
	//
	// return c_rec;
	// }
	//
	// @Override
	// public void updateClient(Client c) {
	//
	// s = sf.getCurrentSession();
	// s.update(c);
	//
	// }
	//
	// @Override
	// public void deleteClient(Client c) {
	//
	// s = sf.getCurrentSession();
	// String req_delete = "DELETE FROM Client c WHERE c.idClient=:pId";
	// Query query = s.createQuery(req_delete);
	// query.setParameter("pId", c.getIdClient());
	// query.executeUpdate();
	//
	// }

}
