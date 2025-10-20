package pages;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.ProjectSpecificationMethods;

public class ProductPage extends ProjectSpecificationMethods{
	WebDriverWait wait;

	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	public WebElement productlink1;

	@FindBy(xpath="//button[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement backpackbtn;

	@FindBy(xpath="//button[text()='Add to cart']")
	WebElement addtoCartBtn;

    @FindBy(xpath="//div[text()='Sauce Labs Onesie']")
    public WebElement productlink2;

    @FindBy(xpath="//div[text()='Test.allTheThings() T-Shirt (Red)']")
    public WebElement productlink3;

	@FindBy(id="back-to-products")
	WebElement prodBtn;

	@FindBy(xpath="//a[@class=\"shopping_cart_link\"]")
	public WebElement cartButtonIcon;

	@FindBy(xpath="//button[@id=\"remove-sauce-labs-onesie\"]")
    WebElement removeBtn;

	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	WebElement productTitle;

	@FindBy(xpath = "//div[@class=\"inventory_details_price\"]")
	WebElement productPrice;

	@FindBy(xpath = "//div[contains(text(), 'carry.allTheThings()')]")
	WebElement productDescription;
	
	@FindBy(xpath="//button[text()='Open Menu']")
	WebElement menuButton;

	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutButton;

	 public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

     public void selectProduct() {
    	 backpackbtn.click();
     }
	 public void selectProduct1() {
	    	productlink1.click();
	    	}
	    public void selectProduct2() {
	    	productlink2.click();
	    	}
	    public void addToCart() {
          addtoCartBtn.click();
         	    }
	    public String getProductTitle() {
			return wait.until(ExpectedConditions.visibilityOf(productTitle)).getText().trim();
		}
		public String getProductPrice() {
			return wait.until(ExpectedConditions.visibilityOf(productPrice)).getText().trim();
		}
		public String getProductDescription() {
			return wait.until(ExpectedConditions.visibilityOf(productDescription)).getText().trim();
		}

	    private void handleLoginAlert() {
	        try {
	            Alert alert = driver.switchTo().alert();
	            alert.accept(); // Clicks "OK"
	        } catch (NoAlertPresentException e) {
	            // No alert to handle — continue execution
	        }
	    }
	    public void backToProducts() {
	    	wait.until(ExpectedConditions.elementToBeClickable(prodBtn)).click();
	    }

	    public void navigateToCart() {
	    	wait.until(ExpectedConditions.elementToBeClickable(cartButtonIcon)).click();
	    }

	    public void removeItemFromCart() {
	        wait.until(ExpectedConditions.elementToBeClickable(removeBtn)).click();
	    }
	    public void clickLogout() {
			wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
			wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
		}}

	    