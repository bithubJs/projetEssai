package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_u")
	private Long idUser;

	private String username;
	private String password;
	private boolean actived;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Role> listeRoles;

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param username
	 * @param password
	 * @param actived
	 */
	public User(String username, String password, boolean actived) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param actived
	 */
	public User(Long idUser, String username, String password, boolean actived) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.actived = actived;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return idUser;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the actived
	 */
	public boolean isActived() {
		return actived;
	}

	/**
	 * @param actived
	 *            the actived to set
	 */
	public void setActived(boolean actived) {
		this.actived = actived;
	}

	/**
	 * @return the listeRoles
	 */
	public List<Role> getListeRoles() {
		return listeRoles;
	}

	/**
	 * @param listeRoles
	 *            the listeRoles to set
	 */
	public void setListeRoles(List<Role> listeRoles) {
		this.listeRoles = listeRoles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + idUser + ", username=" + username + ", password=" + password + ", actived=" + actived
				+ "]";
	}

}
