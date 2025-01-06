package rahulshettyacademy.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".action__submit")
	 private WebElement submit;

	@FindBy(css = "[placeholder='Select Country']")
	private WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	private WebElement selectCountry;

	private By results = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
	
	public ConfirmationPage submitOrder() throws InterruptedException
	{

		// Create an explicit wait to wait for the element to be clickable
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // You can adjust the timeout as needed
	    
	    // Wait until the submit button is clickable
	    WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submit));
	    
	    // Perform the hover action and click in one chain
	    Actions actions = new Actions(driver);
	    actions.moveToElement(submitButton).click().perform();
	    
	    // Return the ConfirmationPage object after the action
	    return new ConfirmationPage(driver);
	    
		/*Actions a = new Actions(driver);
		a.moveToElement(submit).build().perform();
//		Thread.sleep(5000);
		submit.click();
		return new ConfirmationPage(driver);*/
		
		
	}

}
