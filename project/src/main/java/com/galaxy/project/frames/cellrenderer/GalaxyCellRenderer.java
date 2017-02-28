package com.galaxy.project.frames.cellrenderer;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.galaxy.project.model.AFlux;
import com.galaxy.project.model.Galaxy;

public class GalaxyCellRenderer implements ListCellRenderer<Galaxy> {

	/**
	 * 
	 */
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	
	private static final long serialVersionUID = 1L;

	public GalaxyCellRenderer() {
		// TODO Auto-generated constructor stub
	}

	public Component getListCellRendererComponent(JList<? extends Galaxy> list, Galaxy value, int index,
			boolean isSelected, boolean cellHasFocus) {
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		Object item = value;

	        if( item instanceof Galaxy ) {
	            item = ( ( Galaxy ) item ).getName();
	            renderer.setText((String) item);
	            return renderer;
	        }
	        return renderer;
	    }

}
