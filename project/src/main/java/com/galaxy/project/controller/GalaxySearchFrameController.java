package com.galaxy.project.controller;

import com.galaxy.project.frames.GalaxySearchFrame;
import com.galaxy.project.frames.RadiusGalaxySearchFrame;
import com.galaxy.project.frames.RedshiftGalaxySearchFrame;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.tools.GalaxiesFinder;

public class GalaxySearchFrameController {

	GalaxySearchFrame galaxySearchFrame = null;							// Inizializzo JFrame
	GalaxiesFinder galaxyFinder = new GalaxiesFinder();
	
	public GalaxySearchFrameController(GalaxySearchFrame parent){
		this.galaxySearchFrame = parent; 								// Gli passo il GalaxySearchFrame
		}

	public void doRicercaGalassiaPerNome(String galaxyName){
		Galaxy g  = galaxyFinder.ricercaGalassiaPerNome(galaxyName);
	}
	
}
