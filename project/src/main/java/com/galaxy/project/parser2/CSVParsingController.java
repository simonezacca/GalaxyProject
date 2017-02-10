package com.galaxy.project.parser2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.galaxy.project.model.AFlux;
import com.galaxy.project.model.ContinuousFlux;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.RowFlux;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.parser2.csvparser.ApertureFluxCSVParser;
import com.galaxy.project.parser2.csvparser.ContinousRowFluxCSVParser;
import com.galaxy.project.parser2.csvparser.GalaxyCSVParser;
import com.galaxy.project.parser2.csvparser.RowFluxCSVParser;
import com.galaxy.project.parser2.csvparser.RowFluxSpitzerCSVParser;
import com.galaxy.project.persistence.FluxDAO;
import com.galaxy.project.persistence.GalaxyDAO;

public class CSVParsingController {

	private GalaxyCSVParser galaxyParser;
	private RowFluxCSVParser rowFluxParser;
	private RowFluxSpitzerCSVParser spitzerParser;
	private ContinousRowFluxCSVParser continousParser;
	private ApertureFluxCSVParser apertureParser;

	private Map<String, Galaxy> resultMap;

	public CSVParsingController() {
		this.resultMap = new HashMap<>();
	}

	public Map<String, Galaxy> parseAndLink() throws IllegalStateException, IOException {
		parse();
		link();
		return resultMap;
	}

	private void link() {
		// itero sulla mappa delle galassie
		Map<String, List<Galaxy>> galaxyMap = galaxyParser.getParsedMap();
		for (Map.Entry<String, List<Galaxy>> entry : galaxyMap.entrySet()) {
			Galaxy gModel = null;
			// uso come chiave di aggancio il nome della galassia
			String key = entry.getKey();
			Iterator<Galaxy> iter = entry.getValue().iterator();
			if (iter.hasNext()) {
				gModel = iter.next();
				linkGalaxyWithOtherMaps(key, gModel);
			}
			
			// inserisco il model galassia bene formato all'inter della mappa result usando sempre
			// il nome come chiave
			if(gModel!=null)
				resultMap.put(key,gModel);
		}

	}

	private void linkGalaxyWithOtherMaps(String galaxyKey, Galaxy galaxy) {
		// istanzio le mappe su cui effettuare le ricerche
		Map<String, List<RowFlux>> rowFluxMap = null;
		Map<String, List<RowFlux>> fluxSpitzerMap = null;
		Map<String, List<ContinuousFlux>> continousFluxMap = null;
		Map<String, List<RowFlux>> apertureFluxMap = null;
		
		// RowFlux
		if(rowFluxParser!=null) {
			rowFluxMap = rowFluxParser.getParsedMap();
			linkGalaxyWithRowFluxesByMultiMap(galaxy, rowFluxMap);
		}
		// RowFluxSpitzer
		if (spitzerParser!=null) {
			fluxSpitzerMap = spitzerParser.getParsedMap();
			linkGalaxyWithRowFluxesByMultiMap(galaxy, fluxSpitzerMap);
		}
		// ContinousRowFlux 
		if (continousParser!=null) {
			continousFluxMap = continousParser.getParsedMap();
			linkGalaxyWithContinuousFluxesByMultiMap(galaxy, continousFluxMap);
		}
		// Aperture
		if (apertureParser!=null) {
			apertureFluxMap = apertureParser.getParsedMap();
			linkGalaxyWithRowFluxesByMultiMap(galaxy, apertureFluxMap);
		}
		
	}

	private void linkGalaxyWithRowFluxesByMultiMap(Galaxy galaxy, Map<String, List<RowFlux>> rowFluxMap) {
		// verifico l'esistenza della chiave nella mappa
		String galaxyKey = galaxy.getName();//.toUpperCase();
		if (rowFluxMap.containsKey(galaxyKey)) {
			// la galassia esiste nella mappa
			List<RowFlux> fluxes = rowFluxMap.get(galaxyKey);
			for (RowFlux rowFlux : fluxes) {
				// collego la galassia al flusso
				galaxy.addFlux(rowFlux);
			}
		}

	}
	
	private void linkGalaxyWithContinuousFluxesByMultiMap(Galaxy galaxy, Map<String, List<ContinuousFlux>> continuousFluxMap) {
		// verifico l'esistenza della chiave nella mappa
		String galaxyKey = galaxy.getName();//.toUpperCase();
		if (continuousFluxMap.containsKey(galaxyKey)) {
			// la galassia esiste nella mappa
			List<ContinuousFlux> fluxes = continuousFluxMap.get(galaxyKey);
			for (ContinuousFlux continuousFlux : fluxes) {
				// collego la galassia al flusso
				galaxy.addFlux(continuousFlux);
			}
		}

	}

