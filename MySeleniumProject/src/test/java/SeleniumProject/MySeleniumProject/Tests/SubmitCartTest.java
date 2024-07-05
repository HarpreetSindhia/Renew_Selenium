package SeleniumProject.MySeleniumProject.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MySeleniumProject.TestComponents.BaseTest;
import SeleniumProject.MySeleniumProject.pom.CartPage;
import SeleniumProject.MySeleniumProject.pom.CheckOutPage;
import SeleniumProject.MySeleniumProject.pom.ConfirmationPage;
import SeleniumProject.MySeleniumProject.pom.LandingPage;
import SeleniumProject.MySeleniumProject.pom.OrdersPage;
import SeleniumProject.MySeleniumProject.pom.ProductCataloguePage;

public class SubmitCartTest extends BaseTest{
	
	String productName = "ZARA COAT 3";
	
	String inpCountry = "thai";
	
	String orgCountry = "Thailand";
	
	
	@Test(dataProvider="getData",groups= {"NewPurchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException {
		
		/*WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();*/
		
		//driver.get("https://rahulshettyacademy.com/client/");
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		//LandingPage landingPage = new LandingPage(driver);
		
		//landingPage.goTo();
		
		//LandingPage landingPage = launchApplication();
		
		ProductCataloguePage catalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		
		//driver.findElement(By.cssSelector("#userEmail")).sendKeys("harrysindhia@gmail.com");
		
		//driver.findElement(By.cssSelector("#userPassword")).sendKeys("harry@Code5");
		
		//driver.findElement(By.cssSelector("#login")).click();
		
		//ProductCataloguePage catalogue = new ProductCataloguePage(driver);
		
		catalogue.getProductList();
		
		catalogue.getProductByName(input.get("product"));
		
		catalogue.addProductToCart(input.get("product"));
		
		
		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		//WebElement addProduct = products.stream().filter(product -> product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
		
		//addProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-4")));
		
		CartPage cOrders = catalogue.goToCartPage();
		
		//CartPage cOrders = new CartPage(driver);
		
		Boolean match = cOrders.matchCartProductWithList(input.get("product"));
		
		Assert.assertTrue(match);
		
		CheckOutPage checkout = cOrders.clickCheckOut();
		
		//driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		
		//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		//Boolean match = cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase("ZARA COAT 3"));
		
		//CheckOutPage checkout = new CheckOutPage(driver);
		
		checkout.addCountry(inpCountry);
		
		checkout.selectCountry(orgCountry);
		
		ConfirmationPage confirmation = checkout.OrderPlaced();
		
		//OrdersPage orders = new OrdersPage(driver);
		
		
		
        /*driver.findElement(By.cssSelector("button[routerlink='/dashboard/myorders']")).click();
        
		List<WebElement> ordProduct = driver.findElements(By.xpath("//tr/td[2]"));
		
		WebElement productAdded = ordProduct.stream().filter(order->order.getText().equals(productName)).findFirst().orElse(null);
		
		Assert.assertTrue(true);*/
		
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys(inpCountry);
		
		//List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results button"));
		
		//countries.stream().filter(count -> count .getText().equalsIgnoreCase(orgCountry)).findFirst().orElse(null).click();
				
		//driver.findElement(By.cssSelector(".action__submit")).click();
		
		
		
		
		//ConfirmationPage confirmation = new ConfirmationPage(driver);
		
		String orderConfirmed = confirmation.orderConfirmation();
		
		//String orderConfirmed = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(orderConfirmed.equalsIgnoreCase("Thankyou for the order."));
		
		/*OrdersPage orders = confirmation.goToOrders();
		
		WebElement mineProduct = orders.verifyProductByName(productName);
		
		Assert.assertTrue(true);*/
		
		//driver.close();
			

	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void prodMatchOrderList() {
		
		ProductCataloguePage catalogue = landingPage.loginApplication("harrysindhia@gmail.com", "harry@Code5");
	
		OrdersPage ordProducts = landingPage.goToOrders();
		
		ordProducts.verifyProductByName(productName);
				
		Assert.assertTrue(true);
		
		
	}
	
	@DataProvider
	public  Object[][] getData() throws IOException {
		
		
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\MySeleniumProject\\Data\\PurchaseOrder.json");
	
		return new Object[][] {{data.get(0)},{data.get(1)}};
	


}
}
