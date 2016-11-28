package com.galaxy.project.parser.csvfile;

import com.galaxy.project.parser.csvfileparser.ACSVFileParser;
import com.galaxy.project.parser.csvfileparser.RowFluxSpitzerCSVFileParser;
import com.galaxy.project.parser.csvline.ACSVLine;
import com.galaxy.project.parser.csvline.RowFluxSpitzerCSVLine;

public class RowFluxSpitzerCSVFile extends ACSVFile {

	public RowFluxSpitzerCSVFile(String fileName) {
		super(fileName);
	}

	@Override
	public ACSVFileParser getParser() {
		return new RowFluxSpitzerCSVFileParser(this);
	}

	@Override
	protected ACSVLine createCSVLine(String csvline) {
		return new RowFluxSpitzerCSVLine(csvline);
	}

}
