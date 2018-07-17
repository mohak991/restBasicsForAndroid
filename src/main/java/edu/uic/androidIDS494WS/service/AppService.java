package edu.uic.androidIDS494WS.service;

import edu.uic.androidIDS494WS.dao.AppDB;
import edu.uic.androidIDS494WS.model.User;

public class AppService {
	private AppDB appDB;
	
	public AppService () {
		appDB =  new AppDB();
	}
	
	public User getUser(String email, String pass) {
		return appDB.getUser(email, pass);
	}
	
	public String registerUser(User user) {
		return appDB.addUser(user);
	}
}