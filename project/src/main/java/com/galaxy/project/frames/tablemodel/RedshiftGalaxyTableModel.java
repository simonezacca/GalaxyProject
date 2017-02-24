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

	List<Galaxy> galaxies = new ArrayList<Galaxy>();
	String[] headerTable = {"Galassia", "Redshift"};

	public RedshiftGalaxyTableModel(List<Galaxy> newGalaxiesList) {
		// Richiama il costruttore della superclasse
		super();
		galaxies = newGalaxiesList;
	}

	public int getColumnCount() {
		return 2;
	}

	public int getRowCount() {
		return galaxies.size();
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
			if (col==0) {
				return ((Galaxy) (galaxies.get(row))).getName();
			} else if (col==1) {
				return ((Galaxy) (galaxies.get(row))).getRedshift(); //TODO Ordinarle rispetto al valore di redshift
			}
		}
		return "";
	}
	
	@Override
	public String getColumnName(int index) {
		return headerTable[index];
	}
	
	public void setDataModel(List<Galaxy> newGalaxiesList) {
		galaxies = newGalaxiesList;
		this.fireTableDataChanged();
	}

}
