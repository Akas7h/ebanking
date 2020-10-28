package resources;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	ReadConfig readConfig = new ReadConfig();
	public WebDriver driver;
	public Properties prop;
    public String browserName;
    public String url;
    public String userName ;
    public String password ;
	
	public WebDriver initializeDriver(String br) throws IOException {
		
		
		//prop = new Properties();
		//FileInputStream fil = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\project\\resources\\globalParam.properties");
		//prop.load(fil);
	    browserName =readConfig.getBrowserName();
	    url = readConfig.getUrl();
	    userName = readConfig.getUsername();
	    password = readConfig.getPassword();
	    
	    if(br.equals("chrome")) {
	    	
	    System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
	    driver = new ChromeDriver();
	    }else if (br.equals("firefox")) {
	    	
	    	System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
		    driver = new FirefoxDriver();
	    	
	    	
	    }
	    driver.get(url);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenshot(String methodFailed,WebDriver driverObject) throws IOException {
		//this driver is just a reference to the base class,this driver reference should come from testcases of their individual .java files
		TakesScreenshot ts = (TakesScreenshot)driverObject;
		File source = ts.getScreenshotAs(OutputType.FILE);		
		//Name of the screenshot will be the name of the test
		String destination  = System.getProperty("user.dir")+"\\Screenshots\\"+methodFailed+".png" ;
		
		FileUtils.copyFile(source,new File(destination));
		
		return destination;
		
		
	}
	
	
}
	
	
	
