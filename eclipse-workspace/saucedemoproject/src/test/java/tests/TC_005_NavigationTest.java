package tests;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethods;
import pages.LogInPage;
import pages.ProductPage;
public class TC_005_NavigationTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() {
		testName="Session Navigation Test";
		testDescription="This test  verifies user session behavior during navigation between pages. ";
		testAuthor=" Dheepikaa M G ";
	}
@Test
public void productBrowsingAndNavigationTest() {
	 LogInPage logInPg=new LogInPage(driver);
	 ProductPage productPg=new ProductPage(driver);
 
	 logInPg.enterName("standard_user");
	 logInPg.enterPassword("secret_sauce");
	 logInPg.clickLogin();

	 productPg.selectProduct1();
	    String title = productPg.getProductTitle();
		String price = productPg.getProductPrice();
		String description = productPg.getProductDescription();
		
		System.out.println("Product Title is: " + title);
		System.out.println("Product Price is: " + price);
		System.out.println("Product Description: " + description);

		productPg.backToProducts();
		productPg.navigateToCart();
		System.out.println("Current URL: " + driver.getCurrentUrl());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("cart.html"));
        assertTrue(driver.getCurrentUrl().contains("cart.html"), "Cart page not displayed");

}

}