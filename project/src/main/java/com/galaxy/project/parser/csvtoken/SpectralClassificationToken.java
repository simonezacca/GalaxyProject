package com.galaxy.project.parser.csvtoken;

public class SpectralClassificationToken extends ACSVToken {

	protected String rawSpectralClassification;

	public SpectralClassificationToken(String spectralClassification) {
		super();
		this.rawSpectralClassification = spectralClassification;
	}

	public String getSpectralClassificationRawName() {
		return rawSpectralClassification;
	}
	
	

}
