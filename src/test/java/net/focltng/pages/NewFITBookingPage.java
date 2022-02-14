package net.focltng.pages;

import org.openqa.selenium.By;

public class NewFITBookingPage {

	public By CruiseCodeInputAreaUnderCruiseTab = By.id("cru-search-cruiseCode");

	public By PassengersInputAreaUnderCruiseTab = By.id("cruise-search-passengers");

	public By AdultCountOnPassengersAreaUnderCruiseTab = By.xpath("//label[text()='Adult']//following-sibling::div//span");

	public By PlusButtonOnAdultFieldInPassengersAreaUnderCruiseTab = By.xpath("//label[text()='Adult']//following-sibling::div//a[contains(@class,'plus')]");

	public By MinusButtonOnAdultFieldInPassengersAreaUnderCruiseTab = By.xpath("//label[text()='Adult']//following-sibling::div//a[contains(@class,'min')]");

	public By DoneButtonOnPassengersAreaUnderCruiseTab = By.xpath("//button[text()='Done']");

	public By DropdownListUnderCruiseTab = By.xpath("//ul[@role='listbox' and @aria-hidden='false']//li//a");

	public By ShowVoyagesButtonUnderCruiseTab = By.xpath("//button[text()='Show Voyages']");

	//Thushara
	public By MyRecentBookingsOrCartsUnderCruiseTab = By.xpath("//a[@sp-label='label.landingpage.myRecentBookings']");

	//Thushara
	public By RecentBookingsIdListUnderCruiseTab = By.xpath("//a[contains(@class,'recentbookingsID')]");

	public By SelectOccupanyCabinFromTheCabinList(String Occupancy) {return By.xpath("//span[@key='" + Occupancy + "']/../../../..//input[@type='radio']");}

	public By SelectOccupanyCabinSecondOptionFromTheCabinCategoryList(String Occupancy) {return By.xpath("(//span[@key='" + Occupancy + "']/../../../..//input[@type='radio'])[2]");}

	public By CruiseIdSelection(String CruiseName) {return By.xpath("//a[@title='" + CruiseName + "']");}
	
	public By AdvanceSearchButton = By.xpath("//a[@class='expand-drop-icon']");
	
	public By ClickOnDealsTab =By.xpath("//a[contains(@ng-click,\"basicCruiseSearch.isOpenDeals=!basicCruiseSearch.isOpenDeals;basicCruiseSearch.manageAdvanceSearch('deals')\")]//i");
	
	public By RatePlanFieldUnderDealsTab = By.xpath("//li[normalize-space()='Select Rate Plan']");
	
	public By RatePlanFieldSearchBoxUnderDealsTab = By.xpath("(//input[@type='text'])[133]");
	
	public By SailingMonthrangeFieldUnderNewFITBooking = By.xpath("//input[@id='dateOrMonthpicker']");
	
	public By MonthSliderUnderNewFITBooking = By.xpath("//label[@for='sailingMonthRangeToggle']//div[@class='slider']");
	
	public By LastNameFieldUnderNewFITBooking = By.xpath("//input[@id='cpr_typeaheadlastname']");
	
	public By FirstNameFieldUnderNewFITBooking = By.xpath("//input[@id='cpr_typeaheadname']");
	
	public By PassengerFieldUnderNewFITBooking = By.xpath("(//span[text()='Region']/following::input)[3]");

	
	public By AddCabinButtonUnderNewFITBooking =By.xpath("//button[text()='Add cabin']");
	
	public By DoneButtonUnderNewFITBooking =By.xpath("//button[normalize-space()='Done']");
	
	public By ShowAllTabUnderNewFITBooking =By.xpath("//a[@class='all mar-r-2xs']//i");
	
	public By CategoryClassFieldUnderNewFITBooking =By.xpath("//li[normalize-space()='Select Category class']");
	
	public By CategoryClassSearchBoxFieldUnderNewFITBooking =By.xpath("//div[@id='select2-drop']/child::div/input");

	public By PromoCodeFieldUnderNewFITBooking =By.xpath("//input[@name='basicCruiseSearch_searchObj_advanceSearch_promotionCode']");


	public By YearFieldUnderNewFITBooking1 =By.xpath("//div[@class='drp-calendar left']//select[@class='yearselect']");
	public By YearOptionUnderNewFITBooking1=By.xpath("(//option[@value='2023'])[1]");
	public By MonthFieldUnderNewFITBooking1 =By.xpath("//div[@class='drp-calendar left']//select[@class='monthselect']");
	public By MonthOptionUnderNewFITBooking1=By.xpath("(//option[text()='Jan'])[1]");
	public By DateOptionUnderNewFITBooking1=By.xpath("(//td[@class='available' and text()='2'])[1]");
	
	
	public By YearFieldUnderNewFITBooking2 =By.xpath("//div[@class='drp-calendar right']//select[@class='yearselect']");
	public By YearOptionUnderNewFITBooking2=By.xpath("(//option[@value='2023'])[2]");
	public By MonthFieldUnderNewFITBooking2 =By.xpath("//div[@class='drp-calendar right']//select[@class='monthselect']");
	public By MonthOptionUnderNewFITBooking2=By.xpath("(//option[text()='Apr'])[2]");
	public By DateOptionUnderNewFITBooking2=By.xpath("(//td[@class='available' and text()='17'])[2]");
	
	public By ApplyButtonUnderNewFITBooking2=By.xpath("//button[text()='Apply']");

	public By RateTypeFieldUnderNewFITBookingPage=By.xpath("//li[normalize-space()='Select Rate type']");
	
	public By RateClassificationFieldUnderNewFITBookingPage=By.xpath("//li[normalize-space()='Select Rate classification']");
	
	public By RateTypeDropdown = By.xpath("//div[@class='select2-result-label']");
	
	public By RateClassificationDropdown= By.xpath("//div[@class='select2-result-label']");
	
	
	
	
	
}
