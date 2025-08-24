package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class CartPage extends ProjectSpecificationMethods {
	WebDriverWait wait;

	@FindBy(id="continue-shopping")
	WebElement contshopbtn;
	@FindBy(xpath="//button[text()='Checkout']")
	public WebElement checkoutBtn;

	public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}

	 public void contshopping() {
	    	contshopbtn.click();
	    }

	public void checkout() {
		wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
	}}
