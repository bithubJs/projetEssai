package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Panier;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao cDao;

	@Override
	public List<Client> getAllClients() {

		return cDao.getAllClients();
	}

	@Override
	public void addClient(Client c) {

		cDao.addClient(c);
	}

	@Override
	public Client getClientById(Long id) {

		return cDao.getClientById(id);
	}

	@Override
	public void updateClient(Client c) {

		cDao.updateClient(c);
	}

	@Override
	public void deleteClient(Client c) {

		cDao.deleteClient(c);
	}

	@Override
	public List<Commande> getCommandeByClient(Client client) {

		return cDao.getCommandeByClient(client);
	}

	@Override
	public Commande saveCommande(Commande commande) {

		return cDao.saveCommande(commande);
	}

	@Override
	public void deleteCommande(Long idCo) {
		cDao.deleteCommande(idCo);

	}

	@Override
	public Commande getComandeById(Long idCo) {

		return cDao.getComandeById(idCo);
	}

}
