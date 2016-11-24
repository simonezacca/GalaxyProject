package com.galaxy.project.frames;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImportaFileFrame extends JFrame {

	private static final long serialVersionUID = 1L; 
	
	private final static String titolo = "Importa Nuovo File";
	private final JPanel panel = new JPanel();
	
	// Dichiarazione Componenti Grafici
	private JLabel selezionaFileLabel;
	private JButton btnImportaFile;
	

	public ImportaFileFrame() {
		super(titolo);	
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(panel);
		placeComponents(panel);
		
		JLabel lblSelezionaFile = new JLabel("Seleziona File:");
		lblSelezionaFile.setBounds(20, 10, 200, 50);
		panel.add(lblSelezionaFile);
		
		
		centerFrame();
//		addActionListener(); // Inizializza i Listener dei Bottoni (vedi sotto)
		
		this.setVisible(true);

	}

	// Posizionamento Componenti Grafici
	private void placeComponents(JPanel panel) {

		panel.setLayout(null);

		// Etichetta Utente
//		selezionaFileLabel = new JLabel("Seleziona File:");
//		selezionaFileLabel.setBounds(10, 10, 80, 25);
//		panel.add(selezionaFileLabel);

		// Bottone Per Registrarsi
		btnImportaFile = new JButton("Importa");
		btnImportaFile.setBounds(194, 77, 160, 25);
		panel.add(btnImportaFile);
		
		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	
//	private void updateFields(){
//	}
	
	// Inizializzazione Listener Bottoni
//	private void addActionListener() {
//		
//		btnImportaFile.addActionListener(new ActionListener() {
//			
////		@Override
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//	}
	
	private void close(){		
		this.setVisible(false);
	}
}
