package ictInternshipPortal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	public static WebDriver driver=null;
	public Properties prop =null;


	public void loadprop() throws IOException {

		prop = new Properties();		
		InputStream fileip = getClass().getResourceAsStream("/config.properties");
		BufferedReader reader = new BufferedReader(new InputStreamReader(fileip));
		prop.load(fileip);		
	}	

	@BeforeSuite
	public void launch() throws IOException {
		loadprop();	

		this.driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		waitabit();

	}
	public void waitabit() {
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));	
	}
	
	@AfterSuite
	public void new_setup() {
		driver.quit();

	}

}
