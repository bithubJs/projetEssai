package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAdminDao;
import fr.adaming.model.Role;
import fr.adaming.model.User;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao adminDao;

	@Override
	public void addUser(User u) {
		adminDao.addUser(u);

	}

	@Override
	public void attribuerRole(Role r, Long idUser) {
		adminDao.attribuerRole(r, idUser);

	}

}
