package com.galaxy.project.frames.tablemodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.galaxy.project.model.Galaxy;

public class RadiusGalaxyTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<GalaxyDistancePair> galaxyDistancePair = new ArrayList<GalaxyDistancePair>();
	String[] headerTable = {"Galassia", "Distanza"};

	public RadiusGalaxyTableModel(List<GalaxyDistancePair> newGalaxyDistancePair) {
		// Richiama il costruttore della superclasse
		super();
		this.galaxyDistancePair = newGalaxyDistancePair;
	}

	public int getColumnCount() {
		return 2;
	}

	public int getRowCount() {
		return galaxyDistancePair.size();
	}

//	public void setValueAt(Object value, int row, int col) {
//		if (col==0) {
//			Long newId = (Long) value;
//			Galaxy newGalaxy = galaxies.get(row);
//			newGalaxy.setName();
//			galaxies.set(row, newGalaxy);
//		} else if (col==1) {
//			String newName = (String) value;
//			Galaxy newGalaxies = galaxies.get(row);
//			newGalaxies.setNomeServizio(newName);
//			galaxies.set(row, newGalaxies);
//		}
//		
//	}

	public Object getValueAt(int row, int col) {
		if (row>=0) {
			GalaxyDistancePair gdp = galaxyDistancePair.get(row);
			if (col==0) {
				Galaxy g = gdp.getGalaxy();		
				return g.getName();
			} else if (col==1) {
				float distance = gdp.getDistance();
				return distance;
			}
		}
		return "";
	}
	
	@Override
	public String getColumnName(int index) {
		return headerTable[index];
	}
	
	public void setDataModel(List<GalaxyDistancePair> newGalaxiesList) {
		galaxyDistancePair = newGalaxiesList;
		this.fireTableDataChanged();
	}

}
