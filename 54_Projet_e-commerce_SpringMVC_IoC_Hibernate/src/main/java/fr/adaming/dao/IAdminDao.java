package fr.adaming.dao;

import fr.adaming.model.Role;
import fr.adaming.model.User;

public interface IAdminDao {

	public void addUser(User u);

	public void attribuerRole(Role r, Long idUser);

}
