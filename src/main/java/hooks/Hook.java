package hooks;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

	private static final Logger log = LogManager.getLogger(Hook.class);
	private static BaseTest baseTest = new BaseTest();
	@Before
	public static void setup(Scenario scenario) {
	     BaseTest.setDriver();
		log.info("Starting Test Setup: "+scenario.getName());
		String scenarioName = scenario.getName();
		baseTest.test = baseTest.extent.createTest(scenarioName);	
		ExtentTest scenarioTest = BaseTest.extent.createTest(scenario.getName());
	}


	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			BaseTest.captureScreenshot(scenario.getName());
			BaseTest.test.fail("Test Failed");
		}else {
			BaseTest.test.pass("Test Passed");
		}
		if(BaseTest.driver != null) {
			log.info("Test Execution Completed");
			BaseTest.extent.flush();
			BaseTest.getDriver();
		}
	}
	
}
