package com.galaxy.project.parser.csvtoken;

public class GenericFluxToken extends ACSVToken {

	protected String limit;
	protected String value;
	protected String error;
	protected String aperture;
	public GenericFluxToken(String limit, String value, String error,
			String aperture) {
		super();
		this.limit = limit;
		this.value = value;
		this.error = error;
		this.aperture = aperture;
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
