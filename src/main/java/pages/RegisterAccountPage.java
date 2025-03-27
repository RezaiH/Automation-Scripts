package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseTest;
import utils.CommonUtils;

public class RegisterAccountPage {


	public RegisterAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="input-firstname")
	private WebElement fNameInputField;
	public void enterFName(String fName) {
		fNameInputField.clear();
		CommonUtils.hWait(1000);
		fNameInputField.sendKeys(fName);
	}
	
	@FindBy(id ="input-lastname")
	private WebElement lNameInputField;
	public void enterLName(String lName) {
		lNameInputField.sendKeys(lName);;
	}
	
	@FindBy(id ="input-email")
	private WebElement emailInputField;
	public void enterEmail(String email) {
		emailInputField.sendKeys(email);;
	}
	
	@FindBy(id ="input-telephone")
	private WebElement telephoneInputField;
	public void enterTelephoneNumber(long number) {
		telephoneInputField.sendKeys(String.valueOf(number));
	}
	public void enterTelephoneNumber(String number) {
		telephoneInputField.sendKeys(number);
	}
	@FindBy(id = "input-password")
	private WebElement passwordInputField;
	public void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}
	
	@FindBy(id="input-confirm")
	private WebElement confPasswordInputField;
	public void enterConfPassword(String confPassword) {
		confPasswordInputField.sendKeys(confPassword);
	}
	
	@FindBy(xpath ="//input[@type='radio'and @name='newsletter']")
	private List<WebElement> radioBttns;
	public void clickOnRadioBttns(String radioText){
		for(WebElement radio: radioBttns) {
			if(radio.getText().equals(radioText)) {
				radio.click();
				break;
			}else {
				radio.click();
			}
		}
	}
	
	
	@FindBy(xpath ="//input[@name='agree']")
	private WebElement privacyPolicyCheck;
	public void clickOnPrivacyPolicyCheck() {
		privacyPolicyCheck.click();
	}
	
	@FindBy(xpath ="//input[@value='Continue']")
	private WebElement continueBtn;
	public void clickOnContinueBtn() {
		 continueBtn.click();
	}
	
	@FindBy(xpath ="//h1[contains(text(),'Your Account Has Been Created!')]")
	private WebElement accCreationSuccessMsg;
	public void getAccCreationSuccessMsg(String expectedMessage) {
		String actualMessage = accCreationSuccessMsg.getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
}
