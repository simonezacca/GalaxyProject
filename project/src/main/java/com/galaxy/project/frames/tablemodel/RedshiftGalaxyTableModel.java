package com.galaxy.project.frames.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.galaxy.project.model.Galaxy;

public class RedshiftGalaxyTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<GalaxyRedshiftPair> galaxyRedshiftPair = new ArrayList<GalaxyRedshiftPair>();
	String[] headerTable = {"Galassia", "Redshift"};

	public RedshiftGalaxyTableModel(List<GalaxyRedshiftPair> newGalaxiesList) {
		super();
		this.galaxyRedshiftPair = newGalaxiesList;
	}

	public int getColumnCount() {
		return 2;
	}

	public int getRowCount() {
		return galaxyRedshiftPair.size();
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
			GalaxyRedshiftPair grp = galaxyRedshiftPair.get(row);
			if (col==0) {
				Galaxy g = grp.getGalaxy();		
				return g.getName();
			} else if (col==1) {
				float redshift = grp.getRedshift();
				return redshift;
			}
		}
		return "";
	}
	
	@Override
	public String getColumnName(int index) {
		return headerTable[index];
	}
	
	public void setDataModel(List<GalaxyRedshiftPair> newGalaxiesList) {
		galaxyRedshiftPair = newGalaxiesList;
		this.fireTableDataChanged();
	}

}
