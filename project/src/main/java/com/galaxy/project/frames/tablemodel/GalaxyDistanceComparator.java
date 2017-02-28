package com.galaxy.project.frames.tablemodel;

import java.util.Comparator;

public class GalaxyDistanceComparator implements Comparator<GalaxyDistancePair> {

	public GalaxyDistanceComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(GalaxyDistancePair arg0, GalaxyDistancePair arg1) {
		// Ritorna -1 quando arg0<arg1
		// Ritorna 0 quando arg0=arg1
		// Ritorna 1 quando arg0>arg1
		float d0, d1 = 0;
		if(arg0!=null && arg1!=null){
			d0 = arg0.getDistance();
			d1 = arg1.getDistance();
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
