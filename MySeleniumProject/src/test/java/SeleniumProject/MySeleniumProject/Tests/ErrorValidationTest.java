package SeleniumProject.MySeleniumProject.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MySeleniumProject.TestComponents.BaseTest;
import MySeleniumProject.TestComponents.RetryAnalyzer;
import SeleniumProject.MySeleniumProject.pom.CartPage;
import SeleniumProject.MySeleniumProject.pom.CheckOutPage;
import SeleniumProject.MySeleniumProject.pom.ConfirmationPage;
import SeleniumProject.MySeleniumProject.pom.LandingPage;
import SeleniumProject.MySeleniumProject.pom.ProductCataloguePage;

public class ErrorValidationTest extends BaseTest{
	
	@Test(groups= {"Error Validation"},retryAnalyzer=RetryAnalyzer.class)
	public void loginErrorValidation() throws IOException {
		
		
		
		landingPage.loginApplication("harrysindhia@gmail.com", "carefree");
		
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email password.");
			
	}
	
	
	@Test
	public void productErrorValidation() throws IOException {
		
		String productName = "ZARA COAT 3";
		
		ProductCataloguePage catalogue = landingPage.loginApplication("harrysindhia@gmail.com", "harry@Code5");
			
		catalogue.getProductList();
		
		catalogue.getProductByName(productName);
		
		catalogue.addProductToCart(productName);
			
		CartPage cOrders = catalogue.goToCartPage();
		
		Boolean match = cOrders.matchCartProductWithList("Adidas Original");
		
		Assert.assertFalse(match);
		
		
	}

}


