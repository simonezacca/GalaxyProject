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
	
public class ValuesSpectralLinesFrame extends JFrame {
	
		//TODO Si può ricercare sia per redshift con valore maggiore uguale oppure con valore minore o uguale. 
		// Pensare ad una soluzione
	
		private static final long serialVersionUID = 1L; 
		
		private final static String titolo = "Valori delle linee spettrali";
		private final JPanel panel = new JPanel();
		
		// Dichiarazione Componenti Grafici
		private JLabel searchRedshiftGalaxyLabel;
		private JTextField fieldRedshiftValue;
		private JButton btnSearchGalaxyForRedshift;
		private String galaxyNameString;
		
		public ValuesSpectralLinesFrame() {
			
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
		searchRedshiftGalaxyLabel = new JLabel("Ricerca per redshift");
		searchRedshiftGalaxyLabel.setBounds(10, 10, 253, 25);
		panel.add(searchRedshiftGalaxyLabel);

		// Campo Valore Redshift
		fieldRedshiftValue = new JTextField(20);
		fieldRedshiftValue.setBounds(261, 10, 324, 25);
		panel.add(fieldRedshiftValue);
		
		// Bottone Per Ricercare
		btnSearchGalaxyForRedshift = new JButton("Ricerca");
		btnSearchGalaxyForRedshift.setBounds(615, 10, 160, 25);
		panel.add(btnSearchGalaxyForRedshift);
		
		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	
	private void updateFields(){
		galaxyNameString = fieldRedshiftValue.getText();
	}
	
	// Inizializzazione Listener Bottoni
	private void addActionListener() {
		
		btnSearchGalaxyForRedshift.addActionListener(new ActionListener() {
			
//		@Override
			public void actionPerformed(ActionEvent e) {
				updateFields();
				//TODO controller.doRicercaGalassieDentroRaggio(p);
			}
		});
	}
	
	private void close(){
		
		this.setVisible(false);
	}
	


}
