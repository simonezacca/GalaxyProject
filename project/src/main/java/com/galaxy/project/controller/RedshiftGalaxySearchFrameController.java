package com.galaxy.project.controller;

import java.util.List;

import com.galaxy.project.frames.RedshiftGalaxySearchFrame;
import com.galaxy.project.frames.tablemodel.GalaxyRedshiftPair;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.tools.GalaxiesFinder;

public class RedshiftGalaxySearchFrameController {

	RedshiftGalaxySearchFrame redshiftGalaxySearchFrame = null;
	GalaxiesFinder galaxyFinder = new GalaxiesFinder();
	
	public RedshiftGalaxySearchFrameController(RedshiftGalaxySearchFrame parent){
		this.redshiftGalaxySearchFrame = parent; 
		}

	public List<GalaxyRedshiftPair> doRicercaGalassiePerRedshiftMaggiore(Float redshift) {
		List<GalaxyRedshiftPair> galaxies = galaxyFinder.ricercaGalassiePerRedshiftMaggiore(redshift);
		return galaxies;	
	}
	
	public List<GalaxyRedshiftPair> doRicercaGalassiePerRedshiftMinore(Float redshift) {
		List<GalaxyRedshiftPair> galaxies = galaxyFinder.ricercaGalassiePerRedshiftMinore(redshift);
		//TODO galaxies.sort(c); //implementare un COMPARATOR
		return galaxies;	
	}
}
