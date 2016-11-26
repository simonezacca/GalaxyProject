package com.galaxy.project.parser.csvline;

import com.galaxy.project.parser.csvtoken.GalaxyToken;
import com.galaxy.project.parser.csvtoken.PositionToken;
import com.galaxy.project.parser.csvtoken.SpectralClassificationToken;

public class GalaxyCSVLine extends ACSVLine {

	protected GalaxyToken galaxyToken;
	protected PositionToken positionToken;
	protected SpectralClassificationToken spectralClassificationToken;
	public GalaxyCSVLine(String csvline) {
		super(csvline);
	}

	@Override
	protected void populateTokens() {
		String gName = trimToken(rawTokens[0]);
		String redshift = trimToken(rawTokens[8]);
		String distance = trimToken(rawTokens[9]);
		String limitLnev1 = trimToken(rawTokens[16]);
		String Lnev1 = trimToken(rawTokens[17]);
		String limitLnev2 = trimToken(rawTokens[18]);
		String Lnev2 = trimToken(rawTokens[19]);
		String limitLoiv = trimToken(rawTokens[20]);
		String Loiv = trimToken(rawTokens[21]);
		String metDer = trimToken(rawTokens[22]);
		String errMet = trimToken(rawTokens[23]);
		String altGName = trimToken(rawTokens[25]);
		galaxyToken = new GalaxyToken(gName, redshift, distance, limitLnev1, Lnev1, limitLnev2, Lnev2, limitLoiv, Loiv, metDer, errMet, altGName);
		
	}

}
