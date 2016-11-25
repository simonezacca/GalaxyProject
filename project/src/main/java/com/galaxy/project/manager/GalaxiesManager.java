package com.galaxy.project.manager;

import java.util.List;

import com.galaxy.project.model.Galaxy;
import com.galaxy.project.persistence.GalaxyDAO;

public class GalaxiesManager {

	private static GalaxyDAO gdao = new GalaxyDAO();
	private static GalaxiesManager instance = null;
	private List<Galaxy> elencoGalassie;
	
	protected GalaxiesManager(){
		this.elencoGalassie = gdao.getAll();
	}
	
	public static GalaxiesManager getInstance() {
		if (instance==null) {
			instance = new GalaxiesManager();
		}
		return instance;
	}
}