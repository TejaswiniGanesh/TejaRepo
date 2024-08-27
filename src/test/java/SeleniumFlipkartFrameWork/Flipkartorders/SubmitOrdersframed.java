package SeleniumFlipkartFrameWork.Flipkartorders;

import java.io.IOException;
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
import org.testng.annotations.Test;

import PageObjects.FLandingpage;
import PageObjects.PlaceOrderPage;
import PageObjects.Productspage;
import SeleniumFlipkartFrameWork.Flipkartorders.Basepackage.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrdersframed extends BaseClass{

	@Test
	public void submitFlipkartOrder() throws IOException
	{
		 List<String> Mylist = Arrays.asList("Men Printed Cotton Blend Straight Kurta");
		Productspage productspage =landingpage.goToMensKurtas();
		PlaceOrderPage placeorder =  productspage.clickOnProducts(Mylist);
		placeorder.placeOrders();
      
  
	}
}
