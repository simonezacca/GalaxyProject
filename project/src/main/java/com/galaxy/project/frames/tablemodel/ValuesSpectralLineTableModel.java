package com.galaxy.project.frames.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.galaxy.project.model.AFlux;
import com.galaxy.project.model.Galaxy;

public class ValuesSpectralLineTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<AFlux> fluxes = new ArrayList<AFlux>();
	String[] headerTable = {"Limite", "Valore","Errore"};

	public ValuesSpectralLineTableModel(List<AFlux> newFluxesList) {
		// Richiama il costruttore della superclasse
		super();
		fluxes = newFluxesList;
	}

	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		return fluxes.size();
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
				return ((AFlux) (fluxes.get(row))).isLimitFlag();	//TODO Da vedere questo booleano
			} else if (col==1) {
				return ((AFlux) (fluxes.get(row))).getFluxValue(); 
			} else if (col==2) {
				return ((AFlux) (fluxes.get(row))).getFluxError();
			}
		}
		return "";
	}
	
	@Override
	public String getColumnName(int index) {
		return headerTable[index];
	}
	
	public void setDataModel(List<AFlux> newFluxesList) {
		fluxes = newFluxesList;
		this.fireTableDataChanged();
	}

}
