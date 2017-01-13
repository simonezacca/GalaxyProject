package com.galaxy.project.frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ImportaFileFrame extends JFrame {

	private static final long serialVersionUID = 1L; 
	
	private final static String titolo = "Importa Nuovo File";
	private final JPanel panel = new JPanel();
	private final JTextField fieldPathGalassia = new JTextField();
	private final JTextField fieldPathRigheHerschel = new JTextField();
	private final JTextField fieldPathContinuoHerschel = new JTextField();
	private final JTextField fieldPathRigheSpitzer = new JTextField();
	private final JTextField fieldPathRighePerAperture = new JTextField();
	private final JButton btnFileGalassia = new JButton("Seleziona");
	private final JButton btnFileFlussoRigheHerschel = new JButton("Seleziona");
	private final JButton btnFileFlussoContinuoHerschel = new JButton("Seleziona");
	private final JButton btnFileFlussoRigheSpitzer = new JButton("Seleziona");
	private final JButton btnFileFlussoRighePerAperture = new JButton("Seleziona");
	private final JButton btnImportaFile = new JButton("Importa");
	private final JLabel labelGalassie = new JLabel("Inserire CSV relativo alle Galassie:");
	private final JLabel labelFlussoRigheHerschel = new JLabel("Inserire CSV dei flussi delle righe di Herschel/PACS");
	private final JLabel labelFlussoContinuoHerschel = new JLabel("Inserire CSV del flusso continuo di Herschel/PACS");
	private final JLabel labelFlussoRigheSpitzer = new JLabel("Inserire CSV dei flussi delle righe di Spitzer");
	private final JLabel labelFlussoRigheApertureHerschel = new JLabel("Inserire CSV dei flussi delle righe di Herschel/PACS per tutte le Aperture");
	
	public ImportaFileFrame() {
		super(titolo);	
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(panel);
		placeComponents(panel);
		centerFrame();
		addActionListener(); // Inizializza i Listener dei Bottoni (vedi sotto)
		this.setVisible(true);

	}

	// Posizionamento Componenti Grafici
	private void placeComponents(JPanel panel) {

		panel.setLayout(null);
		
		// Bottone Importa
		btnImportaFile.setBounds(544, 349, 102, 25);
		panel.add(btnImportaFile);
		
		// Bottoni Inserisci
		
		btnFileGalassia.setBounds(12, 41, 113, 25);
		panel.add(btnFileGalassia);
		
		btnFileFlussoRigheHerschel.setBounds(12, 109, 113, 25);
		panel.add(btnFileFlussoRigheHerschel);
		
		btnFileFlussoContinuoHerschel.setBounds(12, 173, 113, 25);
		panel.add(btnFileFlussoContinuoHerschel);
		
		btnFileFlussoRigheSpitzer.setBounds(12, 237, 113, 25);
		panel.add(btnFileFlussoRigheSpitzer);
		
		btnFileFlussoRighePerAperture.setBounds(12, 301, 113, 25);
		panel.add(btnFileFlussoRighePerAperture);
		
		labelGalassie.setBounds(12, 12, 312, 15);
		panel.add(labelGalassie);

		labelFlussoRigheHerschel.setBounds(12, 82, 465, 15);
		panel.add(labelFlussoRigheHerschel);
		
		labelFlussoContinuoHerschel.setBounds(12, 146, 416, 15);
		panel.add(labelFlussoContinuoHerschel);
		
		labelFlussoRigheSpitzer.setBounds(12, 210, 312, 15);
		panel.add(labelFlussoRigheSpitzer);
		
		labelFlussoRigheApertureHerschel.setBounds(12, 274, 526, 15);
		panel.add(labelFlussoRigheApertureHerschel);

		fieldPathGalassia.setBounds(137, 44, 509, 19);
		panel.add(fieldPathGalassia);
		fieldPathGalassia.setColumns(10);
		
		fieldPathRigheHerschel.setBounds(137, 112, 509, 19);
		panel.add(fieldPathRigheHerschel);
		fieldPathRigheHerschel.setColumns(10);
		
		fieldPathContinuoHerschel.setBounds(137, 176, 509, 19);
		panel.add(fieldPathContinuoHerschel);
		fieldPathContinuoHerschel.setColumns(10);
		
		fieldPathRigheSpitzer.setBounds(137, 240, 509, 19);
		panel.add(fieldPathRigheSpitzer);
		fieldPathRigheSpitzer.setColumns(10);
		
		fieldPathRighePerAperture.setBounds(137, 304, 509, 19);
		panel.add(fieldPathRighePerAperture);
		fieldPathRighePerAperture.setColumns(10);
		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	
//	private void updateFields(){
//	}
	
	// Inizializzazione Listener Bottoni
	private void addActionListener() {
		
		btnFileGalassia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
	          File selectedFile = fileChooser.getSelectedFile();
	          System.out.println(selectedFile.getName());
	          fieldPathGalassia.setText(selectedFile.getAbsolutePath());
		        }
			}
		});
		
		btnFileFlussoRigheHerschel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
	          File selectedFile = fileChooser.getSelectedFile();
	          System.out.println(selectedFile.getName());
	          fieldPathRigheHerschel.setText(selectedFile.getAbsolutePath());
		        }
			}
		});

		btnFileFlussoContinuoHerschel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
	          File selectedFile = fileChooser.getSelectedFile();
	          System.out.println(selectedFile.getName());
	          fieldPathContinuoHerschel.setText(selectedFile.getAbsolutePath());
		        }
			}
		});
		
		btnFileFlussoRigheSpitzer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
	          File selectedFile = fileChooser.getSelectedFile();
	          System.out.println(selectedFile.getName());
	          fieldPathRigheSpitzer.setText(selectedFile.getAbsolutePath());
		        }
			}
		});
		
		btnFileFlussoRighePerAperture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
	          File selectedFile = fileChooser.getSelectedFile();
	          System.out.println(selectedFile.getName());
	          fieldPathRighePerAperture.setText(selectedFile.getAbsolutePath());
		        }
			}
		});
		
		btnImportaFile.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO DA IMPLEMENTARE
			}
		});
			
	}
	
	private void close(){		
		this.setVisible(false);
	}
}
