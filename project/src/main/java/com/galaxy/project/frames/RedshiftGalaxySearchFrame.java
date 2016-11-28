package com.galaxy.project.frames;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.galaxy.project.controller.RedshiftGalaxySearchFrameController;
	
public class RedshiftGalaxySearchFrame extends JFrame {
	
		//TODO Si può ricercare sia per redshift con valore maggiore uguale oppure con valore minore o uguale. 
		// Pensare ad una soluzione
	
		private static final long serialVersionUID = 1L; 
		
		private RedshiftGalaxySearchFrameController controller = new RedshiftGalaxySearchFrameController(this);
		
		private final static String titolo = "Ricerca Oggetto con valore maggiore/uguale o minore/uguale a redshift";
		private final JPanel panel = new JPanel();
		
		// Dichiarazione Componenti Grafici
		private JLabel searchForGreaterRedshiftLabel;
		private JTextField greaterRedshiftField;
		private JButton btnSearchGalaxyForGreaterRedshift;
		private String galaxyNameString;

		private JLabel searchForLowerRedshiftLabel;

		private Component lowerRedshiftField;

		private JButton btnSearchGalaxyForLowerRedshift;
		
		public RedshiftGalaxySearchFrame() {
			
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
		searchForGreaterRedshiftLabel = new JLabel("Ricerca per valori maggiori/uguali di redshift");
		searchForGreaterRedshiftLabel.setBounds(10, 10, 253, 25);
		panel.add(searchForGreaterRedshiftLabel);

		// Etichetta Inserisci Galassia
		searchForLowerRedshiftLabel = new JLabel("Ricerca per valori minori/uguali di redshift");
		searchForLowerRedshiftLabel.setBounds(10, 10, 253, 25);
		panel.add(searchForLowerRedshiftLabel);
		
		// Campo Valore Redshift Maggiore/Uguale
		greaterRedshiftField = new JTextField(20);
		greaterRedshiftField.setBounds(261, 10, 324, 25);
		panel.add(greaterRedshiftField);

		// Campo Valore Redshift Maggiore/Uguale
		lowerRedshiftField = new JTextField(20);
		lowerRedshiftField.setBounds(261, 10, 324, 25);
		panel.add(lowerRedshiftField);
		
		// Bottone Per Ricercare
		btnSearchGalaxyForGreaterRedshift = new JButton("Ricerca");
		btnSearchGalaxyForGreaterRedshift.setBounds(615, 10, 160, 25);
		panel.add(btnSearchGalaxyForGreaterRedshift);
		
		// Bottone Per Ricercare
		btnSearchGalaxyForLowerRedshift = new JButton("Ricerca");
		btnSearchGalaxyForLowerRedshift.setBounds(615, 10, 160, 25);
		panel.add(btnSearchGalaxyForLowerRedshift);
		
		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	
	private void updateFields(){
		galaxyNameString = greaterRedshiftField.getText();
	}
	
	// Inizializzazione Listener Bottoni
	private void addActionListener() {
		
		btnSearchGalaxyForGreaterRedshift.addActionListener(new ActionListener() {
			
//		@Override
			public void actionPerformed(ActionEvent e) {
				updateFields();
			// TODO	controller.doRicercaGalassieDentroRaggio(p);
			}
		});
	}
	
	private void close(){
		
		this.setVisible(false);
	}
	


}
