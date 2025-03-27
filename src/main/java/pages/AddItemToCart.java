package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddItemToCart {

	public AddItemToCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//h4)[12]/a")
	private WebElement sonyVaioPc;
	public WebElement sonyVaioPc() {
		return sonyVaioPc;
	}
	@FindBy(xpath = "//input[@name='quantity']")
	private WebElement quantityInputField;
	public void clearAndEnterQuantity(int quantity) {
		quantityInputField.clear();
		quantityInputField.sendKeys(String.valueOf(quantity));
	}
	@FindBy(xpath = "//button[text()='Add to Cart']")
	private WebElement addToCartButton;
	public void clicksOnAddToCartBtn() {
		addToCartButton.click();
	}
	@FindBy(xpath = "//div[contains(@class, 'alert-success')]")
    private WebElement itemAddMessage;
	public void itemAddedMessage(String message) {
		String actualMessage = itemAddMessage.getText();
		Assert.assertEquals(actualMessage, message);
	}
}



