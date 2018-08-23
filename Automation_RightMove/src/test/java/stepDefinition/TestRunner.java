package stepDefinition;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import actions.Common;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(

		//Giving path of the feature folder and stepDefinition and plugin for generating report
		features = "src\\test\\resources\\feature", glue = "stepDefinition", plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:Result/report.html" },
       //Giving tag name for which test need to be executed
		tags = { "@RightMoves" })

public class TestRunner extends AbstractTestNGCucumberTests {
    //Declaring object of ExtentReports
	public static ExtentReports extentReports = null;
	//Declaring object of ExtentTest
	public static ExtentTest extentTest = null;

	@BeforeClass

	public static void extent() throws IOException {
        //Setting path for saving the logs
		extentReports = new ExtentReports(System.getProperty("user.dir") + "\\Logs\\Logs.html");

	}

	@AfterMethod

	public static void exit() {
        //Exiting from browser
		Common.driver.quit();
		//Printing the text in logs file
		extentTest.log(LogStatus.INFO, "Browser exit.");
	}

	@AfterClass

	public static void flush() {

		//Flushing the extent report
		extentReports.flush();

	}

}
