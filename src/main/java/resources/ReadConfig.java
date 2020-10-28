package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public FileInputStream fil;
	public ReadConfig() {
		// TODO Auto-generated constructor stub
		
		
		try {
			fil = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\globalParam.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pro = new Properties();
		try {
			pro.load(fil);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	//Now add different method for each and every variable
	//method1: TO get application URl
	public String getUrl() {
		
		String url = pro.getProperty("URL");
		return url;
		
	}
	
	public String getUsername() {
		
		String username = pro.getProperty("username");
		return username;
		
	}
	
	public String getPassword() {
		
		String password = pro.getProperty("password");
		return password;
		
	}
	
	public String getBrowserName() {
	    String browserName = pro.getProperty("browser");
		return browserName;
	}
	
	public String getChromePath() {
	    String chromePath = pro.getProperty("chromepath");
		return chromePath;
	}

	public String getFirefoxPath() {
	    String firefoxPath = pro.getProperty("firefoxpath");
		return firefoxPath;
	}
	
}
