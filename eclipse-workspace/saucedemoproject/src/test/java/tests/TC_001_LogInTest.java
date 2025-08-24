package tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.LogInPage;

public class TC_001_LogInTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() throws IOException {
		sheetname="LogInData";
		testName="LogIn Test";
		testDescription="Testing the LogIn functionality of the application with valid and invalid credentials";
		testAuthor=" Dheepikaa M G ";
	}
@Test(dataProvider = "readData")
public  void logInTest(String username,String pass,String testType,String expectedMessage) {
	LogInPage logInPg=new LogInPage(driver);
	logInPg.enterName(username)
	.enterPassword(pass)
	.clickLogin();
	logInPg.validateLogIn(testType, expectedMessage);
}
}