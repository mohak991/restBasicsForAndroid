package edu.uic.androidIDS494WS.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uic.androidIDS494WS.model.User;
import edu.uic.androidIDS494WS.utils.Utils;

public class AppDB {
	private Connection connection;

	public AppDB() {
		connect();
	}

	private void connect() {
		try {
			Class.forName(Utils.DBStrings.JDBC_DRIVER);
			connection = DriverManager.getConnection(Utils.DBStrings.URL, Utils.DBStrings.USER, Utils.DBStrings.PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User getUser(String em, String password) {
		checkConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("select * from androidFinals.user where email=? and password=?");
			ps.setString(1, em);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String pass = rs.getString("password");
				User user = new User(name, email, pass);
				return user;
			} 
		} catch (SQLException e) {
			close();
			return null;
		} catch (Exception e) {
			close();
			return null;
		}
		return null;
	}

	private void checkConnection() {
		if (connection == null) {
			connect();
		}
	}

	public String addUser(User user) {
		checkConnection();
		if (getUser(user.getEmail(), user.getPassword()) == null) {
			StringBuilder str = new StringBuilder();
			str.append("insert into androidFinals.user VALUES (");
			str.append(null+",");
			str.append("\"" + user.getName() + "\"" +",");
			str.append("\"" +user.getEmail() + "\"" +",");
			str.append("\"" +user.getPassword() + "\"" + ")");
			System.out.println("Insert Query : " + str.toString());
			PreparedStatement ps;
			try {
				ps = connection.prepareStatement(str.toString());
				ps.executeUpdate();
				return "Success";
			} catch (SQLException e) {
				close();
				System.out.println("Error : " + e.getMessage());
				return null;
			} catch (Exception e) {
				close();
				System.out.println("Error : " + e.getMessage());
				return null;
			}
		} else {
			return "Already Registered !";
		}
	}
	
	private void close() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}