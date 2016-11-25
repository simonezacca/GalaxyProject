package com.galaxy.project.parser.csvline;

public abstract class ACSVLine {

	protected int ignoreFieldsIndexes[];
	
	public ACSVToken nextToken(){
		return null;
	}
	
	public boolean isValidLine(){
		return true;	
	}
	
	
	public ACSVLine() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void parse();

}
