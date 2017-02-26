package com.galaxy.project.frames.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.SpectralLine;

public class RigheSpettraliTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<SpectralLine> sl = new ArrayList<SpectralLine>();
	String[] headerTable = {"Riga Spettrale"};

	public RigheSpettraliTableModel(List<SpectralLine> newSpectralLineList) {
		// Richiama il costruttore della superclasse
		super();
		sl = newSpectralLineList;
	}

	public int getColumnCount() {
		return 1;
	}

	public int getRowCount() {
		return sl.size();
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
				return ((SpectralLine) (sl.get(row))).toString();
			} 
		}
		return "";
	}
	
	@Override
	public String getColumnName(int index) {
		return headerTable[index];
	}
	
	public void setDataModel(List<SpectralLine> newSpectralLineList) {
		sl = newSpectralLineList;
		this.fireTableDataChanged();
	}

}
