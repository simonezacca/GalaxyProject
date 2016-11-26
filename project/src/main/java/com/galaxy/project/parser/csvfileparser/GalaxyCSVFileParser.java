package com.galaxy.project.parser.csvfileparser;

import java.util.List;

import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.model.SpectralClassification;
import com.galaxy.project.parser.csvfile.ACSVFile;
import com.galaxy.project.parser.csvline.ACSVLine;
import com.galaxy.project.parser.csvline.GalaxyCSVLine;
import com.galaxy.project.parser.csvtoken.GalaxyToken;
import com.galaxy.project.parser.csvtoken.PositionToken;
import com.galaxy.project.parser.csvtoken.SpectralClassificationToken;

public class GalaxyCSVFileParser extends ACSVFileParser<Galaxy> {

	public GalaxyCSVFileParser(ACSVFile fileToParse) {
		super(fileToParse);
	}

	@Override
	public void parse() {	
		List<ACSVLine> lines = this.fileToParse.getCSVLines(); 
		for(ACSVLine aLine: lines){
			GalaxyCSVLine galaxyLine = (GalaxyCSVLine) aLine;
			GalaxyToken gt = galaxyLine.getGalaxyToken();
			PositionToken pt = galaxyLine.getPositionToken();
			SpectralClassificationToken sct = galaxyLine.getSpectralClassificationToken();
			String key = gt.getRawName();
			
			Galaxy galaxyModel = createGalaxyFromToken(gt);
			Position positionModel = createPositionFromToken(pt);
			SpectralClassification spectralClassificationModel = createSpectralClassificationFromToken(sct);
			
			galaxyModel.setPosition(positionModel);
			galaxyModel.setSpectralClassification(spectralClassificationModel);
			this.modelsMap.put(key, galaxyModel);
		}

	}
	
	private Galaxy createGalaxyFromToken(GalaxyToken gt) {
		String name = gt.getRawName();
		
		Long redshift = Long.valueOf(gt.getRawRedshift());
		Long distance = Long.valueOf(gt.getRawDistance());
		String altName = gt.getRawAltName();
		boolean limitLnev1 = fromTokenToBoolean(gt.getRawLimitLnev1());
		boolean limitLnev2 = fromTokenToBoolean(gt.getRawLimitLnev2());
		boolean limitLoiv = fromTokenToBoolean(gt.getRawLimitLoiv());
		float lnev1 = Float.valueOf(gt.getRawLnev1());
		float lnev2 = Float.valueOf(gt.getRawLnev2());
		float loiv = Float.valueOf(gt.getRawLoiv());
		float derMet = Float.valueOf(gt.getRawMetDer());
		float errMet = Float.valueOf(gt.getRawErrMet());
		
		Galaxy gmodel = new Galaxy(name, 
				redshift, 
				distance, 
				altName, 
				limitLnev1, 
				limitLnev2, 
				limitLoiv, 
				lnev1, 
				lnev2, 
				loiv, 
				derMet, 
				errMet);
		return gmodel;
	}

	private SpectralClassification createSpectralClassificationFromToken(SpectralClassificationToken sct) {
		return new SpectralClassification(sct.getSpectralClassificationRawName());
	}

	private Position createPositionFromToken(PositionToken pt) {
		
		
		int rah = Integer.valueOf(pt.getRawRAh());
		int ram = Integer.valueOf(pt.getRawRAm());
		float ras = Float.valueOf(pt.getRawRAs());
		char dasign = pt.getRawdasign().charAt(0);
		int dad = Integer.valueOf(pt.getRawDAd());
		int dam = Integer.valueOf(pt.getRawDAm());
		float das = Float.valueOf(pt.getRawDAs());
		
		Position pmodel = new Position(rah, ram, ras, dasign, dad, dam, das);
		return pmodel;
	}

	@Override
	public void convert() {
		
	}

}
