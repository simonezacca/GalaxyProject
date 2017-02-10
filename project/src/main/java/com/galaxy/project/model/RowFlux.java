package com.galaxy.project.model;

import javax.persistence.Entity;

@Entity
public class RowFlux extends AFlux {

	public RowFlux(boolean limitFlag, float fluxValue, float fluxError,
			String fluxAperture, SpectralLine spectralLine) {
		super(limitFlag, fluxValue, fluxError, fluxAperture, spectralLine);
		// TODO Auto-generated constructor stub
	}
	
	protected RowFlux(){
		
	}
}
