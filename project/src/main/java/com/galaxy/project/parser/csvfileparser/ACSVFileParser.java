package com.galaxy.project.parser.csvfileparser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.galaxy.project.model.RowFlux;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.parser.csvfile.ACSVFile;
import com.galaxy.project.parser.csvtoken.ACSVToken;
import com.galaxy.project.parser.csvtoken.GenericFluxToken;

public abstract class ACSVFileParser<E> {
	
	protected ACSVFile fileToParse;
	//protected Map<String, List<ACSVToken>> tokensMap;
	protected Map<String, E> modelsMap;

	
	public abstract void parse();				//Ogni implementazione accede alla lista dei Token contenuti 
												//in ACSVFile e li inserisce nella mappa dei Token (tokensMap).
	
	public abstract void convert();				// Scorre gli elementi della mappa dei token Token
												// Per ogni elemento dei Token istanzia un oggetto model
												// Inserisce l'oggetto nella mappa dei model, con la chiave che
												// che è il nome della galassia.

	public ACSVFileParser(ACSVFile fileToParse) {
		this.fileToParse = fileToParse;
		//this.tokensMap = new HashMap<String, List<ACSVToken>>();
		this.modelsMap = new HashMap<String, E>();
	}

	protected static boolean fromTokenToBoolean(String limit){
		if(limit.equals("<")){
			return true;
		}
		else{
			return false;
		}
		
	}
	

}
