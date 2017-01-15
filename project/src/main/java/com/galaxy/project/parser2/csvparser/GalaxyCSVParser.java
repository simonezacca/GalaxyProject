package com.galaxy.project.parser2.csvparser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVRecord;

import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.model.SpectralClassification;
import com.galaxy.project.parser2.csvheader.GalaxyCSVHeader;

public class GalaxyCSVParser extends ACSVParser<Galaxy> {

	public GalaxyCSVParser(String csvFileName) {
		super(csvFileName,27);
		setHeaderClass(GalaxyCSVHeader.class);
	}

	@Override
	public void parse() throws IOException {
		csvparser = createCSVParser(csvFilePath, csvFormat);
		List<CSVRecord> list = this.csvparser.getRecords();
		
		for (CSVRecord record : list) {
			if (isValidRecord(record)) { // se il record contiene il numero corretto di campi
				String nomeGalassia = record.get(GalaxyCSVHeader.GALAXY_NAME);
				
				Position posmodel = createPositionFromRecord(record);
				SpectralClassification scmodel = createSpectralClassificationFromRecord(record);
				
				Galaxy gmodel = createGalaxyFromRecord(record);
				
				gmodel.setPosition(posmodel);
				gmodel.setSpectralClassification(scmodel);
				
				insertIntoMultiMap(nomeGalassia, gmodel);
			}
		}
	}

	private Galaxy createGalaxyFromRecord(CSVRecord r) {
		
		String name = r.get(GalaxyCSVHeader.GALAXY_NAME);
		Float redshift = Float.parseFloat(r.get(GalaxyCSVHeader.REDSHIFT));
		Float distance = (r.get(GalaxyCSVHeader.DISTANCE).length()>0) ? Float.parseFloat(r.get(GalaxyCSVHeader.DISTANCE)) : 0;
		String altName = r.get(GalaxyCSVHeader.ALT_GALAXY_NAME);
		boolean limitLnev1 = convertBoolean(r.get(GalaxyCSVHeader.LIMIT_LNEV1));
		boolean limitLnev2 = convertBoolean(r.get(GalaxyCSVHeader.LIMIT_LNEV2));
		boolean limitLoiv = convertBoolean(r.get(GalaxyCSVHeader.LOIV_LIMIT));
		float lnev1 = (r.get(GalaxyCSVHeader.LNEV1).length()>0) ? Float.parseFloat(r.get(GalaxyCSVHeader.LNEV1)) : 0;
		float lnev2 = (r.get(GalaxyCSVHeader.LNEV2).length()>0) ? Float.parseFloat(r.get(GalaxyCSVHeader.LNEV2)) : 0;
		float loiv = (r.get(GalaxyCSVHeader.LOIV).length()>0) ? Float.parseFloat(r.get(GalaxyCSVHeader.LOIV)) : 0;
		float derMet = (r.get(GalaxyCSVHeader.METALLICITY).length()>0) ? Float.parseFloat(r.get(GalaxyCSVHeader.METALLICITY)) : 0;
		float errMet = (r.get(GalaxyCSVHeader.METALLICITY_ERROR).length()>0) ? Float.parseFloat(r.get(GalaxyCSVHeader.METALLICITY_ERROR)) : 0;
		Galaxy gmodel = new Galaxy(name, 
				redshift, distance, altName, limitLnev1, 
				limitLnev2, limitLoiv, lnev1, lnev2, loiv, derMet, errMet);
		
		return gmodel;
	}


	private SpectralClassification createSpectralClassificationFromRecord(CSVRecord r) {
		String rawString = r.get(GalaxyCSVHeader.SPECTRAL_CLASSIFICATION);
		return new SpectralClassification(rawString);
	}

	private Position createPositionFromRecord(CSVRecord r) {
		
		int rah = Integer.parseInt(r.get(GalaxyCSVHeader.RAH));
		int ram = Integer.parseInt(r.get(GalaxyCSVHeader.RAM));
		float ras = Float.parseFloat(r.get(GalaxyCSVHeader.RAS));
		char dasign = Character.valueOf(r.get(GalaxyCSVHeader.DE).charAt(0));
		int dad = Integer.parseInt(r.get(GalaxyCSVHeader.DED));
		int dam = Integer.parseInt(r.get(GalaxyCSVHeader.DEM));
		float das = Float.parseFloat(r.get(GalaxyCSVHeader.DES));
		
		Position posmodel = new Position(rah, ram, ras, dasign, dad, dam, das);
		return posmodel;
	}
	
	public static void main(String[] args) {
	
		String csvFilePath = "/Users/antonio/Downloads/FileProgetto/MRTable3_sample.csv";
		
		GalaxyCSVParser parser = new GalaxyCSVParser(csvFilePath);
		try {
			parser.parse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, List<Galaxy>> map = parser.getParsedMap();
		for (Map.Entry<String, List<Galaxy>> entry : map.entrySet()) {
			System.out.println("KEY: "+entry.getKey()+"\t\t VALUE: "+entry.getValue());
		}
		
	}

}
