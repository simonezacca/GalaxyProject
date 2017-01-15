package com.galaxy.project.manager;

import java.util.List;

import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.persistence.SpectralLineDAO;

public class SpectralLineManager {

	private static SpectralLineDAO sldao = new SpectralLineDAO();
	private static SpectralLineManager instance = null;
	private List<SpectralLine> elencoHerschelSpectralLines;
	private List<SpectralLine> elencoSpitzerSpectralLines;
	
	protected SpectralLineManager(){
		this.elencoHerschelSpectralLines = sldao.getSpectralLinesBySatelliteType(SpectralLine.HERSCHEL);
		this.elencoSpitzerSpectralLines = sldao.getSpectralLinesBySatelliteType(SpectralLine.SPITZER);
	}
	
	public static SpectralLineManager getInstance() {
		if (instance==null) {
			instance = new SpectralLineManager();
		}
		return instance;
	}
	
	public List<SpectralLine> getSpectralLines(int type) {
		if (type == SpectralLine.HERSCHEL) {
			return elencoHerschelSpectralLines;
		} else 
			return elencoSpitzerSpectralLines;
	}
}