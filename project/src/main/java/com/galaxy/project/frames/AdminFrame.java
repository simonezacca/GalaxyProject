package com.galaxy.project.frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class AdminFrame extends AGenericUserFrame {

	private static final long serialVersionUID = 1L;
	
	RegisterFrame registerFrame = null;
	ImportaFileFrame importaFileFrame = null;
	GalaxySearchFrame galaxySearchFrame = null;
	RadiusGalaxySearchFrame radiusGalaxySearchFrame = null;
	RedshiftGalaxySearchFrame redshiftGalaxySearchFrame = null;
	ValuesSpectralLineFrame valuesSpectralLineFrame = null; 
	DivisionRowFrame divisionRowFrame = null;
	DivisionRowForSpectralLineFrame divisionRowForSpectralLineFrame = null;
	DivisionRowForSpectralLineApertureFrame divisionRowForSpectralLineApertureFrame = null;
	DivisionRowContinuousFluxFrame divisionRowContinuousFluxFrame = null;
	
	private static String titolo = "Pannello di Amministrazione";
	private JPanel panel = new JPanel();
	private JButton btnRegistraNuovoUtente;
	private JButton btnImportaFile;
	private JButton btnRicercaOggettoPerNome;
	private JButton btnRicercaRadius;
	private JButton btnRicercaPerRedshift;
	private JButton btnValoreDelleLinee;
	private JButton btnValoreDeiRapportiDelleRighe;
	private JButton btnValoreDeiRapportiPerGruppo;
	private JButton btnValoreDeiRapportiPerAperture;
	private JButton btnRapportoTraFlusso;
	
	public AdminFrame() {

		super(titolo);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().add(panel);
		placeComponents(panel);
		centerFrame();
		close();
		addActionListener();
		this.setVisible(true);
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}

	private void placeComponents(JPanel panel) {
		panel.setLayout(null);
		btnRegistraNuovoUtente = new JButton("Registra Nuovo Utente");
		btnRegistraNuovoUtente.setBounds(86, 12, 645, 25);
		panel.add(btnRegistraNuovoUtente);
		
		btnImportaFile = new JButton("Importa File");
		btnImportaFile.setBounds(86, 49, 645, 25);
		panel.add(btnImportaFile);
		
		btnRicercaOggettoPerNome = new JButton("Ricerca Oggetto Per Nome");
		btnRicercaOggettoPerNome.setBounds(86, 86, 645, 25);
		panel.add(btnRicercaOggettoPerNome);
		
		btnRicercaRadius = new JButton("Ricerca Oggetto All'Interno Di Un Raggio");
		btnRicercaRadius.setBounds(86, 123, 645, 25);
		panel.add(btnRicercaRadius);
		
		btnRicercaPerRedshift = new JButton("Ricerca Oggetto Per Caratteristiche Fisiche");
		btnRicercaPerRedshift.setBounds(86, 158, 645, 25);
		panel.add(btnRicercaPerRedshift);
		
		btnValoreDelleLinee = new JButton("Valore Delle Linee Spettrali");
		btnValoreDelleLinee.setBounds(86, 192, 645, 25);
		panel.add(btnValoreDelleLinee);
		
		btnValoreDeiRapportiDelleRighe = new JButton("Valore Dei Rapporti Delle Righe");
		btnValoreDeiRapportiDelleRighe.setBounds(86, 228, 645, 25);
		panel.add(btnValoreDeiRapportiDelleRighe);
		
		btnValoreDeiRapportiPerGruppo = new JButton("Valore Dei Rapporti Delle Righe per Gruppo Spettrale");
		btnValoreDeiRapportiPerGruppo.setBounds(86, 264, 645, 25);
		panel.add(btnValoreDeiRapportiPerGruppo);
		
		btnValoreDeiRapportiPerAperture = new JButton("Valore Dei Rapporti Delle Righe Per Gruppo Spettrale Per Una Determinata Aperture");
		btnValoreDeiRapportiPerAperture.setBounds(86, 300, 645, 25);
		panel.add(btnValoreDeiRapportiPerAperture);
		
		btnRapportoTraFlusso = new JButton("Rapporto Tra Flusso e Continuo");
		btnRapportoTraFlusso.setBounds(86, 337, 645, 25);
		panel.add(btnRapportoTraFlusso);


	}

	// Inizializzazione Listener Bottoni
	
	private void addActionListener() {
		
		btnRegistraNuovoUtente.addActionListener(new ActionListener() {
			
//			@Override
			public void actionPerformed(ActionEvent e) {

				registerFrame = new RegisterFrame();
			    registerFrame.setVisible(true);
			    registerFrame.toFront();
			    registerFrame.repaint();
			}
		});
		
		btnImportaFile.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				importaFileFrame = new ImportaFileFrame();
				importaFileFrame.setVisible(true);
				importaFileFrame.toFront();
				importaFileFrame.repaint();
			}
		});
		
		btnRicercaOggettoPerNome.addActionListener(new ActionListener() {
			
//			@Override
			public void actionPerformed(ActionEvent e) {

				galaxySearchFrame = new GalaxySearchFrame();
				galaxySearchFrame.setVisible(true);
				galaxySearchFrame.toFront();
				galaxySearchFrame.repaint();
			}
		});

	btnRicercaRadius.addActionListener(new ActionListener() {
				
	//			@Override
				public void actionPerformed(ActionEvent e) {
	
					radiusGalaxySearchFrame = new RadiusGalaxySearchFrame();
					radiusGalaxySearchFrame.setVisible(true);
					radiusGalaxySearchFrame.toFront();
					radiusGalaxySearchFrame.repaint();
				}
			});

	btnRicercaPerRedshift.addActionListener(new ActionListener() {
		
	//			@Override
				public void actionPerformed(ActionEvent e) {
	
					redshiftGalaxySearchFrame = new RedshiftGalaxySearchFrame();
					redshiftGalaxySearchFrame.setVisible(true);
					redshiftGalaxySearchFrame.toFront();
					redshiftGalaxySearchFrame.repaint();
				}
			});
	
	btnValoreDelleLinee.addActionListener(new ActionListener() {
		
	//			@Override
				public void actionPerformed(ActionEvent e) {
	
					valuesSpectralLineFrame = new ValuesSpectralLineFrame();
					valuesSpectralLineFrame.setVisible(true);
					valuesSpectralLineFrame.toFront();
					valuesSpectralLineFrame.repaint();
				}
			});
	
	btnValoreDeiRapportiDelleRighe.addActionListener(new ActionListener() {
		
	//			@Override
				public void actionPerformed(ActionEvent e) {
	
					divisionRowFrame = new DivisionRowFrame();
					divisionRowFrame.setVisible(true);
					divisionRowFrame.toFront();
					divisionRowFrame.repaint();
				}
			});
	
	btnValoreDeiRapportiPerGruppo.addActionListener(new ActionListener() {
		
	//			@Override
				public void actionPerformed(ActionEvent e) {
	
					divisionRowForSpectralLineFrame = new DivisionRowForSpectralLineFrame();
					divisionRowForSpectralLineFrame.setVisible(true);
					divisionRowForSpectralLineFrame.toFront();
					divisionRowForSpectralLineFrame.repaint();
				}
			});
	
	btnValoreDeiRapportiPerAperture.addActionListener(new ActionListener() {
		
	//			@Override
				public void actionPerformed(ActionEvent e) {
	
					divisionRowForSpectralLineApertureFrame = new DivisionRowForSpectralLineApertureFrame();
					divisionRowForSpectralLineApertureFrame.setVisible(true);
					divisionRowForSpectralLineApertureFrame.toFront();
					divisionRowForSpectralLineApertureFrame.repaint();
				}
			});
	
	btnRapportoTraFlusso.addActionListener(new ActionListener() {
		
	//			@Override
				public void actionPerformed(ActionEvent e) {
	
					divisionRowContinuousFluxFrame = new DivisionRowContinuousFluxFrame();
					divisionRowContinuousFluxFrame.setVisible(true);
					divisionRowContinuousFluxFrame.toFront();
					divisionRowContinuousFluxFrame.repaint();
				}
			});
}
//	

	private void close(){
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent windowEvent) {
		    	Integer risposta = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler chiudere l'applicazione?", "Stai per chiudere l'applicazione", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        if ( risposta == JOptionPane.YES_OPTION) {
		        	 LoginFrame loginFrame = new LoginFrame();
				     loginFrame.setVisible(true);
		        	}
			   
		    }
		});
	}
}
