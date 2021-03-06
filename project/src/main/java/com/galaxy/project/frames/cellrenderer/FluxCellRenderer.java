package com.galaxy.project.frames.cellrenderer;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.galaxy.project.model.AFlux;

public class FluxCellRenderer implements ListCellRenderer<AFlux> {

	/**
	 * 
	 */
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	
	private static final long serialVersionUID = 1L;

	public FluxCellRenderer() {
		// TODO Auto-generated constructor stub
	}

	public Component getListCellRendererComponent(JList<? extends AFlux> list, AFlux value, int index,
			boolean isSelected, boolean cellHasFocus) {
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		Object item = value;

	        // if the item to be rendered is Proveedores then display it's Name
	        if( item instanceof AFlux ) {
	            item = ( ( AFlux ) item ).getFluxValue() + "-" + ( ( AFlux ) item ).getSpectralLine();
	            renderer.setText((String) item);
	            return renderer;
	        }
	        return renderer;
	    }
}
