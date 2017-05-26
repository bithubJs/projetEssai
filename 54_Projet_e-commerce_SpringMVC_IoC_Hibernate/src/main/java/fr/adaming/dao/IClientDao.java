package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Panier;

public interface IClientDao {

	public List<Client> getAllClients();

	public Commande saveCommande(Panier panier, Client c);

	// public void addClient(Client c);
	//
	// public Client getClientById(Long id);
	//
	// public void updateClient(Client c);
	//
	// public void deleteClient(Client c);

}
