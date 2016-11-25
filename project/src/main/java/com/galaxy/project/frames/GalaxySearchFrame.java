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

import com.galaxy.project.controller.GalaxySearchFrameController;
import com.galaxy.project.model.Galaxy;
	
public class GalaxySearchFrame extends JFrame {
	
		private static final long serialVersionUID = 1L; 
		
		private GalaxySearchFrameController controller = new GalaxySearchFrameController(this);
		
		private final static String titolo = "Ricerca Oggetto per Nome";
		private final JPanel panel = new JPanel();
		
		// Dichiarazione Componenti Grafici
		private JLabel labelSearchGalaxy;
		private JLabel labelPosition;
		private JLabel labelDistance;
		private JLabel labelRedshift;
		private JLabel labelLnev1;
		private JLabel labelErrLum;
		private JLabel labelMet;
		private JLabel labelErrMet;
		private JLabel labelPositionValue;
		private JLabel labelDistanceValue;
		private JLabel labelRedshiftValue;
		private JLabel labelLumValue;
		private JLabel labelErrLumValue;
		private JLabel labelMetValue;
		private JLabel labelErrMetValue;
		private JTextField fieldGalaxy;
		private JButton btnSearchGalaxy;
		private String galaxyNameString;

		private JLabel labelLnev1Value;

		private JLabel labelLoivValue;

		private JLabel labelLnev2Value;

		private JLabel labelLoiv;

		private JLabel labelLnev2;


	
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
		labelSearchGalaxy = new JLabel("Inserisci il nome della Galassia: ");
		labelSearchGalaxy.setBounds(10, 10, 253, 25);
		panel.add(labelSearchGalaxy);

		// Etichetta Posizione
		labelPosition = new JLabel("Posizione: ");
		labelPosition.setBounds(10, 10, 253, 25);
		panel.add(labelPosition);
		
		// Etichetta Distanza
		labelDistance = new JLabel("Distanza: ");
		labelDistance.setBounds(10, 10, 253, 25);
		panel.add(labelDistance);

		// Etichetta Redshift
		labelRedshift = new JLabel("Redshift: ");
		labelRedshift.setBounds(10, 10, 253, 25);
		panel.add(labelRedshift);
		
		// Etichetta Lnev1
		labelLnev1 = new JLabel("Lnev 1: ");
		labelLnev1.setBounds(10, 10, 253, 25);
		panel.add(labelLnev1);
		
		// Etichetta Lnev2
		labelLnev2 = new JLabel("Lnev 2: ");
		labelLnev2.setBounds(10, 10, 253, 25);
		panel.add(labelLnev2);

		// Etichetta Loiv
		labelLoiv = new JLabel("Lnev 2: ");
		labelLoiv.setBounds(10, 10, 253, 25);
		panel.add(labelLoiv);
		
		// Etichetta Errore Luminosità
		labelErrLum = new JLabel("Errore Luminosità: ");
		labelErrLum.setBounds(10, 10, 253, 25);
		panel.add(labelErrLum);
				
		// Etichetta Metallicità
		labelMet = new JLabel("Metallicità: ");
		labelMet.setBounds(10, 10, 253, 25);
		panel.add(labelMet);
		
		// Etichetta Errore Metallicità
		labelErrMet = new JLabel("Errore Metallicità: ");
		labelErrMet.setBounds(10, 10, 253, 25);
		panel.add(labelErrMet);
				
		
		// Campo Galassia
		fieldGalaxy = new JTextField(20);
		fieldGalaxy.setBounds(261, 10, 324, 25);
		panel.add(fieldGalaxy);
		
		// Bottone Per Registrarsi
		btnSearchGalaxy = new JButton("Ricerca Galassia");
		btnSearchGalaxy.setBounds(615, 10, 160, 25);
		panel.add(btnSearchGalaxy);

		// Etichetta Valore Posizione
		labelPositionValue = new JLabel("");
		labelPositionValue.setBounds(10, 10, 253, 25);
		panel.add(labelPositionValue);
		
		// Etichetta Valore Distanza
		labelDistanceValue = new JLabel("");
		labelDistanceValue.setBounds(10, 10, 253, 25);
		panel.add(labelDistanceValue);

		// Etichetta Valore Redshift
		labelRedshiftValue = new JLabel("");
		labelRedshiftValue.setBounds(10, 10, 253, 25);
		panel.add(labelRedshiftValue);
		
		// Etichetta Valore Lnev1
		labelLnev1Value = new JLabel("");
		labelLnev1Value.setBounds(10, 10, 253, 25);
		panel.add(labelLnev1Value);
		
		// Etichetta Valore Lnev2
		labelLnev2Value = new JLabel("");
		labelLnev2Value.setBounds(10, 10, 253, 25);
		panel.add(labelLnev2Value);
		
		// Etichetta Valore Loiv
		labelLoivValue = new JLabel("");
		labelLoivValue.setBounds(10, 10, 253, 25);
		panel.add(labelLoivValue);
		
		// Etichetta Valore Luminosità
		labelErrLumValue = new JLabel("");
		labelErrLumValue.setBounds(10, 10, 253, 25);
		panel.add(labelErrLumValue);
				
		// Etichetta Valore Metallicità
		labelMetValue = new JLabel("");
		labelMetValue.setBounds(10, 10, 253, 25);
		panel.add(labelMetValue);
		
		// Etichetta Valore Metallicità
		labelErrMetValue = new JLabel("");
		labelErrMetValue.setBounds(10, 10, 253, 25);
		panel.add(labelErrMetValue);

		
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
	
	public void setLabelsFromGalaxy(Galaxy g){
		// labelPositionValue.setText(g.getPos());
		labelDistanceValue.setText(g.getDistance().toString());
		labelRedshiftValue.setText(g.getRedshift().toString());
		labelLnev1Value.setText(g.getLnev1());
		labelLnev2Value.setText(g.getLnev2());
		labelLoivValue.setText(g.getLoiv());
		labelMetValue.setText(g.getDerMet());
		labelErrMetValue.setText(g.getErrMet());
	}
	


}
