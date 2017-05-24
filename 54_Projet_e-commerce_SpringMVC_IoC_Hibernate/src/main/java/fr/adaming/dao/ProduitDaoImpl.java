package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Repository
public class ProduitDaoImpl implements IProduitDao {

	@Autowired
	private SessionFactory sf;
	private Session s;
	
	
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	
	// ---------------------------------- //
	// Methodes pour gestion des produits //
	// ---------------------------------- //
	
	
	@Override
	public void addProduit(Produit p) {

		s = sf.getCurrentSession();
		s.save(p);
		
	}

	@Override
	public List<Produit> getAllProduits() {

		s = sf.getCurrentSession();
		String req_GetAllProduits = "FROM Produit";
		Query query = s.createQuery(req_GetAllProduits);
		
		return query.list();
	}

	@Override
	public Produit getProduitById(int id) {

		
		s = sf.getCurrentSession();
		
		Produit p_rec = (Produit) s.get(Produit.class, id);
		
		return p_rec;
	}

	@Override
	public void updateProduit(Produit p) {

		s = sf.getCurrentSession();
		s.update(p);
		
	}

	@Override
	public void deleteProduit(Produit p) {

		s = sf.getCurrentSession();
		String req_delete = "DELETE FROM Produit p WHERE p.idProduit=:pId";
		Query query = s.createQuery(req_delete);
		query.setParameter("pId", p.getIdProduit());
		query.executeUpdate();
		
	}

}
