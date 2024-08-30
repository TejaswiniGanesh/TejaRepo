package SeleniumFlipkartFrameWork.Flipkartorders;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrders {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		List<String> Mylist = Arrays.asList("Men Printed Cotton Blend Straight Kurta");
		 Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("(//div[@class='YBLJE4']/span)[3]"))).build().perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Men's Kurtas")));
		a.moveToElement(driver.findElement(By.linkText("Men's Kurtas"))).click().build().perform();
		List<WebElement> Allproducts = driver.findElements(By.cssSelector("a[title*='Men']"));
		System.out.println("these are my changes1");
		System.out.println("these are my changes2");
		System.out.println("these are my changes3");
		System.out.println("these are my changes4");
      for(int i=0;i<Allproducts.size();i++)
      {
    	 String productname = Allproducts.get(i).getText();
    	 
    		// System.out.println(productname);
    		 if(Mylist.contains(productname))
    		 {
    			 Thread.sleep(5000);
    			 driver.findElements(By.cssSelector("a[title*='Men']")).get(i).click();
    			 Set<String> windows= driver.getWindowHandles();
    			 Iterator<String> it = windows.iterator(); 
    			String parenttab =it.next();
    			driver.switchTo().window(parenttab);
    			}
    		
      }
     /* Set<String> windows= driver.getWindowHandles();
	 Iterator<String> it = windows.iterator(); */
	 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	 for (int i=1;i<tabs.size();i++)
	 {
    	    driver.switchTo().window(tabs.get(i));
    	  System.out.println(driver.getTitle());
    	  driver.findElement(By.xpath("//a[text()='XL']")).click();  //click on size xl
    		 JavascriptExecutor js = (JavascriptExecutor) driver;
    		 js.executeScript("window.scrollBy (0,400)");
    		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sBWZ-k")));  //viewdetails
    		 Assert.assertTrue(driver.findElement(By.className("UFTn-O")).isEnabled()); //check is enabled
    		 driver.findElement(By.className("UFTn-O")).click(); //click on check
    		  System.out.println(driver.findElement(By.className("hVvnXm")).getText());
    		   WebElement AddtoCartbutton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
     		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add to cart']"))); 
     		js.executeScript("window.scrollBy (218,2000)");
     		AddtoCartbutton.click();
    		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Place Order']"))); 
    		  driver.findElement(By.xpath("//span[text()='Place Order']")).click();
    		
      } 
	
	}
}
