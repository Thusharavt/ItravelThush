package net.focltng.pages;

import org.openqa.selenium.By;

public class BookingConfirmationPage {
	
	public By ConfirmAndExitButton = By.xpath("//button[contains(@ng-click,'confirmAndExit')]");
	
	public By BookingReferenceId = By.xpath("//span[contains(@sp-label,'bookingReferenceNo')]//following-sibling::span");
	
	public By ChargeDetailsOnTheBookingConfirmationPage = By.xpath("//span[@class='ga-nbcbcp__chargedetails-btn']");
	
	public By CancelBookingOnTheBookingConfirmationPage = By.xpath("//button[@class='btn btn-default ga-nbcbcp__cancelbooking-btn']");

	public By AddOrUpdatePassengersInforButton = By.xpath("//a[@class='anci right ng-binding']");
						
	public By AddPassengerOnTheBookingConfirmationPage = By.xpath("//button[@class='btn btn-orange'][text()='Add']");
	
	public By PassengerTypeOnTheAddPassenegerPage = By.xpath("//span[text()='Passenger']");
	
	public By SelectFromTheDropDownOfAddPassengerPage(String passengerType) {return By.xpath("//div[text()='"+passengerType+"']");}
	
	public By FirstNameOfThePassengerOnTheAddPassengerPage = By.xpath("//input[@id='typeaheadnameP']");
	
	public By SaveButtonOnTheAddPassengerPage = By.xpath("//button[@ng-click='checkCPSetting(passenger,mainFormConfirm,booking)']");
		
	public By FirstNameSuggestionsOnAddPassengerPage = By.xpath("//span[@class='name_ w-100 left ng-binding']");
		
	public By ReviseItemButtonOnTheBookingConfirmationPage = By.xpath("//a[@class='bkg_a_holdr act_09']");
	
	public By RadioButtonOfNewPassengerInTheBookingConfirmationpage = By.id("recentCruiseAmendment_2");
		
	public By ContinueButtonOnTheBookingConfirmationPage = By.xpath("//button[@ng-click='cruiseAmendment.proccedToCruiseRevise()']");
		
	public By RadioButtonOfTermsAndConditionInTheBookingConfirmationpage = By.xpath("//input[@Id='recentCruiseAmendment_2']");
		
	public By TermsAndConditionOnTheBookingConfirmationPage = By.xpath("//input[@type='checkbox'][@id='acceptTnC']");	
	
    public By ProceedButtonOnTheBookingConfirmationPage = By.xpath("//button[@ng-click='cruiseAmendment.proceedFromAmendmentSummary()']");	
	
	public By AssertionFirstNameOnTheBookingConfirmationPage = By.xpath("//th[text()='First Name']//following::tr/td[@class='ng-binding'][3]");
   
	public By AssertionInformationOnTheBookingConfirmationPage = By.xpath("//h4[text()='Passenger Information']");
	
	public By PassengerFirstNameValidation(String PassengerFirstName) {return By.xpath("// tr[@ng-repeat=\"passenger in booking.passengerInfoBookingVOListAll | orderBy:'passenger.status'\"]//td[text()='"+PassengerFirstName+"'][@class='ng-binding' ]");}
	
	public By BookingIdValidation(String BookingId) {return By.xpath("//span[text()='"+BookingId+"'][@class='left bkg_no ng-binding']");}
	
	public By BookingConfirmationStatus = By.xpath("//span[text()='Booking Status']/..//span[@class='pass_value pass_value_02 ng-binding success']");
	
	public By PaxValidaiton = By.xpath("//span[@class='w-auto left dot-view ng-binding']");
		
	public By PassengerAlreadyExist = By.xpath("//span[text()='The Passenger already exists.']");
	
	public By MoreOptionsButtonUnderConfirmationpage = By.xpath("//a[@class='bkg_a_holdr act_108 rel']");
	
	public By AddFacilitiesButtonUnderConfirmationpage = By.xpath("//span[@class='tip_data']");
	
	public By FacilityAdditionCheckboxUnderConfirmationpage = By.xpath("(//input[@class='left'])[2]");
		
	public By SaveButtonUnderConfirmationpage = By.xpath("//button[@ng-click='proceedToModifyFacilityForCabin(cruiseDetailsVO)']");
	
	public By FacilityFieldUnderConfirmationpage = By.xpath("//span[normalize-space()='Facilities']");
	
	public By ViewDetailsButtonUnderConfirmationpage = By.xpath("//div[@class='promo_popup promo_popup_03 collapse in ng-scope']//a[@class='link_'][normalize-space()='View Details']");
	
	public By FacilityListUnderConfirmationpage = By.xpath("//div[@class='tab-pane ng-scope active']//div[@class='fac_head'][normalize-space()='Facility Name']");
	
	public By ViewDetailsUnderConfirmationpage =By.xpath("//div[@class='fac_sub_head text-left ng-binding ng-scope'][normalize-space()='A2']");
	
	public By ViewCotDetailsUnderConfirmationpage =By.xpath("//span[normalize-space()='CO - Reserve Infant Cot']");

	public By CnfButtonForSecondPassenger = By.xpath("//div[text()='A2']//following::div[@class='fac_sub_content'][2]//input[@type='checkbox']");
	
	//public By CnfButtonForSecondPassenger2 =By.xpath("(//input[@value='{\"paxRefId\":2,\"chkLabel\":\"A2\",\"paxType\":\"A\",\"paxIdentity\":\"A2\",\"cbStatus\":false}'])[1]");
	
	public By StatusOfFacilitySelected= By.xpath("(//i[@ng-if='pdt.tempFacStatus'])[1]");
	
	public By InitialCountOnBookingConfirmationPage = By.xpath("(//div[@sp-label='label.cruiseSearchResultWidget.fcltyAvail']/following::div[@class='fac_content ng-binding'])[2]");
	
	public By FinalCountOnBookingConfirmationPage = By.xpath("(//div[@sp-label='label.cruiseSearchResultWidget.fcltyAvail']/following::div[@class='fac_content ng-binding'])[2]");
	
	public By StatusOfSecondFacilitySelected =By.xpath("(//i[@ng-if='pdt.tempFacStatus'])[2]");
	
	public By FinalCountOfSecondFacilityOnBookingConfirmationPage=By.xpath("(//div[@sp-label='label.cruiseSearchResultWidget.fcltyAvail']/following::div[@class='fac_content ng-binding'])[5]");
	
	public By CnfButtonForSecondfacility = By.xpath("(//i[@ng-if='pdt.tempFacStatus'])[2]");

	public By FinalWaitlistCountOnBookingConfirmationPageOfFirstfacility =By.xpath("(//div[@class='fac_content ng-binding'])[3]");

	public By FinalWaitlistCountOnBookingConfirmationPageOfSecondFacility =By.xpath("(//div[@class='fac_content ng-binding'])[6]");

	public By InitialWaitlistCountOnBookingConfirmationPageOfFirstfacility =By.xpath("(//div[@class='fac_content ng-binding'])[3]");

	public By InitiallWaitlistCountOnBookingConfirmationPageOfSecondFacility =By.xpath("(//div[@class='fac_content ng-binding'])[6]");



}	
	


