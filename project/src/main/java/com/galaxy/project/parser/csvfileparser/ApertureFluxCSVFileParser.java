package com.galaxy.project.parser.csvfileparser;

import java.util.List;

import com.galaxy.project.model.RowFlux;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.parser.csvfile.ACSVFile;
import com.galaxy.project.parser.csvline.ACSVLine;
import com.galaxy.project.parser.csvline.ApertureFluxCSVLine;
import com.galaxy.project.parser.csvtoken.GenericFluxToken;

public class ApertureFluxCSVFileParser extends ACSVFileParser<RowFlux> {

	public ApertureFluxCSVFileParser(ACSVFile fileToParse) {
		super(fileToParse);
		// TODO capire come implementare multimap per file Aperture
	};

	@Override
	public void parse() {
		List<ACSVLine> lines = this.fileToParse.getCSVLines(); 
		for(ACSVLine aLine: lines){
			ApertureFluxCSVLine apertureLine = (ApertureFluxCSVLine) aLine;
			List<GenericFluxToken> listApertureFluxToken = apertureLine.getApertureFluxTokens();
			
			for(GenericFluxToken rowFluxToken: listApertureFluxToken){
				
				RowFlux rowFluxModel = createRowFluxFromToken(rowFluxToken);
				String keyMap = rowFluxToken.getGalaxyName();	
				this.modelsMap.put(keyMap, rowFluxModel);
			}
		}
			
	}

	private RowFlux createRowFluxFromToken(GenericFluxToken rowFluxToken) {
		
		boolean limitFlag = fromTokenToBoolean(rowFluxToken.getLimit());
		float fluxValue = Float.valueOf(rowFluxToken.getValue());
		float fluxError = Float.valueOf(rowFluxToken.getError());;
		String fluxAperture = rowFluxToken.getAperture();
		SpectralLine spectralLine = null;
		RowFlux rowFluxModel = new RowFlux(limitFlag, fluxValue, fluxError, fluxAperture, spectralLine);
		return rowFluxModel;
		
	}

	@Override
	public void convert() {
		// TODO Auto-generated method stub
		
	}

}