	private void parse() throws IllegalStateException, IOException {
		// avvio il parsing su tutti i file
		if (galaxyParser == null) {
			// controllo che il galaxy parser sia associato
			// è obbligatorio associare almeno il galaxy parser
			// gli altri parser sono opzionali
			throw new IllegalStateException("Galaxy parser non associato");
		}
		galaxyParser.parse();

		if (rowFluxParser != null) {
			// avvio il parsing del file flussi
			rowFluxParser.parse();
		}
		
		if (spitzerParser != null) {
			// avvio il parsing del file flussi di Spitzer
			spitzerParser.parse();
		}
		if (continousParser != null) {
			// avvio il parsing del file flussi del continuo
			continousParser.parse();
		}
		if (apertureParser != null) {
			// avvio il parsing del file delle aperture
			apertureParser.parse();
		}
	}

	public void setGalaxyParser(GalaxyCSVParser galaxyParser) {
		this.galaxyParser = galaxyParser;
	}

	public void setRowFluxParser(RowFluxCSVParser rowFluxParser) {
		this.rowFluxParser = rowFluxParser;
	}

	public void setSpitzerParser(RowFluxSpitzerCSVParser spitzerParser) {
		this.spitzerParser = spitzerParser;
	}

	public void setContinousParser(ContinousRowFluxCSVParser continousParser) {
		this.continousParser = continousParser;
	}

	public void setApertureParser(ApertureFluxCSVParser apertureParser) {
		this.apertureParser = apertureParser;
	}

	public static void main(String[] args) {
		String basePath = "/home/simone/Scrivania/FileProgetto/";

		String galaxyCSVFile = basePath + "MRTable3_sample.csv";
		String rowFluxCSVFile = basePath + "MRTable4_flux.csv";
		String rowFluxSpitzerCSVFile = basePath + "MRTable8_irs.csv";
		String continousRowFluxCSVFile = basePath + "MRTable6_cont.csv";
		String apertureRowFluxCSVFile = basePath + "MRTable11_C_3x3_5x5_flux.csv";

		CSVParsingController controller = new CSVParsingController();

		// instazione i vari parser dei CSV fornendo il percorso di ogni file
		GalaxyCSVParser galaxyParser = new GalaxyCSVParser(galaxyCSVFile);
		RowFluxCSVParser rowFluxParser = new RowFluxCSVParser(rowFluxCSVFile);
		RowFluxSpitzerCSVParser spitzerParser = new RowFluxSpitzerCSVParser(rowFluxSpitzerCSVFile);
		ContinousRowFluxCSVParser continousParser = new ContinousRowFluxCSVParser(continousRowFluxCSVFile);
		ApertureFluxCSVParser apertureParser = new ApertureFluxCSVParser(apertureRowFluxCSVFile);

		// associo i vari parser creati al controller
		controller.setGalaxyParser(galaxyParser);
		controller.setRowFluxParser(rowFluxParser);
		controller.setSpitzerParser(spitzerParser);
		controller.setContinousParser(continousParser);
		controller.setApertureParser(apertureParser);
		
		Map<String, Galaxy> map = null;
		try {
			map = controller.parseAndLink();
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		for (Iterator<Entry<String, Galaxy>> iter = map.entrySet().iterator(); iter.hasNext();) {
			Entry<String,Galaxy> entry = iter.next();
			
			String galaxyKey = entry.getKey();
			Galaxy galaxyModel = entry.getValue();
			System.out.println("KEY: "+galaxyKey+"\t\t MODEL: "+galaxyModel);
		}
		
		Entry<String,Galaxy> entry = map.entrySet().iterator().next();
		String galaxyKey = entry.getKey();
		Galaxy galaxyModel = entry.getValue();
		System.out.println("KEY: "+galaxyKey+"\t\t MODEL: "+galaxyModel);
		
//		List<SpectralLine> specLines = galaxyModel.getSpectralLines();
//		for (SpectralLine line : specLines) {
//			System.out.println("GALAXY NAME: "+galaxyModel.getName()+"\t\t"+line);
//		}
//		
		List<AFlux> rowFluxes = galaxyModel.getFluxes();
		for (AFlux flux : rowFluxes) {
			System.out.println(flux);
		}
		
		
		// TEST PERSISTENZA
		System.out.println("TEST PERSISTENZA");
		
		GalaxyDAO gdao = new GalaxyDAO();
		for (Iterator<Entry<String, Galaxy>> iter = map.entrySet().iterator(); iter.hasNext();) {
			Entry<String,Galaxy> entry1 = iter.next();
			
			String galaxyKey1 = entry1.getKey();
			Galaxy galaxyModel1 = entry1.getValue();
			gdao.saveOrUpdate(galaxyModel1);
		}
		
//		FluxDAO rfdao = new FluxDAO();
//		Map<String, List<RowFlux>> rowFluxMap = rowFluxParser.getParsedMap();
//		for (Map.Entry<String, List<RowFlux>> entry2 : rowFluxMap.entrySet()) {
//			
//			String rowFluxKey = entry2.getKey();
//			RowFlux rowFluxModel = (RowFlux) entry2.getValue().get(0);
//			
//			rfdao.saveOrUpdate(rowFluxModel);
//		}
		
		
	}

}
