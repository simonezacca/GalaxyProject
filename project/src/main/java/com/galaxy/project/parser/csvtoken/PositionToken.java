package com.galaxy.project.parser.csvtoken;

public class PositionToken extends ACSVToken{

	protected String rawRAh;
	protected String rawRAm;
	protected String rawRAs;
	protected String rawdasign;
	protected String rawDAd;
	protected String rawDAm;
	protected String rawDAs;
	
	public PositionToken(String rawRAh, String rawRAm, String rawRAs,
			String rawDAsign, String rawDAd, String rawDAm, String rawDAs) {
		super();
		this.rawRAh = rawRAh;
		this.rawRAm = rawRAm;
		this.rawRAs = rawRAs;
		this.rawdasign = rawDAsign;
		this.rawDAd = rawDAd;
		this.rawDAm = rawDAm;
		this.rawDAs = rawDAs;
	}

	public String getRawRAh() {
		return rawRAh;
	}

	public String getRawRAm() {
		return rawRAm;
	}

	public String getRawRAs() {
		return rawRAs;
	}

	public String getRawdasign() {
		return rawdasign;
	}

	public String getRawDAd() {
		return rawDAd;
	}

	public String getRawDAm() {
		return rawDAm;
	}

	public String getRawDAs() {
		return rawDAs;
	}

	
}
