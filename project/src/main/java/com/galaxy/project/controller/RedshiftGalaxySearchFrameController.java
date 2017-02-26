package com.galaxy.project.controller;

import java.util.List;

import com.galaxy.project.frames.RedshiftGalaxySearchFrame;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.tools.GalaxiesFinder;

public class RedshiftGalaxySearchFrameController {

	RedshiftGalaxySearchFrame redshiftGalaxySearchFrame = null;
	GalaxiesFinder galaxyFinder = new GalaxiesFinder();
	
	public RedshiftGalaxySearchFrameController(RedshiftGalaxySearchFrame parent){
		this.redshiftGalaxySearchFrame = parent; 
		}

	public List<Galaxy> doRicercaGalassiePerRedshiftMaggiore(Float redshift) {
		List<Galaxy> galaxies = galaxyFinder.ricercaGalassiePerRedshiftMaggiore(redshift);
		//TODO galaxies.sort(c); //implementare un COMPARATOR
		return galaxies;	
	}
	
	public List<Galaxy> doRicercaGalassiePerRedshiftMinore(Float redshift) {
		List<Galaxy> galaxies = galaxyFinder.ricercaGalassiePerRedshiftMinore(redshift);
		//TODO galaxies.sort(c); //implementare un COMPARATOR
		return galaxies;	
	}
}
