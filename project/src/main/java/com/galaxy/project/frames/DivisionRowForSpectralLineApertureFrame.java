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
import com.galaxy.project.controller.DivisionRowController;
import com.galaxy.project.controller.DivisionRowForSpectralLineController;
import com.galaxy.project.model.Position;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
	
public class DivisionRowForSpectralLineApertureFrame extends JFrame {
	
		private static final long serialVersionUID = 1L; 
		
		private DivisionRowForSpectralLineController controller = new DivisionRowForSpectralLineController(this);
		
		private final static String titolo = "Valore dei rapporti delle righe per gruppo spettrale per aperture";
		private final JPanel panel = new JPanel();
		
		// Dichiarazione Componenti Grafici
		private JLabel lblSelezionaRigaSpettrale;
		private JLabel lblFlusso1;
		private JLabel lblValoreMedio;
		private JLabel lblFlusso2;
		private JButton btnValueDivision;
		private JLabel lblAperture;
		private JLabel lblDeviazioneStandard;
		private JLabel lblMediana;
		private JLabel lblDeviazioneMediaAssoluta;
		private JLabel lblValmedio;
		private JLabel lblValdev;
		private JLabel lblValmediana;
		private JLabel lblValdevabs;
		private JComboBox comboBox;
		private JComboBox cbRigaSpettrale;
		private JComboBox cbFlusso1;
		private JComboBox cbFlusso2;
		
		private JComboBox cbAperture;
		
		
		public DivisionRowForSpectralLineApertureFrame() {
			
		super(titolo);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(panel);
		placeComponents(panel);
		
		lblDeviazioneStandard = new JLabel("Deviazione Standard:");
		lblDeviazioneStandard.setBounds(10, 229, 113, 25);
		panel.add(lblDeviazioneStandard);
		
		lblMediana = new JLabel("Mediana:");
		lblMediana.setBounds(10, 262, 70, 25);
		panel.add(lblMediana);
		
		lblDeviazioneMediaAssoluta = new JLabel("Deviazione Media Assoluta:");
		lblDeviazioneMediaAssoluta.setBounds(10, 298, 136, 25);
		panel.add(lblDeviazioneMediaAssoluta);
		
		lblValmedio = new JLabel("ValMedio");
		lblValmedio.setBounds(156, 193, 70, 25);
		panel.add(lblValmedio);
		
		lblValdev = new JLabel("ValDev");
		lblValdev.setBounds(156, 229, 70, 25);
		panel.add(lblValdev);
		
		lblValmediana = new JLabel("ValMediana");
		lblValmediana.setBounds(156, 262, 70, 25);
		panel.add(lblValmediana);
		
		lblValdevabs = new JLabel("ValDevAbs");
		lblValdevabs.setBounds(156, 298, 70, 25);
		panel.add(lblValdevabs);
		
		cbRigaSpettrale = new JComboBox();
		cbRigaSpettrale.setBounds(10, 35, 113, 20);
		panel.add(cbRigaSpettrale);
		
		cbFlusso1 = new JComboBox();
		cbFlusso1.setBounds(156, 35, 70, 20);
		panel.add(cbFlusso1);
		
		cbFlusso2 = new JComboBox();
		cbFlusso2.setBounds(156, 97, 70, 20);
		panel.add(cbFlusso2);
		
		lblAperture = new JLabel("Aperture:");
		lblAperture.setBounds(10, 66, 70, 25);
		panel.add(lblAperture);
		
		cbAperture = new JComboBox();
		cbAperture.setBounds(10, 97, 113, 20);
		panel.add(cbAperture);
		
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
		lblSelezionaRigaSpettrale = new JLabel("Seleziona Riga Spettrale");
		lblSelezionaRigaSpettrale.setBounds(10, 11, 180, 25);
		panel.add(lblSelezionaRigaSpettrale);
		
		// Etichetta Inserisci RAs
		lblFlusso1 = new JLabel("Flusso 1:");
		lblFlusso1.setBounds(156, 11, 70, 25);
		panel.add(lblFlusso1);
		
		// Etichetta Inserisci RDsign
		lblValoreMedio = new JLabel("Valore Medio: ");
		lblValoreMedio.setBounds(10, 193, 70, 25);
		panel.add(lblValoreMedio);
		// Etichetta Inserisci RDs
		lblFlusso2 = new JLabel("Flusso 2:");
		lblFlusso2.setBounds(156, 66, 70, 25);
		panel.add(lblFlusso2);
		
		// Bottone Per Ricercare
		btnValueDivision = new JButton("Calcola");
		btnValueDivision.setBounds(156, 145, 70, 25);
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
