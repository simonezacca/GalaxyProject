package com.galaxy.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.galaxy.project.persistence.IPersistente;

@Embeddable
public class SpectralClassification implements IPersistente {
	
	@Override
	public String toString() {
		return "SpectralClassification [name=" + name + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="spectralname", length=10, nullable=false)
	protected String name;
	
	//@OneToMany(mappedBy="spectralClassification")
	@Transient
	protected List<Galaxy> galaxies;

	protected SpectralClassification() {
		
	}
	
	public SpectralClassification(String name) {
		super();
		this.name = name;
		this.galaxies = new ArrayList<Galaxy>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addGalaxy(Galaxy aGalaxy){
		if(aGalaxy!=null && !this.galaxies.contains(aGalaxy)){
			this.galaxies.add(aGalaxy);
		}
	}
	
	public Galaxy removeGalaxy(Galaxy aGalaxy){
		if(aGalaxy!=null){
			this.galaxies.remove(aGalaxy);
		}
		return aGalaxy;
	}
	
	public Galaxy getGalaxyByName(String name){
		for(Galaxy aGalaxy: this.galaxies){				// for aGalaxy in this.galaxies
			if(aGalaxy.getName().equals(name)){
				return aGalaxy;
			}
		}
		throw new NoSuchElementException("Nome galassia non trovato per questa classificazione spettrale");
	}

}
