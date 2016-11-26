package com.galaxy.project.parser.csvfile;

import com.galaxy.project.parser.csvfileparser.ACSVFileParser;
import com.galaxy.project.parser.csvfileparser.FluxSpectralLineCSVFileParser;
import com.galaxy.project.parser.csvline.ACSVLine;
import com.galaxy.project.parser.csvline.FluxSpectralCSVLine;

public class FluxSpectralLineCSVFile extends ACSVFile {

	public FluxSpectralLineCSVFile(String fileName) {
		super(fileName);
	}

	@Override
	public ACSVFileParser getParser() {
		return new FluxSpectralLineCSVFileParser(this);
	}

	@Override
	protected ACSVLine createCSVLine(String csvline) {
		return new FluxSpectralCSVLine(csvline);
	}

}
