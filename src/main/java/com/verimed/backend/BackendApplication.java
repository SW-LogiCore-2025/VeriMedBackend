package com.verimed.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class BackendApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		createDatabaseIfNotExists();
		SpringApplication.run(BackendApplication.class, args);
	}

	private static void createDatabaseIfNotExists() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "verimed_db";
		String user = "root";
		String pass = "12345678";
		try (Connection conn = DriverManager.getConnection(url, user, pass);
			 Statement stmt = conn.createStatement()) {
			stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
		} catch (SQLException e) {
			throw new RuntimeException("Error creando la base de datos: " + dbName, e);
		}
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*") // Permite cualquier origen
				.allowedMethods("*") // Permite cualquier método HTTP
				.allowedHeaders("*") // Permite cualquier encabezado
				.allowCredentials(false); // No requiere credenciales
	}
}