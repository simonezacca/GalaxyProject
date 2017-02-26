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

import com.galaxy.project.controller.RadiusGalaxySearchFrameController;
import com.galaxy.project.controller.DivisionRowContinuousFluxController;
import com.galaxy.project.controller.DivisionRowController;
import com.galaxy.project.controller.DivisionRowForSpectralLineController;
import com.galaxy.project.model.Position;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
	
public class DivisionRowContinuousFluxFrame extends JFrame {
	
		private static final long serialVersionUID = 1L; 
		
		private DivisionRowContinuousFluxController controller = new DivisionRowContinuousFluxController(this);
		
		private final static String titolo = "Rapporto tra flusso e continuo";
		private final JPanel panel = new JPanel();
		
		// Dichiarazione Componenti Grafici
		private JLabel lblSelezionaGalassia;
		private JLabel lblRigaSpettrale;
		private JLabel lblValoreDelRapporto;
		private JLabel lblValoreFlussoContinuo;
		private JButton btnValueDivision;
		private JComboBox cbGalassia;
		private JComboBox cbRigaSpettrale;
		private JComboBox cbFlussoContinuo;
		private JLabel lblValoreFlussoRiga;
		private JComboBox cbFlussoRiga;
		
		
		public DivisionRowContinuousFluxFrame() {
			
		super(titolo);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(panel);
		placeComponents(panel);
		
		cbGalassia = new JComboBox();
		cbGalassia.setBounds(10, 35, 113, 20);
		panel.add(cbGalassia);
		
		cbRigaSpettrale = new JComboBox();
		cbRigaSpettrale.setBounds(156, 35, 113, 20);
		panel.add(cbRigaSpettrale);
		
		cbFlussoContinuo = new JComboBox();
		cbFlussoContinuo.setBounds(156, 97, 113, 20);
		panel.add(cbFlussoContinuo);
		
		lblValoreFlussoRiga = new JLabel("Valore Flusso Riga: ");
		lblValoreFlussoRiga.setBounds(10, 66, 113, 25);
		panel.add(lblValoreFlussoRiga);
		
		cbFlussoRiga = new JComboBox();
		cbFlussoRiga.setBounds(10, 97, 113, 20);
		panel.add(cbFlussoRiga);
		
		JLabel lblDivisionvalue = new JLabel("DivisionValue");
		lblDivisionvalue.setBounds(289, 133, 95, 14);
		panel.add(lblDivisionvalue);
		
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
		lblSelezionaGalassia = new JLabel("Seleziona Galassia:");
		lblSelezionaGalassia.setBounds(10, 11, 113, 25);
		panel.add(lblSelezionaGalassia);
		
		// Etichetta Inserisci RAs
		lblRigaSpettrale = new JLabel("Seleziona Riga Spettrale");
		lblRigaSpettrale.setBounds(156, 11, 128, 25);
		panel.add(lblRigaSpettrale);
		
		// Etichetta Inserisci RDsign
		lblValoreDelRapporto = new JLabel("Valore Del Rapporto ( Flusso Riga / Flusso Continuo): ");
		lblValoreDelRapporto.setBounds(10, 128, 257, 25);
		panel.add(lblValoreDelRapporto);
		// Etichetta Inserisci RDs
		lblValoreFlussoContinuo = new JLabel("Valore Flusso Continuo:");
		lblValoreFlussoContinuo.setBounds(156, 66, 113, 25);
		panel.add(lblValoreFlussoContinuo);
		
		// Bottone Per Ricercare
		btnValueDivision = new JButton("Calcola");
		btnValueDivision.setBounds(279, 95, 70, 25);
		panel.add(btnValueDivision);
		
		// TODO Tabella Nome Galassia | Distanza
		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	

	// Inizializzazione Listener Bottoni
	private void addActionListener() {
		
		btnValueDivision.addActionListener(new ActionListener() {
			
//		@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	private void close(){
		this.setVisible(false);
	}
}
