package com.galaxy.project;

import org.junit.BeforeClass;
import org.junit.Test;

import com.galaxy.project.authentication.AuthSystem;
import com.galaxy.project.controller.DivisionRowContinuousFluxController;
import com.galaxy.project.controller.DivisionRowForSpectralLineController;
import com.galaxy.project.controller.RedshiftGalaxySearchFrameController;
import com.galaxy.project.controller.ValuesSpectralLineFrameController;
import com.galaxy.project.frames.tablemodel.GalaxyDistancePair;
import com.galaxy.project.frames.tablemodel.GalaxyRedshiftPair;
import com.galaxy.project.model.AFlux;
import com.galaxy.project.model.ContinuousFlux;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.model.RowFlux;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.model.Utente;
import com.galaxy.project.tools.GalaxiesFinder;

//import static
import static org.junit.Assert.*;

import java.util.List;
public class DivisionRowTest{
	
	
	private static GalaxiesFinder galaxyFinder;
	private static DivisionRowContinuousFluxController controller;

	
	public DivisionRowTest() {
		
	}
	
	@BeforeClass
	public static void initDataSet() {
		galaxyFinder = new GalaxiesFinder();
		controller = new DivisionRowContinuousFluxController(null);

	}
	// REQUISITO FUNZIONALE 9
	@Test
	public void divisionRowTest(){
		
		String Galassia = "IRAS15176+5216";
		Galaxy gmodel = galaxyFinder.ricercaGalassiaPerNome(Galassia);
		List<AFlux> fluxes = gmodel.getFluxes();
		assertTrue(fluxes.size()==9);
	}
	
	// REQUISITO FUNZIONALE 11
	@Test
	public void divisionRowContinuousTest(){
		
		String Galassia = "IRAS15176+5216";
		Galaxy gmodel = galaxyFinder.ricercaGalassiaPerNome(Galassia);
		List<SpectralLine> slList = controller.getSpectralLineFromGalaxy(gmodel);
		List<RowFlux> fList = controller.getRowFluxFromSpectralLine(gmodel, slList.get(0));
		List<ContinuousFlux> fcList = controller.getContinuousFluxFromSpectralLine(gmodel, slList.get(0));
		float resultDivision = controller.getValueFromDivision(fList.get(0), fcList.get(0));
		assertTrue(resultDivision==22.333334F);
	}
}
