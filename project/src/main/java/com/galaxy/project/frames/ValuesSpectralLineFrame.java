package com.galaxy.project.frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;

import com.galaxy.project.controller.ValuesSpectralLineFrameController;
import com.galaxy.project.frames.tablemodel.RedshiftGalaxyTableModel;
import com.galaxy.project.frames.tablemodel.RigheSpettraliTableModel;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.persistence.GalaxyDAO;
import com.galaxy.project.tools.PositionHelper;
	
public class ValuesSpectralLineFrame extends JFrame {
	
		private static final long serialVersionUID = 1L; 
		
		private ValuesSpectralLineFrameController controller = new ValuesSpectralLineFrameController(this);
		
		private final static String titolo = "Valori delle linee spettrali";
		private final JPanel panel = new JPanel();
		private Position p = null;
		
		// Dichiarazione Componenti Grafici
		private JTable tableRigheSpettrali = new JTable();
		private JTable tableFlussi = new JTable();
		
		public ValuesSpectralLineFrame() {
			
		super(titolo);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(panel);
		placeComponents(panel);
		
		
		tableFlussi = new JTable(null);
		tableFlussi.setBounds(52, 159, 533, 350);
		tableFlussi.setPreferredScrollableViewportSize(new Dimension(450,63));
		tableFlussi.setFillsViewportHeight(true);
		//TODO
//		List<AFlux> fluxes = controller.doValuesSpectralLine();
//		ValuesSpectralLineTableModel jmodel = new RadiusGalaxyTableModel(galaxyOnRadius);
//		tableFlussi.setModel(jmodel);
		
		JScrollPane spFlussi = new JScrollPane(tableFlussi);
		spFlussi.setBounds(272, 33, 419, 350);
		panel.add(spFlussi);
		
		tableRigheSpettrali = new JTable(null);
		tableRigheSpettrali.setBounds(52, 159, 533, 350);
		tableRigheSpettrali.setPreferredScrollableViewportSize(new Dimension(450,63));
		tableRigheSpettrali.setFillsViewportHeight(true);
		List<SpectralLine> spectralLines = controller.getRigheSpettrali();
		RigheSpettraliTableModel jmodel = new RigheSpettraliTableModel(spectralLines);
		tableRigheSpettrali.setModel(jmodel);

		
		
		JScrollPane spRigheSpettrali = new JScrollPane(tableRigheSpettrali);
		spRigheSpettrali.setBounds(10, 68, 242, 193);
		panel.add(spRigheSpettrali);
		
		List<Galaxy> galaxies = controller.getListaGalassie();

		JComboBox<String> cbGalaxies = new JComboBox<String>(); //new JComboBox(lista Galassie)
		for (Galaxy g : galaxies) {
				cbGalaxies.addItem(g.getName());
		}
				
		cbGalaxies.setForeground(new Color(0, 0, 0));
		cbGalaxies.setBounds(10, 37, 242, 20);
		cbGalaxies.setToolTipText("");
		panel.add(cbGalaxies);
		
		JLabel lblSelezionaGalassia = new JLabel("Seleziona Galassia:");
		lblSelezionaGalassia.setBounds(10, 18, 100, 14);
		panel.add(lblSelezionaGalassia);

		
		centerFrame();
		addActionListener(); // Inizializza i Listener dei Bottoni (vedi sotto)
		
		this.setVisible(true);

	}
	
	// Posizionamento Componenti Grafici
	private void placeComponents(JPanel panel) {

		panel.setLayout(null);
		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}

	// Inizializzazione Listener Bottoni
	private void addActionListener() {
		
	}
	
	private void close(){
		this.setVisible(false);
	}
	
}
