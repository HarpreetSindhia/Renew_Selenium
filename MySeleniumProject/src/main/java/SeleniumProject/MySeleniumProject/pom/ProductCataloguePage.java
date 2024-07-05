package SeleniumProject.MySeleniumProject.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MySeleniumProject.AbstractComponents.Abstract_Components;

public class ProductCataloguePage extends Abstract_Components{
	
	WebDriver driver;
	
	public ProductCataloguePage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		
	}
	
	        //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
			//WebElement addProduct = products.stream().filter(product -> product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
			
			//addProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
			
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-4")));
	
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By toastMessage = By.cssSelector("#toast-container");
	
	By invisibleMessage = By.cssSelector(".ng-tns-c31-4");
	
	public List<WebElement> getProductList() {
		
		return products;
	}
	
	
	public WebElement getProductByName(String productName) {
		
		WebElement prod = getProductList().stream().filter(product -> product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
	
		return prod;
	
	}
	
	public void addProductToCart(String productName) {
		
		getProductByName(productName).findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WaitForTheElementToAppear(toastMessage);
		
		WaitForTheElementToDisappear(invisibleMessage);
		
		
	}
	
	
	
	
	
	
	}

