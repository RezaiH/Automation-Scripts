package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			
			features = {"src/test/resources/features"},
			glue = {"steps", "hooks"},
			tags = "@validLogin",
			monochrome = true,
			plugin = {"pretty",
					"html:target/cucumber-reports/cucumber.html",
					"json:target/cucumber-reports/cucumber.json",
					"junit:target/cucumber-reports/cucumber.xml"
			},
			snippets = CucumberOptions.SnippetType.CAMELCASE,
			dryRun = false
			// 1. publish = true  will publish the execution report on the cucumber cloud server and we will be provided a link
			// through that link we can access the execution report on the browser
			// 2. creating a cucumber.properties file under src/test/resources folder and providing the value as, cucumber.publish.enabled=true
		    // 3. setting the environment variable through CMD running as administrator and running the command as, 
			// setx /M CUCUMBER_PUBLISH_ENABLED "true"   then we run and we will get a success message that the variable is 
			// saved but we have to remember to restart our computer after it.
		
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
