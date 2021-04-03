package com.akhil.spring.springbeanlifecycle.dao.usingxml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class StudentDAO {
	private String driver;
	private String url;
	private String username;
	private String password;
	private Connection connection;
	private Statement stmt;
	
	public void init() {
		System.out.println("init method is called. By this time values are set in attribute");
		try {
			createDBConnection();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		System.out.println("calling the destroy method");
		try {
			closeDBConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void createDBConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);

		// get a connection
		this.connection = DriverManager.getConnection(url, username, password);

		// execute query
		this.stmt = connection.createStatement();
	}
	


	public void closeDBConnection() throws SQLException {
		connection.close();

	}

	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public void getAllRows() {
		try {
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM public.\"SchoolManagement\";");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString("name");
				int age = resultSet.getInt(3);
				System.out.println("id is " + id + " name is " + name + " age is " + age);
			}
			
		} catch (SQLException e) {
			System.out.println("error occured " + e.getLocalizedMessage());
		}

	}

	public void deletStudent(int id) throws ClassNotFoundException, SQLException {
		stmt.executeUpdate("DELETE FROM public.\"SchoolManagement\" where id=" + id);
		
	}
}
