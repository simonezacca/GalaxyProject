package com.galaxy.project.tools;


import java.util.ArrayList;
import java.util.List;

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
		gdao = new GalaxyDAO();
	}
	
	public Galaxy ricercaGalassiaPerNome(String galaxyNameString) {		
		Session session = gdao.getSessionFactory().openSession();
		Query q = session.createQuery("from Galaxy g where g.name like :name");
		q.setParameter("name", galaxyNameString);
		Galaxy risultato = (Galaxy) q.uniqueResult();
		session.close();
		return risultato;
				
	}
	
	public List<Galaxy> ricercaGalassieDentroRaggio(Position p, float radius) {
		List<Galaxy> resultSetGalaxies = new ArrayList<Galaxy>();
		List<Galaxy> galaxies = gdao.getAll();
		for (Galaxy g : galaxies) {
			if(PositionHelper.computeDistance(p, g.getPos()) <= radius)
				resultSetGalaxies.add(g);
		}
		return resultSetGalaxies;
		
	}
	
	public void ricercaGalassiePerRedshiftMaggiore(Long redshift) {
		// TODO Auto-generated constructor stub		
		
	}
	
	public void ricercaGalassiePerRedshiftMinore(Long redshift) {
		// TODO Auto-generated constructor stub		
		
	}
	
	public static void main(String[] args) {
		Position p = new Position(4, 33, (float)11.094, '+', 5, 21, (float)15.7104);
		float radius = 1F;
		float radiustwo = 0.1F;
		float radiusthree = 0.01F;
		GalaxiesFinder gFinder = new GalaxiesFinder();
		List<Galaxy> provaGalassie = gFinder.ricercaGalassieDentroRaggio(p,radius);
		List<Galaxy> provaGalassietwo = gFinder.ricercaGalassieDentroRaggio(p,radiustwo);
		List<Galaxy> provaGalassiethree = gFinder.ricercaGalassieDentroRaggio(p,radiusthree);
		
		System.out.println(provaGalassie.size());
		for (Galaxy g : provaGalassie) {
			System.out.println(g);
		}
		
		System.out.println(provaGalassietwo.size());
		for (Galaxy g : provaGalassietwo) {
			System.out.println(g);
		}
		System.out.println(provaGalassiethree.size());
		for (Galaxy g : provaGalassiethree) {
			System.out.println(g);
		}
	}
}
