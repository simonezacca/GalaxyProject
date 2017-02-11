package com.galaxy.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.galaxy.project.persistence.IPersistente;

@Entity
@Table(name="spectral_line")
@NamedQueries({
	   @NamedQuery(
	        name = "getSpectralLineBySatellite", 
	        query="FROM SpectralLine sl WHERE sl.satelliteType = :satelliteType order by sl.order asc")
	   
	})
public class SpectralLine implements Serializable, IPersistente {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_SATELLITETYPE = "getSpectralLineBySatellite";

	protected SpectralLine() {

	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id = null;
	
	@Column(name="atom", length=255, nullable=false)
	protected String atom;
	
	@Column(name="atomic_number", nullable=false)
	protected int atomicNumber;
	
	@Column(name="line_length", nullable=false)
	protected float lineLength;
	
//	//@OneToMany(fetch=FetchType.EAGER)
//	@Transient
//	protected List<AFlux> fluxes;
	
	@Column(name="satellite_type", nullable=false)
	private Integer satelliteType;
	
	public static final Integer HERSCHEL = 0;
	public static final Integer SPITZER = 1; 
	
	@Column(name="spectral_line_order", nullable=false)
	protected int order;
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "spectralline_galaxy", joinColumns = {
//			@JoinColumn(name = "spectral_line_id", nullable = false, updatable = true) },
//			inverseJoinColumns = { @JoinColumn(name = "galaxy_id",
//					nullable = false, updatable = true) })
//	
//	protected List<Galaxy> galaxies;	
	
	@Override
	public String toString() {
		return "[" + atom + atomicNumber + "]" + lineLength;
	}

	public SpectralLine(String atom, int atomicNumber, float lineLength, int satType) {
		super();
		this.atom = atom;
		this.atomicNumber = atomicNumber;
		this.lineLength = lineLength;
//		this.fluxes = new ArrayList<AFlux>();
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
	
//	public void addFlux(AFlux aFlux){
//		if(aFlux!=null && !this.fluxes.contains(aFlux)){
//			this.fluxes.add(aFlux);
//			aFlux.setSpectralLine(this);
//		}
//	}
//	
//	public AFlux removeFlux(AFlux aFlux){
//		if(aFlux!=null){
//			this.fluxes.remove(aFlux);
//		}
//		return aFlux;
//	}

	public Long getId() {
		return this.id;
	}
	
//	public List<AFlux> getFluxes() {
//		return fluxes;
//	}
}
