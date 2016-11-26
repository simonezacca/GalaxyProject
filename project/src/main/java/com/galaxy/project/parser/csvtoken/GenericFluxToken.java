package com.galaxy.project.parser.csvtoken;

public class GenericFluxToken extends ACSVToken {

	protected String galaxyName;
	protected String limit;
	protected String value;
	protected String error;
	protected String aperture;
	
	public GenericFluxToken(String galaxyName, String limit, String value, String error,
			String aperture) {
		super();
		this.galaxyName = galaxyName;
		this.limit = limit;
		this.value = value;
		this.error = error;
		this.aperture = aperture;
	}
	
	public String getGalaxyName() {
		return galaxyName;
	}

	public String getLimit() {
		return limit;
	}
	public String getValue() {
		return value;
	}
	public String getError() {
		return error;
	}
	public String getAperture() {
		return aperture;
	}
	


}
