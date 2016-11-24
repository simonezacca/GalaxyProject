package com.galaxy.project.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class UserFrame extends AGenericUserFrame {

	private static final long serialVersionUID = 1L;

	private static String titolo = "Pannello di Amministrazione";
	private JPanel panel = new JPanel();

	public UserFrame() {

		super(titolo);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().add(panel);
		placeComponents(panel);
		
		JButton btnRicercaOggettoPer = new JButton("Ricerca Oggetto Per Nome");
		btnRicercaOggettoPer.setBounds(86, 12, 645, 25);
		panel.add(btnRicercaOggettoPer);
		
		JButton btnRicercaOggettoAllinterno = new JButton("Ricerca Oggetto All'Interno Di Un Raggio");
		btnRicercaOggettoAllinterno.setBounds(86, 49, 645, 25);
		panel.add(btnRicercaOggettoAllinterno);
		
		JButton btnRicercaOggettoPer_1 = new JButton("Ricerca Oggetto Per Caratteristiche Fisiche");
		btnRicercaOggettoPer_1.setBounds(86, 84, 645, 25);
		panel.add(btnRicercaOggettoPer_1);
		
		JButton btnValoreDelleLinee = new JButton("Valore Delle Linee Spettrali");
		btnValoreDelleLinee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValoreDelleLinee.setBounds(86, 118, 645, 25);
		panel.add(btnValoreDelleLinee);
		
		JButton btnValoreDeiRapporti = new JButton("Valore Dei Rapporti Delle Righe");
		btnValoreDeiRapporti.setBounds(86, 151, 645, 25);
		panel.add(btnValoreDeiRapporti);
		
		JButton btnValoreDeiRapporti_1 = new JButton("Valore Dei Rapporti Delle Righe Per Gruppo Spettrale");
		btnValoreDeiRapporti_1.setBounds(86, 185, 645, 25);
		panel.add(btnValoreDeiRapporti_1);
		
		JButton btnRapportoTraFlusso = new JButton("Rapporto Tra Flusso e Continuo");
		btnRapportoTraFlusso.setBounds(86, 222, 645, 25);
		panel.add(btnRapportoTraFlusso);
		close();

		this.setVisible(true);
	}
	


	private void placeComponents(JPanel panel) {
		panel.setLayout(null);

	}

//	private class GestioneServiziListener implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			@SuppressWarnings("unused")
//			ServicesFrame sf = new ServicesFrame();
//		}
//	}
//
//	private class ConsultaLogListener implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			@SuppressWarnings("unused")
//			LogFrame lf = new LogFrame();
//		}
//	}

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
