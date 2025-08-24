package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class CheckOutPage extends ProjectSpecificationMethods {
	@FindBy(id="first-name")
	WebElement firstnamefield;
	
	@FindBy(id="last-name")
	WebElement lastnamefield;

	@FindBy(id="postal-code")
	WebElement postalcodefield;

	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutBtn;

	@FindBy(xpath="//h2[@class=\"complete-header\"]")
	public WebElement confirmationMessage;

	@FindBy(id="continue")
	WebElement continueButton;

	@FindBy(xpath="//button[@id=\"finish\"]")
	WebElement finishButton;

	@FindBy(xpath="//h3[contains(text(),'First Name is required')]")
    public WebElement errormsg;

	public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
}

	 public void enterFirstName(String firstname) {
		 firstnamefield.clear();
		 firstnamefield.sendKeys(firstname);   
	   }
	 
	   public void enterLastName(String lastname) {
		   lastnamefield.clear();
		   lastnamefield.sendKeys(lastname);
	   }

	   public void enterPostalCode(String code) {
		   postalcodefield.clear();
		   postalcodefield.sendKeys(code);
	   }

	public void clickContinue() {
	       continueButton.click();
	   }

	public void clickFinish() {
		  finishButton.click();
	}


}
