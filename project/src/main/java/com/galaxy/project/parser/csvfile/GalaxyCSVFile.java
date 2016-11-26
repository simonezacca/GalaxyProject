package com.galaxy.project.parser.csvfile;

import com.galaxy.project.parser.csvfileparser.ACSVFileParser;
import com.galaxy.project.parser.csvfileparser.GalaxyCSVFileParser;
import com.galaxy.project.parser.csvline.ACSVLine;
import com.galaxy.project.parser.csvline.GalaxyCSVLine;

public class GalaxyCSVFile extends ACSVFile {

	public GalaxyCSVFile(String fileName) {
		super(fileName);
	}

	@Override
	public ACSVFileParser getParser() {
		return new GalaxyCSVFileParser(this);
	}

	@Override
	protected ACSVLine createCSVLine(String csvline) {
		return new GalaxyCSVLine(csvline);
	}

}
