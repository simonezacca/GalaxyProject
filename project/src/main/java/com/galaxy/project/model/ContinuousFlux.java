package com.galaxy.project.model;

import javax.persistence.Entity;

@Entity
public class ContinuousFlux extends AFlux {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContinuousFlux(boolean limitFlag, float fluxValue, float fluxError,
			String fluxAperture, SpectralLine spectralLine) {
		super(limitFlag, fluxValue, fluxError, fluxAperture, spectralLine);
		// TODO Auto-generated constructor stub
	}

	protected ContinuousFlux(){
		
	}

}
