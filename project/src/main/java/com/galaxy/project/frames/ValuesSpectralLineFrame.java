package com.galaxy.project.frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;

import com.galaxy.project.controller.ValuesSpectralLineFrameController;
import com.galaxy.project.model.Galaxy;
import com.galaxy.project.model.Position;
import com.galaxy.project.persistence.GalaxyDAO;
import com.galaxy.project.tools.PositionHelper;
	
public class ValuesSpectralLineFrame extends JFrame {
	
		private static final long serialVersionUID = 1L; 
		
		private ValuesSpectralLineFrameController controller = new ValuesSpectralLineFrameController(this);
		
		private final static String titolo = "Valori delle linee spettrali";
		private final JPanel panel = new JPanel();
		private Position p = null;
		
		// Dichiarazione Componenti Grafici
		private JTable tableRigheSpettrali;
		private JTable tableFlussi;
		
		private String[] columnsRigheSpettrali = { "Riga Spettrale"};
		private String[] columnsFlussi = { "Limit" , "Valore", "Errore"};
		private String[] dataRigheSpettrali = {"RigaSpettrale1",
								   			   "RigaSpettrale2"};
		private String[][] dataFlussi = {{"Limite", "Valore", "Errore"},
									   {"Limite", "Valore", "Errore"},
									   {"Limite", "Valore", "Errore"}};

		
		public ValuesSpectralLineFrame() {
			
		super(titolo);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(panel);
		placeComponents(panel);
		
		
		tableFlussi = new JTable(null);
		tableFlussi.setBounds(52, 159, 533, 350);
		tableFlussi.setPreferredScrollableViewportSize(new Dimension(450,63));
		tableFlussi.setFillsViewportHeight(true);
		//TODO
//		List<AFlux> fluxes = controller.doValuesSpectralLine();
//		ValuesSpectralLineTableModel jmodel = new RadiusGalaxyTableModel(galaxyOnRadius);
//		tableFlussi.setModel(jmodel);
		
		JScrollPane spFlussi = new JScrollPane(tableFlussi);
		spFlussi.setBounds(272, 33, 419, 350);
		panel.add(spFlussi);
		
		tableRigheSpettrali = new JTable(10, 1);
		tableRigheSpettrali.setBounds(52, 159, 533, 350);
		tableRigheSpettrali.setPreferredScrollableViewportSize(new Dimension(450,63));
		tableRigheSpettrali.setFillsViewportHeight(true);
		
		
		JScrollPane spRigheSpettrali = new JScrollPane(tableRigheSpettrali);
		spRigheSpettrali.setBounds(10, 68, 242, 193);
		panel.add(spRigheSpettrali);
		
		GalaxyDAO gdao = new GalaxyDAO();
		List<Galaxy> galaxies = gdao.getAll();

		JComboBox<String> cbGalaxies = new JComboBox<String>(); //new JComboBox(lista Galassie)
		for (Galaxy g : galaxies) {
				cbGalaxies.addItem(g.getName());
		}
				
		cbGalaxies.setForeground(new Color(0, 0, 0));
		cbGalaxies.setBounds(10, 37, 242, 20);
		cbGalaxies.setToolTipText("");
		cbGalaxies.setRenderer(new MyComboBoxRenderer("Seleziona Galassie")); // Non riesco a capire perché non funziona.
		cbGalaxies.setSelectedIndex(-1); //
		panel.add(cbGalaxies);
		
		JLabel lblSelezionaGalassia = new JLabel("Seleziona Galassia:");
		lblSelezionaGalassia.setBounds(10, 18, 100, 14);
		panel.add(lblSelezionaGalassia);

		
		centerFrame();
		addActionListener(); // Inizializza i Listener dei Bottoni (vedi sotto)
		
		this.setVisible(true);

	}
	
	// Posizionamento Componenti Grafici
	private void placeComponents(JPanel panel) {

		panel.setLayout(null);
		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}

	// Inizializzazione Listener Bottoni
	private void addActionListener() {
		
	}
	
	private void close(){
		this.setVisible(false);
	}
	
	class MyComboBoxRenderer extends JLabel implements ListCellRenderer
    {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String title;

        public MyComboBoxRenderer(String title)
        {
            title = this.title;
        }
        
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus)
        {
            if (index == -1 && value == null) setText(title);
            else setText(value.toString());
            return this;
        }
    }
}
