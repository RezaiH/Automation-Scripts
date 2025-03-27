package steps;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BaseTest;
import hooks.Hook;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountInformation;
import pages.RegisterAccountPage;
import utils.CommonUtils;
import utils.PropertiesUtils;

public class LoginSteps {
  
	WebDriver driver = BaseTest.driver;
	public static final Logger logger = LogManager.getLogger(LoginSteps.class);
	
	HomePage home = new HomePage(driver);
	RegisterAccountPage register = new RegisterAccountPage(driver);
	LoginPage login = new LoginPage(driver);
	MyAccountInformation account = new MyAccountInformation(driver);
	
	@Given("User is on the website homepage")
	public void userIsOnTheWebsiteHomepage() {
		driver.get(PropertiesUtils.loadEnvironmentProperties().getProperty("url"));
		logger.info("url is successfully launched");
		CommonUtils.hWait(1000);
	}
	@When("User clicks on My Account tab")
	public void userClicksOnMyAccountTab() {
		home.clickOnMyAccTab();
		logger.info("user clicked on My Account tab");
		CommonUtils.hWait(1000);
	}
	@And("User clicks on Register option")
	public void userClicksOnRegisterOption() {
		home.clickOnRegisterOption();
		logger.info("user clicked on Register option");
		CommonUtils.hWait(1000);
	}
	@Then("User is navigated to the Register Account page")
	public void userIsNavigatedToTheRegisterAccountPage() {
		String expectedTitle = "Register Account";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		logger.info("Assertion Passed");
		CommonUtils.hWait(1000);
	}
	@When("User enters first name {string} in the first name input field")
	public void userEntersFirstNameInTheFirstNameInputField(String fName) {
		register.enterFName(fName);
		logger.info("user entered first name");
		CommonUtils.hWait(1000);
	}
	@And("User enters last name {string} in the last name input field")
	public void userEnteresLastNameInTheLastNameInputField(String lName) {
		register.enterLName(lName);
		logger.info("user entered last name");
		CommonUtils.hWait(1000);
	}
	@And("User enters email {string} in the email input field")
	public void userEnteresEmailInTheEmailInputField(String email) {
		register.enterEmail(email);
		logger.info("user entered email");
		CommonUtils.hWait(1000);
	}
	@And("User enters telephone number {int} in the telephone input field")
	public void userEnteresTelephoneNumberInTheTelephoneInputField(long number) {
		register.enterTelephoneNumber(number);
		logger.info("user entered telephone number");
		CommonUtils.hWait(1000);
	}
    @And("User enters telephone number {string} in the telephone input field")
    public void userEntersTelephoneNumberInTheTelephoneInputField(String number) {
    	register.enterConfPassword(number);
    }
	
	@And("User re-enters the password {string} in the confirm password input field")
	public void userReentersThePasswordInTheConfirmPasswordInputField(String confPassword){
		register.enterConfPassword(confPassword);
		logger.info("user re-entered the password");
		CommonUtils.hWait(1000);
	}
	@And("User clicks on Subscribe Yes button")
	public void userClicksOnSubscribeYesButton() {
		register.clickOnRadioBttns("Yes");
		logger.info("user clicked on Yes button");
		CommonUtils.hWait(1000);
	}
	@And("User checks the Privacy Policy checkbox")
	public void userChecksThePrivacyPolicyCheckbox() {
		register.clickOnPrivacyPolicyCheck();
		logger.info("user checked the Privacy Policy checkbox");
		CommonUtils.hWait(1000);
	}
	@And("User clicks on Continue button")
	public void userClicksOnContinueButton() {
		register.clickOnContinueBtn();
		logger.info("user clicked on Continue button");
		CommonUtils.hWait(1000);
	}
	@Then("User is navigated to the Your Account Has Been Created page")
	public  void userIsNavigatedToTheYourAccountHasBeenCreatedPage() {
		register.getAccCreationSuccessMsg("Your Account Has Been Created!");
	}
	
