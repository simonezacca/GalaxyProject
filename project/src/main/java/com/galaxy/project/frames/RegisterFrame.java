package com.galaxy.project.frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.galaxy.project.controller.RegisterController;
import com.galaxy.project.model.Utente;

public class RegisterFrame extends JFrame {

	private static final long serialVersionUID = 1L; 
	
	private RegisterController controller = new RegisterController(this);
	
	private final static String titolo = "Registrazione Nuovo Utente";
	private final JPanel panel = new JPanel();
	
	// Dichiarazione Componenti Grafici
	private JLabel userLabel;
	private JTextField userText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel surnameLabel;
	private JTextField surnameText;
	private JLabel mailLabel;
	private JTextField mailText;
	private JLabel ruleLabel;
	private JButton btnRegister;
	private String userIDString;
	private String passwordString;
	private String nameString;
	private String surnameString;
	private String mailString;
	private Integer roleInt;
	private JComboBox<String> comboBoxRule;

	public RegisterFrame() {
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

		// Etichetta Utente
		userLabel = new JLabel("Username");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		// Campo Username
		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		// Etichetta Password
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(278, 10, 80, 25);
		panel.add(passwordLabel);

		// Campo Password
		passwordText = new JPasswordField(20);
		passwordText.setBounds(360, 10, 160, 25);
		panel.add(passwordText);

		// Etichetta Nome
		nameLabel = new JLabel("Nome");
		nameLabel.setBounds(10, 40, 80, 25);
		panel.add(nameLabel);

		// Campo Nome
		nameText = new JTextField(20);
		nameText.setBounds(100, 40, 160, 25);
		panel.add(nameText);
		
		// Etichetta Cognome
		surnameLabel = new JLabel("Cognome");
		surnameLabel.setBounds(278, 40, 80, 25);
		panel.add(surnameLabel);

		// Campo Cognome
		surnameText = new JTextField(20);
		surnameText.setBounds(360, 40, 160, 25);
		panel.add(surnameText);
		
		// Etichetta Mail
		mailLabel = new JLabel("Mail");
		mailLabel.setBounds(10, 72, 80, 25);
		panel.add(mailLabel);

		// Campo Mail
		mailText = new JTextField(50);
		mailText.setBounds(100, 72, 420, 25);
		panel.add(mailText);		
		
		// Etichetta Ruolo
		ruleLabel = new JLabel("Ruolo");
		ruleLabel.setBounds(10, 105, 80, 25);
		panel.add(ruleLabel);
		
		// Combo Box Utente/Amministratore
		comboBoxRule = new JComboBox<String>();
		comboBoxRule.setBounds(100, 105, 160, 24);
		panel.add(comboBoxRule);
		comboBoxRule.addItem("Amministratore");
		comboBoxRule.addItem("Utente");
		
		// Bottone Per Registrarsi
		btnRegister = new JButton("Registra");
		btnRegister.setBounds(360, 105, 160, 25);
		panel.add(btnRegister);
		
		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	
	private void updateFields(){
		userIDString = userText.getText();
		passwordString = passwordText.getText();
		nameString = nameText.getText();
		surnameString = surnameText.getText();
		mailString = mailText.getText();
		roleInt = (comboBoxRule.getSelectedItem().equals("Amministratore")) ? Utente.RUOLO_AMMINISTRATORE : Utente.RUOLO_UTENTE; // IF/THEN/ELSE
	}
	
	// Inizializzazione Listener Bottoni
	private void addActionListener() {
		
		btnRegister.addActionListener(new ActionListener() {
			
//		@Override
			public void actionPerformed(ActionEvent e) {
				updateFields();
				controller.doRegistrazione(userIDString, passwordString, nameString, surnameString, mailString, roleInt);
			}
		});
	}
	
	private void close(){
		
		this.setVisible(false);
	}
	

}
