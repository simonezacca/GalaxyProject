package com.galaxy.project.parser.csvfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.galaxy.project.parser.csvfileparser.ACSVFileParser;
import com.galaxy.project.parser.csvline.ACSVLine;
import com.galaxy.project.parser.csvline.GalaxyCSVLine;

public abstract class ACSVFile {

	protected BufferedReader br = null;
	protected String fileName;
	protected String line = "";
	// Lista di righe valide
	protected List<ACSVLine> csvLines;

	public ACSVFile(String fileName) {
		this.fileName = fileName;
		try {
			br = new BufferedReader(new FileReader(this.fileName));
			readAndValidCSVLine();
		} catch (FileNotFoundException e) {
			// TODO Appendere messaggio su log di errore
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFile();
		}

	}

	private void readAndValidCSVLine() throws IOException {
		while ((line = br.readLine()) != null) {
			ACSVLine csvline = createCSVLine(line);
			if (csvline.isValidLine())
				this.csvLines.add(csvline);
		}
	}

	private void closeFile() {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected abstract ACSVLine createCSVLine(String csvline); // Pattern "Template Method" in base all'implementazione ognuna si crea il suo tipo di riga.

	public abstract ACSVFileParser getParser();

	public List<ACSVLine> getCSVLines() {
		return this.csvLines;
	}
	


}
