package com.galaxy.project.parser.fileparser;

import com.galaxy.project.parser.csvfile.ACSVFile;

public abstract class ACSVFileParser {
	
	protected ACSVFile fileToParse;
	
	public abstract void parse();

	public ACSVFileParser(ACSVFile fileToParse) {
		this.fileToParse = fileToParse;
	}
	
}
