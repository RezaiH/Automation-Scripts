package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBox;
	
	@FindBy(xpath="(//img[@alt='iPhone 6'])[2]")
	private WebElement pictureSection;
	
	@FindBy(xpath ="(//a[text()='Login'])[1]")
	private WebElement loginOption;
	public void clickOnLoginOption() {
		loginOption.click();
	}
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccTab;
	public void clickOnMyAccTab() {
		myAccTab.click();
	}
	@FindBy(linkText="Register")
	private WebElement registerOption;
	public void clickOnRegisterOption() {
		registerOption.click();
	}
	@FindBy(xpath = "//span[@class='input-group-btn']//child::button/i")
	private WebElement searchBttn;
	
	@FindBy(xpath="//div[@id='cart']")
	private WebElement cartItemIcon;
	 
	@FindBy(xpath = "//a[text()='Qafox.com']")
	private WebElement qafoxcomText;
	
	@FindBy(xpath = "(//a[text()='Desktops'])[1]")
	private WebElement desktopTab;
	public void hoverOnDesktopTabAndClickOnShowAllDesktops() {
	    WebDriver driver = BaseTest.driver;
		Actions actions = new Actions(driver);
		actions.moveToElement(desktopTab).perform();
		clickShowAllDesktops();
	}
	@FindBy(linkText ="Show AllDesktops")
	private WebElement showAllDesktops;
	public void clickShowAllDesktops() {
		showAllDesktops.click();
	}
	@FindBy(xpath ="//li/a[text()='PC (0)']")
	private WebElement pC0;
	
	@FindBy(xpath ="//li/a[text()='Mac (1)']")
	private WebElement mac1;
	
	@FindBy(xpath = "//a[text()='Laptops & Notebooks']")
	private WebElement LaptopsNotebooksTab;
	
	@FindBy(xpath ="(//a[contains(text(),'Laptops & Notebooks')])[2]")
	private WebElement showAllLabptopsAndNotebooks;
	 
	@FindBy(xpath ="(//ul[@class='list-unstyled'])/li/a[contains(@href,'18')]")
	private List<WebElement> macsAndWindows;
	
	
	@FindBy(xpath = "//a[text()='Components']")
	private WebElement componentsTab;
	
	@FindBy(xpath = "(//ul[@class='list-unstyled'])[3]/li")
	private WebElement componentsList;
	
	@FindBy(linkText ="Tablets")
	private WebElement tabletsTab;
	
	@FindBy(xpath = "//a[text()='Software']")
	private WebElement softwareTab;
	
	@FindBy(linkText ="Phones & PDAs")
	private WebElement phonesAndPDAsTab;
	
	@FindBy(xpath = "//a[text()='Cameras']")
	private WebElement camerasTab;
	
	@FindBy(xpath = "//a[text()='MP3 Players']")
	private WebElement mp3PlayersTab;
	
	@FindBy(xpath ="(//li[@class='dropdown'])[5]//ul/li")
	private List<WebElement> mp3PlayersList;
	
	
	@FindBy(xpath = "//a[text()='MacBook']")
	private WebElement macBook;
	
	@FindBy(xpath ="//a[text()='iPhone']")
	private WebElement iphone;
	
	@FindBy(xpath = "//a[text()='Apple Cinema 30\"']")
	private WebElement appleCinema30;
	
	@FindBy(xpath = "//a[text()='Canon EOS 5D']")
	private WebElement canonEos5d;
	
	@FindBy(xpath = "(//h5)[1]")
	private WebElement informationText;
	
	@FindBy(xpath ="(//h5)[2]")
	private WebElement customerServiceText;
	
	@FindBy(xpath ="(//h5)[3]")
	private WebElement extrasText;
	
	@FindBy(xpath ="(//h5)[4]")
	private WebElement myAccountText;
	
	@FindBy(xpath ="(//ul[@class='list-unstyled'])[8]/li[1]")
	private WebElement aboutUsLink;
	
	@FindBy(xpath ="(//ul[@class='list-unstyled'])[8]/li[2]")
	private WebElement deliveryInformationLink;
	
	@FindBy(xpath="(//ul[@class='list-unstyled'])[8]/li[3]")
	private WebElement privacyPolicyLink;
	
	@FindBy(xpath ="(//ul[@class='list-unstyled'])[8]/li[4]")
	private WebElement tersmAndConditionsLink;
	
	@FindBy(xpath = "(//ul[@class='list-unstyled'])[9]/li[1]")
	private WebElement contactUsLink;
	
	@FindBy(xpath = "(//ul[@class='list-unstyled'])[9]/li[2]")
	private WebElement returnsLink;
	
	@FindBy(xpath ="(//ul[@class='list-unstyled'])[9]/li[3]")
	private WebElement siteMapLink;
	
	@FindBy(xpath ="(//ul[@class='list-unstyled'])[10]/li[1]")
	private WebElement brandsLink;
	
	@FindBy(xpath = "(//ul[@class='list-unstyled'])[10]/li[2]")
	private WebElement giftCertificatesLink;
	
	@FindBy(xpath ="(//ul[@class='list-unstyled'])[10]/li[3]")
	private WebElement affiliateLink;
	
	@FindBy(xpath ="(//ul[@class='list-unstyled'])[10]/li[4]")
	private WebElement specialsLink;
	
	@FindBy(xpath = "(//ul[@class='list-unstyled'])[11]/li[1]")
	private WebElement myAccountLink;
	
	@FindBy(xpath ="(//ul[@class='list-unstyled'])[11]/li[2]")
	private WebElement orderHistoryLink;
	
	@FindBy(xpath ="(//ul[@class='list-unstyled'])[11]/li[3]")
	private WebElement wishListLink;
	
	@FindBy(xpath ="(//ul[@class='list-unstyled'])[11]/li[4]")
	private WebElement newsLetterLink;
	
	@FindBy(tagName = "h3")
	private WebElement featuredText;
	
	@FindBy(xpath = "//span[text()='Currency']")
	private WebElement currencyTab;
	
	@FindBy(xpath ="//span[text()='Checkout']")
	private WebElement checkout;
	
	@FindBy(xpath ="//span[text()='Shopping Cart']")
	private WebElement shoppingCart;
	
	@FindBy(xpath ="//span[text()='Wish List (0)']")
	private WebElement wishList;
	
	@FindBy(xpath ="//span[text()='123456789']")
	private WebElement telephoneNumber;
	
}
