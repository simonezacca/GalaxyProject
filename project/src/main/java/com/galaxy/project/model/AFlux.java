package com.galaxy.project.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.galaxy.project.persistence.IPersistente;

@Entity
@Table(name="flux")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")

public abstract class AFlux implements IPersistente{
	
	@Override
	public String toString() {
		return "AFlux [limitFlag=" + limitFlag + ", fluxValue=" + fluxValue + ", fluxError=" + fluxError
				+ ", fluxAperture=" + fluxAperture + ", spectralLine=" + spectralLine + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id = null;
	
	@Column(name="limit_flag")
	protected boolean limitFlag;
	
	@Column(name="flux_value", nullable=true)
	protected float fluxValue;
	
	@Column(name="flux_error", nullable=true)
	protected float fluxError;
	
	@Column(name="flux_aperture", length=5, nullable=false)
	protected String fluxAperture;
	
	@ManyToOne(fetch = FetchType.LAZY)
	protected Galaxy galaxy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	protected SpectralLine spectralLine;
	
	public AFlux(boolean limitFlag, float fluxValue, float fluxError,
			String fluxAperture, SpectralLine spectralLine) {
		super();
		this.limitFlag = limitFlag;
		this.fluxValue = fluxValue;
		this.fluxError = fluxError;
		this.fluxAperture = fluxAperture;
		spectralLine.addFlux(this);
	}
	
	public AFlux() {
		
	}

	public boolean isLimitFlag() {
		return limitFlag;
	}

	public void setLimitFlag(boolean limitFlag) {
		this.limitFlag = limitFlag;
	}

	public float getFluxValue() {
		return fluxValue;
	}

	public void setFluxValue(float fluxValue) {
		this.fluxValue = fluxValue;
	}

	public float getFluxError() {
		return fluxError;
	}

	public void setFluxError(float fluxError) {
		this.fluxError = fluxError;
	}

	public String getFluxAperture() {
		return fluxAperture;
	}

	public void setFluxAperture(String fluxAperture) {
		this.fluxAperture = fluxAperture;
	}

	public SpectralLine getSpectralLine() {
		return spectralLine;
	}

	public void setSpectralLine(SpectralLine spectralLine) {
		this.spectralLine = spectralLine;
	}
	
	public void setGalaxy(Galaxy galaxy) {
		this.galaxy = galaxy;
	}

	public Galaxy getGalaxy() {
		return galaxy;
	}

	public Long getId() {
		return id;
	}
	
	public boolean isNotZeroValue() {
		// torna true solo se il valore del flusso è diverso da zero
		return fluxValue != 0;
	}
	
	
}
