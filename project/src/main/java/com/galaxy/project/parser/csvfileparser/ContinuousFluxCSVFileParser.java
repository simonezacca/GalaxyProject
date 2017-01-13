package com.galaxy.project.parser.csvfileparser;

import java.util.List;

import com.galaxy.project.model.ContinuousFlux;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.parser.csvfile.ACSVFile;
import com.galaxy.project.parser.csvline.ACSVLine;
import com.galaxy.project.parser.csvline.ContinuousFluxCSVLine;
import com.galaxy.project.parser.csvtoken.GenericFluxToken;

public class ContinuousFluxCSVFileParser extends ACSVFileParser<ContinuousFlux> {

	public ContinuousFluxCSVFileParser(ACSVFile fileToParse) {
		super(fileToParse);
	}

	@Override
	public void parse() {
		List<ACSVLine> lines = this.fileToParse.getCSVLines(); 
		for(ACSVLine aLine: lines){																			// Scansiono linea per linea il CSV
			ContinuousFluxCSVLine continuousFluxLine = (ContinuousFluxCSVLine) aLine;						// Scansiono la singola riga che mi restituisce una lista di oggetti continuousFluxToken
			List<GenericFluxToken> continuousFluxToken = continuousFluxLine.getListContinuousFluxToken();	// Assegno la lista precedentemente scansionata dalla singola riga al continuousFluxToken di questo scope 
			
			for(GenericFluxToken cft: continuousFluxToken){													// Scorro la lista dei Token inerenti ad una linea del CSV
				
				ContinuousFlux rowFluxModel = createContinuousFluxFromToken(cft);									// Mi creo il rowFluxModel, per ogni token.
				String keyMap = cft.getGalaxyName();														// Prendo come chiave di riferimento il nome della Galassia	
				this.modelsMap.put(keyMap, rowFluxModel);								
			}
		}
	}

	private ContinuousFlux createContinuousFluxFromToken(GenericFluxToken rowFluxToken) {
		
		boolean limitFlag = fromTokenToBoolean(rowFluxToken.getLimit());
		float fluxValue = Float.valueOf(rowFluxToken.getValue());
		float fluxError = Float.valueOf(rowFluxToken.getError());;
		String fluxAperture = rowFluxToken.getAperture();
		SpectralLine spectralLine = null;
		ContinuousFlux continuousFluxModel = new ContinuousFlux(limitFlag, fluxValue, fluxError, fluxAperture, spectralLine);
		return continuousFluxModel;
		
	}
	@Override
	public void convert() {
		// TODO Auto-generated method stub
		
	}

}
