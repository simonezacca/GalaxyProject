package com.galaxy.project.parser2.csvparser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public abstract class ACSVParser<E> {
	
	protected String csvFilePath;
	protected int validTokens;
	protected CSVParser csvparser;
	protected Map<String,List<E>> modelsMultiMap;
	
	protected CSVFormat csvFormat = CSVFormat.DEFAULT
											.withDelimiter(';')
											.withTrim(true);
	
	public ACSVParser(String csvFilePath, int validTokens) {
		this.csvFilePath = csvFilePath;
		this.validTokens = validTokens;
		
		this.modelsMultiMap = new HashMap<String, List<E>>();
	}
	
	public abstract void parse() throws IOException;
	
	public Map<String,List<E>> getParsedMap() {
		return modelsMultiMap;
	}
	
	protected CSVParser createCSVParser(String csvFilePath, CSVFormat csvFormat) throws IOException {
		return CSVParser.parse(new File(this.csvFilePath), StandardCharsets.UTF_8, csvFormat);
	}
	
	protected boolean isValidRecord(CSVRecord record) {
		return record.size() == validTokens;
	}
	
	protected void insertIntoMultiMap(String key, E model) {
		List<E> list;
		if (modelsMultiMap.containsKey(key)) {
			// la chiave esiste già
			// recupero la lista e appeno il model E
			list = modelsMultiMap.get(key);
			list.add(model);
		}
		else {
			// la chiave non esiste
			// si tratta di un primo inserimento
			
			// inizializzo la lista vuota
			list = new ArrayList<>();
			// appendo il model alla lista
			list.add(model);
			// inserisco nella mappa la coppia chiave,lista
			this.modelsMultiMap.put(key, list);
		}
	}
	
	protected boolean convertBoolean(String string) {
		return string.equals("<");
	}
	
	protected void setHeaderClass(Class c) {
		csvFormat = csvFormat.withHeader(c);
	}
	
}
