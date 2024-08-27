package SeleniumFlipkartFrameWork.Flipkartorders.Basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import PageObjects.FLandingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;
	public FLandingpage landingpage;
	public WebDriver Webdriverinitializer() throws IOException {
     Properties pr = new Properties();
     FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Flipkartorderspageobject\\resources\\GlobalData.properties");
     pr.load(fis);
    String browsername =  pr.getProperty("Browser");
     if(browsername.equalsIgnoreCase("chrome"))
     {
    	 WebDriverManager.chromedriver().setup();
    	  driver = new ChromeDriver();
     }
     else if(browsername.equalsIgnoreCase("firefox"))
     {
    	 WebDriverManager.firefoxdriver().setup();
    	  driver = new FirefoxDriver();
     }
     else if(browsername.equalsIgnoreCase("edge"))
     {
    	 WebDriverManager.edgedriver().setup();
    	  driver = new EdgeDriver();
     }
     
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
     
	}
	
	@BeforeMethod
	public FLandingpage launchApplication() throws IOException
	{
		driver = Webdriverinitializer();
		 landingpage =  new FLandingpage(driver);
		landingpage.goToURL();
		return landingpage;
	}

}
