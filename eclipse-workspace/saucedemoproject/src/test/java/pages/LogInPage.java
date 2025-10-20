package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethods;
public class LogInPage extends ProjectSpecificationMethods {
	WebDriver driver;
	
	WebDriverWait wait;
	@FindBy(id = "user-name")
    WebElement usernamefield;

    @FindBy(xpath="//input[@id=\"password\"]")
    WebElement passwordfield;

    @FindBy(xpath="//input[@id=\"login-button\"]")
    WebElement loginButton;
    
    @FindBy(xpath="//span[text()='Products']")
    WebElement productspage;
    
    @FindBy(xpath="//h3[text()='Epic sadface: Username is required']")
    WebElement noUser;
    
   public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }
   
   public LogInPage enterName(String username) {
       usernamefield.clear();
       usernamefield.sendKeys(username);
       return this;
       
   }

   public LogInPage enterPassword(String pass) {
       passwordfield.clear();
       passwordfield.sendKeys(pass);
       return this;
   }
public void clickLogin() {
       loginButton.click();
   }
   public void validateLogIn(String testType,String expectedMessage) {
	   if(testType.equals("ValidInput")) {
			String actualText=productspage.getText();
			Assert.assertEquals(actualText, expectedMessage);
		System.out.println("Login successful");
			}
	   if(testType.equals("InvalidInput")){
	   {
	   	String actualText1=noUser.getText();
	   	Assert.assertEquals(actualText1, expectedMessage);
	   }
	   	 if(testType.equals("PasswordFieldMask")) {
	   		WebElement passwordField = driver.findElement(By.id("password"));
	   String fieldType = passwordField.getAttribute("type");
	   Assert.assertEquals(fieldType, "password", "Password field is not masked!");
	   	 }
   }}
   public boolean isLoginPageDisplayed() {
       return loginButton.isDisplayed();
   }
   public boolean isLoginButtonVisible() {
	   return wait.until(ExpectedConditions.visibilityOf(loginButton)).isDisplayed();
   }
}