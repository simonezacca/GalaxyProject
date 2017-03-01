package com.galaxy.project;

import org.junit.BeforeClass;
import org.junit.Test;

import com.galaxy.project.authentication.AuthSystem;
import com.galaxy.project.controller.RedshiftGalaxySearchFrameController;
import com.galaxy.project.controller.ValuesSpectralLineFrameController;
import com.galaxy.project.frames.tablemodel.GalaxyDistancePair;
import com.galaxy.project.frames.tablemodel.GalaxyRedshiftPair;
import com.galaxy.project.model.AFlux;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.model.Utente;
import com.galaxy.project.tools.GalaxiesFinder;

//import static
import static org.junit.Assert.*;

import java.util.List;
public class ValuesSpectralLineTest{
	
	
	private static GalaxiesFinder galaxyFinder;

	
	public ValuesSpectralLineTest() {
		
	}
	
	@BeforeClass
	public static void initDataSet() {
		galaxyFinder = new GalaxiesFinder();
	}
	// REQUISITO FUNZIONALE 8
	@Test
	public void valuesSpectralLineTest(){
		
		String Galassia = "NGC7213";
		Galaxy gmodel = galaxyFinder.ricercaGalassiaPerNome(Galassia);
		List<AFlux> fluxes = gmodel.getFluxes();
		assertTrue(fluxes.size()==13); 
	}
}
