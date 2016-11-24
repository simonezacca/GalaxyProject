package com.galaxy.project.controller;

import com.galaxy.project.authentication.AuthSystem;
import com.galaxy.project.frames.RegisterFrame;
import com.galaxy.project.model.Utente;
import com.galaxy.project.persistence.UserDAO;

public class RegisterController {


	RegisterFrame parentFrame = null;							//inizializzo JFrame
	AuthSystem auth = null;
	Utente u = null;
	UserDAO udao = null;
	
	public RegisterController(RegisterFrame parent){
		this.parentFrame = parent; 							//gli passo il RegisterFrame
		this.auth = AuthSystem.getInstance();
		this.udao = new UserDAO();
	}

	public void doRegistrazione(String username, String password, String name, String surname, String mail, Integer roleInt){	
		if(auth.esisteUserID(username)==false){
			u = new Utente(username,password, name, surname, mail, roleInt);
			udao.create(u);
		}	
	}
}
