package com.galaxy.project.persistence;

import java.util.HashMap;
import java.util.Map;

import com.galaxy.project.model.Utente;

public class UserDAO extends AGenericDAO<Utente> {

	public UserDAO() {
		super(Utente.class);
	}
	
	public Utente cercaUtentePerUserID(String userID){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userID", userID);  

		return super.findOneResult(Utente.FIND_BY_USERID, parameters);
	}
	
}
