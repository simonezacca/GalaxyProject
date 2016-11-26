package com.galaxy.project.parser;

import com.galaxy.project.parser.csvfileparser.ApertureFluxCSVFileParser;
import com.galaxy.project.parser.csvfileparser.ContinueFluxCSVFileParser;
import com.galaxy.project.parser.csvfileparser.FluxSpectralLineCSVFileParser;
import com.galaxy.project.parser.csvfileparser.GalaxyCSVFileParser;
import com.galaxy.project.parser.csvfileparser.IRSFluxCSVFileParser;

public class MainCSVParser {
	protected GalaxyCSVFileParser galaxyFileParser;
	protected FluxSpectralLineCSVFileParser fluxFileParser;
	protected ContinueFluxCSVFileParser continueFluxFileParser;
	protected IRSFluxCSVFileParser irsFluxFileParser;
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

