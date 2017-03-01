package com.galaxy.project;

import org.junit.BeforeClass;
import org.junit.Test;

import com.galaxy.project.authentication.AuthSystem;
import com.galaxy.project.controller.RedshiftGalaxySearchFrameController;
import com.galaxy.project.frames.tablemodel.GalaxyDistancePair;
import com.galaxy.project.frames.tablemodel.GalaxyRedshiftPair;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.model.Utente;
import com.galaxy.project.tools.GalaxiesFinder;

//import static
import static org.junit.Assert.*;

import java.util.List;
public class GalaxySearchTest{
	
	
	private static GalaxiesFinder galaxyFinder;
	private static RedshiftGalaxySearchFrameController controller;

	
	public GalaxySearchTest() {
		
	}
	
	@BeforeClass
	public static void initDataSet() {
		galaxyFinder = new GalaxiesFinder();
		controller = new RedshiftGalaxySearchFrameController(null);
	}
	// REQUISITO FUNZIONALE 5
	@Test
	public void galaxySearchTest(){
		
		String Galassia = "Mrk334";
		Galaxy gmodel = galaxyFinder.ricercaGalassiaPerNome(Galassia);
		assertTrue(gmodel!=null);
	}
	// REQUISITO FUNZIONALE 6
		@Test
		public void galaxySearchTest2(){
			
			Position p = new Position(4, 33, (float)11.094, '+', 5, 21, (float)15.7104);
			float radius = 1F;
			float radiustwo = 0.1F;
			float radiusthree = 0.01F;
			float redshift = 0.1F;
			GalaxiesFinder gFinder = new GalaxiesFinder();
			List<GalaxyDistancePair> provaGalassie = gFinder.ricercaGalassieDentroRaggio(p,radius);
			List<GalaxyDistancePair> provaGalassietwo = gFinder.ricercaGalassieDentroRaggio(p,radiustwo);
			List<GalaxyDistancePair> provaGalassiethree = gFinder.ricercaGalassieDentroRaggio(p, radiusthree);
			assertTrue(provaGalassie.size()==51);
			assertTrue(provaGalassietwo.size()==2);
			assertTrue(provaGalassiethree.size()==1);
		}

		// REQUISITO FUNZIONALE 7
		@Test
		public void galaxySearchTest3(){
			float gRedshift = 0.4F;
			List<GalaxyRedshiftPair> galaxyDistance = controller.doRicercaGalassiePerRedshiftMaggiore(gRedshift);
			assertTrue(galaxyDistance.size()==1);
		}	

		@Test
		public void galaxySearchTest4(){
			float lRedshift = 0.0001F;
			List<GalaxyRedshiftPair> galaxyDistance = controller.doRicercaGalassiePerRedshiftMinore(lRedshift);
			assertTrue(galaxyDistance.size()==5);
			}	
}
