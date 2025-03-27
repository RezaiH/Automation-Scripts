package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyAccountInformation{

	public MyAccountInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText ="Edit your account information")
	private WebElement editYourAccountInfoLink;
	public void clickOnEditYourAccountInfoLink() {
		editYourAccountInfoLink.click();
	}
	
	@FindBy(xpath ="//div[contains(@class, 'alert-success') and contains(text(), 'Success: Your account has been successfully updated.')]")
	private WebElement yourAccountHasBeenSuccessfullyUpdated;
	public void getYourAccountHasBeenSuccessfullyUpdated(String exp) {
		String act = yourAccountHasBeenSuccessfullyUpdated.getText();
		Assert.assertEquals(act, exp);
	}
	@FindBy(xpath = "(//h2)[1]")
	private WebElement myAccountText;
	public String getMyAccountText() {
		String actualText = myAccountText.getText();
		return actualText;
	}
	
	@FindBy(xpath = "(//h1)[2]/following-sibling::p[contains(text(),'You have been logged off your account.')]")
	private WebElement logOutText;
	public void getLogoutText() {
		String actualText = logOutText.getText();
		String expectedText = "You have been logged off your account. It is now safe to leave the computer.";
		Assert.assertEquals(actualText, expectedText);
	}
	@FindBy(linkText = "Change your password")
	private WebElement changeYourPassLink;
	
	@FindBy(linkText = "Modify your address book entries")
	private WebElement modifyYourAddressBookEntries;
	
	@FindBy(linkText = "Modify your wish list")
	private WebElement modifyYourWishList;
	
	@FindBy(xpath ="//h2[text()='My Orders']")
	private WebElement myOrdersText;
	
	@FindBy(xpath ="(//ul)[15]/li[1]")
	private WebElement viewYourOrderHistory;
	
	@FindBy(xpath ="(//ul)[15]/li[2]")
	private WebElement downloads;
	
	@FindBy(xpath = "(//ul)[15]/li[3]")
	private WebElement YourRewardPoints;
	
	@FindBy(xpath ="(//ul)[15]/li[4]")
	private WebElement viewYourReturnRequests;
	
	@FindBy(xpath = "(//ul)[15]/li[5]")
	private WebElement yourTransactions;
	
	@FindBy(xpath ="(//ul)[15]/li[6]")
	private WebElement recurringPayments;
	
	@FindBy(xpath = "//h2[text()='My Affiliate Account']")
	private WebElement myAffiliateAccountText;
	
	@FindBy(xpath ="//h2[text()='My Affiliate Account']/following::a[contains(text(),'Register for an')]")
	private WebElement registerForAnAffiliateAccountLink;
	
	@FindBy(xpath ="//h2[text()='Newsletter']")
	private WebElement newsLetterText;
	
	@FindBy(xpath ="//h2[text()='Newsletter']/following::a[contains(text(),'Subscribe / ')]")
	private WebElement subscribe_unscribeLink;
	
	@FindBy(xpath ="//div[@class='list-group']//a[1]")
	private WebElement myAccountLink;
	
	@FindBy(xpath ="//div[@class='list-group']//a[2]")
	private WebElement editAccountLink;
	
	@FindBy(xpath ="//div[@class='list-group']//a[3]")
	private WebElement passwordLink;
	
	@FindBy(xpath ="//div[@class='list-group']//a[4]")
	private WebElement addressBookLink;
	
	@FindBy(xpath ="//div[@class='list-group']//a[5]")
	private WebElement wishListLink;
	
	@FindBy(xpath ="//div[@class='list-group']//a[6]")
	private WebElement orderHistoryLink;
	
	@FindBy(xpath ="//div[@class='list-group']//a[7]")
	private WebElement downloadsLink;
	
	@FindBy(xpath ="//div[@class='list-group']//a[13]")
	private WebElement logoutLink;
	public void clicksOnLogoutLink() {
		logoutLink.click();
	}
	
	
	

}
