package com.galaxy.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.galaxy.project.frames.RadiusGalaxySearchFrame;
import com.galaxy.project.frames.ValuesSpectralLineFrame;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.persistence.GalaxyDAO;
import com.galaxy.project.persistence.SpectralLineDAO;
import com.galaxy.project.tools.PositionHelper;

public class ValuesSpectralLineFrameController {
	
	ValuesSpectralLineFrame valuesSpectralLineFrame = null;
	GalaxyDAO gdao = null;
	SpectralLineDAO sdao = null;

	public ValuesSpectralLineFrameController(ValuesSpectralLineFrame parent){
		this.valuesSpectralLineFrame = parent;
		gdao = new GalaxyDAO();
		sdao = new SpectralLineDAO();
	}
	
	public List<Galaxy> getListaGalassie() {
		List<Galaxy> galaxies = gdao.getAll();
		return galaxies;
		
	}
	
	public List<SpectralLine> getRigheSpettrali() {
		List<SpectralLine> spectralLines = sdao.getAll();
		return spectralLines;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
