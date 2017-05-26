package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Role;
import fr.adaming.model.User;

@Repository
public class AdminDaoImpl implements IAdminDao {

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

	@Override
	public void addUser(User u) {

		s = sf.getCurrentSession();
		s.save(u);

	}

	@Override
	public void attribuerRole(Role r, Long idUser) {

		s = sf.getCurrentSession();
		User u_rec = (User) s.get(User.class, idUser);
		r.setUser(u_rec);
		s.save(r);

	}

}
