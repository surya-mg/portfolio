package tests;
import static org.testng.Assert.assertEquals;
import java.awt.Checkbox;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethods;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LogInPage;
import pages.ProductPage;
public class TC_003_OrderTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() {
		testName="Order Test";
		testDescription="Testing the order functionality by giving user details";
		testAuthor=" Dheepikaa M G ";
	}
	
@Test(priority=1)

public void validOrderTest() throws InterruptedException {
	LogInPage logInPg=new LogInPage(driver);
	ProductPage productPg=new ProductPage(driver);
    CartPage cartpg=new CartPage(driver);
	CheckOutPage coPage=new CheckOutPage(driver);

     logInPg.enterName("standard_user");
	 logInPg.enterPassword("secret_sauce");
	 logInPg.clickLogin();
	 
	 productPg.selectProduct();
	 productPg.navigateToCart();
	 cartpg.checkout();
	 
     coPage.enterFirstName("Sai");
     coPage.enterLastName("Madhi");
	 coPage.enterPostalCode("600094");
	 coPage.clickContinue();
	 coPage.clickFinish();
	 coPage.confirmationMessage.getText();

	 String message = coPage.confirmationMessage.getText();
	 Assert.assertEquals(message, "Thank you for your order!");
	 System.out.println("Confirmation message: " + message);
}

@Test(priority=2)

public void emptyFormTest() throws InterruptedException {

	LogInPage logInPg=new LogInPage(driver);
	ProductPage productPg=new ProductPage(driver);
    CartPage cartpg=new CartPage(driver);
	CheckOutPage coPage=new CheckOutPage(driver);

	  logInPg.enterName("standard_user");
	  logInPg.enterPassword("secret_sauce");
	  logInPg.clickLogin();
	 

	 productPg.selectProduct();
	 productPg.navigateToCart();
	 cartpg.checkout();
	 Thread.sleep(2000);
	 coPage.enterFirstName("");
	 coPage.enterLastName("Madhi");
	 coPage.enterPostalCode("600094");
	 coPage.clickContinue();
	 String actualMessage=coPage.errormsg.getText();
	 assertEquals(actualMessage, "Error: First Name is required", "Missing field error not displayed.");
}


}