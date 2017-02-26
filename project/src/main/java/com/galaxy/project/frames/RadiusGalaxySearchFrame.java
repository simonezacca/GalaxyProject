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

import com.galaxy.project.controller.RadiusGalaxySearchFrameController;
import com.galaxy.project.frames.tablemodel.RadiusGalaxyTableModel;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
	
public class RadiusGalaxySearchFrame extends JFrame {
	
		private static final long serialVersionUID = 1L; 
		
		private RadiusGalaxySearchFrameController controller = new RadiusGalaxySearchFrameController(this);
		
		private final static String titolo = "Ricerca Oggetto all'interno di un raggio";
		private final JPanel panel = new JPanel();
		private Position p = null;
		
		// Dichiarazione Componenti Grafici
		private JLabel rahLabel;
		private JLabel ramLabel;
		private JLabel rasLabel;
		private JLabel rdsignLabel;
		private JLabel rddLabel;
		private JLabel rdmLabel;
		private JLabel rdsLabel;
		private JTextField fieldRAh;
		private JTextField fieldRAm;
		private JTextField fieldRAs;
		private JTextField fieldRDSign;
		private JTextField fieldRDd;
		private JTextField fieldRDm;
		private JTextField fieldRDs;
		private JButton btnSearchGalaxyForRadius;
		private String rah;
		private String ram;
		private String ras;
		private String rdsign;
		private String rdd;
		private String rdm;
		private String rds;
		private String radius;
		private int positionRAh;
		private int positionRAm;
		private float positionRAs;
		private char positionRDsign;
		private int positionRDd;
		private int positionRDm;
		private float positionRDs;
		private float limitRadius;
		private JLabel lblInserisciDati = new JLabel("Inserisci tutti i dati relativi alla posizione:");
		private JTable tableGalassiaDistanza;
		private JTextField fieldRadius;	
		
		public RadiusGalaxySearchFrame() {
			
		super(titolo);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(panel);
		placeComponents(panel);
		tableGalassiaDistanza = new JTable(null);	
		tableGalassiaDistanza.setBounds(52, 159, 533, 350);
		tableGalassiaDistanza.setPreferredScrollableViewportSize(new Dimension(450,63));
		tableGalassiaDistanza.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tableGalassiaDistanza);
		scrollPane.setBounds(52, 194, 533, 315);
		panel.add(scrollPane);	
		JLabel lblRaggio = new JLabel("Raggio:");
		lblRaggio.setBounds(454, 107, 58, 15);
		panel.add(lblRaggio);
	
		centerFrame();
		addActionListener(); 
		
		this.setVisible(true);

	}
	
	private void placeComponents(JPanel panel) {

		panel.setLayout(null);

		lblInserisciDati.setBounds(10, 12, 352, 15);
		panel.add(lblInserisciDati);
		
		// Etichetta Inserisci RAh
		rahLabel = new JLabel("RAh: ");
		rahLabel.setBounds(10, 47, 45, 25);
		panel.add(rahLabel);

		// Etichetta Inserisci RAm
		ramLabel = new JLabel("RAm: ");
		ramLabel.setBounds(161, 47, 45, 25);
		panel.add(ramLabel);
		
		// Etichetta Inserisci RAs
		rasLabel = new JLabel("RAs: ");
		rasLabel.setBounds(319, 47, 45, 25);
		panel.add(rasLabel);
		
		// Etichetta Inserisci RDsign
		rdsignLabel = new JLabel("RDsign: ");
		rdsignLabel.setBounds(454, 47, 58, 25);
		panel.add(rdsignLabel);
		
		// Etichetta Inserisci RDd
		rddLabel = new JLabel("RDd: ");
		rddLabel.setBounds(10, 102, 37, 25);
		panel.add(rddLabel);
		// Etichetta Inserisci RDm
		rdmLabel = new JLabel("RDm: ");
		rdmLabel.setBounds(161, 102, 45, 25);
		panel.add(rdmLabel);
		// Etichetta Inserisci RDs
		rdsLabel = new JLabel("RDs: ");
		rdsLabel.setBounds(319, 102, 37, 25);
		panel.add(rdsLabel);
	
		// Campo RAh
		fieldRAh = new JTextField(20);
		fieldRAh.setBounds(52, 47, 68, 25);
		panel.add(fieldRAh);
		// Campo RAm
		fieldRAm = new JTextField(20);
		fieldRAm.setBounds(206, 47, 68, 25);
		panel.add(fieldRAm);
		// Campo RAs
		fieldRAs = new JTextField(20);
		fieldRAs.setBounds(361, 47, 68, 25);
		panel.add(fieldRAs);
		// Campo RDsign
		fieldRDSign = new JTextField(20);
		fieldRDSign.setBounds(517, 47, 68, 25);
		panel.add(fieldRDSign);
		// Campo RDd
		fieldRDd = new JTextField(20);
		fieldRDd.setBounds(52, 102, 68, 25);
		panel.add(fieldRDd);
		// Campo RDm
		fieldRDm = new JTextField(20);
		fieldRDm.setBounds(206, 102, 68, 25);
		panel.add(fieldRDm);
		// Campo RDs
		fieldRDs = new JTextField(20);
		fieldRDs.setBounds(361, 102, 68, 25);
		panel.add(fieldRDs);
		
		fieldRadius = new JTextField(20);
		fieldRadius.setBounds(517, 99, 68, 25);
		panel.add(fieldRadius);
		
		// Bottone Per Ricercare
		btnSearchGalaxyForRadius = new JButton("Ricerca");
		btnSearchGalaxyForRadius.setBounds(52, 149, 533, 25);
		panel.add(btnSearchGalaxyForRadius);		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	
	private void updateFields(){
		rah = fieldRAh.getText();
		ram = fieldRAm.getText();
		ras = fieldRAs.getText();
		rdsign = fieldRDSign.getText();
		rdd = fieldRDd.getText();
		rdm = fieldRDm.getText();
		rds = fieldRDs.getText();
		radius = fieldRadius.getText();
	}
	
	private void convertFields(){
		positionRAh = Integer.valueOf(rah);
		positionRAm = Integer.valueOf(ram);
		positionRAs = Float.valueOf(ras);
		positionRDsign = rdsign.charAt(0);
		positionRDd = Integer.valueOf(rdd);
		positionRDm = Integer.valueOf(rdm);
		positionRDs = Float.valueOf(rds);
		limitRadius = Float.valueOf(radius);
	}

	private void addActionListener() {
		
		btnSearchGalaxyForRadius.addActionListener(new ActionListener() {
			
//		@Override
			public void actionPerformed(ActionEvent e) {
				updateFields();
				convertFields();
				p = new Position(positionRAh, positionRAm, positionRAs, positionRDsign, positionRDd, positionRDm, positionRDs);
				List<Galaxy> galaxyOnRadius = controller.doRicercaGalassieDentroRaggio(p, limitRadius);
				RadiusGalaxyTableModel jmodel = new RadiusGalaxyTableModel(galaxyOnRadius);
				tableGalassiaDistanza.setModel(jmodel);
			}
		});
	}
	
	private void close(){
		this.setVisible(false);
	}
}
