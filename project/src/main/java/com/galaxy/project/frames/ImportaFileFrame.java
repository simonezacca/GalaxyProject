package com.galaxy.project.frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.galaxy.project.model.AFlux;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.parser2.CSVParsingController;
import com.galaxy.project.parser2.csvparser.ApertureFluxCSVParser;
import com.galaxy.project.parser2.csvparser.ContinousRowFluxCSVParser;
import com.galaxy.project.parser2.csvparser.GalaxyCSVParser;
import com.galaxy.project.parser2.csvparser.RowFluxCSVParser;
import com.galaxy.project.parser2.csvparser.RowFluxSpitzerCSVParser;
import com.galaxy.project.persistence.GalaxyDAO;

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
	private final JLabel labelErroreGalassia = new JLabel("");
	
	public ImportaFileFrame() {
		super(titolo);	
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		labelErroreGalassia.setBounds(12, 354, 514, 15);
		panel.add(labelErroreGalassia);
		
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
	          System.out.println(selectedFile.getAbsolutePath());
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
				String galaxyCSVFile = fieldPathGalassia.getText();
				String rowFluxCSVFile = fieldPathRigheHerschel.getText();
				String rowFluxSpitzerCSVFile = fieldPathRigheSpitzer.getText();
				String continousRowFluxCSVFile = fieldPathContinuoHerschel.getText();
				String apertureRowFluxCSVFile = fieldPathRighePerAperture.getText();
				
				GalaxyCSVParser galaxyParser = null;
				RowFluxCSVParser rowFluxParser = null;
				RowFluxSpitzerCSVParser spitzerParser = null;
				ContinousRowFluxCSVParser continousParser = null;
				ApertureFluxCSVParser apertureParser = null;
				
				CSVParsingController controller = new CSVParsingController();
				
				if(galaxyCSVFile.length()>0) {
					galaxyParser = new GalaxyCSVParser(galaxyCSVFile);
				}
				else {
					labelErroreGalassia.setForeground(Color.red);;
					labelErroreGalassia.setText("Inserire il file relativo alle galassie");
				}
				// instazione i vari parser dei CSV fornendo il percorso di ogni file
				
				if(rowFluxCSVFile.length()>0) {
					rowFluxParser = new RowFluxCSVParser(rowFluxCSVFile);
				}
				if(rowFluxSpitzerCSVFile.length()>0) {
					spitzerParser = new RowFluxSpitzerCSVParser(rowFluxSpitzerCSVFile);
				}
				if(continousRowFluxCSVFile.length()>0) {
					continousParser = new ContinousRowFluxCSVParser(continousRowFluxCSVFile);
				}
				if(apertureRowFluxCSVFile.length()>0) {
					apertureParser = new ApertureFluxCSVParser(apertureRowFluxCSVFile);
				} 

				// associo i vari parser creati al controller
				controller.setGalaxyParser(galaxyParser);
				controller.setRowFluxParser(rowFluxParser);
				controller.setSpitzerParser(spitzerParser);
				controller.setContinousParser(continousParser);
				controller.setApertureParser(apertureParser);
				
				Map<String, Galaxy> map = null;
				try {
					map = controller.parseAndLink();
				} catch (IllegalStateException | IOException e1) {
					e1.printStackTrace();
				}
				
				// TEST PERSISTENZA
				
				System.out.println("TEST PERSISTENZA");
				
				GalaxyDAO gdao = new GalaxyDAO();
				for (Iterator<Entry<String, Galaxy>> iter = map.entrySet().iterator(); iter.hasNext();) {
					Entry<String,Galaxy> entry = iter.next();
					
					String gKey = entry.getKey();
					Galaxy gModel = entry.getValue();
					gdao.saveOrUpdate(gModel);
				}
				
			}
		});
			
	}
	
	private void close(){		
		this.setVisible(false);
	}
}
