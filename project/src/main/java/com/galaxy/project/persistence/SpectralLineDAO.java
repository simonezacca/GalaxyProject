package com.galaxy.project.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.galaxy.project.model.SpectralLine;

public class SpectralLineDAO extends AGenericDAO<SpectralLine> {
	
	public SpectralLineDAO() {
		super(SpectralLine.class);
	}

	public List<SpectralLine> getSpectralLinesBySatelliteType(int satelliteType){
		List<SpectralLine> slList = new ArrayList<SpectralLine>();
		Session session = getSessionFactory().openSession();
		//Query q = session.createQuery(SpectralLine.FIND_BY_SATELLITETYPE);
		Query q = session.createQuery("FROM SpectralLine sl WHERE sl.satelliteType = :satelliteType order by sl.order asc");
		q.setParameter("satelliteType", satelliteType);
		slList = q.list();
		session.close();
		return slList;
	}

}
