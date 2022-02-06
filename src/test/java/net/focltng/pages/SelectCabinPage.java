package net.focltng.pages;

import org.openqa.selenium.By;

public class SelectCabinPage {
	
	public By CabinCatagoryList = By.xpath("//span[starts-with(@ng-mouseover,'initializeCategoryPopover')]");

	public By FreedomFareRadioButtonList = By.xpath("//input[@type='radio' and starts-with(@ng-checked,'ratePlanDetail.selectedRateplan')]");

	public By SelectCabinButton = By.xpath("//button[contains(@class,'selectcabin-tab')]");

	public By CabinNumberList = By.xpath("//input[contains(@name,'radioButton')]//following-sibling::span");

	public By CabinNumberRadioButtonList = By.xpath("//input[contains(@name,'radioButton')]");

	public By AddToCartButton = By.xpath("//button[text()='ADD TO CART']");

	public By AcceptAndContinueButtonOnPopup = By.id("cabinLevelAlertAcceptButton");

	public By SaveButtonOnBookingContactInfoPopup = By.xpath("//button[@sp-label='label.cartBookingContact.save']");

	public By FirstNameAreaOnBookingContactInfoPopup = By.id("arttypeaheadname");
	
	public By FirstNameSuggestionsOnPopup = By.xpath("//li[starts-with(@ng-click,'selectMatch($index)')]//span[contains(@class,'name')]");

	public By SideMenuPopupOptionsList = By.xpath("//div[contains(@class,'rightPanel')]//div[@class='icons']//i");

	public By FirstNameAreaListOnSelectPassengerPopup = By.name("fname");
	
	public By ContinueButtonOnSelectPassengerPopup = By.xpath("//form[@name='selectPassengerForm']//button[contains(@sp-label,'continue')]");

	public By ReviewCartButtonOnMiniCartSideMenu = By.xpath("//span[@sp-label='label.minicart.ReviewCart']");
	
	public By SelectOccupanycabinfromcabindetailspage(String Ocuupancy ) {return By.xpath("//span[@class='ng-binding'][text()='"+Ocuupancy+"']/../..//input[@type='radio']");}
		
	public By FirstNameOfthePassengerList  = By.xpath("//div[@class='pax-info-th ng-isolate-scope']//li");
		
	public By EnterTheFirstNameOfthePassenger  = By.id("carttypeaheadname");
	
	public By AutoAssignButtonOnCabinCategoryPage = By.xpath("//button[@sp-label='label.cruiseshopping.commonlabel.AutoAssign']");
	
	public By ProceedButtonOnCabinSelectionPage = By.xpath("//button[@ng-click=\"autoAssignCabinSelection(eachCabinIndex,'PRO')\"]");
	
	public By AssociatedTravellerFirstNameField = By.id("typeaheadnameFN_1");
	
	public By AssociatedTravellerFirstNameFieldSuggestionList(String AssociatedTraveller ) {return By.xpath("//span[text() ='"+AssociatedTraveller+"']");}
	
	public By LeadTravellerFirstNameField = By.xpath("//input[@id='typeaheadnameFN_0']");
	
	public By LeadTravellerFirstNameFieldSuggestionList(String LeadTraveller ) {return By.xpath("//span[text()='"+LeadTraveller+"']");}


	public By SelectFacilityUnderCabinSelectionBox = By.xpath("//span[normalize-space()='Select facility']");
	
	public By SelectFacilityUnderCabinSelectionBox2 = By.xpath("(//span[normalize-space()='Select Facility'])[1]");
	
	public By CheckFaclitynum(String Num) {return By.xpath("//div[@data-title='"+Num+"']//input[@type='checkbox']");}
	
	public By CheckFacilitynumCheckbox= By.xpath("(//input[@class='m-0 p-0 ng-valid ng-dirty ng-valid-parse ng-touched'])[2]");
	
	public By SelectFacilityUnderCabinSelectionSearchBox = By.xpath("//*[@id=\"select2-drop\"]/div/input");
	
	public By SelectFacilityUnderCabinSelectionCheckBox = By.xpath("//input[@id='auto_checkBox_cabin__A1']");
	
	public By SelectTwoOccupanycabinfromcabindetailspage = By.xpath("//span[@class='ng-binding'][text()='3']/../..//input[@type='radio']");
	
	//public By FacilityAdditionCheckboxUnderConfirmationpage2 = By.xpath("//input[@id='auto_checkBox_cabin__A1']");
	
	public By FacilityAdditionCheckboxUnderCabinpage2 = By.className("m-0 p-0 ng-valid ng-dirty ng-valid-parse ng-touched");
	
	public By FacilityAdditionAddButton=By.xpath("//a[@class='actn_ic add ng-scope']");
	
	public By InitialCountOnSelectionCabin = By.xpath("//i[@class='din_box avl ng-binding ng-scope']");
	
	public By InitialCountOnSelectionCabinDirectCustomerLogin = By.xpath("(//label[@sp-label='label.bookingConfirmation.cruise.facilities.waitlist']/following::label)[1]");
	
	public By InitialCountOnSelectionCabinForSecondFacility = By.xpath("(//label[@sp-label='label.bookingConfirmation.cruise.facilities.waitlist']/following::label)[3]");
	
    public By InitialWaitlistCountOnCabinSelectionPageOfFirstfacility =By.xpath("(//label[@sp-label='label.bookingConfirmation.cruise.facilities.waitlist']/following::label)[2]");
    
    public By InitialWaitlistCountOnCabinSelectionPageForAutoAssign =By.xpath("(//label[@sp-label='label.bookingConfirmation.cruise.facilities.waitlist']/following::i)[2]");
    
    public By InitialWaitlistCountOnCabinSelectionPageOfSecondFacility =By.xpath("(//label[@sp-label='label.bookingConfirmation.cruise.facilities.waitlist']/following::label)[4]");
    
    public By DetailsButtonOnTheCabinSelectionPage = By.xpath("//label[@ng-show='!categoryDetail.showDetail']");
    
    public By InfoTabOnTheCabinSelectionPage = By.xpath("//a[normalize-space()='Info']");

    public By IdentifiersTabOnTheCabinSelectionPage = By.xpath("//a[normalize-space()='Identifiers']");
    
	public By RatePlanValidation(String RatePlan) {return By.xpath("(//span[normalize-space()='Rate Plan']/following::span[@class='w-100 left m-t-5 fz-12 txt_30 bld-only ng-binding'])[1]");}

	public By CabincategoryValidation(String CategoryClass) {return By.xpath("(//span[contains(text(),'"+CategoryClass+"')])[1]");}

	public By PromocodeValidation(String Promocode) {return By.xpath("//span[contains(@key,'"+Promocode+"')]/..//..//input[@checked='checked']");}

	public By DateValidation = By.xpath("((//button[text()='PROCEED'])[1]/..//..//../div//label)[4]");

	
	
    
}



