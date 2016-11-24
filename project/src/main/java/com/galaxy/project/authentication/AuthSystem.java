package com.galaxy.project.authentication;

import com.galaxy.project.model.Utente;
import com.galaxy.project.persistence.UserDAO;

public class  AuthSystem {

	private static AuthSystem instance = null;
	private UserDAO udao = null;
	
	private AuthSystem(){
		udao = new UserDAO();
	}
	
	public static AuthSystem getInstance(){
		if(instance==null) {
			instance = new AuthSystem();
		}
		return instance;
	}
	
	public boolean verificaCredenziali(String userID, String password){
		Utente u = udao.cercaUtentePerUserID(userID);
		if (u==null) 
			return false; // user id non esistente
		return (u != null && u.getPassword().equals(password)); // ritorno un oggetto diverso da null e verifico password
	}

	// Se l'user ID esiste ritorna true, altrimenti false
	public boolean esisteUserID(String userID){
		return (udao.cercaUtentePerUserID(userID) != null); 
	}
	
	public Utente getAuthorizedUser(String userID){
		return udao.cercaUtentePerUserID(userID);
	}
}