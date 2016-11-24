package com.galaxy.project.start; 

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class EsempioJDBC {

	public static void main(String[] argv) {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres", "postgres",
					"postgres");

		} catch (SQLException e) {

			System.out.println("Connessione fallita! Guarda la console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("Fatto, ora hai il controllo del Database!");
		} else {
			System.out.println("Connessione fallita!");
		}
	}

}