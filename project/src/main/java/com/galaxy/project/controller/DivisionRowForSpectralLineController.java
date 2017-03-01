package com.galaxy.project.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.galaxy.project.frames.DivisionRowForSpectralLineApertureFrame;
import com.galaxy.project.frames.DivisionRowForSpectralLineFrame;
import com.galaxy.project.model.AFlux;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.SpectralClassification;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.persistence.GalaxyDAO;

public class DivisionRowForSpectralLineController {

	DivisionRowForSpectralLineFrame valuesDivisionRowForSpectralLineFrame = null;
	DivisionRowForSpectralLineApertureFrame valuesDivisionRowForSpectralLineApertureFrame = null;

	public DivisionRowForSpectralLineController(DivisionRowForSpectralLineFrame parent){
		this.valuesDivisionRowForSpectralLineFrame = parent; 	
	}
	
	public DivisionRowForSpectralLineController(DivisionRowForSpectralLineApertureFrame parent){
		this.valuesDivisionRowForSpectralLineApertureFrame = parent; 	
	}

	public List<String> getSpectralClassificationFromGalaxy(){
		GalaxyDAO gdao = new GalaxyDAO();
		Session session = gdao.getSessionFactory().openSession();
		Query q = session.createQuery("select distinct spectralClassification.name from Galaxy");
		List<String> scList = q.list();
		session.close();
		return scList;
		

	}

	public List<AFlux> getFluxFromSpectralClassification(String sc){
		GalaxyDAO gdao = new GalaxyDAO();
		Session session = gdao.getSessionFactory().openSession();
		Query q = session.createQuery("from AFlux f where f.galaxy.spectralClassification.name like :sc");
		q.setParameter("sc", sc);
		List<AFlux> scList = q.list();
		session.close();
		return scList;
		

	}
	
	public List<AFlux> getFluxFromSpectralClassificationAndAperture(String sc, String aperture){
		GalaxyDAO gdao = new GalaxyDAO();
		Session session = gdao.getSessionFactory().openSession();
		Query q = session.createQuery("from AFlux f where f.galaxy.spectralClassification.name like :sc and f.fluxAperture like :c");
		q.setParameter("sc", sc);
		q.setParameter("c", aperture);
		List<AFlux> scList = q.list();
		session.close();
		return scList;
		

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
