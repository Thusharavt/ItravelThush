package net.focltng.pages;

import org.openqa.selenium.By;

public class SellingAppHomePage {
	
			
	public By MyRecentBookingsOrCartsUnderCruiseTab = By.xpath("//a[@sp-label='label.landingpage.myRecentBookings']");
		
	public By RecentBookingsIdListUnderCruiseTab = By.xpath("//a[contains(@class,'recentbookingsID')]");
	
	public By SearchKeywordUnderMyRecentBookingOrCarts = By.id("postal");		
	
	public By  DirectCustomerOnTheSellingAppHomePage  = By.xpath("//input[@id='cpr_typeaheadname']");
			
	public By LoadButtonOnTheSellingAppHomePage = By.xpath("//button[@ng-click='loadMiniProfile()'][text()='Load']");
	
	public By enterThreeLttersOnTheFirstNameOfTheDirectCustomer = By.xpath("//a[@class='anci right ng-binding']");
		
	public By FirstNameInTheCreateNewProfilePage = By.xpath("//input[@id='create_profile_First_Name']");
	
	public By EnterTheLastNameInTheCreateNewProfilePage = By.xpath("//input[@id='create_profile_Last_Name']");
	
	public By CreateNewProfileOnTheSellingAppHomePage = By.xpath("//div[@class='cpr-dropdown-show-panel ng-scope']//ul//li//span[text()='Create New Profile']");

	public By EnterTheEmailOfTheCustomerOnTheCreateNewProfile = By.xpath("//input[@id='create_profile_Email']");

	public By ConfirmButtonOnTheCreateNewProfile = By.xpath("//button[text()='Confirm'][@ng-click='loadOrCreateCustomer()']");																																																											 
	
	public By HeadingCreateNewProfileOnTheSellingAppHomePage = By.xpath("//span[@id='ui-id-7']");
	
	public By MiniProfileOnSellingAppHomePage = By.xpath("//span[@class='text-center mini-cart-head width_90 ng-binding']");
	
	public By ViewProfilePopUpOnTheSellingAppHomePage = By.xpath("//button[@ng-click='showCustomerProfile(miniCustomer)'][text()='View Profile']");
	
	public By ContactInformationOnTheViewProfilePage = By.xpath("//div[@id='travel-dtl']//ul[@role='tablist']//li//label");
		
	public By TableOnTheViewProfilePageLocator = By.xpath("//div[@id='travel-dtl']");
		
	public By AddPhoneOnTheContactInformationPage = By.xpath("//span[@class='ga-nbcbcp__chargedetails-btn']");
	
	public By AddressLineOnTheContactInformationPage= By.xpath("//input[@class='form-control pull-left ng-pristine ng-valid ng-touched']");
	
	public By CountryNameOnTheContactInformationPage = By.xpath("//div[@id='s2id_autogen219']//a[@class='select2-choice']");
	
	public By SelectTheCountryFromTheDropDownOnContactInformation = By.xpath("//div[@class='select2-result-label'][text()='Andorra']");
	
	public By CityNameOnTheConfirmationPage = By.xpath("//input[@class= 'form-control pull-left ng-pristine ng-valid ng-touched'][@ng-model ='haddress.city']");
		
	public By PostCodeInTheContactInformationPagE = By.xpath("//input[@class= 'form-control pull-left ng-pristine ng-untouched ng-valid'][@ng-model ='haddress.zipCode']");
	
	public By SaveButtonOnTheContactInformationPage = By.xpath("//span[@class='ga-nbcbcp__chargedetails-btn']");
	
	public By DirectCustomerFirstNameSuggestionlist = By.xpath("//li[@ng-repeat='(matchIndex,match) in matches']");
	
	public By  AgencyOnTheSellingAppHomePage  = By.xpath("//input[@id='agnParamConfig[0].configId']");
	
	public By  AgencyCodeSuggestionOnTheSellingAppHomePage  = By.xpath("//li[@ng-repeat='match in matches']");
	
	public By LoadButtonAgencyOnTheSellingAppHomePage = By.xpath("//button[@ng-click='loadMiniAgencyProfile()'][text()='Load']");
	
	public By AgencyMiniProfileIconOnMiniProfilePopup = By.xpath("//i[@title='Agency profile']");
	
	
}

	

