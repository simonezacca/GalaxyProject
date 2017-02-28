package com.galaxy.project.frames.tablemodel;

import com.galaxy.project.model.Galaxy;

public class GalaxyRedshiftPair {

	private Galaxy g = null;
	private float redshift = 0;
	
	public GalaxyRedshiftPair(Galaxy g, float redshift) {
		this.g = g;
		this.redshift = redshift;
	}

	public Galaxy getGalaxy() {
		return g;
	}

	public float getRedshift() {
		return redshift;
	}

}
