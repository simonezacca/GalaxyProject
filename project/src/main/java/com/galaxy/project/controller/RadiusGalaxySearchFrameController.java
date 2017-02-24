package com.galaxy.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.galaxy.project.frames.GalaxySearchFrame;
import com.galaxy.project.frames.RadiusGalaxySearchFrame;
import com.galaxy.project.frames.RedshiftGalaxySearchFrame;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.tools.GalaxiesFinder;

public class RadiusGalaxySearchFrameController {

	RadiusGalaxySearchFrame radiusGalaxySearchFrame = null;
	GalaxiesFinder galaxyFinder = new GalaxiesFinder();
	
	public RadiusGalaxySearchFrameController(RadiusGalaxySearchFrame parent){
		this.radiusGalaxySearchFrame = parent; 							//gli passo il GalaxySearchFrame
		}

	public List<Galaxy> doRicercaGalassieDentroRaggio(Position p, float radius) {
		
		List<Galaxy> galaxies = galaxyFinder.ricercaGalassieDentroRaggio(p, radius);
		//TODO galaxies.sort(c); //implementare un COMPARATOR
		return galaxies;
		
	}
}
