package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.Abstractclass;

public class FLandingpage extends Abstractclass {
	WebDriver driver;

	public FLandingpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@class='YBLJE4']/span)[3]")
	WebElement Fashion;

	@FindBy(linkText = "Men's Kurtas")
	WebElement MensKurtas;

	By loadMensKurtas = By.linkText("Men's Kurtas");

	public void goToURL() {
		driver.get("https://www.flipkart.com/");
	}

	public Productspage goToMensKurtas() {
		moveToElement(Fashion);
		waitForElement(loadMensKurtas);
		MoveandClick(MensKurtas);
		Productspage productspage =  new Productspage(driver);
		return productspage;
	}

}
