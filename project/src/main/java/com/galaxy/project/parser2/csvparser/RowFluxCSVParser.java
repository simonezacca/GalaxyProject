package com.galaxy.project.parser2.csvparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVRecord;

import com.galaxy.project.model.RowFlux;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.parser2.csvheader.GalaxyCSVHeader;
import com.galaxy.project.parser2.csvheader.RowFluxCSVHeader;
import com.galaxy.project.persistence.SpectralLineDAO;

public class RowFluxCSVParser extends ACSVParser<RowFlux> {

	private List<SpectralLine> spectralLines;
	
	public RowFluxCSVParser(String csvFileName) {
		super(csvFileName, 24);
		setHeaderClass(RowFluxCSVHeader.class);

		// inizializzo la lista dei model SpectralLine
		// usata solo per TEST
		// successivamento questa lista sarà recuperata dal servizio di persistenza
		spectralLines = getSpectralLineList();
	}

	@Override
	public void parse() throws IOException {
		csvparser = createCSVParser(csvFilePath, csvFormat);
		List<CSVRecord> list = this.csvparser.getRecords();

		for (CSVRecord record : list) {
			if (isValidRecord(record)) {
				// setto il nome della chiave da utilizzare nella multi mappa
				String nomeGalassia = record.get(GalaxyCSVHeader.GALAXY_NAME);
				
				// instanzio una lista di model di tipo RowFlux
				List<RowFlux> fluxes = createListOfRowFluxFromRecord(record);
				for (RowFlux rf : fluxes) {
					if(rf.isNotZeroValue()){
						// inserisco nella multimappa solo i flussi con un valore diverso da zero
						insertIntoMultiMap(nomeGalassia, rf);
					}
				}
			}
		}
	}

	private List<RowFlux> createListOfRowFluxFromRecord(CSVRecord r) {
		List<RowFlux> list = new ArrayList<>();
		int i = 1;
		for (SpectralLine spectralLine : spectralLines) {
			
			boolean limitFlag = convertBoolean(r.get(i));
			float fluxValue = (r.get(i+1).length()>0) ? Float.parseFloat(r.get(i+1)) : 0;
			float fluxError = (r.get(i+2).length()>0) ? Float.parseFloat(r.get(i+2)) : 0;
			String fluxAperture = r.get(RowFluxCSVHeader.APERTURE);
			
			RowFlux rf = new RowFlux(limitFlag, fluxValue, fluxError, fluxAperture, spectralLine);		
			list.add(rf);
			
			i += 3;
		}
		
		return list;
	}
	
	private List<SpectralLine> getSpectralLineList() {

		List<SpectralLine> line = new ArrayList<>();
		
		SpectralLine sl1 = new SpectralLine("O", 3, 52,SpectralLine.HERSCHEL);
		SpectralLine sl2 = new SpectralLine("N", 3, 57,SpectralLine.HERSCHEL);
		SpectralLine sl3 = new SpectralLine("O", 1, 63,SpectralLine.HERSCHEL);
		SpectralLine sl4 = new SpectralLine("O", 3, 88,SpectralLine.HERSCHEL);
		SpectralLine sl5 = new SpectralLine("N", 2, 122,SpectralLine.HERSCHEL);
		SpectralLine sl6 = new SpectralLine("O", 1, 145,SpectralLine.HERSCHEL);
		SpectralLine sl7 = new SpectralLine("C", 2, 158,SpectralLine.HERSCHEL);
		
		line.add(sl1);
		line.add(sl2);
		line.add(sl3);
		line.add(sl4);
		line.add(sl5);
		line.add(sl6);
		line.add(sl7);
		
//		SpectralLineDAO sdao = new SpectralLineDAO();
//		List<SpectralLine> line = sdao.getSpectralLinesBySatelliteType(SpectralLine.HERSCHEL);
		
		return line;
	}
	
	public static void main(String[] args) {
		String csvFilePath = "/home/simone/Scrivania/FileProgetto/MRTable4_flux.csv";
		
		RowFluxCSVParser parser = new RowFluxCSVParser(csvFilePath);
		try {
			parser.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String, List<RowFlux>> map = parser.getParsedMap();
		for (Map.Entry<String, List<RowFlux>> entry : map.entrySet()) {
			System.out.println("KEY: "+entry.getKey()+"\t\t VALUE: "+entry.getValue());
		}
		
	}
}
