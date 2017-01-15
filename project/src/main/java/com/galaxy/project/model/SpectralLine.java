package com.galaxy.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.galaxy.project.persistence.IPersistente;

@Entity
@Table(name="spectral_line")
@NamedQueries({
	   @NamedQuery(
	        name = "getSpectralLineBySatellite", 
	        query="FROM SpectralLine sl WHERE sl.satelliteType = :satelliteType order by sl.order")
	})
public class SpectralLine implements Serializable, IPersistente {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_SATELLITETYPE = "getSpectralLineBySatellite";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id = null;
	
	@Column(name="atom", length=255, nullable=false)
	protected String atom;
	
	@Column(name="atomic_number", nullable=false)
	protected int atomicNumber;
	
	@Column(name="line_lenght", nullable=false)
	protected float lineLength;
	
	@OneToMany(mappedBy="spectralLine", cascade=CascadeType.ALL)
	protected List<AFlux> fluxes;
	
	@Column(name="satellite_type", nullable=false)
	private Integer satelliteType;
	
	public static final Integer HERSCHEL = 0;
	public static final Integer SPITZER = 1; 
	
	protected int order = 0;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "spectralline_galaxy", joinColumns = {
			@JoinColumn(name = "spectral_line_id", nullable = false, updatable = true) },
			inverseJoinColumns = { @JoinColumn(name = "galaxy_id",
					nullable = false, updatable = true) })
	
	protected List<Galaxy> galaxies;
	
	
	@Override
	public String toString() {
		return "[" + atom + atomicNumber + "]" + lineLength;
	}

	public SpectralLine(String atom, int atomicNumber, float lineLength, int satType) {
		super();
		this.atom = atom;
		this.atomicNumber = atomicNumber;
		this.lineLength = lineLength;
		this.fluxes = new ArrayList<AFlux>();
		this.galaxies = new ArrayList<Galaxy>();
		this.satelliteType = satType;
	}
	
	public String getAtom() {
		return atom;
	}

	public void setAtom(String atom) {
		this.atom = atom;
	}

	public int getAtomicNumber() {
		return atomicNumber;
	}

	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}

	public float getLineLength() {
		return lineLength;
	}

	public void setLineLength(float lineLength) {
		this.lineLength = lineLength;
	}

	public List<Galaxy> getGalaxies() {
		return galaxies;
	}

	public void addGalaxy(Galaxy aGalaxy){
		if(aGalaxy!=null && !this.galaxies.contains(aGalaxy)){
			this.galaxies.add(aGalaxy);
			aGalaxy.addSpectralLine(this);
		}
	}
	
	public Galaxy removeGalaxy(Galaxy aGalaxy){
		if(aGalaxy!=null){
			this.galaxies.remove(aGalaxy);
			aGalaxy.removeSpectralLine(this);
		}
		return aGalaxy;
	}
	
	public void addFlux(AFlux aFlux){
		if(aFlux!=null && !this.fluxes.contains(aFlux)){
			this.fluxes.add(aFlux);
			aFlux.setSpectralLine(this);
		}
	}
	
	public AFlux removeFlux(AFlux aFlux){
		if(aFlux!=null){
			this.fluxes.remove(aFlux);
		}
		return aFlux;
	}

	public Long getId() {
		return this.id;
	}
	
	public List<AFlux> getFluxes() {
		return fluxes;
	}
}
