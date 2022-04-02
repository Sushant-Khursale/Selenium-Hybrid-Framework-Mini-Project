package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro = new Properties();
	
	public ReadConfig() {
		
		
		try {
			File src = new File("./Configurations//config.properties");
			FileInputStream fis = new FileInputStream(src);
			pro.load(fis);
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	
	}
	
	public String getURL() {
		String url = pro.getProperty("BaseURL");
		return url;
	}
	
	public String getUsername() {
		String url = pro.getProperty("userid");
		return url;
	}
	
	public String getPassword() {
		String url = pro.getProperty("password");
		return url;
	}
	
	public String getChromepath() {
		String url = pro.getProperty("chromepath");
		return url;
	}
	
	public String getFirefoxpath() {
		String url = pro.getProperty("firefoxpath");
		return url;
	}
	

}
