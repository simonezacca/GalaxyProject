package com.galaxy.project.parser.csvfile;

import com.galaxy.project.parser.csvfileparser.ACSVFileParser;
import com.galaxy.project.parser.csvfileparser.ApertureFluxCSVFileParser;
import com.galaxy.project.parser.csvline.ACSVLine;
import com.galaxy.project.parser.csvline.ApertureFluxCSVLine;

public class ApertureFluxCSVFile extends ACSVFile {

	public ApertureFluxCSVFile(String fileName) {
		super(fileName);
	}

	@Override
	public ACSVFileParser getParser() {
		return new ApertureFluxCSVFileParser(this);
	}

	@Override
	protected ACSVLine createCSVLine(String csvline) {
		return new ApertureFluxCSVLine(csvline);
	}

}
