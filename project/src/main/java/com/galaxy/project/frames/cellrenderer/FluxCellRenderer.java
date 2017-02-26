package com.galaxy.project.frames.cellrenderer;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import com.galaxy.project.model.AFlux;

public class FluxCellRenderer extends DefaultListCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FluxCellRenderer() {
		// TODO Auto-generated constructor stub
	}

	public Component getListCellRendererComponent(JList<? extends AFlux> list, AFlux value, int index,
			boolean isSelected, boolean cellHasFocus) {
		 Object item = value;

	        // if the item to be rendered is Proveedores then display it's Name
	        if( item instanceof AFlux ) {
	            item = ( ( AFlux ) item ).getFluxValue() + "-" + ( ( AFlux ) item ).getSpectralLine();
	        }
	        return super.getListCellRendererComponent( list, item, index, isSelected, cellHasFocus);
	    }
}
