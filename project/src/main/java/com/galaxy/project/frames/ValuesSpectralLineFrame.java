package com.galaxy.project.frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.galaxy.project.controller.ValuesSpectralLineFrameController;
import com.galaxy.project.frames.tablemodel.RadiusGalaxyTableModel;
import com.galaxy.project.frames.tablemodel.RigheSpettraliTableModel;
import com.galaxy.project.frames.tablemodel.ValuesSpectralLineTableModel;
import com.galaxy.project.model.AFlux;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.model.SpectralLine;
	
public class ValuesSpectralLineFrame extends JFrame {
	
		private static final long serialVersionUID = 1L; 
		
		private ValuesSpectralLineFrameController controller = new ValuesSpectralLineFrameController(this);
		
		private final static String titolo = "Valori delle linee spettrali";
		private final JPanel panel = new JPanel();
		private Position p = null;
		
		// Dichiarazione Componenti Grafici
		private JTable tableRigheSpettrali = new JTable();
		private JTable tableFlussi = new JTable();
		private JButton btnSelezionaGalassia = new JButton("Seleziona");
		private JComboBox<Galaxy> cbGalaxies;
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
		
		JScrollPane spFlussi = new JScrollPane(tableFlussi);
		spFlussi.setBounds(272, 33, 419, 350);
		panel.add(spFlussi);
		
		List<Galaxy> galaxies = controller.getListaGalassie();

		cbGalaxies = new JComboBox<Galaxy>(); //new JComboBox(lista Galassie)
		for (Galaxy g : galaxies) {
				cbGalaxies.addItem(g);
		}
				
		cbGalaxies.setForeground(new Color(0, 0, 0));
		cbGalaxies.setBounds(10, 37, 242, 20);
		cbGalaxies.setToolTipText("");
		panel.add(cbGalaxies);
		
		JLabel lblSelezionaGalassia = new JLabel("Seleziona Galassia:");
		lblSelezionaGalassia.setBounds(10, 18, 100, 14);
		panel.add(lblSelezionaGalassia);
		
		btnSelezionaGalassia.setBounds(10, 68, 242, 23);
		panel.add(btnSelezionaGalassia);

		
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
		
		btnSelezionaGalassia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Galaxy g = (Galaxy) cbGalaxies.getSelectedItem();
				List<AFlux> fluxes = g.getFluxes();
				ValuesSpectralLineTableModel jmodel = new ValuesSpectralLineTableModel(fluxes);
				tableFlussi.setModel(jmodel);
			}
		} );

	}
	
	private void close(){
		this.setVisible(false);
	}
}
