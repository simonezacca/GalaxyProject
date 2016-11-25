package com.galaxy.project.parser.csvfile;

import java.io.InputStream;
import java.util.List;

import com.galaxy.project.parser.csvline.ACSVLine;
import com.galaxy.project.parser.fileparser.ACSVFileParser;

public abstract class ACSVFile {

	private InputStream is;
	private List<ACSVLine> csvLines;
	
	public ACSVFile() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract ACSVFileParser getParser();
}
