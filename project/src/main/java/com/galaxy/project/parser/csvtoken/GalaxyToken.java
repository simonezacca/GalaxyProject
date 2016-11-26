package com.galaxy.project.parser.csvtoken;

public class GalaxyToken extends ACSVToken {

	protected String rawName;
	protected String rawAltName;
	protected String rawRedshift;
	protected String rawDistance;
	protected String rawLimitLnev1;
	protected String rawLimitLnev2;
	protected String rawLimitLoiv;
	protected String rawLnev1;
	protected String rawLnev2;
	protected String rawLoiv;
	protected String rawMetDer;
	protected String rawErrMet;
	public GalaxyToken(String rawName, String rawRedshift,
			String rawDistance, String rawLimitLnev1, String rawLnev1,
			String rawLimitLnev2, String rawLnev2, String rawLimitLoiv,
			String rawLoiv, String rawMetDer, String rawErrMet, String rawAltName) {
		super();
		this.rawName = rawName;
		this.rawRedshift = rawRedshift;
		this.rawDistance = rawDistance;
		this.rawLimitLnev1 = rawLimitLnev1;
		this.rawLnev1 = rawLnev1;
		this.rawLimitLnev2 = rawLimitLnev2;
		this.rawLnev2 = rawLnev2;
		this.rawLimitLoiv = rawLimitLoiv;
		this.rawLoiv = rawLoiv;
		this.rawMetDer = rawErrMet;
		this.rawErrMet = rawErrMet;
		this.rawAltName = rawAltName;
	}
	public String getRawName() {
		return rawName;
	}
	public String getRawAltName() {
		return rawAltName;
	}
	public String getRawRedshift() {
		return rawRedshift;
	}
	public String getRawDistance() {
		return rawDistance;
	}
	public String getRawLimitLnev1() {
		return rawLimitLnev1;
	}
	public String getRawLimitLnev2() {
		return rawLimitLnev2;
	}
	public String getRawLimitLoiv() {
		return rawLimitLoiv;
	}
	public String getRawLnev1() {
		return rawLnev1;
	}
	public String getRawLnev2() {
		return rawLnev2;
	}
	public String getRawLoiv() {
		return rawLoiv;
	}
	
	
}
