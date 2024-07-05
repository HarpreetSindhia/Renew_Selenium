package MySeleniumProject.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumProject.MySeleniumProject.pom.CartPage;
import SeleniumProject.MySeleniumProject.pom.OrdersPage;

public class Abstract_Components {
	
	// Here we will keep all the reusable code 
	
	WebDriver driver;
	
	public Abstract_Components(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void waitForTheWebElementToAppear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	//Explicit Wait will be here 
	
	public void WaitForTheElementToAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	

	public void WaitForTheElementToDisappear(By findBy) {
		
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	
	//WebElement cartPage = driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
	
	//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	
	//Boolean match = cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase("ZARA COAT 3"));
	
	
	//Page Factory
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartPage;
	
	public CartPage goToCartPage() {
		
		cartPage.click();
		
		CartPage cOrders = new CartPage(driver);
		
		return cOrders;
		
		
	}
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement orderPage;
	
	public OrdersPage goToOrders() {
		
		orderPage.click();
		
		OrdersPage orders = new OrdersPage(driver);
		
		return orders;
	
	}
	
	
	
	

	
	

}
