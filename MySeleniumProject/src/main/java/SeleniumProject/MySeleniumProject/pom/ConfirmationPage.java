package SeleniumProject.MySeleniumProject.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MySeleniumProject.AbstractComponents.Abstract_Components;

public class ConfirmationPage extends Abstract_Components {
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//String orderConfirmed = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	@FindBy(css=".hero-primary")
	
	WebElement orderConfirmed;
	
	
	public String orderConfirmation() {
		
		return orderConfirmed.getText();
	}
	
	

}