	// valid login
	@And("User clicks on Login option")
	public void userClicksOnLoginOption() {
		home.clickOnLoginOption();
		logger.info("user clicked on login option");
		CommonUtils.hWait(1000);
	}
	@Then("User is navigated to the Account Login page")
	public void userIsNavigatedToTheAccountLoginPage() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Account Login";
		Assert.assertEquals(actualTitle, expectedTitle);
		logger.info("Assetion Passed");
		CommonUtils.hWait(1000);
	}

	@When("User enters the email {string} in the email input field")
	public void userEntersTheEmailInTheEmailInputField(String email) {
		login.enterEmail(email);
		logger.info("user entered email");
		CommonUtils.hWait(1000);
	}
	@And("User enters the password {string} in the password input field")
	public void userEntersThePasswordInThePasswordInputField(String password) {
		login.enterPassword(password);
		logger.info("user entered password");
		CommonUtils.hWait(1000);
	}
	@And("User clicks on the Login button")
	public void userClicksOnTheLoginButton() {
	   login.clickOnLoginButton();
	   logger.info("user clicked on the loging button");
	   CommonUtils.hWait(1000);
	}
	@Then("User is navigated to the My Account page")
	public void userIsNavigatedToTheMyAccountPage() {
		String actTitle = driver.getTitle();
		String expTitle = "My Account";
		Assert.assertTrue(actTitle.equals(expTitle));
		logger.info("Assertion Passed");
		String expectedText ="My Account";
		String actualText = account.getMyAccountText();
		if(actualText.equals(expectedText)) {
			logger.info("Assertion Passed");
		}else {
			logger.info("Assertion Failed");
		}
	}
	// invalid login
	@Then("User gets an error message {string}")
	public void userGetsAnErrorMessage(String message) {
		login.getErrorMessageAndVerify(message);
		logger.info("Assertion Passed");
	}
	
	// multiple user login
	/*
	 * @When("User enters email {string} in the email input field") public void
	 * userEntersEmailInTheEmailInuptField(String email) { login.enterEmail(email);
	 * logger.info("user entered email address"); CommonUtils.hWait(1000); }
	 */

	  @And("User enters password {string} in the password input field") public void
	  userEntersPasswordInThePasswordInputField(String password) {
	  login.enterPassword(password); logger.info("user entered password");
	  CommonUtils.hWait(1000); }
	
	/*
	 * @And("User fills the inputs with below information") public void
	 * userFillsTheInputWithBelowInformation(DataTable table) { List<List<String>>
	 * data = table.asLists(String.class); for(int i = 1; i< data.size(); i++) {
	 * register.enterFName(data.get(i).get(0));
	 * register.enterLName(data.get(i).get(1));
	 * register.enterEmail(data.get(i).get(2));
	 * register.enterTelephoneNumber(data.get(i).get(3));
	 * register.enterConfPassword(data.get(i).get(4)); } }
	 */
	
	@And("User fills the inputs with below information")
	public void userFillsTheInputsWithBelowInformation(DataTable table) {
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for(Map <String, String> map : data) {
			register.enterFName(map.get("firstName"));
			CommonUtils.hWait(1000);
			register.enterLName(map.get("lastName"));
			CommonUtils.hWait(1000);
			register.enterEmail(map.get("emailAddress"));
			CommonUtils.hWait(1000);
			register.enterTelephoneNumber(map.get("telephoneNumber"));
			CommonUtils.hWait(1000);
			register.enterPassword(map.get("password"));
			CommonUtils.hWait(1000);
			register.enterConfPassword(map.get("confPassword"));
			CommonUtils.hWait(1000);
		}
	}
	
	@When("User clicks on Logout link")
	public void userClicksOnLogoutLink() {
		account.clicksOnLogoutLink();
		CommonUtils.hWait(1000);
	}
	@Then("User is successfully logedout")
	public void userIsSuccessfullyLogedout() {
		 account.getMyAccountText();
	}
	
	
	
	
	/*
	 * extent.setSystemInfo("Automation Engineer", "Hussain Rezai");
	 * extent.setSystemInfo("Environment", "QA"); extent.setSystemInfo("Browser",
	 * "Chrome"); extent.setSystemInfo("OS", "Windows");
	 */

	// below is how we get the system information dynamically
	/*
	 * extent.setSystemInfo("OS", System.getProperty("os.name"));
	 * extent.setSystemInfo("OS Version",System.getProperty("os.version"));
	 * extent.setSystemInfo("Java Version",System.getProperty("java.version"));
	 * extent.setSystemInfo("User", System.getProperty("user.name"));
	 * extent.setSystemInfo("Browser",bro );
	 */
	
	
	
}
