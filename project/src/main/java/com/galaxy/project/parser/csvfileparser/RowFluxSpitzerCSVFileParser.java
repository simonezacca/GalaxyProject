package com.galaxy.project.parser.csvfileparser;

import java.util.List;

import com.galaxy.project.model.RowFlux;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.parser.csvfile.ACSVFile;
import com.galaxy.project.parser.csvline.ACSVLine;
import com.galaxy.project.parser.csvline.RowFluxSpitzerCSVLine;
import com.galaxy.project.parser.csvtoken.GenericFluxToken;

public class RowFluxSpitzerCSVFileParser extends ACSVFileParser<RowFlux> {

	public RowFluxSpitzerCSVFileParser(ACSVFile fileToParse) {
		super(fileToParse);
	}

	@Override
	public void parse() {
		List<ACSVLine> lines = this.fileToParse.getCSVLines(); 
		for(ACSVLine aLine: lines){																			
			RowFluxSpitzerCSVLine RowFluxSpitzerFluxLine = (RowFluxSpitzerCSVLine) aLine;						
			List<GenericFluxToken> rowFluxSpitzerToken = RowFluxSpitzerFluxLine.getListRowFluxSpitzerToken();	 
			
			for(GenericFluxToken rfst: rowFluxSpitzerToken){													
				
				RowFlux rowFluxSpitzerModel = createRowFluxFromToken(rfst);									
				String keyMap = rfst.getGalaxyName();															
				this.modelsMap.put(keyMap, rowFluxSpitzerModel);								
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
