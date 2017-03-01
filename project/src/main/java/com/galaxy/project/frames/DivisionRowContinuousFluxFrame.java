package com.galaxy.project.frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.hibernate.Query;
import org.hibernate.Session;

import com.galaxy.project.controller.DivisionRowContinuousFluxController;
import com.galaxy.project.frames.cellrenderer.FluxCellRenderer;
import com.galaxy.project.frames.cellrenderer.GalaxyCellRenderer;
import com.galaxy.project.model.AFlux;
import com.galaxy.project.model.ContinuousFlux;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.RowFlux;
import com.galaxy.project.model.SpectralLine;
import com.galaxy.project.persistence.GalaxyDAO;
	
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
		private JButton btnValueDivision = new JButton("Calcola");
		private JButton btnSelezionaGalassia;
		private JButton btnSelezionaRigaSpettrale;
		private JComboBox<Galaxy> cbGalaxies;
		private JComboBox<SpectralLine> cbRigaSpettrale;
		private JComboBox<ContinuousFlux> cbFlussoContinuo;
		private JComboBox<RowFlux> cbFlussoRiga;
		private JLabel lblValoreFlussoRiga;
		private JLabel lblDivisionvalue = new JLabel("DivisionValue");
		private Galaxy selectedGalaxy = null;
		private SpectralLine selectedSpectralLine = null;
		
		
		
		public DivisionRowContinuousFluxFrame() {
			
		super(titolo);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(panel);
		placeComponents(panel);
		
		List<Galaxy> galaxies = controller.getListaGalassie();

		cbGalaxies = new JComboBox<Galaxy>(); //new JComboBox(lista Galassie)
		cbGalaxies.setRenderer(new GalaxyCellRenderer());
		for (Galaxy g : galaxies) {
				cbGalaxies.addItem(g);
		}
				
		cbGalaxies.setForeground(new Color(0, 0, 0));
		cbGalaxies.setBounds(10, 35, 154, 20);
		cbGalaxies.setToolTipText("");
		panel.add(cbGalaxies);
		
		cbRigaSpettrale = new JComboBox<SpectralLine>();
		cbRigaSpettrale.setBounds(318, 35, 150, 20);
		panel.add(cbRigaSpettrale);
		
		cbFlussoContinuo = new JComboBox();
		cbFlussoContinuo.setRenderer(new FluxCellRenderer());
		cbFlussoContinuo.setBounds(191, 97, 150, 20);
		panel.add(cbFlussoContinuo);
		
		lblValoreFlussoRiga = new JLabel("Valore Flusso Riga: ");
		lblValoreFlussoRiga.setBounds(10, 66, 154, 25);
		panel.add(lblValoreFlussoRiga);
		
		cbFlussoRiga = new JComboBox();
		cbFlussoRiga.setRenderer(new FluxCellRenderer());
		cbFlussoRiga.setBounds(10, 97, 154, 20);
		panel.add(cbFlussoRiga);
		
		
		lblDivisionvalue.setBounds(373, 133, 95, 14);
		panel.add(lblDivisionvalue);
		
		btnSelezionaGalassia = new JButton("Seleziona");
		btnSelezionaGalassia.setBounds(174, 34, 134, 23);
		panel.add(btnSelezionaGalassia);
		
		btnSelezionaRigaSpettrale = new JButton("Seleziona");
		btnSelezionaRigaSpettrale.setBounds(478, 34, 134, 23);
		panel.add(btnSelezionaRigaSpettrale);
		
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
		lblSelezionaGalassia.setBounds(10, 11, 298, 25);
		panel.add(lblSelezionaGalassia);
		
		// Etichetta Inserisci RAs
		lblRigaSpettrale = new JLabel("Seleziona Riga Spettrale");
		lblRigaSpettrale.setBounds(318, 11, 150, 25);
		panel.add(lblRigaSpettrale);
		
		// Etichetta Inserisci RDsign
		lblValoreDelRapporto = new JLabel("Valore Del Rapporto ( Flusso Riga / Flusso Continuo): ");
		lblValoreDelRapporto.setBounds(10, 128, 331, 25);
		panel.add(lblValoreDelRapporto);
		// Etichetta Inserisci RDs
		lblValoreFlussoContinuo = new JLabel("Valore Flusso Continuo:");
		lblValoreFlussoContinuo.setBounds(191, 66, 150, 25);
		panel.add(lblValoreFlussoContinuo);
		
		// Bottone Per Ricercare
		btnValueDivision.setBounds(373, 95, 95, 25);
		panel.add(btnValueDivision);
		
		// TODO Tabella Nome Galassia | Distanza
		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	

	// Inizializzazione Listener Bottoni
	private void addActionListener() {
		
		btnSelezionaGalassia.addActionListener(new ActionListener() {
			
//			@Override
				public void actionPerformed(ActionEvent e) {
					Galaxy g = (Galaxy) cbGalaxies.getSelectedItem();
					selectedGalaxy = g;
					List<SpectralLine> slList = controller.getSpectralLineFromGalaxy(g);
					cbRigaSpettrale.removeAllItems();
					for (SpectralLine sl : slList) {
						cbRigaSpettrale.addItem(sl);
					}					
				}
			});
		
			btnSelezionaRigaSpettrale.addActionListener(new ActionListener() {
			
//			@Override
				public void actionPerformed(ActionEvent e) {
					SpectralLine sl = (SpectralLine) cbRigaSpettrale.getSelectedItem();
					selectedSpectralLine = sl;
					List<RowFlux> fList = controller.getRowFluxFromSpectralLine(selectedGalaxy, selectedSpectralLine);
					cbFlussoRiga.removeAllItems();
					for (RowFlux f : fList) {
						cbFlussoRiga.addItem(f);
					}
					
					List<ContinuousFlux> fcList = controller.getContinuousFluxFromSpectralLine(selectedGalaxy, selectedSpectralLine);
					cbFlussoContinuo.removeAllItems();
					for (ContinuousFlux fc : fcList) {
						cbFlussoContinuo.addItem(fc);
					}
				}
			});
		
		btnValueDivision.addActionListener(new ActionListener() {
			
//		@Override
			public void actionPerformed(ActionEvent e) {
				RowFlux rf = (RowFlux) cbFlussoRiga.getSelectedItem();
				ContinuousFlux cf = (ContinuousFlux) cbFlussoContinuo.getSelectedItem();
				float result = controller.getValueFromDivision(rf, cf);
				lblDivisionvalue.setText(result + ""); 
			}
		});
	}
	
	private void close(){
		this.setVisible(false);
	}
}
