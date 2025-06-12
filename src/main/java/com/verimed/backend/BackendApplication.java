package com.verimed.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		createDatabaseIfNotExists();
		SpringApplication.run(BackendApplication.class, args);
	}

	private static void createDatabaseIfNotExists() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "verimed_db";
		String user = "root";
		String pass = "admin";
		try (Connection conn = DriverManager.getConnection(url, user, pass);
			 Statement stmt = conn.createStatement()) {
			stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
		} catch (SQLException e) {
			throw new RuntimeException("Error creando la base de datos: " + dbName, e);
		}
	}
}
