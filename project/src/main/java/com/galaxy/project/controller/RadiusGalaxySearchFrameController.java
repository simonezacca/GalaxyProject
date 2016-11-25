package com.galaxy.project.controller;

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

	public void doRicercaGalassieDentroRaggio(Position p) {
		galaxyFinder.ricercaGalassieDentroRaggio(p);
		
	}
}
