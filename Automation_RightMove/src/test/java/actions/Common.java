package actions;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import stepDefinition.TestRunner;

public class Common extends TestRunner {


	public static DesiredCapabilities capabilities;

	static WebDriverWait wait = null;
	public static WebDriver driver;

	public static void launchBrowser() {
        //Setting the path of chromedriver and initializing the driver
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("excludeSwitches", "enable-automation");
		options.setExperimentalOption("prefs", prefs);
		capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("version", "latest");
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		extentTest.log(LogStatus.INFO, "Browser opened successfully");

	}

	public static void open_URL(String URL) throws InterruptedException {

		//Opening URL of the app
		driver.get(URL);
		//Waiting for 3 seconds
		Thread.sleep(3000);
		extentTest.log(LogStatus.INFO, "URL opened successfully");

	}

	public static String getValue(String input) throws IOException {

		//Creating object of Filereader to get values from config file and setting up path of config
		FileReader reader = new FileReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\confi.properties");
		//Creating object of property file
		Properties prop = new Properties();
		//Loading reader object in property to read
		prop.load(reader);
		String getProp = prop.getProperty(input);
        // Getting property values 
		return getProp;
	}

	public static void exitBrowser() {
		//Quit from browser
		driver.quit();
	}

	public static void scenarioName(String testName, String description) {

		//Storing all logs under extentTest
		extentTest = extentReports.startTest(testName, description);

	}

	public static WebElement waitForElement(WebElement element) {

		try {
            //Creating object of WebDriverwait class
			wait = new WebDriverWait(driver, 40000);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception

			System.err.println(e.getStackTrace());

		}
		return element;

	}
	
	public static void selectByVisibleText(String ele, String text) {
		
		try {
			//Storing webelement in element 
			WebElement element = driver.findElement(By.cssSelector(ele));
			//Creating object of select class to select the values from DDL
			Select select = new Select(element);
			//Selecting value by visible Text
			select.selectByVisibleText(text);
			extentTest.log(LogStatus.INFO, "Selected "+text+" from DDL");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
