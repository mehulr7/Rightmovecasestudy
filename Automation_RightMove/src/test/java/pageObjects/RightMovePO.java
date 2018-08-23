package pageObjects;

public interface RightMovePO {
	
//Storing the locators of all elements to be used in testcase
public final static String css_SearchTextField = "#searchLocation";
public final static String css_ForSaleButton = "#buy";
public final static String css_SearchRadiusFilter = "#radius";
public final static String css_PriceRangeMinPriceFilter = "#minPrice";
public final static String css_PriceRangeMaxPriceFilter = "#maxPrice";
public final static String css_MinBedroomsFilter = "#minBedrooms";
public final static String css_MaxBedroomsFilter = "#maxBedrooms";
public final static String css_PropertyTypeFilter = "#displayPropertyType";
public final static String css_AddedToSiteFilter = "#maxDaysSinceAdded";
public final static String css_UnderOfferCheckBox = ".tickbox--indicator";
public final static String css_FindPropertiesButton = "#submit";
public final static String css_SortFilter = "#sortType";
public final static String xpath_NonFeatureProp = ".//*[@class='propertyCard']//div[@class='propertyCard-details']/a//span";
public final static String xpath_NonFeaturePropName = ".//*[@class='left']/address";



}