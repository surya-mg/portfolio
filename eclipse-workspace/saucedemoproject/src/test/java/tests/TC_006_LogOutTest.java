package tests;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethods;
import pages.LogInPage;
import pages.ProductPage;

public class TC_006_LogOutTest extends ProjectSpecificationMethods{
	@BeforeTest
	public void setup() {
		testName="LogOut Test";
		testDescription="Testing the LogOut functionality";
		testAuthor=" Dheepikaa M G ";
	}
	
@Test
public void LogOutTest() {
	LogInPage logInPg=new LogInPage(driver);
	ProductPage productPg=new ProductPage(driver);
	
	logInPg.enterName("standard_user");
	logInPg.enterPassword("secret_sauce");
	
     logInPg.clickLogin(); 
	 productPg.clickLogout();
	 assertTrue(logInPg.isLoginButtonVisible(), "Login button not visible after logout");

}}