package abstractcomponents;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractclass {
	
	  WebDriver driver;

	public Abstractclass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElement(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
	}
	
	public void moveToElement(WebElement ele)
	{
		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();
	}
	
	public void MoveandClick(WebElement ele)
	{
		Actions a = new Actions(driver);
		a.moveToElement(ele).click().build().perform();
	}
	
	public String getWindowHandles()
	{
		Set<String> windows= driver.getWindowHandles();
			Iterator<String> it = windows.iterator(); 
			String parenttab =it.next();
			driver.switchTo().window(parenttab);
			return parenttab;
	}
	


}
