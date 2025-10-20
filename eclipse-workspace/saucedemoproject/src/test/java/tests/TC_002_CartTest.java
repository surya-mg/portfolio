package tests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethods;
import pages.LogInPage;
import pages.ProductPage;


public class TC_002_CartTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() {
		testName="Cart Test";
		testDescription="Testing the cart functionality by adding products";
		testAuthor=" Dheepikaa M G ";
	}
  @Test
  public void cartTest() throws InterruptedException {
 LogInPage logInPg=new LogInPage(driver);
 ProductPage productPg=new ProductPage(driver);

   logInPg.enterName("standard_user");
   logInPg.enterPassword("secret_sauce");
   logInPg.clickLogin();
   try {
	    Alert alert = driver.switchTo().alert();
	    alert.accept(); // or alert.dismiss()
	    System.out.println("Alert handled successfully.");
	} catch (NoAlertPresentException e) {
	    System.out.println("No alert present.");
	}

   productPg.selectProduct1();
   productPg.addToCart();
   productPg.backToProducts();

  productPg.selectProduct2();
  productPg.addToCart();
  productPg.backToProducts();
  productPg.navigateToCart();

 List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
 int itemCount = cartItems.size();
 System.out.println("Items in cart: " + itemCount);
 Assert.assertEquals(itemCount, 2, "Expected 2 items in the cart");
 
   productPg.removeItemFromCart();
 List<WebElement> updatedCartItems = driver.findElements(By.className("cart_item"));
 int itemCount1 = updatedCartItems.size();
 System.out.println("Items in cart after removing a product: " + itemCount1);
 Assert.assertEquals(itemCount1, 1, "Expected 1 item in the cart");
  } 
}