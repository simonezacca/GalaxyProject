package com.galaxy.project.frames.tablemodel;

import com.galaxy.project.model.Galaxy;

public class GalaxyDistancePair {

	private Galaxy g = null;
	private float distance = 0;
	
	public GalaxyDistancePair(Galaxy g, float distance) {
		this.g = g;
		this.distance = distance;
	}

	public Galaxy getGalaxy() {
		return g;
	}

	public float getDistance() {
		return distance;
	}

}
