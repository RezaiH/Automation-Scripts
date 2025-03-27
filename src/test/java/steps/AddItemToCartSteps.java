package steps;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddItemToCart;
import pages.HomePage;
import utils.CommonUtils;

public class AddItemToCartSteps{
	WebDriver driver = BaseTest.driver;
	public static final Logger logger = LogManager.getLogger(AddItemToCartSteps.class);
	
	AddItemToCart cart = new AddItemToCart(driver);
	HomePage home = new HomePage(driver);
	
	@When("User clicks on Desktops tab and click on show Alldesktops")
	public void userClicksOnDesktopsTab() {
		home.hoverOnDesktopTabAndClickOnShowAllDesktops();
		logger.info("user hoverd and clicked on show Alldesktops");
		CommonUtils.hWait(1000);
	}
	@Then("User should be navigated to the Desktops page {string}")
	public void userShouldBeNavigatedToTheDesktopsPage(String title ) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, title);
		logger.info("Assertion Passed");
	}
	@When("User clicks on {string} item")
	public void userClicksOnItem(String item) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cart.sonyVaioPc()));
		cart.sonyVaioPc().click();
		logger.info("user clicked on Sony VAIO item");
		CommonUtils.hWait(1000);
	}
	@Then("User should be navigated to the Sony VAIO page")
	public void userShouldBeNavigatedToTheSonyVAIOPage() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Sony VAIO";
		Assert.assertEquals(actualTitle, expectedTitle);
		logger.info("Assertion Passed");
		CommonUtils.hWait(1000);
	}
	@When("User enters the quantity as {int}")
	public void userEntersTheQuantityAs(int quantity) {
		cart.clearAndEnterQuantity(quantity);
		logger.info("user entered the quantity"+quantity);
		CommonUtils.hWait(1000);
	}
	@And("User clicks on Add to Cart button")
	public void userClicksOnAddToCartButton() {
		cart.clicksOnAddToCartBtn();
		logger.info("user clicked on Add to Cart button");
		CommonUtils.hWait(3000);
	}
	@Then("User gets the message {string}")
	public void userGetsTheErrorMessage(String message) {
		cart.itemAddedMessage(message);
		logger.info("Assertion Passed");
	}
}
