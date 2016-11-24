package com.galaxy.project.persistence;

import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Utente;

public class GalaxyDAO extends AGenericDAO<Galaxy> {

	public GalaxyDAO() {
		super(Galaxy.class);
	}
}
