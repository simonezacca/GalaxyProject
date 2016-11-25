package com.galaxy.project.controller;

import com.galaxy.project.frames.GalaxySearchFrame;
import com.galaxy.project.frames.RadiusGalaxySearchFrame;
import com.galaxy.project.frames.RedshiftGalaxySearchFrame;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.tools.GalaxiesFinder;

public class RedshiftGalaxySearchFrameController {

	RedshiftGalaxySearchFrame redshiftGalaxySearchFrame = null;
	GalaxiesFinder galaxyFinder = new GalaxiesFinder();
	
	public RedshiftGalaxySearchFrameController(RedshiftGalaxySearchFrame parent){
		this.redshiftGalaxySearchFrame = parent; 							//gli passo il GalaxySearchFrame
		}

	public void doRicercaGalassiePerRedshiftMaggiore(Long redshift) {
		galaxyFinder.ricercaGalassiePerRedshiftMaggiore(redshift);
		
	}
	
	public void doRicercaGalassiePerRedshiftMinore(Long redshift) {
		galaxyFinder.ricercaGalassiePerRedshiftMinore(redshift);
		
	}
}
