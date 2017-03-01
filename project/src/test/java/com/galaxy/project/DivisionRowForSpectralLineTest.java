package com.galaxy.project;

//import static
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.galaxy.project.controller.DivisionRowForSpectralLineController;
import com.galaxy.project.model.AFlux;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.tools.GalaxiesFinder;
import com.galaxy.project.tools.StatisticsHelper;
public class DivisionRowForSpectralLineTest{
	
	
	private static GalaxiesFinder galaxyFinder;
	private static DivisionRowForSpectralLineController controller;
	

	
	public DivisionRowForSpectralLineTest() {
		
	}
	
	@BeforeClass
	public static void initDataSet() {
		galaxyFinder = new GalaxiesFinder();
		controller = new DivisionRowForSpectralLineController();

	}
	// REQUISITO FUNZIONALE 9
	@Test
	public void divisionRowTest(){
		
		String Galassia = "IRAS15176+5216";
		Galaxy gmodel = galaxyFinder.ricercaGalassiaPerNome(Galassia);
		List<AFlux> fluxes = gmodel.getFluxes();
		assertTrue(fluxes.size()==9);
	}
	
	// REQUISITO FUNZIONALE 10
	@Test
	public void divisionRowForSpectralLineApertureTest(){
		
		String gruppoSpettrale = "HII";
		String aperture = "c";
		List<AFlux> fluxList = controller.getFluxFromSpectralClassificationAndAperture(gruppoSpettrale,aperture);
		AFlux fl1 = fluxList.get(0);
		AFlux fl2 = fluxList.get(1);
		double[] data = {fl1.getFluxValue(),fl2.getFluxValue()};
		StatisticsHelper sh = new StatisticsHelper(data);
		assertTrue(sh.getMean()==2155.4900512695312);
		assertTrue(sh.getStdDev()==1116.3200073242188);
	}

}
