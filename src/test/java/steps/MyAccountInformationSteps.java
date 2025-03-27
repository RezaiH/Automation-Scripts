package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountInformation;
import pages.RegisterAccountPage;
import utils.CommonUtils;
import utils.PropertiesUtils;

public class MyAccountInformationSteps {
  
	WebDriver driver = BaseTest.driver;
	public static final Logger logger = LogManager.getLogger(MyAccountInformationSteps.class);
	
	HomePage home = new HomePage(driver);
	LoginPage login = new LoginPage(driver);
	RegisterAccountPage register = new RegisterAccountPage(driver);
	MyAccountInformation account = new MyAccountInformation(driver);
	
	@Given("User is logged in into the application")
	public void userIsLoggedInIntoTheApplication() {
		driver.get(PropertiesUtils.loadEnvironmentProperties().getProperty("url"));
		CommonUtils.hWait(2000);
		home.clickOnMyAccTab();
		CommonUtils.hWait(1000);
		home.clickOnLoginOption();
		CommonUtils.hWait(1000);
		login.enterEmail("habibi1@gmail.com");
		CommonUtils.hWait(1000);
		login.enterPassword("habibi");
		CommonUtils.hWait(1000);
		login.clickOnLoginButton();
	}
	@When("User clicks on Edit your account information link")
	public void userClicksOnEditYourAccountInformationLink() {
		account.clickOnEditYourAccountInfoLink();
		logger.info("user clicked on Edit your account information link");
		CommonUtils.hWait(1000);
	}
	@Then("User is navigated to the My Account Information page")
	public void userIsNavigatedToTheMyAccountInformationPage() {
		String actTitle = driver.getTitle();
		String expTitle = "My Account Information";
		Assert.assertEquals(actTitle, expTitle);
	}
	@And("User update the last name as {string}")
	public void userUpdateTheLastNameas(String update) {
		register.enterFName(update);
		logger.info("user updated the first name");
		CommonUtils.hWait(1000);
	}
	@Then("User gets the success message {string}")
	public void userGetsTheSuccessMessage(String message) {
		account.getYourAccountHasBeenSuccessfullyUpdated(message);
		logger.info("Assertion Passed");
	}
}
