package com.galaxy.project.parser.csvfile;

import com.galaxy.project.parser.csvfileparser.ACSVFileParser;
import com.galaxy.project.parser.csvfileparser.ContinueFluxCSVFileParser;
import com.galaxy.project.parser.csvline.ACSVLine;
import com.galaxy.project.parser.csvline.ContinueFluxCSVLine;

public class ContinueFluxCSVFile extends ACSVFile {

	public ContinueFluxCSVFile(String fileName) {
		super(fileName);
	}

	@Override
	public ACSVFileParser getParser() {
		return new ContinueFluxCSVFileParser(this);
	}

	@Override
	protected ACSVLine createCSVLine(String csvline) {
		return new ContinueFluxCSVLine(csvline);
	}

}
