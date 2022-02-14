package net.focltng.pages;

import org.openqa.selenium.By;

public class BookingCartPage {
		
	public By ProceedToBookingButton = By.xpath("//button[@sp-label='label.quote.ProceedToBooking']");
	
	public By RadioButtonOnTermsAndConditionsPopup = By.xpath("//input[@id='popUpTnC']");
			
	public By OkButtonOnTermsAndConditionsPopup = By.xpath("//button[contains(@class,'OK-btn')]");
	
	public By TermsAndConditionCheckBoxOnCartPage = By.xpath("//input[@type=\"checkbox\"][@ng-model=\"tncAcceptFlagParent\"]");

	//Thushara
	
	public By MoreOptionsButtonUnderCartpage = By.xpath("//a[@class='bkg_a_holdr act_108 rel']");
	
	//Thushara
	public By AddFacilitiesButtonUnderCartpage = By.xpath("//span[@class='tip_data']");
	
	//Thushara
	public By FacilityAdditionCheckboxUnderCartpage = By.xpath("(//input[@type='checkbox'])[4]");
	
	//Thushara
	public By SaveButtonUnderCartpage = By.xpath("//button[@ng-click='modifyFacilityForCabin(lineItem)']");
	
	//Thushara
	public By FacilityFieldUnderCartpage = By.xpath("//span[normalize-space()='Facilities']");
	
	//Thushara
	public By ViewDetailsButtonUnderCartpage = By.xpath("//div[@class='promo_popup promo_popup_03 collapse in ng-scope']//a[@class='link_'][normalize-space()='View Details']");
	//Thushara
	
	public By FacilityListUnderCartpage = By.xpath("//div[@class='tab-pane ng-scope active']//div[@class='fac_head'][normalize-space()='Facility Name']");
	
	//Thushara
	public By ViewDetailsUnderCartpage =By.xpath("//div[@class='fac_sub_head text-left ng-binding ng-scope'][normalize-space()='A2']");
	
	//Thushara
	public By ViewCotDetailsUnderCartpage =By.xpath("//span[normalize-space()='CO - Reserve Infant Cot']");
	
	//Thushara
	public By CnfButtonForSecondPassenger = By.xpath("//div[@ng-repeat='(facIndex,facility) in lineItem.cru.mainVo.facDispalyArray']//input[@value='{\"paxRefId\":2,\"paxIdentity\":\"A2\",\"cbStatus\":true,\"chkLabel\":\"A2\",\"paxType\":\"A\"}']");
	
	//Thushara
	public By StatusOfFacilitySelected= By.xpath("//i[@class='ng-binding ng-scope cnf_']");
	
	//Thushara
	public By InitialCountOnBookingCartPage = By.xpath("//div[@class='cru_fac_hldr ng-scope']/child::div[3]");
	
	//Thushara
	public By InitialWaitlistCountOnBookingConfirmationPageOfFirstfacility =By.xpath("(//div[@class='fac_content ng-binding'])[3]");

	
	
}
