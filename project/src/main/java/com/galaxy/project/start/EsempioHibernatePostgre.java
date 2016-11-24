package com.galaxy.project.start;

import com.galaxy.project.model.Utente;
import com.galaxy.project.persistence.UserDAO;

public class EsempioHibernatePostgre {

	public static void main(String[] args) {
//		Utente utente = new Utente("SimoneZacca", "Simone", "Zaccariello", "simone", "simone.zaccariello@fastwebnet.it", Utente.RUOLO_AMMINISTRATORE);
		Utente utente= new Utente("Lello", "Andrea", "Leonetti", "lello", "lamammadelello@gmail.com", Utente.RUOLO_UTENTE);
		System.out.println(utente);
		
		UserDAO udao = new UserDAO();
		udao.create(utente);
	
	}

}
