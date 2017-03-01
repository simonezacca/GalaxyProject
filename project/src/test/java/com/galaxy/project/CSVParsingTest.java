package com.galaxy.project;

import org.junit.BeforeClass;
import org.junit.Test;

import com.galaxy.project.authentication.AuthSystem;
import com.galaxy.project.model.AFlux;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Utente;
import com.galaxy.project.parser2.CSVParsingController;
import com.galaxy.project.parser2.csvparser.ApertureFluxCSVParser;
import com.galaxy.project.parser2.csvparser.ContinousRowFluxCSVParser;
import com.galaxy.project.parser2.csvparser.GalaxyCSVParser;
import com.galaxy.project.parser2.csvparser.RowFluxCSVParser;
import com.galaxy.project.parser2.csvparser.RowFluxSpitzerCSVParser;
import com.galaxy.project.persistence.GalaxyDAO;

//import static
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
public class CSVParsingTest{
	
	
	private static AuthSystem authSystem ;
	
	public CSVParsingTest() {
		
	}
	
	@BeforeClass
	public static void initDataSet() {
		authSystem = AuthSystem.getInstance();
	}
	
	@Test
	public void parsingTest(){
	
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

	List<AFlux> rowFluxes = galaxyModel.getFluxes();
	for (AFlux flux : rowFluxes) {
		System.out.println(flux);
	}
}
		
		
}
