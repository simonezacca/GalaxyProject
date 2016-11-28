package com.galaxy.project.parser.csvline;

import java.util.List;

import com.galaxy.project.parser.csvtoken.GenericFluxToken;

public class ContinuousFluxCSVLine extends ACSVLine {
	
	protected List<GenericFluxToken> listContinuousFluxToken;


	public ContinuousFluxCSVLine(String csvline) {
		super(csvline, 22);
	}

	@Override
	protected void populateTokens() {
		String galaxyName = trimToken(rawTokens[0]);
		String apertureFlux = trimToken(rawTokens[21]);
		for(int i=1;i<5;){
			String limitFlux = "";
			String valueFlux = trimToken(rawTokens[i]);
			String errorFlux = trimToken(rawTokens[i+1]);
			GenericFluxToken continueFluxToken = new GenericFluxToken(galaxyName, limitFlux, valueFlux, errorFlux, apertureFlux);
			listContinuousFluxToken.add(continueFluxToken);		
			i=i+2;
		}
		for(int i=5;i<20;){
			String limitFlux = trimToken(rawTokens[i]);
			String valueFlux = trimToken(rawTokens[i+1]);
			String errorFlux = trimToken(rawTokens[i+2]);
			i = i+3;
			GenericFluxToken continuousFluxToken = new GenericFluxToken(galaxyName, limitFlux, valueFlux, errorFlux, apertureFlux);
			listContinuousFluxToken.add(continuousFluxToken);		
		}
	}

	public List<GenericFluxToken> getListContinuousFluxToken() {
		return listContinuousFluxToken;
	}
	
}
