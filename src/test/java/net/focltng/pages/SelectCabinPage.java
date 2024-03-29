package net.focltng.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.focltng.utils.WebCtrls;

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
	
	public By SelectOccupanyCabinFromCabinDetailsPage(String Ocuupancy ) {return By.xpath("//span[@class='ng-binding'][text()='"+Ocuupancy+"']/../..//input[@type='radio']");}
		
	public By FirstNameOfThePassengerList  = By.xpath("//div[@class='pax-info-th ng-isolate-scope']//li");
		
	public By EnterTheFirstNameOfThePassenger  = By.id("carttypeaheadname");
	
	public By AutoAssignButtonOnCabinCategoryPage = By.xpath("//button[@sp-label='label.cruiseshopping.commonlabel.AutoAssign']");
	
	public By ProceedButtonOnCabinSelectionPage = By.xpath("//button[@ng-click=\"autoAssignCabinSelection(eachCabinIndex,'PRO')\"]");
	
	public By AssociatedTravellerFirstNameField = By.id("typeaheadnameFN_1");
	
	public By AssociatedTravellerFirstNameFieldSuggestionList(String AssociatedTraveller ) {return By.xpath("//span[text() ='"+AssociatedTraveller+"']");}
	
	public By LeadTravellerFirstNameField = By.xpath("//input[@id='typeaheadnameFN_0']");
	
	public By LeadTravellerFirstNameFieldSuggestionList(String LeadTraveller ) {return By.xpath("//span[text()='"+LeadTraveller+"']");}

	//Thushara
	public By SelectFacilityUnderCabinSelectionBox = By.xpath("//span[normalize-space()='Select facility']");
	
	//lekshmi
	public By SelectFacilityUnderCabinSelectionBoxForAutoAssign = By.xpath("(//span[normalize-space()='Select Facility'])[1]");
	
	//Thushara
	public By CheckFaclityNum(String Num) {return By.xpath("//div[@data-title='"+Num+"']//input[@type='checkbox']");}
	
	//Thushara
	public By CheckFacilityNumCheckbox= By.xpath("(//input[@class='m-0 p-0 ng-valid ng-dirty ng-valid-parse ng-touched'])[2]");
	
	//Thushara
	public By SelectFacilityUnderCabinSelectionSearchBox = By.xpath("//*[@id=\"select2-drop\"]/div/input");
	
	//Thushara
	public By SelectFacilityUnderCabinSelectionCheckBox = By.xpath("//input[@id='auto_checkBox_cabin__A1']");
	
	
	public By SelectOccupanycabinfromcabindetailspage = By.xpath("//span[@class='ng-binding'][text()='3']/../..//input[@type='radio']");
	
	//lekshmi
	public By FacilityAdditionCheckboxUnderConfirmationpage2 = By.xpath("//input[@id='auto_checkBox_cabin__A1']");
	
	//lekshmi
	public By FacilityAdditionCheckboxUnderCabinpage2 = By.className("m-0 p-0 ng-valid ng-dirty ng-valid-parse ng-touched");
	
	//Thushara
	public By FacilityAdditionAddButton=By.xpath("//a[@class='actn_ic add ng-scope']");
	
	//Thushara
	public By InitialCountOnSelectionCabin = By.xpath("//i[@class='din_box avl ng-binding ng-scope']");
	
	//Thushara
	public By InitialCountOnSelectionCabinDirectCustomerLogin = By.xpath("(//label[@sp-label='label.bookingConfirmation.cruise.facilities.waitlist']/following::label)[1]");
	
	//Thushara
	public By InitialCountOnSelectionCabinForSecondFacility = By.xpath("(//label[@sp-label='label.bookingConfirmation.cruise.facilities.waitlist']/following::label)[3]");
	
	//Thushara
    public By InitialWaitlistCountOnCabinSelectionPageOfFirstfacility =By.xpath("(//label[@sp-label='label.bookingConfirmation.cruise.facilities.waitlist']/following::label)[2]");
   
    //lekshmi
    public By InitialWaitlistCountOnCabinSelectionPageForAutoAssign =By.xpath("(//label[@sp-label='label.bookingConfirmation.cruise.facilities.waitlist']/following::i)[2]");
    
  //Thushara
    public By InitialWaitlistCountOnCabinSelectionPageOfSecondFacility =By.xpath("(//label[@sp-label='label.bookingConfirmation.cruise.facilities.waitlist']/following::label)[4]");
    
 
    public By DetailsButtonOnTheCabinSelectionPage = By.xpath("//label[@ng-show='!categoryDetail.showDetail']");
    
    public By InfoTabOnTheCabinSelectionPage = By.xpath("//a[normalize-space()='Info']");

    public By IdentifiersTabOnTheCabinSelectionPage = By.xpath("//a[normalize-space()='Identifiers']");
    
	public By RatePlanValidation(String RatePlan) {return By.xpath("(//span[normalize-space()='Rate Plan']/following::span[@class='w-100 left m-t-5 fz-12 txt_30 bld-only ng-binding'])[1]");}

	public By CabincategoryValidation(String CategoryClass) {return By.xpath("(//span[contains(text(),'"+CategoryClass+"')])[1]");}

	public By PromocodeValidation(String Promocode) {return By.xpath("//span[contains(@key,'"+Promocode+"')]/..//..//input[@checked='checked']");}

	public By RateTypeValidation(String RateType) {return By.xpath("//span[@class='hd_lbl text-center dot-view ng-binding sltd']");}
	

	
	
	
	public By SpecificOccupancyOnCabinCategoryPage(String Occupancy, int i) {return By.xpath("(//span[@key='"+Occupancy+"']//ancestor::div[contains(@ng-class,'categoryDetail.showDetail&&categoryDetail')]//span[contains(@ng-if,'isShowPerPersonPrice')])["+i+"]");}

	public By SelectCabinSpecificRadioButtonFromTheCabinCategoryListOfAutoAssign(int i) {return By.xpath("(//input[@ng-checked='ratePlanDetail.selectedRateplan && eachCabin.isSelected']/..//input[@type='radio'])["+i+"]");}
	
	public By SelectOccupanyCabinFromTheCabinList(String Occupancy) {return By.xpath("//span[@key='" + Occupancy + "']/../../../..//input[@type='radio']");}

	
	
	
	
	public void SelectCabinCategoryRadioButtonSpecificOccupancy(String Occupancy) {
	//	List<WebElement> CabinCategoryRadioButtonCount = WebCtrls.Ctrls(SelectCabinSpecificRadioButtonFromTheCabinCategoryListOfAutoAssign (Occupancy));
		List<WebElement> CabinCategoryRadioButtonCount = WebCtrls.Ctrls(SelectOccupanyCabinFromTheCabinList (Occupancy));
		for(int i=1;i<CabinCategoryRadioButtonCount.size();i++)
		{
			if (!WebCtrls.GetText(SpecificOccupancyOnCabinCategoryPage(Occupancy,i)).equals("GBP 0.00")  )
				{
					WebCtrls.JavascriptClick(SelectCabinSpecificRadioButtonFromTheCabinCategoryListOfAutoAssign(i));
					WebCtrls.DeadWait(2000);
					break;
				}
			
		}
	
	
	}}



