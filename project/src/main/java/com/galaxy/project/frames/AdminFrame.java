package com.galaxy.project.frames;

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
	private static String titolo = "Pannello di Amministrazione";
	private JPanel panel = new JPanel();
	private JButton btnRegistraNuovoUtente;
	private JButton btnImportaFile;
	private JButton btnRicercaOggettoPer;
	private JButton btnRicercaOggettoAllinterno;
	private JButton btnRicercaOggettoPer_1;
	private JButton btnValoreDelleLinee;
	private JButton btnValoreDeiRapporti;
	private JButton btnValoreDeiRapporti_1;
	private JButton btnRapportoTraFlusso;
	
	public AdminFrame() {

		super(titolo);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().add(panel);
		placeComponents(panel);
		close();
		addActionListener();
		this.setVisible(true);
	}
	
	private void placeComponents(JPanel panel) {
		panel.setLayout(null);
		btnRegistraNuovoUtente = new JButton("Registra Nuovo Utente");
		btnRegistraNuovoUtente.setBounds(86, 12, 645, 25);
		panel.add(btnRegistraNuovoUtente);
		
		btnImportaFile = new JButton("Importa File");
		btnImportaFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImportaFile.setBounds(86, 49, 645, 25);
		panel.add(btnImportaFile);
		
		btnRicercaOggettoPer = new JButton("Ricerca Oggetto Per Nome");
		btnRicercaOggettoPer.setBounds(86, 86, 645, 25);
		panel.add(btnRicercaOggettoPer);
		
		btnRicercaOggettoAllinterno = new JButton("Ricerca Oggetto All'Interno Di Un Raggio");
		btnRicercaOggettoAllinterno.setBounds(86, 123, 645, 25);
		panel.add(btnRicercaOggettoAllinterno);
		
		btnRicercaOggettoPer_1 = new JButton("Ricerca Oggetto Per Caratteristiche Fisiche");
		btnRicercaOggettoPer_1.setBounds(86, 158, 645, 25);
		panel.add(btnRicercaOggettoPer_1);
		
		btnValoreDelleLinee = new JButton("Valore Delle Linee Spettrali");
		btnValoreDelleLinee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValoreDelleLinee.setBounds(86, 192, 645, 25);
		panel.add(btnValoreDelleLinee);
		
		btnValoreDeiRapporti = new JButton("Valore Dei Rapporti Delle Righe");
		btnValoreDeiRapporti.setBounds(86, 225, 645, 25);
		panel.add(btnValoreDeiRapporti);
		
		btnValoreDeiRapporti_1 = new JButton("Valore Dei Rapporti Delle Righe Per Gruppo Spettrale");
		btnValoreDeiRapporti_1.setBounds(86, 259, 645, 25);
		panel.add(btnValoreDeiRapporti_1);
		
		btnRapportoTraFlusso = new JButton("Rapporto Tra Flusso e Continuo");
		btnRapportoTraFlusso.setBounds(86, 296, 645, 25);
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
		
	}

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
