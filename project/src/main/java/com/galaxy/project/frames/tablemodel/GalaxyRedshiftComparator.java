package com.galaxy.project.frames.tablemodel;

import java.util.Comparator;

public class GalaxyRedshiftComparator implements Comparator<GalaxyRedshiftPair> {

	public GalaxyRedshiftComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(GalaxyRedshiftPair arg0, GalaxyRedshiftPair arg1) {
		// Ritorna -1 quando arg0<arg1
		// Ritorna 0 quando arg0=arg1
		// Ritorna 1 quando arg0>arg1
		float d0, d1 = 0;
		if(arg0!=null && arg1!=null){
			d0 = arg0.getRedshift();
			d1 = arg1.getRedshift();
			if(d0<d1){
				return -1;
			}
			if(d0==d1){
				return 0;
			}
			if(d0>d1){
				return 1;
			}
		}
		return 0;
	}

}
