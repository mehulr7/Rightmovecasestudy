package stepDefinition;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import actions.Common;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.RightMovePO;

public class RightMove implements RightMovePO{

	//Initializing string for global use
	String getFirstNonFeatureProp;

	@Given("^Home page of the web application$")
	public void home_page_of_the_web_application(){
	    
		//Printing Testcase name and description
		actions.Common.scenarioName("Search Non feature property", "Search all properties and select non feature property");
		//Launching browser
		Common.launchBrowser();
		try {
			//Opening URL
			Common.open_URL(Common.getValue("RightMoveURL"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@When("^Enter city name under search text field$")
	public void enter_city_name_under_search_text_field(){
		
		try {
			//Entering city naame in search text field
			Common.driver.findElement(By.cssSelector(css_SearchTextField)).sendKeys(Common.getValue("CityName"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Common.extentTest.log(LogStatus.INFO, "Entered city name under search text field");
	    
	}

	@When("^Carry out a For sale search$")
	public void carry_out_a_For_sale_search(){
	   
		//Clicking on for sale button
	    Common.driver.findElement(By.cssSelector(css_ForSaleButton)).click();
	    Common.extentTest.log(LogStatus.INFO, "Clicked on for sale button");
 
	}

	@When("^Select various filters in the dropdowns$")
	public void select_various_filters_in_the_dropdowns(){
		
		
		try {
			//Selecting values from all dropdown lists
			Common.selectByVisibleText(css_SearchRadiusFilter, Common.getValue("RadiusFilter"));
			Common.selectByVisibleText(css_PriceRangeMinPriceFilter, Common.getValue("MinPriceFilter"));		
			Common.selectByVisibleText(css_PriceRangeMaxPriceFilter, Common.getValue("MaxPriceFilter"));		
			Common.selectByVisibleText(css_MinBedroomsFilter, Common.getValue("MinBedroomsFilter"));		
			Common.selectByVisibleText(css_MaxBedroomsFilter, Common.getValue("MaxBedroomsFilter"));		
			Common.selectByVisibleText(css_PropertyTypeFilter, Common.getValue("PropertyTypeFilter"));		
			Common.selectByVisibleText(css_AddedToSiteFilter, Common.getValue("AddedToSiteFilter"));
			//Clicking on underoff checkbox
			Common.driver.findElement(By.cssSelector(css_UnderOfferCheckBox)).click();
			Common.extentTest.log(LogStatus.INFO, "Clicked on underoffer checkbox");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@When("^Click on Find properties button$")
	public void click_on_Find_properties_button(){
	   
		//Clicking on find property button
	Common.driver.findElement(By.cssSelector(css_FindPropertiesButton)).click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	Common.extentTest.log(LogStatus.INFO, "Clicked on find property button");
	
	}

	@When("^Change the sort order on the search results to newest listed$")
	public void change_the_sort_order_on_the_search_results_to_newest_listed(){
	   
		try {
			//Select sort type
			Common.selectByVisibleText(css_SortFilter, Common.getValue("SortType"));
			Thread.sleep(3000);
			Common.extentTest.log(LogStatus.INFO, "Selected "+Common.getValue("SortType")+" from Dropdown");
		    
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@When("^Choose the first non-feature property in the list$")
	public void choose_the_first_non_feature_property_in_the_list(){
		
		//Storing all non feature properties in list
		List<WebElement> list = Common.driver.findElements(By.xpath(xpath_NonFeatureProp));
		Common.extentTest.log(LogStatus.INFO, "Store all non feature property in list");
		//Getting propertyname of first non feature property 
		getFirstNonFeatureProp = list.get(0).getText();
		System.out.println(getFirstNonFeatureProp);
		Common.extentTest.log(LogStatus.INFO, "Getting name of first non feature property as "+getFirstNonFeatureProp+"");
		//Clicking on first non feature property
		list.get(0).click();
		Common.extentTest.log(LogStatus.INFO, "Clicked on first non feature property");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("^Selected property should be open$")
	public void selected_property_should_be_open(){
		
		//Getting property name after opening the first non feature property
		String getNonFeaturePropName = Common.driver.findElement(By.xpath(xpath_NonFeaturePropName)).getText();
		System.out.println(getNonFeaturePropName);
		Common.extentTest.log(LogStatus.INFO, "Getting name of opened non feature property as "+getNonFeaturePropName+"");
		//Verify the property name and match it
		Assert.assertEquals(getNonFeaturePropName, getFirstNonFeatureProp);
		Common.extentTest.log(LogStatus.INFO, "TestCase Passed ");
	    
	}
	
}