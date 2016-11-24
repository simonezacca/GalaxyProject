package com.galaxy.project.frames;

import javax.swing.JFrame;

import com.galaxy.project.model.Utente;

public abstract class AGenericUserFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Utente utenteCorrente = null;
	
	public AGenericUserFrame(String titolo){
		super(titolo);
	}
	
	public Utente getUtenteCorrente() {
		return utenteCorrente;
	}
	public void setUtenteCorrente(Utente utenteCorrente) {
		this.utenteCorrente = utenteCorrente;
	}

}
