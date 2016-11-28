package com.galaxy.project.parser.csvline;

import java.util.ArrayList;
import java.util.List;

import com.galaxy.project.parser.csvtoken.GenericFluxToken;

public class ApertureFluxCSVLine extends ACSVLine {
	
	protected List<GenericFluxToken> listApertureFluxToken;
	
	public ApertureFluxCSVLine(String csvline) {
		super(csvline, 23);
		this.listApertureFluxToken= new ArrayList<GenericFluxToken>();
	}

	@Override
	protected void populateTokens() {
		String galaxyName = trimToken(rawTokens[0]);
		String apertureFlux = trimToken(rawTokens[22]);
		for(int i=1;i<=21;){
			String limitFlux = trimToken(rawTokens[i]);
			String valueFlux = trimToken(rawTokens[i+1]);
			String errorFlux = trimToken(rawTokens[i+2]);
			i = i+3;
			GenericFluxToken rowFluxToken = new GenericFluxToken(galaxyName, limitFlux, valueFlux, errorFlux, apertureFlux);
			listApertureFluxToken.add(rowFluxToken);
		}
	}
	
	public List<GenericFluxToken> getApertureFluxTokens(){
		return listApertureFluxToken;
	}
}
