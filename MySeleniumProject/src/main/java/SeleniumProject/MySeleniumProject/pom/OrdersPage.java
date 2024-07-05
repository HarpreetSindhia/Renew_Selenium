package SeleniumProject.MySeleniumProject.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MySeleniumProject.AbstractComponents.Abstract_Components;

public class OrdersPage extends Abstract_Components{
	
	WebDriver driver;
	
	public OrdersPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.cssSelector("button[routerlink='/dashboard/myorders']"));
	
	//List<WebElement> ordProduct = driver.findElements(By.xpath("//tr/td[2]"));
	
	//WebElement productAdded = ordProduct.stream().filter(order->order.getText().equals(productName)).findFirst().orElse(null);

	
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> ordProducts;
	
	
	public WebElement verifyProductByName(String productName) {
		
		WebElement myProduct = ordProducts.stream().filter(order->order.getText().equals(productName)).findFirst().orElse(null);
		
		return myProduct;
	}
}
 