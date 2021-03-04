package com.capsule.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Testbase {
	
	private static final String strpath = System.getProperty("user.dir") + "/src/main/java/com/capsule/qa/config/config.properties";
	private static final String chromepath = System.getProperty("user.dir")+ "/driver/chromedriver.exe";	
	private static final String FFpath = System.getProperty("user.dir") + "/driver/geckodriver.exe";
	private static final String IEpath = System.getProperty("user.dir") + "/driver/IEDriverServer.exe";
	
	
	FileInputStream file= null;
	public static Properties prop = null;
	public static WebDriver driver = null;
		
	public Testbase() {
		try {
			file = new FileInputStream(strpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			prop = new Properties();
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void intialization() {
		String Browser = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromepath);
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--ignore-certificate-error");
			
			driver = new ChromeDriver(options);
		}
		else if (Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", FFpath);
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.ie.driver", IEpath);
			driver = new InternetExplorerDriver();			
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

}
