package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;

@Repository
public class CategorieDaoImpl implements ICategorieDao {

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

	// ---------------------------------- //
	// Methodes pour gestion des catégories //
	// ---------------------------------- //

	@Override
	public void addCategorie(Categorie c) {

		s = sf.getCurrentSession();
		s.save(c);

	}

	@Override
	public List<Categorie> getAllCategories() {

		s = sf.getCurrentSession();
		String reqCategorie = "SELECT c FROM Categorie c";
		Query query = s.createQuery(reqCategorie);

		return query.list();
	}

	@Override
	public Categorie getCategorieById(Long id) {
		s = sf.getCurrentSession();

		Categorie c_rec = (Categorie) s.get(Categorie.class, id);

		return c_rec;
	}

	@Override
	public void updateCategorie(Categorie c) {
		s = sf.getCurrentSession();
		s.update(c);

	}

	@Override
	public void deleteCategorie(Categorie c) {

		s = sf.getCurrentSession();
		String reqDelete = "DELETE FROM Categorie c WHERE c.idCategorie=:cIdc";
		Query query = s.createQuery(reqDelete);
		query.setParameter("cIdc", c.getIdCategorie());
		query.executeUpdate();

	}

}
