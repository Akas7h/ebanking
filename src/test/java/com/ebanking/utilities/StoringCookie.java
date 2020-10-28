package com.ebanking.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class StoringCookie {
	public static WebDriver cookieDriver ;
	
	public static void getCookie(WebDriver driver) {
		
		//create a file named cookies to store information
		cookieDriver = driver;
		//\test\java\com\ebanking\testData
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\ebanking\\testData\\Cookies.data");
		
		//delete old file if exists
		file.delete();
		try {
			file.createNewFile();
			FileWriter filewrite = new FileWriter(file);
			BufferedWriter Bwrite = new BufferedWriter(filewrite);
			
			//loops for getting the cookie information
			for(Cookie ck:cookieDriver.manage().getCookies()) {
				
				Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
				Bwrite.newLine();
				
			}
			
			Bwrite.close();
			filewrite.close();			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	public static void setCookie(WebDriver driver) {
		cookieDriver = driver;
		try{			
		     
			File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\ebanking\\testData\\Cookies.data");						
	        FileReader fileReader = new FileReader(file);							
	        BufferedReader Buffreader = new BufferedReader(fileReader);							
	        String strline;			
	        while((strline=Buffreader.readLine())!=null){									
	        StringTokenizer token = new StringTokenizer(strline,";");									
	        while(token.hasMoreTokens()){					
	        String name = token.nextToken();					
	        String value = token.nextToken();					
	        String domain = token.nextToken();					
	        String path = token.nextToken();					
	        Date expiry = null;					
	        		
	        String val;			
	      /*  if(!(val=token.nextToken()).equals("null"))
			{		
	        	expiry = new Date(val);					
	        }	*/	
	        Boolean isSecure = new Boolean(token.nextToken()).								
	        booleanValue();		
	        Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);			
	        System.out.println(ck);
	        driver.manage().addCookie(ck); // This will add the stored cookie to your current session					
	        }		
	        }		
	        }catch(Exception ex){					
	        ex.printStackTrace();			
	        }		
		
		
	}
	

}
