package com.galaxy.project.controller;

import com.galaxy.project.frames.GalaxySearchFrame;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.tools.GalaxiesFinder;

public class GalaxySearchFrameController {

	GalaxySearchFrame galaxySearchFrame = null;							// Inizializzo JFrame
	GalaxiesFinder galaxyFinder = new GalaxiesFinder();
	
	public GalaxySearchFrameController(GalaxySearchFrame parent){
		this.galaxySearchFrame = parent; 								// Gli passo il GalaxySearchFrame
		}

	public Galaxy doRicercaGalassiaPerNome(String galaxyName){
		Galaxy g  = galaxyFinder.ricercaGalassiaPerNome(galaxyName);
		return g;
	}
	

	public String floatToString(Float num){
		String s = Float.toString(num);
		return s;
	}

	public String intToString(int num) {
		String s = Integer.toString(num);
		return s;
	}

	

	
	

	
}

