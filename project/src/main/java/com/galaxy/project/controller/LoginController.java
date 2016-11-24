package com.galaxy.project.controller;

import javax.swing.JOptionPane;

import com.galaxy.project.authentication.AuthSystem;
import com.galaxy.project.frames.LoginFrame;
import com.galaxy.project.model.Utente;

public class LoginController {

	LoginFrame parentFrame = null;							//inizializzo JFrame
	AuthSystem auth = null;
	Utente u = null;
	
	public LoginController(LoginFrame parent){
		this.parentFrame = parent; 							//gli passo il LoginFrame
		this.auth = AuthSystem.getInstance();
		
	}
	
	public void doLogin(String userID, String password){
		if(auth.verificaCredenziali(userID, password)){		// Se l'utente esiste
			u = auth.getAuthorizedUser(userID);				// ritorna oggetto utente autorizzato
			parentFrame.createMainUserFrame(u); 			// Crea il frame in base al ruolo utente
		}
		else
		{
			String title = "Login fallito";
			String message = "Credenziali di accesso non valide!";
			JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
