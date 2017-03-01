package com.galaxy.project.tools;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.galaxy.project.frames.tablemodel.GalaxyDistanceComparator;
import com.galaxy.project.frames.tablemodel.GalaxyDistancePair;
import com.galaxy.project.frames.tablemodel.GalaxyRedshiftComparator;
import com.galaxy.project.frames.tablemodel.GalaxyRedshiftPair;
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
	
	public List<GalaxyDistancePair> ricercaGalassieDentroRaggio(Position p, float radius) {
		List<GalaxyDistancePair> resultSetGalaxies = new ArrayList<GalaxyDistancePair>();
		List<Galaxy> galaxies = gdao.getAll();
		for (Galaxy g : galaxies) {
			float distance = PositionHelper.computeDistance(p, g.getPos()); 
			if(distance <= radius){
				GalaxyDistancePair gdp = new GalaxyDistancePair(g, distance);
				resultSetGalaxies.add(gdp);
			}
		}	
		Collections.sort(resultSetGalaxies, new GalaxyDistanceComparator());

		return resultSetGalaxies;
	}
	
	public List<GalaxyRedshiftPair> ricercaGalassiePerRedshiftMaggiore(Float redshift) {
		List<GalaxyRedshiftPair> resultSetGalaxies = new ArrayList<GalaxyRedshiftPair>();
		List<Galaxy> galaxies = gdao.getAll();
		for (Galaxy g : galaxies) {
			float redshiftGalaxy = g.getRedshift(); 
			if(redshiftGalaxy >= redshift){
				GalaxyRedshiftPair grp = new GalaxyRedshiftPair(g, redshiftGalaxy);
				resultSetGalaxies.add(grp);
			}
		}
		Collections.sort(resultSetGalaxies, new GalaxyRedshiftComparator());
		return resultSetGalaxies;	
	}
	
	public List<GalaxyRedshiftPair> ricercaGalassiePerRedshiftMinore(Float redshift) {
		List<GalaxyRedshiftPair> resultSetGalaxies2 = new ArrayList<GalaxyRedshiftPair>();
		List<Galaxy> galaxies2 = gdao.getAll();
		for (Galaxy g : galaxies2) {
			float redshiftGalaxy = g.getRedshift(); 
			if(redshiftGalaxy <= redshift){
				GalaxyRedshiftPair grp = new GalaxyRedshiftPair(g, redshiftGalaxy);
				resultSetGalaxies2.add(grp);
			}
		}
		Collections.sort(resultSetGalaxies2, new GalaxyRedshiftComparator());
		return resultSetGalaxies2;	
	}

	public static void main(String[] args) {
		Position p = new Position(4, 33, (float)11.094, '+', 5, 21, (float)15.7104);
		float radius = 1F;
		float radiustwo = 0.1F;
		float radiusthree = 0.01F;
		float redshift = 0.1F;
		GalaxiesFinder gFinder = new GalaxiesFinder();
		List<GalaxyDistancePair> provaGalassie = gFinder.ricercaGalassieDentroRaggio(p,radius);
		List<GalaxyDistancePair> provaGalassietwo = gFinder.ricercaGalassieDentroRaggio(p,radiustwo);
		List<GalaxyDistancePair> provaGalassiethree = gFinder.ricercaGalassieDentroRaggio(p, radiusthree);
		
		System.out.println("ProvaGalassia con 1" + " - " + provaGalassie.size());
//		for (Galaxy g : provaGalassie) {
//			System.out.println(g);
//		}
//		
		System.out.println("ProvaGalassia con 0.1" + " - " + provaGalassietwo.size());
//		for (Galaxy g : provaGalassietwo) {
//			System.out.println(g);
//		}
		System.out.println("ProvaGalassia con 0.01" + " - " + provaGalassiethree.size());
//		for (Galaxy g : provaGalassiethree) {
//			System.out.println(g);
//		}
	}
}
