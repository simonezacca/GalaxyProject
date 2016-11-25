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
		private JLabel rahLabel;
		private JLabel ramLabel;
		private JLabel rasLabel;
		private JLabel rdsignLabel;
		private JLabel rddLabel;
		private JLabel rdmLabel;
		private JLabel rdsLabel;
		private JTextField fieldRAh;
		private JTextField fieldRAm;
		private JTextField fieldRAs;
		private JTextField fieldRDSign;
		private JTextField fieldRDd;
		private JTextField fieldRDm;
		private JTextField fieldRDs;
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

//			Coordinate Spaziali:
//			2MASS Right Ascension 2000 hours
//			2MASS Right Ascension 2000 minutes
//			2MASS Right Ascension 2000 seconds
//			2MASS Right Declination 2000 sign
//			2MASS Right Declination 2000 degrees
//			2MASS Right Declination 2000 minutes
//			2MASS Right Declination 2000 seconds
		
		// Etichetta Inserisci RAh
		rahLabel = new JLabel("Inserisci RAh: ");
		rahLabel.setBounds(10, 10, 253, 25);
		panel.add(rahLabel);

		// Etichetta Inserisci RAm
		ramLabel = new JLabel("Inserisci RAm: ");
		ramLabel.setBounds(10, 10, 253, 25);
		panel.add(ramLabel);
		
		// Etichetta Inserisci RAs
		rasLabel = new JLabel("Inserisci RAs: ");
		rasLabel.setBounds(10, 10, 253, 25);
		panel.add(rasLabel);
		
		// Etichetta Inserisci RDsign
		rdsignLabel = new JLabel("Inserisci RDsign: ");
		rdsignLabel.setBounds(10, 10, 253, 25);
		panel.add(rdsignLabel);
		
		// Etichetta Inserisci RDd
		rddLabel = new JLabel("Inserisci RDd: ");
		rddLabel.setBounds(10, 10, 253, 25);
		panel.add(rddLabel);
		// Etichetta Inserisci RDm
		rdmLabel = new JLabel("Inserisci RDm: ");
		rdmLabel.setBounds(10, 10, 253, 25);
		panel.add(rdmLabel);
		// Etichetta Inserisci RDs
		rdsLabel = new JLabel("Inserisci RDs: ");
		rdsLabel.setBounds(10, 10, 253, 25);
		panel.add(rdsLabel);
	
		// Campo RAh
		fieldRAh = new JTextField(20);
		fieldRAh.setBounds(261, 10, 324, 25);
		panel.add(fieldRAh);
		// Campo RAm
		fieldRAm = new JTextField(20);
		fieldRAm.setBounds(261, 10, 324, 25);
		panel.add(fieldRAm);
		// Campo RAs
		fieldRAs = new JTextField(20);
		fieldRAs.setBounds(261, 10, 324, 25);
		panel.add(fieldRAs);
		// Campo RDsign
		fieldRDSign = new JTextField(20);
		fieldRDSign.setBounds(261, 10, 324, 25);
		panel.add(fieldRDSign);
		// Campo RDd
		fieldRDd = new JTextField(20);
		fieldRDd.setBounds(261, 10, 324, 25);
		panel.add(fieldRDd);
		// Campo RDm
		fieldRDm = new JTextField(20);
		fieldRDm.setBounds(261, 10, 324, 25);
		panel.add(fieldRDm);
		// Campo RDs
		fieldRDs = new JTextField(20);
		fieldRDs.setBounds(261, 10, 324, 25);
		panel.add(fieldRDs);
		
		
		
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
		galaxyNameString = fieldRAh.getText();
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
