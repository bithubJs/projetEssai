package fr.adaming.service;

import fr.adaming.model.Role;
import fr.adaming.model.User;

public interface IAdminService {

	public void addUser(User u);

	public void attribuerRole(Role r, Long idUser);
	
}
