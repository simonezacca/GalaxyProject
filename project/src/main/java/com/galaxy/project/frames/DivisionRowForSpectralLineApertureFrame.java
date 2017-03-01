package com.galaxy.project.frames;

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

import com.galaxy.project.controller.DivisionRowForSpectralLineController;
import com.galaxy.project.frames.cellrenderer.FluxCellRenderer;
import com.galaxy.project.model.AFlux;
import com.galaxy.project.tools.StatisticsHelper;
	
public class DivisionRowForSpectralLineApertureFrame extends JFrame {
	
	private static final long serialVersionUID = 1L; 
	
	private DivisionRowForSpectralLineController controller = new DivisionRowForSpectralLineController(this);
	
	private final static String titolo = "Valore dei rapporti delle righe per gruppo spettrale";
	private final JPanel panel = new JPanel();
	
	// Dichiarazione Componenti Grafici
	private JLabel lblSelezionaRigaSpettrale;
	private JLabel lblFlusso1;
	private JLabel lblValoreMedio;
	private JLabel lblFlusso2;
	private JButton btnCalcola;
	private JButton btnGruppoSpettrale = new JButton("Seleziona");
	
	private JLabel lblDeviazioneStandard;
	private JLabel lblMediana;
	private JLabel lblDeviazioneMediaAssoluta;
	private JLabel lblValmedio;
	private JLabel lblValdev;
	private JLabel lblValmediana;
	private JLabel lblValdevabs;
	private JComboBox comboBox;
	private JComboBox<String> cbClassificazioneSpettrale;
	private JComboBox<AFlux> cbFlusso1;
	private JComboBox<AFlux> cbFlusso2;
	private JComboBox<String> cbAperture = new JComboBox<String>();
	
	
	public DivisionRowForSpectralLineApertureFrame() {
		
	super(titolo);
	this.setSize(800, 600);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	getContentPane().add(panel);
	placeComponents(panel);
	
	lblDeviazioneStandard = new JLabel("Deviazione Standard:");
	lblDeviazioneStandard.setBounds(10, 229, 166, 25);
	panel.add(lblDeviazioneStandard);
	
	lblMediana = new JLabel("Mediana:");
	lblMediana.setBounds(10, 262, 166, 25);
	panel.add(lblMediana);
	
	lblDeviazioneMediaAssoluta = new JLabel("Deviazione Media Assoluta:");
	lblDeviazioneMediaAssoluta.setBounds(10, 298, 166, 25);
	panel.add(lblDeviazioneMediaAssoluta);
	
	lblValmedio = new JLabel("");
	lblValmedio.setBounds(227, 193, 307, 25);
	panel.add(lblValmedio);
	
	lblValdev = new JLabel("");
	lblValdev.setBounds(227, 229, 307, 25);
	panel.add(lblValdev);
	
	lblValmediana = new JLabel("");
	lblValmediana.setBounds(227, 262, 307, 25);
	panel.add(lblValmediana);
	
	lblValdevabs = new JLabel("");
	lblValdevabs.setBounds(227, 298, 307, 25);
	panel.add(lblValdevabs);
	
	cbClassificazioneSpettrale = new JComboBox();
	cbClassificazioneSpettrale.setBounds(10, 35, 182, 20);
	panel.add(cbClassificazioneSpettrale);
	List<String> csList = controller.getSpectralClassificationFromGalaxy();
	for (String cs : csList) {
		cbClassificazioneSpettrale.addItem(cs);
	}
	
	cbFlusso1 = new JComboBox();
	cbFlusso1.setRenderer(new FluxCellRenderer());
	cbFlusso1.setBounds(10, 90, 116, 20);
	panel.add(cbFlusso1);
	
	cbFlusso2 = new JComboBox();
	cbFlusso2.setRenderer(new FluxCellRenderer());
	cbFlusso2.setBounds(211, 90, 116, 20);
	panel.add(cbFlusso2);
	
	
	btnGruppoSpettrale.setBounds(435, 34, 182, 23);
	panel.add(btnGruppoSpettrale);
	
	JLabel lblAperture = new JLabel("Seleziona Aperture:");
	lblAperture.setBounds(211, 16, 182, 14);
	panel.add(lblAperture);
	
	
	cbAperture.addItem("c");
	cbAperture.addItem("3x3");
	cbAperture.addItem("5x5");
	cbAperture.addItem("LR");
	cbAperture.addItem("HR");
	
	cbAperture.setBounds(211, 35, 182, 20);
	panel.add(cbAperture);
	
	addActionListener(); // Inizializza i Listener dei Bottoni (vedi sotto)
	
	this.setVisible(true);

}

// Posizionamento Componenti Grafici
private void placeComponents(JPanel panel) {

	panel.setLayout(null);

//		Coordinate Spaziali:
//		2MASS Right Ascension 2000 hours
//		2MASS Right Ascension 2000 minutes
//		2MASS Right Ascension 2000 seconds
//		2MASS Right Declination 2000 sign
//		2MASS Right Declination 2000 degrees
//		2MASS Right Declination 2000 minutes
//		2MASS Right Declination 2000 seconds
	

	
	// Etichetta Inserisci RAh
	lblSelezionaRigaSpettrale = new JLabel("Seleziona Gruppo Spettrale:");
	lblSelezionaRigaSpettrale.setBounds(10, 11, 182, 25);
	panel.add(lblSelezionaRigaSpettrale);
	
	// Etichetta Inserisci RAs
	lblFlusso1 = new JLabel("Flusso 1:");
	lblFlusso1.setBounds(10, 66, 116, 25);
	panel.add(lblFlusso1);
	
	// Etichetta Inserisci RDsign
	lblValoreMedio = new JLabel("Valore Medio: ");
	lblValoreMedio.setBounds(10, 193, 166, 25);
	panel.add(lblValoreMedio);
	// Etichetta Inserisci RDs
	lblFlusso2 = new JLabel("Flusso 2:");
	lblFlusso2.setBounds(211, 66, 116, 25);
	panel.add(lblFlusso2);
	
	// Bottone Per Ricercare
	btnCalcola = new JButton("Calcola");
	btnCalcola.setBounds(435, 88, 182, 25);
	panel.add(btnCalcola);
	
	// TODO Tabella Nome Galassia | Distanza
	
}

private void centerFrame() {
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
}


// Inizializzazione Listener Bottoni
private void addActionListener() {
	
	btnGruppoSpettrale.addActionListener(new ActionListener() {
		
//		@Override
			public void actionPerformed(ActionEvent e) {
				String sc = (String) cbClassificazioneSpettrale.getSelectedItem();
				String aperture = (String) cbAperture.getSelectedItem();
				List<AFlux> fluxList = controller.getFluxFromSpectralClassificationAndAperture(sc,aperture);
				cbFlusso1.removeAllItems();
				cbFlusso2.removeAllItems();
				for (AFlux flux : fluxList) {
					cbFlusso1.addItem(flux);
					cbFlusso2.addItem(flux);			
				}
			}
		});
	
	btnCalcola.addActionListener(new ActionListener() {
		
//	@Override
		public void actionPerformed(ActionEvent e) {
			AFlux fl1 = (AFlux) cbFlusso1.getSelectedItem();
			AFlux fl2 = (AFlux) cbFlusso2.getSelectedItem();
			double[] data = {fl1.getFluxValue(),fl2.getFluxValue()};
			StatisticsHelper sh = new StatisticsHelper(data);
			lblValmedio.setText(sh.getMean() +"");
			lblValdev.setText(sh.getStdDev() +"");
			lblValdevabs.setText(sh.getVariance() +"");
			lblValmediana.setText(sh.median() +"");
		}
	});
}

private void close(){
	this.setVisible(false);
}
}