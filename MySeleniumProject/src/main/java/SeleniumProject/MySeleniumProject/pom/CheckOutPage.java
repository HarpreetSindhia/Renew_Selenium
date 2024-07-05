package SeleniumProject.MySeleniumProject.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MySeleniumProject.AbstractComponents.Abstract_Components;

public class CheckOutPage extends Abstract_Components {
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		
		
	}
	

	
	//WebElement inputCountry = driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("thai");
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement inputCountry;
	
	public void addCountry(String inpCountry) {
		
		inputCountry.sendKeys(inpCountry);
	}
	
	//List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results button"));
	
	@FindBy(css=".ta-results button")
	List<WebElement> countries;
	
	
	//WebElement myCountry = countries.stream().filter(count -> count .getText().equalsIgnoreCase("Thailand")).findFirst().orElse(null);
	
	//myCountry.click();
	
	public void selectCountry(String orgCountry) {
		
		countries.stream().filter(count -> count .getText().equalsIgnoreCase(orgCountry)).findFirst().orElse(null).click();
	}
	
	//driver.findElement(By.cssSelector(".action__submit")).click();
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	
	public ConfirmationPage OrderPlaced() {
		
		placeOrder.click();
		
		ConfirmationPage confirmation = new ConfirmationPage(driver);
		
		return confirmation;
	}

}
