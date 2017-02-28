package com.galaxy.project.controller;

import java.util.List;

import com.galaxy.project.frames.RadiusGalaxySearchFrame;
import com.galaxy.project.frames.tablemodel.GalaxyDistancePair;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.tools.GalaxiesFinder;

public class RadiusGalaxySearchFrameController {

	RadiusGalaxySearchFrame radiusGalaxySearchFrame = null;
	GalaxiesFinder galaxyFinder = new GalaxiesFinder();
	
	public RadiusGalaxySearchFrameController(RadiusGalaxySearchFrame parent){
		this.radiusGalaxySearchFrame = parent; 							//gli passo il GalaxySearchFrame
		}

	public List<GalaxyDistancePair> doRicercaGalassieDentroRaggio(Position p, float radius) {
		
		List<GalaxyDistancePair> galaxies = galaxyFinder.ricercaGalassieDentroRaggio(p, radius);
		return galaxies;
		
	}
}
