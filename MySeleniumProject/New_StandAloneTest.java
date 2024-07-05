package SeleniumProject.MySeleniumProject;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class New_StandAloneTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client/");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("harrysindhia@gmail.com");
		
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("harry@Code5");
		
		driver.findElement(By.cssSelector("#login")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement addProduct = products.stream().filter(product -> product.findElement(By.tagName("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		addProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-4")));
		
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean match = cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase("ZARA COAT 3"));
		
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("thai");
		
		List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results button"));
		
		WebElement myCountry = countries.stream().filter(count -> count .getText().equalsIgnoreCase("Thailand")).findFirst().orElse(null);
		
		myCountry.click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String orderConfirmed = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(orderConfirmed.equalsIgnoreCase("Thankyou for the order."));
		
		driver.close();
		
		

	
	}

}
