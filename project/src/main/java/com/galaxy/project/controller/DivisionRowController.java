package com.galaxy.project.controller;

import java.util.List;

import com.galaxy.project.frames.DivisionRowFrame;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.persistence.GalaxyDAO;

public class DivisionRowController {

	DivisionRowFrame valuesRowDivisionFrame = null;
	GalaxyDAO gdao = null;

	public DivisionRowController(DivisionRowFrame parent){
		this.valuesRowDivisionFrame = parent; 	
		gdao = new GalaxyDAO();
	}
	
	public List<Galaxy> getListaGalassie() {
		List<Galaxy> galaxies = gdao.getAll();
		return galaxies;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
