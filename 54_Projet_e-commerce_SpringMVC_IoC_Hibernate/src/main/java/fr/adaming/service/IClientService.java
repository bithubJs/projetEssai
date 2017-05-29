package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Panier;

public interface IClientService {

	public List<Client> getAllClients();

	public void addClient(Client c);

	public Client getClientById(Long id);

	public void updateClient(Client c);

	public void deleteClient(Client c);

	public List<Commande> getCommandeByClient(Client client);

	public Commande saveCommande(Commande commande);

	public void deleteCommande(Long idCo);

	public Commande getComandeById(Long idCo);

}
