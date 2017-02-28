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

import com.galaxy.project.controller.DivisionRowController;
import com.galaxy.project.frames.cellrenderer.FluxCellRenderer;
import com.galaxy.project.frames.cellrenderer.GalaxyCellRenderer;
import com.galaxy.project.model.AFlux;
import com.galaxy.project.model.Galaxy;
	
public class DivisionRowFrame extends JFrame {
	
		private static final long serialVersionUID = 1L; 
		
		private DivisionRowController controller = new DivisionRowController(this);
		
		private final static String titolo = "Valore dei rapporti delle righe";
		private final JPanel panel = new JPanel();
		
		// Dichiarazione Componenti Grafici
		private JLabel lblSelezionaGalassia1;
		private JLabel lblFlusso1;
		private JLabel lblLimitValue;
		private JLabel lblSelezionaGalassia2;
		private JLabel lblFlusso2;
		private JButton btnValueDivision;
		private JButton btnGalassiaNumeratore;
		private JButton btnGalassiaDenominatore;
		
		private JLabel lblInserisciDati = new JLabel("Inserisci tutti i dati relativi alla posizione:");
		
		private JComboBox<Galaxy> cbGalassia1;
		private JComboBox<Galaxy> cbGalassia2;
		private JComboBox<AFlux> cbFlussoNumeratore;
		private JComboBox<AFlux> cbFlussoDenominatore;
		
		
		public DivisionRowFrame() {
			
		super(titolo);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(panel);
		placeComponents(panel);
		
		List<Galaxy> galaxies = controller.getListaGalassie();

		cbGalassia1 = new JComboBox<Galaxy>(); 
		cbGalassia1.setRenderer(new GalaxyCellRenderer());
		for (Galaxy g : galaxies) {
				cbGalassia1.addItem(g);;
		}
		cbGalassia1.setBounds(10, 71, 226, 20);
		panel.add(cbGalassia1);
		
		cbGalassia2 = new JComboBox<Galaxy>();
		cbGalassia2.setRenderer(new GalaxyCellRenderer());
		for (Galaxy g : galaxies) {
				cbGalassia2.addItem(g);
		}
		cbGalassia2.setBounds(10, 142, 226, 20);
		panel.add(cbGalassia2);
		
		cbFlussoNumeratore = new JComboBox<AFlux>();
		cbFlussoNumeratore.setRenderer(new FluxCellRenderer());
		cbFlussoNumeratore.setBounds(370, 71, 226, 20);
		panel.add(cbFlussoNumeratore);
		
		cbFlussoDenominatore = new JComboBox<AFlux>();
		cbFlussoDenominatore.setRenderer(new FluxCellRenderer());
		cbFlussoDenominatore.setBounds(370, 142, 226, 20);
		panel.add(cbFlussoDenominatore);
		
		btnGalassiaNumeratore = new JButton("Seleziona");
		btnGalassiaNumeratore.setBounds(246, 70, 89, 23);
		panel.add(btnGalassiaNumeratore);
		
		btnGalassiaDenominatore = new JButton("Seleziona");
		btnGalassiaDenominatore.setBounds(246, 141, 89, 23);
		panel.add(btnGalassiaDenominatore);
		
		centerFrame();
		addActionListener(); // Inizializza i Listener dei Bottoni (vedi sotto)
		
		this.setVisible(true);

	}
	
	// Posizionamento Componenti Grafici
	private void placeComponents(JPanel panel) {

		panel.setLayout(null);
		
		lblInserisciDati.setBounds(10, 12, 352, 15);
		panel.add(lblInserisciDati);
		
		lblSelezionaGalassia1 = new JLabel("Seleziona Galassia (Numeratore)");
		lblSelezionaGalassia1.setBounds(10, 47, 279, 25);
		panel.add(lblSelezionaGalassia1);
		
		lblFlusso1 = new JLabel("Flusso:");
		lblFlusso1.setBounds(370, 47, 70, 25);
		panel.add(lblFlusso1);
		
		lblLimitValue = new JLabel("");
		lblLimitValue.setBounds(214, 205, 382, 25);
		panel.add(lblLimitValue);
		
		lblSelezionaGalassia2 = new JLabel("Seleziona Galassia 2 (Denominatore)");
		lblSelezionaGalassia2.setBounds(10, 112, 279, 25);
		panel.add(lblSelezionaGalassia2);

		lblFlusso2 = new JLabel("Flusso:");
		lblFlusso2.setBounds(370, 112, 70, 25);
		panel.add(lblFlusso2);
		
		btnValueDivision = new JButton("Valore Rapporto");
		btnValueDivision.setBounds(10, 205, 180, 25);
		panel.add(btnValueDivision);
			
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	

	// Inizializzazione Listener Bottoni
	private void addActionListener() {
		
		btnGalassiaNumeratore.addActionListener(new ActionListener() {
			
//			@Override
				public void actionPerformed(ActionEvent e) {
					Galaxy g1 = (Galaxy) cbGalassia1.getSelectedItem();
					System.out.println(cbGalassia1.getSelectedItem());
					cbFlussoNumeratore.removeAllItems();
					for (AFlux f : g1.getFluxes()) {
							System.out.println(f);
							cbFlussoNumeratore.addItem(f);
					}
				}
			});
		
		btnGalassiaDenominatore.addActionListener(new ActionListener() {
			
//			@Override
				public void actionPerformed(ActionEvent e) {
					Galaxy g2 = (Galaxy) cbGalassia2.getSelectedItem();
					System.out.println(cbGalassia2.getSelectedItem());
					cbFlussoDenominatore.removeAllItems();
					for (AFlux f : g2.getFluxes()) {
							System.out.println(f);
							cbFlussoDenominatore.addItem(f);
					}	
				}
			});
		
		btnValueDivision.addActionListener(new ActionListener() {
			
//		@Override
			public void actionPerformed(ActionEvent e) {
				AFlux flussoNumeratore = (AFlux) cbFlussoNumeratore.getSelectedItem();
				AFlux flussoDenominatore = (AFlux) cbFlussoDenominatore.getSelectedItem();	
				if (flussoNumeratore.isLimitFlag() == true) {
					lblLimitValue.setText("Upper Limit");
				}
				if (flussoDenominatore.isLimitFlag() == true) {
					lblLimitValue.setText("Lower Limit");
				}
				if (flussoNumeratore.isLimitFlag() == false && flussoDenominatore.isLimitFlag() == false) {
					lblLimitValue.setText("Entrambi non hanno limite");
				}
			}
		});
	}
	
	private void close(){
		this.setVisible(false);
	}
}
