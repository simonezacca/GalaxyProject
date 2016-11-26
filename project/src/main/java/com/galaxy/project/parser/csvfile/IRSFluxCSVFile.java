package com.galaxy.project.parser.csvfile;

import com.galaxy.project.parser.csvfileparser.ACSVFileParser;
import com.galaxy.project.parser.csvfileparser.IRSFluxCSVFileParser;
import com.galaxy.project.parser.csvline.ACSVLine;
import com.galaxy.project.parser.csvline.IRSFluxCSVLine;

public class IRSFluxCSVFile extends ACSVFile {

	public IRSFluxCSVFile(String fileName) {
		super(fileName);
	}

	@Override
	public ACSVFileParser getParser() {
		return new IRSFluxCSVFileParser(this);
	}

	@Override
	protected ACSVLine createCSVLine(String csvline) {
		return new IRSFluxCSVLine(csvline);
	}

}
