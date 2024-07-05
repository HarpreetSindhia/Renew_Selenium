package SeleniumProject.MySeleniumProject.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MySeleniumProject.AbstractComponents.Abstract_Components;

public class CartPage extends Abstract_Components {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	
	public Boolean matchCartProductWithList(String productName) {
		
		Boolean match = cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		
		return match;
	}
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	
	
	public CheckOutPage clickCheckOut() {
		
		checkOut.click();
		
		CheckOutPage checkout = new CheckOutPage(driver);
		
		return checkout;
		
		
	}

}
