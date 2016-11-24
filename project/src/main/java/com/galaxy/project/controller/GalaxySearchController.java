package com.galaxy.project.controller;

import com.galaxy.project.frames.GalaxySearchFrame;
import com.galaxy.project.frames.RadiusGalaxySearchFrame;
import com.galaxy.project.frames.RedshiftGalaxySearchFrame;
import com.galaxy.project.model.Position;
import com.galaxy.project.tools.GalaxiesFinder;

public class GalaxySearchController {

	GalaxySearchFrame galaxySearchFrame = null;							//inizializzo JFrame
	RadiusGalaxySearchFrame radiusGalaxySearchFrame = null;
	GalaxiesFinder galaxyFinder = new GalaxiesFinder();
	
	public GalaxySearchController(GalaxySearchFrame parent){
		this.galaxySearchFrame = parent; 							//gli passo il GalaxySearchFrame
		}

	public GalaxySearchController(RadiusGalaxySearchFrame parent){
		this.radiusGalaxySearchFrame = parent; 							//gli passo il GalaxySearchFrame
		}
	
	public GalaxySearchController(RedshiftGalaxySearchFrame parent) {
		// TODO Auto-generated constructor stub
	}

	public void doRicercaGalassiaPerNome(String galaxyName){
		galaxyFinder.ricercaGalassiaPerNome(galaxyName);
	}
	
	public void doRicercaGalassieDentroRaggio(Position p) {
		galaxyFinder.ricercaGalassieDentroRaggio(p);
		
	}
	
	public void doRicercaGalassiePerRedshiftMaggiore(Long redshift) {
		galaxyFinder.ricercaGalassiePerRedshiftMaggiore(redshift);
		
	}
	
	public void doRicercaGalassiePerRedshiftMinore(Long redshift) {
		galaxyFinder.ricercaGalassiePerRedshiftMinore(redshift);
		
	}
}