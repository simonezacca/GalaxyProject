package com.galaxy.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.galaxy.project.persistence.IPersistente;


@Entity
@Table(name="galaxy")
@NamedQueries({
	   @NamedQuery(
	        name = "cercaGalassiaPerNome", 
	        query="FROM Galaxy g WHERE g.name LIKE :name")
	})

public class Galaxy implements IPersistente {
	
	@Override
	public String toString() {
		return "Galaxy [name=" + name + ", redshift=" + redshift + ", distance=" + distance
				+ ", altName=" + altName + ", limitLnev1=" + limitLnev1 + ", limitLnev2=" + limitLnev2 + ", limitLoiv="
				+ limitLoiv + ", lnev1=" + lnev1 + ", lnev2=" + lnev2 + ", loiv=" + loiv + ", derMet=" + derMet
				+ ", errMet=" + errMet + ", pos=" + pos + ", spectralClassification=" + spectralClassification + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="name", length=255, nullable=false, unique=true)
	protected String name;
	
	@Column()
	protected Float redshift;
	
	@Column(name="distance", nullable=true)
	protected Float distance;
	
	@Column(name="alt_name",length=255, nullable=true)
	protected String altName;
	
	@Column() // 
	protected boolean limitLnev1, limitLnev2, limitLoiv; // TODO nel file quelli che hanno limite sono segnati da "<"
	
	@Column(nullable=true)
	
	protected float lnev1, lnev2, loiv;
	
	@Column(nullable=true)
	protected float derMet;
	
	@Column(nullable=true)
	protected float errMet;
	
	@Embedded
	protected Position pos;
	
	@Embedded
	protected SpectralClassification spectralClassification;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "galaxy", cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@OrderBy("id ASC")
	protected List<AFlux> fluxes;
	
	public Galaxy(String name, Float redshift2, Float distance2,
			String altName, boolean limitLnev1,
			boolean limitLnev2, boolean limitLoiv, float lnev1,
			float lnev2, float loiv, float derMet, float errMet) {
		super();
		
		this.name = name;
		this.redshift = redshift2;
		this.distance = distance2;
		this.altName = altName;
		this.limitLnev1 = limitLnev1;
		this.limitLnev2 = limitLnev2;
		this.limitLoiv = limitLoiv;
		this.lnev1 = lnev1;
		this.lnev2 = lnev2;
		this.loiv = loiv;
		this.derMet = derMet;
		this.errMet = errMet;
		this.fluxes = new ArrayList<AFlux>();
	}
	
	public Galaxy() {
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getRedshift() {
		return redshift;
	}
	public void setRedshift(Float redshift) {
		this.redshift = redshift;
	}
	public Float getDistance() {
		return distance;
	}
	public void setDistance(Float distance) {
		this.distance = distance;
	}
	public String getAltName() {
		return altName;
	}
	public void setAltName(String altName) {
		this.altName = altName;
	}
	public boolean isLimitLnev1() {
		return limitLnev1;
	}
	public void setLimitLnev1(boolean limitLnev1) {
		this.limitLnev1 = limitLnev1;
	}
	public boolean isLimitLnev2() {
		return limitLnev2;
	}
	public void setLimitLnev2(boolean limitLnev2) {
		this.limitLnev2 = limitLnev2;
	}
	public boolean isLimitLoiv() {
		return limitLoiv;
	}
	public void setLimitLoiv(boolean limitLoiv) {
		this.limitLoiv = limitLoiv;
	}
	public float getLnev1() {
		return lnev1;
	}
	public void setLnev1(float lnev1) {
		this.lnev1 = lnev1;
	}
	public float getLnev2() {
		return lnev2;
	}
	public void setLnev2(float lnev2) {
		this.lnev2 = lnev2;
	}
	public float getLoiv() {
		return loiv;
	}
	public void setLoiv(float loiv) {
		this.loiv = loiv;
	}
	public float getDerMet() {
		return derMet;
	}
	public void setDerMet(float derMet) {
		this.derMet = derMet;
	}
	public float getErrMet() {
		return errMet;
	}
	public void setErrMet(float errMet) {
		this.errMet = errMet;
	}
	public Position getPos() {
		return pos;
	}
	public void setPosition(Position pos) {
		this.pos = pos;
	}

	public List<AFlux> getFluxes() {
		return fluxes;
	}

	public void addFlux(AFlux aFlux){
		if(aFlux!=null && !this.fluxes.contains(aFlux)){
			this.fluxes.add(aFlux);
			aFlux.setGalaxy(this);
		}
	}

	public AFlux removeFlux(AFlux aFlux){
		if(aFlux!=null){
			this.fluxes.remove(aFlux);
		}
		return aFlux;
	}
	
	
	public void setSpectralClassification(SpectralClassification spectralClassification) {
		this.spectralClassification = spectralClassification;
		spectralClassification.addGalaxy(this);
	}
	

	 

	
}
