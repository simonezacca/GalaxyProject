package com.galaxy.project.parser.csvfileparser;

import java.util.List;

import com.galaxy.project.model.RowFlux;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.parser.csvfile.ACSVFile;
import com.galaxy.project.parser.csvline.ACSVLine;
import com.galaxy.project.parser.csvline.RowFluxCSVLine;
import com.galaxy.project.parser.csvtoken.GenericFluxToken;

public class RowFluxLineCSVFileParser extends ACSVFileParser<RowFlux> {

	public RowFluxLineCSVFileParser(ACSVFile fileToParse) {
		super(fileToParse);
	}

	
	@Override
	public void parse() {
		List<ACSVLine> lines = this.fileToParse.getCSVLines(); 
		for(ACSVLine aLine: lines){														// Scansiono linea per linea il CSV
			RowFluxCSVLine rowFluxLine = (RowFluxCSVLine) aLine;						// Scansiono la singola riga che mi restituisce una lista di oggetti rowFluxToken
			List<GenericFluxToken> rowFluxToken = rowFluxLine.getListRowFluxToken();	// Assegno la lista precedentemente scansionata dalla singola riga al rowFluxToken di questo scope 
			
			for(GenericFluxToken rft: rowFluxToken){									// Scorro la lista dei Token inerenti ad una linea del CSV
				
				RowFlux rowFluxModel = createRowFluxFromToken(rft);						// Mi creo il rowFluxModel, per ogni token.
				String keyMap = rft.getGalaxyName();									// Prendo come chiave di riferimento il nome della Galassia	
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
