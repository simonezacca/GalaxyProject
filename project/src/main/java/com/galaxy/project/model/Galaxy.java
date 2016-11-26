package com.galaxy.project.model;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Table;

import com.galaxy.project.persistence.IPersistente;


@Entity
@Table(name="galaxy")
@NamedQueries({
	   @NamedQuery(
	        name = "cercaGalassiaPerNome", 
	        query="FROM Galaxy g WHERE g.name LIKE :name")
	})

public class Galaxy implements IPersistente {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@Column(length=255, nullable=false)
	protected String name;
	
	@Column()
	protected Long redshift;
	
	@Column(name="distance", nullable=true)
	protected Long distance;
	
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
	
	@ManyToOne()
	protected SpectralClassification spectralClassification;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "galaxies")
	protected List<SpectralLine> spectralLines;
	
	public Galaxy(String name, Long redshift, Long distance,
			String altName, boolean limitLnev1,
			boolean limitLnev2, boolean limitLoiv, float lnev1,
			float lnev2, float loiv, float derMet, float errMet) {
		super();
		
		this.name = name;
		this.redshift = redshift;
		this.distance = distance;
		this.altName = altName;
		this.limitLnev1 = limitLnev1;
		this.limitLnev2 = limitLnev2;
		this.limitLoiv = limitLoiv;
		this.lnev1 = lnev1;
		this.lnev2 = lnev2;
		this.loiv = loiv;
		this.derMet = derMet;
		this.errMet = errMet;
		this.spectralLines = new ArrayList<SpectralLine>();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getRedshift() {
		return redshift;
	}
	public void setRedshift(Long redshift) {
		this.redshift = redshift;
	}
	public Long getDistance() {
		return distance;
	}
	public void setDistance(Long distance) {
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
	
	public void addSpectralLine(SpectralLine aSpectralLine){
		if(aSpectralLine!=null && !this.spectralLines.contains(aSpectralLine)){
			this.spectralLines.add(aSpectralLine);
		}
	}

	public void removeSpectralLine(SpectralLine aSpectralLine){
		if(aSpectralLine!=null){
			this.spectralLines.remove(aSpectralLine);
		}
	}
	
	public void setSpectralClassification(SpectralClassification spectralClassification) {
		this.spectralClassification = spectralClassification;
		spectralClassification.addGalaxy(this);
	} 
	 

	
}
