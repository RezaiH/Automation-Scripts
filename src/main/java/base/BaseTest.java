package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.maven.surefire.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.java.AfterAll;
import utils.PropertiesUtils;

public class BaseTest {

	public static WebDriver driver;
	public static Properties properties;
	public static String bro;
	public static String head;
	// ExtentReports variables
	public static ExtentReports extent;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest test;
	public static final Logger log = LogManager.getLogger(BaseTest.class);

	// Initialize WebDriver
	public static WebDriver setDriver() {
		if (driver == null) {
			properties = PropertiesUtils.loadEnvironmentProperties();
			bro = properties.getProperty("browser");
			head = properties.getProperty("headless");
			if (bro.equals("chrome") && head.equals("true")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else if (bro.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (bro.equals("edge")) {
				driver = new EdgeDriver();
			} else if (bro.equals("firefox")) {
				driver = new FirefoxDriver();
			} else {
				System.out.println("Chosen browser not supported!");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// Initialize ExtentReport
			extent = new ExtentReports();
			String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
			sparkReporter = new ExtentSparkReporter(reportPath);
			extent.attachReporter(sparkReporter);
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setDocumentTitle("Automation Report");
			sparkReporter.config().setReportName("Automation Test Execution Summary");
			extent.setSystemInfo("Automation Engineer", "Hussain Rezai");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("OS", "Windows");
			log.info("Driver Initialization Successful");
		}
		return driver;
	}

	// Method to capture the screenshot
	public static void captureScreenshot(String testName) {
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
		try {
			FileUtils.copyFile(sourceFile, new File(screenshotPath));
			test.fail("Screenshot Below:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (IOException i) {
			System.out.println("Screenshot capture failed: "+i.toString());
		}
	}

	public static WebDriver getDriver() {
		try {
			if (driver != null) {
				log.info("Closing Browser");
				driver.quit();
				driver = null;
			}
			return driver;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return driver;
	}
}
