package edu.uic.androidIDS494WS.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static final String dataFormatter(Date date) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return(simpleDateFormat.format(date));
	}
	
	public interface DBStrings {
		String URL = "jdbc:mysql://localhost:3306/androidFinals";
		String USER = "root";
		String PASSWORD = "root";
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	}
}
