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
import com.galaxy.project.model.Position;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
	
public class DivisionRowFrame extends JFrame {
	
		private static final long serialVersionUID = 1L; 
		
		private DivisionRowController controller = new DivisionRowController(this);
		
		private final static String titolo = "Ricerca Oggetto all'interno di un raggio";
		private final JPanel panel = new JPanel();
		private Position p = null;
		
		// Dichiarazione Componenti Grafici
		private JLabel lblSelezionaGalassia1;
		private JLabel lblRigaSpettrale1;
		private JLabel lblFlusso1;
		private JLabel lblLimitValue;
		private JLabel lblSelezionaGalassia2;
		private JLabel lblRigaSpettrale2;
		private JLabel lblFlusso2;
		private JButton btnValueDivision;
		private String rah;
		private String ram;
		private String ras;
		private String rdsign;
		private String rdd;
		private String rdm;
		private String rds;
		
		private int positionRAh;
		private int positionRAm;
		private float positionRAs;
		private char positionRDsign;
		private int positionRDd;
		private int positionRDm;
		private float positionRDs;
		private JLabel lblInserisciDati = new JLabel("Inserisci tutti i dati relativi alla posizione:");
		private String[] columns = { "Galassia", "Distanza" };
		private String[][] data = {{"NomeGalassia1", "Distanza1"},
								   {"NomeGalassia2", "Distanza2"}};
		private JComboBox cbGalassia1;
		private JComboBox cbGalassia2;
		private JComboBox cbRigaSpettrale1;
		private JComboBox cbRigaSpettrale2;
		private JComboBox cbFlusso1;
		private JComboBox cbFlusso2;
		
		
		public DivisionRowFrame() {
			
		super(titolo);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(panel);
		placeComponents(panel);
		
		cbGalassia1 = new JComboBox();
		cbGalassia1.setBounds(10, 71, 180, 20);
		panel.add(cbGalassia1);
		
		cbGalassia2 = new JComboBox();
		cbGalassia2.setBounds(10, 132, 180, 20);
		panel.add(cbGalassia2);
		
		cbRigaSpettrale1 = new JComboBox();
		cbRigaSpettrale1.setBounds(288, 71, 94, 20);
		panel.add(cbRigaSpettrale1);
		
		cbRigaSpettrale2 = new JComboBox();
		cbRigaSpettrale2.setBounds(288, 132, 94, 20);
		panel.add(cbRigaSpettrale2);
		
		cbFlusso1 = new JComboBox();
		cbFlusso1.setBounds(484, 71, 94, 20);
		panel.add(cbFlusso1);
		
		cbFlusso2 = new JComboBox();
		cbFlusso2.setBounds(484, 132, 94, 20);
		panel.add(cbFlusso2);
		
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
		
		// Etichetta inserimento dati
		lblInserisciDati.setBounds(10, 12, 352, 15);
		panel.add(lblInserisciDati);
		
		// Etichetta Inserisci RAh
		lblSelezionaGalassia1 = new JLabel("Seleziona Galassia (Numeratore)");
		lblSelezionaGalassia1.setBounds(10, 47, 180, 25);
		panel.add(lblSelezionaGalassia1);

		// Etichetta Inserisci RAm
		lblRigaSpettrale1 = new JLabel("Riga Spettrale:");
		lblRigaSpettrale1.setBounds(288, 47, 120, 25);
		panel.add(lblRigaSpettrale1);
		
		// Etichetta Inserisci RAs
		lblFlusso1 = new JLabel("Flusso:");
		lblFlusso1.setBounds(484, 47, 70, 25);
		panel.add(lblFlusso1);
		
		// Etichetta Inserisci RDsign
		lblLimitValue = new JLabel("Upper o Lower Limit");
		lblLimitValue.setBounds(210, 179, 94, 25);
		panel.add(lblLimitValue);
		
		// Etichetta Inserisci RDd
		lblSelezionaGalassia2 = new JLabel("Seleziona Galassia 2 (Denominatore)");
		lblSelezionaGalassia2.setBounds(10, 102, 180, 25);
		panel.add(lblSelezionaGalassia2);
		// Etichetta Inserisci RDm
		lblRigaSpettrale2 = new JLabel("Riga Spettrale:");
		lblRigaSpettrale2.setBounds(288, 102, 120, 25);
		panel.add(lblRigaSpettrale2);
		// Etichetta Inserisci RDs
		lblFlusso2 = new JLabel("Flusso:");
		lblFlusso2.setBounds(484, 102, 70, 25);
		panel.add(lblFlusso2);
		
		// Bottone Per Ricercare
		btnValueDivision = new JButton("Valore Rapporto");
		btnValueDivision.setBounds(10, 179, 180, 25);
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
