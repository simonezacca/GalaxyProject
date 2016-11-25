package com.galaxy.project.tools;


import org.hibernate.Query;
import org.hibernate.Session;

import com.galaxy.project.manager.GalaxiesManager;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.persistence.GalaxyDAO;

public class GalaxiesFinder {
	
	private GalaxiesManager manager = GalaxiesManager.getInstance();
	GalaxyDAO gdao = null;
	
	public GalaxiesFinder() {
		// TODO Auto-generated constructor stub
	}
	
	public Galaxy ricercaGalassiaPerNome(String galaxyNameString) {		
		Session session = gdao.getSessionFactory().openSession();
		Query q = session.createQuery("from Galaxy g where g.name like :name");
		q.setParameter("name", galaxyNameString);
		Galaxy risultato = (Galaxy) q.uniqueResult();
		session.close();
		return risultato;
				
	}
	
	public void ricercaGalassieDentroRaggio(Position p) {
		// TODO Auto-generated constructor stub
		
	}
	
	public void ricercaGalassiePerRedshiftMaggiore(Long redshift) {
		// TODO Auto-generated constructor stub		
		
	}
	
	public void ricercaGalassiePerRedshiftMinore(Long redshift) {
		// TODO Auto-generated constructor stub		
		
	}
	
}
