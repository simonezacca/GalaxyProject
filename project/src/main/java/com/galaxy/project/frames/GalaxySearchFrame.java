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
	
public class GalaxySearchFrame extends JFrame {
	
		private static final long serialVersionUID = 1L; 
		
		private GalaxySearchController controller = new GalaxySearchController(this);
		
		private final static String titolo = "Ricerca Oggetto per Nome";
		private final JPanel panel = new JPanel();
		
		// Dichiarazione Componenti Grafici
		private JLabel searchGalaxyLabel;
		private JTextField fieldGalaxy;
		private JButton btnSearchGalaxy;
		private String galaxyNameString;
		
		public GalaxySearchFrame() {
			
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
		searchGalaxyLabel = new JLabel("Inserisci il nome della Galassia: ");
		searchGalaxyLabel.setBounds(10, 10, 253, 25);
		panel.add(searchGalaxyLabel);

		// Campo Galassia
		fieldGalaxy = new JTextField(20);
		fieldGalaxy.setBounds(261, 10, 324, 25);
		panel.add(fieldGalaxy);
		
		// Bottone Per Registrarsi
		btnSearchGalaxy = new JButton("Ricerca Galassia");
		btnSearchGalaxy.setBounds(615, 10, 160, 25);
		panel.add(btnSearchGalaxy);
		
		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	
	private void updateFields(){
		galaxyNameString = fieldGalaxy.getText();
	}
	
	// Inizializzazione Listener Bottoni
	private void addActionListener() {
		
		btnSearchGalaxy.addActionListener(new ActionListener() {
			
//		@Override
			public void actionPerformed(ActionEvent e) {
				updateFields();
				controller.doRicercaGalassiaPerNome(galaxyNameString);
			}
		});
	}
	
	private void close(){
		
		this.setVisible(false);
	}
	


}
