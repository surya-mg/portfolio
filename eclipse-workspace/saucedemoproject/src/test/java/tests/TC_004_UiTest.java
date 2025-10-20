package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethods;
import pages.CartPage;
import pages.LogInPage;
import pages.ProductPage;


public class TC_004_UiTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() {
		testName="UI Test";
		testDescription="Testing the user interface displays correctly ";
		testAuthor=" Dheepikaa M G ";
	}
@Test
public void product () throws InterruptedException {

	LogInPage logInPg=new LogInPage(driver);
	ProductPage productPg=new ProductPage(driver);

	 logInPg.enterName("standard_user");
	 logInPg.enterPassword("secret_sauce");
	 logInPg.clickLogin();

     int Product1 = productPg.productlink2.getLocation().getY();
     int Product2 = productPg.productlink3.getLocation().getY();
     Assert.assertEquals(Product1, Product2, "First and Last Name fields should be aligned horizontally");
     System.out.println("UI alignment test passed.");

}
@Test
public void buttonVisibilityTest() throws InterruptedException {

	LogInPage logInPg=new LogInPage(driver);
	ProductPage productPg=new ProductPage(driver);
    CartPage cartpg=new CartPage(driver);

	 logInPg.enterName("standard_user");
	 logInPg.enterPassword("secret_sauce");
	 logInPg.clickLogin();
	 Assert.assertTrue(productPg.cartButtonIcon.isDisplayed() && productPg.cartButtonIcon.isEnabled(), "Cart button not visible or clickable");
}}