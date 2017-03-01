package com.galaxy.project.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.galaxy.project.frames.DivisionRowContinuousFluxFrame;
import com.galaxy.project.model.ContinuousFlux;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.RowFlux;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.persistence.GalaxyDAO;

public class DivisionRowContinuousFluxController {

	DivisionRowContinuousFluxFrame divisionRowContinuousFluxFrame = null;
	GalaxyDAO gdao = null;

	public DivisionRowContinuousFluxController(DivisionRowContinuousFluxFrame parent){
		this.divisionRowContinuousFluxFrame = parent;
		gdao = new GalaxyDAO();
	}
	
	
	public List<Galaxy> getListaGalassie() {
		List<Galaxy> galaxies = gdao.getAll();
		return galaxies;
		
	}
	
	public List<SpectralLine> getSpectralLineFromGalaxy(Galaxy g){
		GalaxyDAO gdao = new GalaxyDAO();
		Session session = gdao.getSessionFactory().openSession();
		Query q = session.createQuery("select distinct spectralLine from AFlux f where f.galaxy = :g");
		q.setParameter("g", g);
		List<SpectralLine> slList = q.list();
		session.close();
		return slList;
	}
	
	public List<RowFlux> getRowFluxFromSpectralLine(Galaxy selectedGalaxy, SpectralLine selectedSpectralLine){

		GalaxyDAO gdao = new GalaxyDAO();
		Session session = gdao.getSessionFactory().openSession();
		Query q = session.createQuery("from RowFlux f where f.galaxy = :g and f.spectralLine = :sl");
									
		q.setParameter("g", selectedGalaxy);
		q.setParameter("sl", selectedSpectralLine);
		List<RowFlux> fList = q.list();
		session.close();
		return fList;
	}
	
	public List<ContinuousFlux> getContinuousFluxFromSpectralLine(Galaxy selectedGalaxy, SpectralLine selectedSpectralLine){
		
		GalaxyDAO gdao = new GalaxyDAO();
		Session session = gdao.getSessionFactory().openSession();
		Query q = session.createQuery("from ContinuousFlux  f where f.galaxy = :g and f.spectralLine = :sl");
		
		q.setParameter("g", selectedGalaxy);
		q.setParameter("sl", selectedSpectralLine);
		List<ContinuousFlux> fcList = q.list();
		session.close();
		return fcList;
		
	}
	
	public float getValueFromDivision(RowFlux rf, ContinuousFlux cf){
		return rf.getFluxValue() / cf.getFluxValue();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
