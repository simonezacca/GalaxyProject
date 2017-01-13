package com.galaxy.project.parser.csvline;

import java.util.List;

import com.galaxy.project.parser.csvtoken.GenericFluxToken;

public class RowFluxSpitzerCSVLine extends ACSVLine {

	protected List<GenericFluxToken> listRowFluxSpitzerToken;

	public RowFluxSpitzerCSVLine(String csvline) {
		super(csvline, 29);
	}

	@Override
	protected void populateTokens() {
		String galaxyName = trimToken(rawTokens[0]);
		String apertureFlux = trimToken(rawTokens[28]);
		for(int i=1;i<=25;){
			String limitFlux = trimToken(rawTokens[i]);
			String valueFlux = trimToken(rawTokens[i+1]);
			String errorFlux = trimToken(rawTokens[i+2]);
			i = i+3;
			GenericFluxToken rowFluxSpitzerToken = new GenericFluxToken(galaxyName, 
																		limitFlux, 
																		valueFlux, 
																		errorFlux, 
																		apertureFlux);
			listRowFluxSpitzerToken.add(rowFluxSpitzerToken);
		}
	}
	
	@Override
	public boolean isValidLine(){
		return (validContSplit <= rawTokens.length);	
	}
	
	public List<GenericFluxToken> getListRowFluxSpitzerToken() {
		return listRowFluxSpitzerToken;
	}

}
