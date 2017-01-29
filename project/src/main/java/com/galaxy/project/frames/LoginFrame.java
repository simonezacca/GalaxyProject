package com.galaxy.project.frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.galaxy.project.controller.LoginController;
import com.galaxy.project.model.Utente;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L; 
	
	private LoginController controller = new LoginController(this);
	
	private final static String titolo = "Login";
	private final JPanel panel = new JPanel();
	
	// Dichiarazione Componenti Grafici
	private JLabel userLabel;
	private JTextField userText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JButton btnRegister;
	private JButton btnLogin;
	private String userIDString;
	private String passwordString;

	public LoginFrame() {
		super(titolo);
		
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
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
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		// Campo Password
		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		// Bottone Per Registrarsi
		btnRegister = new JButton("Registra");
		btnRegister.setBounds(180, 80, 80, 25);
		panel.add(btnRegister);
		
		// Bottone Per Il Login
		btnLogin = new JButton("Login");
		btnLogin.setBounds(10, 80, 80, 25);
//		btnLogin.addActionListener(new LoginListener(this,userText,passwordText));
		panel.add(btnLogin);
		
	}
	
	private void centerFrame() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
	}
	
	// Inizializzazione Listener Bottoni
	private void addActionListener() {
		btnLogin.addActionListener(new ActionListener() {
			
//			@Override
			public void actionPerformed(ActionEvent e) {
//				AppLogger.debug("Verifico coppia credenziali login");
				updateFields();
				controller.doLogin(userIDString, passwordString);
			}
		});
		
//		btnRegister.addActionListener(new ActionListener() {
//			
////		@Override
//			public void actionPerformed(ActionEvent e) {
//				updateAdminFields();
//			}
//		});
	}
	
	private void close(){
		
		this.setVisible(false);
	}
	
	private void updateFields(){
		userIDString = userText.getText();
		passwordString = passwordText.getText();
	}
	
	public void createMainUserFrame(Utente u){
		if(u.getRuolo()==Utente.RUOLO_AMMINISTRATORE){
			this.close();
			AGenericUserFrame mainFrame = new AdminFrame();
		} else {
			this.close();
			AGenericUserFrame mainFrame = new UserFrame();
		}
		
		
	}
	

}
