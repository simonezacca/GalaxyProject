package com.galaxy.project.frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.galaxy.project.controller.GalaxySearchController;
	
public class RadiusGalaxySearchFrame extends JFrame {
	
		private static final long serialVersionUID = 1L; 
		
		private GalaxySearchController controller = new GalaxySearchController(this);
		
		private final static String titolo = "Ricerca Oggetto all'interno di un raggio";
		private final JPanel panel = new JPanel();
		
		// Dichiarazione Componenti Grafici
		private JLabel searchPositionGalaxyLabel;
		private JTextField fieldPosition;
		private JButton btnSearchGalaxyForRadius;
		private String galaxyNameString;
		
		public RadiusGalaxySearchFrame() {
			
		super(titolo);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(panel);
		placeComponents(panel);
		
		centerFrame();
		addActionListener(); // Inizializza i Listener dei Bottoni (vedi sotto)
		
		this.setVisible(true);

	}

	// Posizionamento Componenti Grafici
	private void placeComponents(JPanel panel) {

		panel.setLayout(null);

		// Etichetta Inserisci Galassia
		searchPositionGalaxyLabel = new JLabel("Ricerca");
		searchPositionGalaxyLabel.setBounds(10, 10, 253, 25);
		panel.add(searchPositionGalaxyLabel);

		// Campo Posizione
		fieldPosition = new JTextField(20);
		fieldPosition.setBounds(261, 10, 324, 25);
		panel.add(fieldPosition);
		
		// Bottone Per Ricercare
		btnSearchGalaxyForRadius = new JButton("Ricerca");
		btnSearchGalaxyForRadius.setBounds(615, 10, 160, 25);
		panel.add(btnSearchGalaxyForRadius);
		
		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	
	private void updateFields(){
		galaxyNameString = fieldPosition.getText();
	}
	
	// Inizializzazione Listener Bottoni
	private void addActionListener() {
		
		btnSearchGalaxyForRadius.addActionListener(new ActionListener() {
			
//		@Override
			public void actionPerformed(ActionEvent e) {
				updateFields();
				// TODO controller.doRicercaGalassieDentroRaggio(p);
			}
		});
	}
	
	private void close(){
		
		this.setVisible(false);
	}
	


}
