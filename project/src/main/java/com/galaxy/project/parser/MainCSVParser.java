package com.galaxy.project.parser;

import com.galaxy.project.parser.csvfileparser.ApertureFluxCSVFileParser;
import com.galaxy.project.parser.csvfileparser.ContinuousFluxCSVFileParser;
import com.galaxy.project.parser.csvfileparser.RowFluxLineCSVFileParser;
import com.galaxy.project.parser.csvfileparser.GalaxyCSVFileParser;
import com.galaxy.project.parser.csvfileparser.RowFluxSpitzerCSVFileParser;

public class MainCSVParser {
	protected GalaxyCSVFileParser galaxyFileParser;
	protected RowFluxLineCSVFileParser fluxFileParser;
	protected ContinuousFluxCSVFileParser continueFluxFileParser;
	protected RowFluxSpitzerCSVFileParser irsFluxFileParser;
	protected ApertureFluxCSVFileParser apertureFluxFileParser;
	
	public MainCSVParser(){
			
	}
	
	public void parseAll(){
		galaxyFileParser.parse();
		fluxFileParser.parse();
		continueFluxFileParser.parse();
		irsFluxFileParser.parse();
		apertureFluxFileParser.parse();
	}
}

