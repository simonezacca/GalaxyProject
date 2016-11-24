package com.galaxy.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.galaxy.project.persistence.IPersistente;


@Entity
@Table(name="user")
@NamedQueries({
	   @NamedQuery(
	        name = "cercaUtentePerUserID", 
	        query="FROM Utente u WHERE u.userID LIKE :userID")
	})

public class Utente implements IPersistente {
	
	public static final String FIND_BY_USERID = "cercaUtentePerUserID";
	
	protected Utente() {
		
	}
	
	public Utente(String userID, String nome, String cognome, String password,
			String email, Integer ruolo) {
		this.userID = userID;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.email = email;
		this.ruolo = ruolo;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id = null;
	
	@Override
	public String toString() {
		return "Utente [id=" + id + ", userID=" + userID + ", nome=" + nome
				+ ", cognome=" + cognome + ", password=" + password
				+ ", email=" + email + ", ruolo=" + ruolo + "]";
	}

	@Column(nullable=false, length=255, unique=true)
	private String userID;
	
	@Column(nullable=false, length=255)
	private String nome;
	
	@Column(nullable=false, length=255)
	private String cognome;
	
	@Column(nullable=false, length=255)
	private String password;
	
	@Column(nullable=false, length=255, unique=true)
	private String email;
	
	@Column(nullable=false)
	private Integer ruolo;
	
	public static final Integer RUOLO_AMMINISTRATORE = 0;
	public static final Integer RUOLO_UTENTE = 1; 
	

	public String getUserID() {
		return password;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRuolo() {
		return ruolo;
	}

	public void setRuolo(Integer ruolo) {
		this.ruolo = ruolo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean isValid() {
		return userID.length()>0 && password.length()>0;
	}

}
