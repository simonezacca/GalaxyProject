package com.galaxy.project.parser.csvline;

import com.galaxy.project.parser.csvtoken.ACSVToken;

public abstract class ACSVLine {

	protected String CSVSplitBy = ";";
	protected int validContSplit = 0;
	String[] rawTokens;
	
	public ACSVToken nextToken(){
		return null;
	}
	
	public boolean isValidLine(){
		return validContSplit == rawTokens.length;	
	}
	
	
	public ACSVLine(String csvRawLine, int validContSplit) {
		this.validContSplit = validContSplit;
		String line = new String(csvRawLine);
		rawTokens = csvRawLine.split(CSVSplitBy);
		if(isValidLine()){
			populateTokens();
		}
	}
	
	protected abstract void populateTokens();
	protected String trimToken(String rawString){
		return rawString.trim();
	}
}
