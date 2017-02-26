package com.galaxy.project.frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.galaxy.project.controller.RedshiftGalaxySearchFrameController;
import com.galaxy.project.frames.tablemodel.RedshiftGalaxyTableModel;
import com.galaxy.project.model.Galaxy;
	
public class RedshiftGalaxySearchFrame extends JFrame {
	
		private static final long serialVersionUID = 1L; 
		
		private RedshiftGalaxySearchFrameController controller = new RedshiftGalaxySearchFrameController(this);
		
		private final static String titolo = "Ricerca Oggetto con valore maggiore/uguale o minore/uguale a redshift";
		private final JPanel panel = new JPanel();
		
		// Dichiarazione Componenti Grafici

		private JLabel searchForGreaterRedshiftLabel;
		private JLabel searchForLowerRedshiftLabel;
		private JTextField greaterRedshiftField;
		private JTextField lowerRedshiftField;
		private JButton btnSearchGalaxyForGreaterRedshift;
		private JButton btnSearchGalaxyForLowerRedshift;
		private JTable tableGalassiaRedshift = new JTable();

		private String greaterRedshift,lowerRedshift;
		private float gRedshift,lRedshift;
		public RedshiftGalaxySearchFrame() {
			
		super(titolo);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(panel);
		placeComponents(panel);
		
		tableGalassiaRedshift = new JTable(null);
		tableGalassiaRedshift.setBounds(52, 159, 533, 350);
		tableGalassiaRedshift.setPreferredScrollableViewportSize(new Dimension(450,63));
		tableGalassiaRedshift.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(tableGalassiaRedshift);
		scrollPane.setBounds(10, 123, 672, 386);
		panel.add(scrollPane);
		
		centerFrame();
		addActionListener(); 
		
		this.setVisible(true);

	}

	// Posizionamento Componenti Grafici
	private void placeComponents(JPanel panel) {

		panel.setLayout(null);

		searchForGreaterRedshiftLabel = new JLabel("Ricerca per valori maggiori/uguali di redshift:");
		searchForGreaterRedshiftLabel.setBounds(10, 10, 324, 25);
		panel.add(searchForGreaterRedshiftLabel);

		searchForLowerRedshiftLabel = new JLabel("Ricerca per valori minori/uguali di redshift:");
		searchForLowerRedshiftLabel.setBounds(10, 63, 324, 25);
		panel.add(searchForLowerRedshiftLabel);
		
		greaterRedshiftField = new JTextField(20);
		greaterRedshiftField.setBounds(340, 10, 160, 25);
		panel.add(greaterRedshiftField);

		lowerRedshiftField = new JTextField(20);
		lowerRedshiftField.setBounds(340, 63, 160, 25);
		panel.add(lowerRedshiftField);
		
		btnSearchGalaxyForGreaterRedshift = new JButton("Ricerca");
		btnSearchGalaxyForGreaterRedshift.setBounds(522, 10, 160, 25);
		panel.add(btnSearchGalaxyForGreaterRedshift);
		
		btnSearchGalaxyForLowerRedshift = new JButton("Ricerca");
		btnSearchGalaxyForLowerRedshift.setBounds(522, 63, 160, 25);
		panel.add(btnSearchGalaxyForLowerRedshift);
		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	
	private void updateFields(){
		greaterRedshift = greaterRedshiftField.getText();
		lowerRedshift = lowerRedshiftField.getText();
	}
	
	private void convertGRedshiftFields(){
		gRedshift = Float.valueOf(greaterRedshift);
		
	}
	
	private void convertLRedshiftFields(){
		lRedshift = Float.valueOf(lowerRedshift);
	}
	
	// Inizializzazione Listener Bottoni
	private void addActionListener() {
		
		btnSearchGalaxyForGreaterRedshift.addActionListener(new ActionListener() {
			
//		@Override
			public void actionPerformed(ActionEvent e) {
				updateFields();
				convertGRedshiftFields();
				List<Galaxy> galaxyGreaterRedshift = controller.doRicercaGalassiePerRedshiftMaggiore(gRedshift);
				RedshiftGalaxyTableModel jmodel = new RedshiftGalaxyTableModel(galaxyGreaterRedshift);
				tableGalassiaRedshift.setModel(jmodel);
			}
		});
		
		btnSearchGalaxyForLowerRedshift.addActionListener(new ActionListener() {
			
//			@Override
				public void actionPerformed(ActionEvent e) {
					updateFields();
					convertLRedshiftFields();
					List<Galaxy> galaxyLowerRedshift = controller.doRicercaGalassiePerRedshiftMinore(lRedshift);
					RedshiftGalaxyTableModel jmodel = new RedshiftGalaxyTableModel(galaxyLowerRedshift);
					tableGalassiaRedshift.setModel(jmodel);
				}
			});
	}
	
	private void close(){
		this.setVisible(false);
	}
	


}
