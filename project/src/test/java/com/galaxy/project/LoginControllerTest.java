package com.galaxy.project;

import org.junit.BeforeClass;
import org.junit.Test;

import com.galaxy.project.authentication.AuthSystem;
import com.galaxy.project.model.Utente;

//import static
import static org.junit.Assert.*;
public class LoginControllerTest{
	
	
	private static AuthSystem authSystem ;
	
	public LoginControllerTest() {
		
	}
	
	@BeforeClass
	public static void initDataSet() {
		authSystem = AuthSystem.getInstance();
	}
	// REQUISITO FUNZIONALE 1
	@Test
	public void loginTest(){
		String userID = "amministratore";
		String password = "amministratore";
		boolean resultTest = authSystem.verificaCredenziali(userID, password);
		assertTrue(resultTest);
	}
	
	@Test
	public void loginTest2(){
		String userID = "prova";
		String password = "prova";
		boolean resultTest = authSystem.verificaCredenziali(userID, password);
		assertFalse(resultTest);
	}
	// REQUISITO FUNZIONALE 2
	@Test
	public void loginTest3(){
		String userID = "amministratore";
		Utente u = AuthSystem.getInstance().getAuthorizedUser(userID);
		assertTrue(u.getUserID().length()>= 6);
		assertTrue(u.getPassword().length()>= 6);
	}
	
	// REQUISITO FUNZIONALE 3
		@Test
		public void loginTest4(){
			String userID = "amministratore";
			Utente u = AuthSystem.getInstance().getAuthorizedUser(userID);
			assertTrue(u.getRuolo()==Utente.RUOLO_AMMINISTRATORE);
			userID = "utente";
			u = AuthSystem.getInstance().getAuthorizedUser(userID);
			assertTrue(u.getRuolo()==Utente.RUOLO_UTENTE);
		}
		
		
}
