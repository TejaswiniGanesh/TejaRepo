package PageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.Abstractclass;

public class Productspage extends Abstractclass{

	WebDriver driver;
		public Productspage(WebDriver driver)
		{
			super(driver);
			this.driver= driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css="a[title*='Men']")
		List<WebElement> Allproducts;
		
		By productsload = By.cssSelector(".zg-M3Z._0H7xSG");
		
		public List<WebElement> getAllproducts()
		{
			waitForElement(productsload);
			return Allproducts;
		}
	
public PlaceOrderPage clickOnProducts(List<String> Mylist)
{ 
     for(int i=0;i<Allproducts.size();i++)
     {
   	 String productname = Allproducts.get(i).getText();
   	 
   		// System.out.println(productname);
   		 if(Mylist.contains(productname))
   		 {
   			waitForElement(productsload);
   			Allproducts.get(i).click();
   			getWindowHandles();
   			}  		
     }
     PlaceOrderPage placeorder = new PlaceOrderPage(driver);
     return placeorder;
}


}
