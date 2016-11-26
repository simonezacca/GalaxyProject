package com.galaxy.project.parser.csvtoken;

public class SpectralClassificationToken extends ACSVToken {

	protected String spectralClassification;

	public SpectralClassificationToken(String spectralClassification) {
		super();
		this.spectralClassification = spectralClassification;
	}

	public String getSpectralClassification() {
		return spectralClassification;
	}
	
	

}
