package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseTest;

public class LoginPage{
//	public WebDriver driver = BaseTest.driver;
	// we can initialize the driver either by extending the BaseTest class through the POM classes or we can declare an instance of WebDriver on top of each POM class
	// and then within the constructor of each POM class we first initialize this as this.driver = driver. this is it for driver initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="input-email")
	private WebElement emailField;
	public void enterEmail(String email) {
		 emailField.sendKeys(email);;
	}
	@FindBy(id = "input-password")
	private WebElement passField;
	public void enterPassword(String password) {
		passField.sendKeys(password);;
	}
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	public void clickOnLoginButton() {
		 loginButton.click();
	}
	@FindBy(xpath = "//div[contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")
	private WebElement errorMessage;
	public void getErrorMessageAndVerify(String expectedMessage) {
		String actualMessage = errorMessage.getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
}
