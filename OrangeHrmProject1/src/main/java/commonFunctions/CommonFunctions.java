package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions {
	
	public static Properties properties=null;
	public static WebDriver driver=null;	
	
	Logger logger = Logger.getLogger(CommonFunctions.class);
	
	public Properties loadPropertyFile() throws IOException{
		
		FileInputStream file = new FileInputStream("config.properties");
		properties= new Properties();
		properties.load(file);
		return properties;
		
	}
	
	
	
	@BeforeSuite
	public void startBrowser() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Test Starting");
		logger.info("Loading the property file");
		loadPropertyFile();
		
		String link = properties.getProperty("url");
		logger.info("Launching Chrome");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		
		driver.manage().window().maximize();
		logger.info("website Loading");
		driver.get(link);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	@AfterSuite
	public void closeBrowser() {
		logger.info("Closing the browser");
		//driver.quit();

}
}
