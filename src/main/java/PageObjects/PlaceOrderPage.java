package PageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractcomponents.Abstractclass;

public class PlaceOrderPage extends Abstractclass {
	WebDriver driver;

	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='XL']")
	WebElement ClickOnXL;
	
	@FindBy(className="UFTn-O")
	WebElement Checklocation;
	
	@FindBy(className="hVvnXm")
	WebElement Deliveryinfo;
	
	@FindBy(css="button[class='QqFHMw vslbG+ In9uk2']")
	WebElement AddtoCart;
	
	@FindBy(xpath="//span[text()='Place Order']")
	WebElement PlaceOrder;
	
	By viewdetails =  By.cssSelector(".sBWZ-k");
	By Addcartbutton =  By.xpath("//button[text()='Add to cart']");
	By placeorderbutton =By.xpath("//span[text()='Place Order']");
	
	public void placeOrders()
	{
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 for (int i=1;i<tabs.size();i++)
		 {
	    	    driver.switchTo().window(tabs.get(i));
	    	     System.out.println(driver.getTitle());
	    	     ClickOnXL.click();  //click on size xl
	    	     waitForElement(viewdetails);  //viewdetails
	    		 Assert.assertTrue(driver.findElement(By.className("UFTn-O")).isEnabled()); //check is enabled
	    		 Checklocation.click(); //click on check
	    		  System.out.println(Deliveryinfo.getText());
	    		  waitForElement(Addcartbutton);
	    		  JavascriptExecutor js = (JavascriptExecutor) driver;
	     		  js.executeScript("window.scrollBy (300,500)");
	     		   AddtoCart.click();
	     		  waitForElement(placeorderbutton);
	     		 PlaceOrder.click();
	    		
	      }  
	}

}
