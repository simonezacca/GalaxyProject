package com.galaxy.project.parser2.csvparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVRecord;

import com.galaxy.project.model.AFlux;
import com.galaxy.project.model.RowFlux;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.parser2.csvheader.GalaxyCSVHeader;
import com.galaxy.project.parser2.csvheader.RowFluxSpitzerCSVHeader;
import com.galaxy.project.persistence.SpectralLineDAO;

public class RowFluxSpitzerCSVParser extends ACSVParser<RowFlux> {

	private List<SpectralLine> spectralLines;
	
	public RowFluxSpitzerCSVParser(String csvFileName) {
		super(csvFileName,31);
		setHeaderClass(RowFluxSpitzerCSVHeader.class);
		
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
					if (rf.isNotZeroValue()) {
						// inserisco nella multimappa solo i flussi con valore diverso da zero
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
			String irsMode = r.get(RowFluxSpitzerCSVHeader.IRS_MODE);
			
			RowFlux rf = new RowFlux(limitFlag, fluxValue, fluxError, irsMode, spectralLine);		
			list.add(rf);
			
			i += 3;
		}
		
		return list;
	}

	private List<SpectralLine> getSpectralLineList() {

//		List<SpectralLine> line = new ArrayList<>();
		
//		SpectralLine sl1 = new SpectralLine("S", 4, new Float(10.5),SpectralLine.SPITZER);
//		SpectralLine sl2 = new SpectralLine("Ne", 2, new Float(12.8),SpectralLine.SPITZER);
//		SpectralLine sl3 = new SpectralLine("Ne", 5, new Float(14.3),SpectralLine.SPITZER);
//		SpectralLine sl4 = new SpectralLine("Ne", 3, new Float(15.6),SpectralLine.SPITZER);
//		SpectralLine sl5 = new SpectralLine("S", 3, new Float(18.7),SpectralLine.SPITZER);
//		SpectralLine sl6 = new SpectralLine("Ne", 5, new Float(24.3),SpectralLine.SPITZER);
//		SpectralLine sl7 = new SpectralLine("O", 4, new Float(25.9),SpectralLine.SPITZER);
//		SpectralLine sl8 = new SpectralLine("S", 3, new Float(33.5),SpectralLine.SPITZER);
//		SpectralLine sl9 = new SpectralLine("Si", 2, new Float(34.8),SpectralLine.SPITZER);
//		
//		
//		line.add(sl1);
//		line.add(sl2);
//		line.add(sl3);
//		line.add(sl4);
//		line.add(sl5);
//		line.add(sl6);
//		line.add(sl7);
//		line.add(sl8);
//		line.add(sl9);
//		
		SpectralLineDAO sdao = new SpectralLineDAO();
		List<SpectralLine> line = sdao.getSpectralLinesBySatelliteType(SpectralLine.SPITZER);
		return line;
	}
	
	public static void main(String[] args) {
		String csvFilePath = "/Users/antonio/Downloads/FileProgetto/MRTable8_irs.csv";
		
		RowFluxSpitzerCSVParser parser = new RowFluxSpitzerCSVParser(csvFilePath);
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
