package net.focltng.pages;

import org.openqa.selenium.By;

public class BookingCartPage {
		
	public By ProceedToBookingButton = By.xpath("//button[@sp-label='label.quote.ProceedToBooking']");
	
	public By RadioButtonOnTermsAndConditionsPopup = By.xpath("//input[@id='popUpTnC']");
			
	public By OkButtonOnTermsAndConditionsPopup = By.xpath("//button[contains(@class,'OK-btn')]");
	
	public By TermsAndConditionCheckBoxOnCartPage = By.xpath("//input[@type=\"checkbox\"][@ng-model=\"tncAcceptFlagParent\"]");

	public By MoreOptionsButtonUnderCartpage = By.xpath("//a[@class='bkg_a_holdr act_108 rel']");
	
	public By AddFacilitiesButtonUnderCartpage = By.xpath("//span[@class='tip_data']");
	
	public By FacilityAdditionCheckboxUnderCartpage = By.xpath("(//input[@type='checkbox'])[4]");
	
	public By SaveButtonUnderCartpage = By.xpath("//button[@ng-click='modifyFacilityForCabin(lineItem)']");
	
	public By FacilityFieldUnderCartpage = By.xpath("//span[normalize-space()='Facilities']");
	
	public By ViewDetailsButtonUnderCartpage = By.xpath("//div[@class='promo_popup promo_popup_03 collapse in ng-scope']//a[@class='link_'][normalize-space()='View Details']");
	
	public By FacilityListUnderCartpage = By.xpath("//div[@class='tab-pane ng-scope active']//div[@class='fac_head'][normalize-space()='Facility Name']");
	
	public By ViewDetailsUnderCartpage =By.xpath("//div[@class='fac_sub_head text-left ng-binding ng-scope'][normalize-space()='A2']");
	
	public By ViewCotDetailsUnderCartpage =By.xpath("//span[normalize-space()='CO - Reserve Infant Cot']");

	//public By CnfButtonForSecondPassenger = By.xpath("//div[text()='A2']//following::div[@class='fac_sub_content'][2]//input[@type='checkbox']");
	
	public By CnfButtonForSecondPassenger = By.xpath("//div[@ng-repeat='(facIndex,facility) in lineItem.cru.mainVo.facDispalyArray']//input[@value='{\"paxRefId\":2,\"paxIdentity\":\"A2\",\"cbStatus\":true,\"chkLabel\":\"A2\",\"paxType\":\"A\"}']");
	
	public By StatusOfFacilitySelected= By.xpath("//i[@class='ng-binding ng-scope cnf_']");
	
	public By InitialCountOnBookingCartPage = By.xpath("//div[@class='cru_fac_hldr ng-scope']/child::div[3]");
	
	public By InitialWaitlistCountOnBookingConfirmationPageOfFirstfacility =By.xpath("(//div[@class='fac_content ng-binding'])[3]");

	
	
}
