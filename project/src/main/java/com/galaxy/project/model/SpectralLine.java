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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atom == null) ? 0 : atom.hashCode());
		result = prime * result + atomicNumber;
		result = prime * result + Float.floatToIntBits(lineLength);
		result = prime * result + order;
		result = prime * result
				+ ((satelliteType == null) ? 0 : satelliteType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpectralLine other = (SpectralLine) obj;
		if (atom == null) {
			if (other.atom != null)
				return false;
		} else if (!atom.equals(other.atom))
			return false;
		if (atomicNumber != other.atomicNumber)
			return false;
		if (Float.floatToIntBits(lineLength) != Float
				.floatToIntBits(other.lineLength))
			return false;
		if (order != other.order)
			return false;
		if (satelliteType == null) {
			if (other.satelliteType != null)
				return false;
		} else if (!satelliteType.equals(other.satelliteType))
			return false;
		return true;
	}
	
//	public List<AFlux> getFluxes() {
//		return fluxes;
//	}
}
