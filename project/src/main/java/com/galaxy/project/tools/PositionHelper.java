package com.galaxy.project.tools;

import com.galaxy.project.model.Position;

public class PositionHelper {

	public static float computeDistance(Position p1, Position p2){
		float ra1 = fromPositionToRAD(p1);
		float dec1 = fromPositionToDec(p1);
		float ra2 = fromPositionToRAD(p2);
		float dec2 = fromPositionToDec(p2);
		
		return (float) computeDistance(ra1, dec1, ra2, dec2);
	}
	
	private static double computeDistance(float ra1, float dec1, float ra2,
			float dec2) {
		double result = (Math.sin((double)ra1)*Math.sin((double)ra2) + (Math.cos((double)ra1)*Math.cos((double)ra2) * Math.cos((double)dec1 - dec2)));
		result = Math.acos(result);
		return result;
	}

	public static float fromPositionToRAD(Position p){
		//RA(degrees) = 15 *(HH + MM/60 + SS/3600)
		float rad = 15 * (p.getRah() + (p.getRam()/60) + (p.getRas()/3600));
		return rad;	
	}
	
	public static float fromPositionToDec(Position p){
		//Dec(decimal degrees) = + or - (DD + MM/60 + SS/3600)
		float dec = p.getDad() + ((float)p.getDam()/60) + (p.getDas()/3600);
		if(p.getDasign()=='-'){
			return dec = -dec;
		}
	return dec;
	}
	
	
	
}