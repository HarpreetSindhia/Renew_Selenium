package SeleniumProject.MySeleniumProject.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MySeleniumProject.AbstractComponents.Abstract_Components;

public class LandingPage extends Abstract_Components {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Page Factory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id ="login")
	WebElement submit;
	
	//String errorMessage = driver.findElement(By.cssSelector(".ng-trigger-flyInOut")).getText();
	
	@FindBy(css=".ng-trigger-flyInOut")
	WebElement errorMessage;
	
	public String getErrorMessage() {
		
		waitForTheWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	
	public ProductCataloguePage loginApplication(String email , String password) {
		
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCataloguePage catalogue = new ProductCataloguePage(driver);
		return catalogue;
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
	

}
