package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientDao {
	

	public void addClient(Client c);
	public List<Client> getAllClients();
	public Client getClientById(int id);
	public void updateClient(Client c);
	public void deleteClient(Client c);
	

}
