package net.focltng.testcases;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import net.focltng.helper.ExcelHelper;
import net.focltng.helper.Listeners;
import net.focltng.pages.BaseTest;
import net.focltng.pages.BookingCartPage;
import net.focltng.pages.BookingConfirmationPage;
import net.focltng.pages.CruiseSelectionPage;
import net.focltng.pages.HomePage;
import net.focltng.pages.LoginPage;
import net.focltng.pages.NewFITBookingPage;
import net.focltng.pages.PassengerInformationPage;
import net.focltng.pages.PaymentInformationPage;
import net.focltng.pages.SelectCabinPage;
import net.focltng.pages.SellingAppHomePage;
import net.focltng.utils.WebCtrls;
import java.text.SimpleDateFormat;  
import java.util.Date;  

//<summary>
/// Test Scenario :  A search for a cruise can be filtered by port, location, month and year of sailing, by ship and cruise duration in order to narrow down customer or user requirements
public class T007 extends BaseTest {
	private static Map<String, String> ExcelHelperMap = new HashMap<String, String>();

// <summary>
/// Test Case Title :Verify that the user is able to narrow down the search for a particular cabin by 'Rate Plan' under Deals in a B2E itravel account
/// Automation ID : 019
/// @Author : Thushara
/// </summary>

	@Test(enabled = false)
	public void TC_019() {
		ExcelHelperMap = ExcelHelper.getExcelData();
		Listeners listeners = new Listeners();

		getDriver().get(ExcelHelperMap.get("URL"));

		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		SellingAppHomePage sellingAppHomePage = new SellingAppHomePage();
		NewFITBookingPage newFITBookingPage = new NewFITBookingPage();
		CruiseSelectionPage cruiseSelectionPage = new CruiseSelectionPage();
		SelectCabinPage selectCabinPage = new SelectCabinPage();
		BookingCartPage bookingCartPage = new BookingCartPage();
		BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
		PassengerInformationPage passengerInformationPage = new PassengerInformationPage();
		PaymentInformationPage paymentInformationPage = new PaymentInformationPage();
		WebCtrls.PerfectEditWithTimeOut(loginPage.UserNameAreaOnLoginPage, ExcelHelperMap.get("UserName"));
		WebCtrls.PerfectClick(loginPage.NextButtonOnLoginPage);
		WebCtrls.PerfectEditWithTimeOut(loginPage.PasswordAreaOnLoginPage, ExcelHelperMap.get("Password"));
		WebCtrls.PerfectClick(loginPage.LoginButtonOnLoginPage);
		WebCtrls.WaitForElement(homePage.SellingAppTileOnHomePage);
		WebCtrls.PerfectClick(homePage.SellingAppTileOnHomePage);
		WebCtrls.DeadWait(4000);
		WebCtrls.CloseCurrentWindow();
		WebCtrls.SwithToLastWindow();
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),"Selling App page is not Loaded");
		listeners.addLog("TC_019", "Selling App page Loaded");

		WebCtrls.PerfectClick(newFITBookingPage.FirstNameFieldUnderNewFITBooking);
		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.FirstNameFieldUnderNewFITBooking,ExcelHelperMap.get("PassengerFirstName"));
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectSendKeys(newFITBookingPage.FirstNameFieldUnderNewFITBooking, Keys.ENTER);
		WebCtrls.PerfectClick(sellingAppHomePage.LoadButtonOnTheSellingAppHomePage);
		WebCtrls.PerfectClick(sellingAppHomePage.MiniProfileOnSellingAppHomePage);
		WebCtrls.PerfectClick(newFITBookingPage.MonthSliderUnderNewFITBooking);
		WebCtrls.PerfectClick(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking);
		WebCtrls.Ctrl(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking).clear();
		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking,ExcelHelperMap.get("SailingMonthrange"));
		WebCtrls.PerfectSendKeys(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking, Keys.ENTER);
		WebCtrls.DeadWait(2000);
		WebCtrls.JavascriptClick(newFITBookingPage.AdvanceSearchButton);
		WebCtrls.PerfectClick(newFITBookingPage.ClickOnDealsTab);
		WebCtrls.PerfectScroll(newFITBookingPage.RatePlanFieldUnderDealsTab);
		WebCtrls.PerfectClick(newFITBookingPage.RatePlanFieldUnderDealsTab);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab);
		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab,ExcelHelperMap.get("RatePlan"));
		WebCtrls.PerfectSendKeys(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab, Keys.ENTER);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(newFITBookingPage.PassengerFieldUnderNewFITBooking);
		WebCtrls.PerfectClick(newFITBookingPage.AddCabinButtonUnderNewFITBooking);
		WebCtrls.PerfectClick(newFITBookingPage.DoneButtonOnPassengersAreaUnderCruiseTab);
		WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage),"Cruise selection page is not Loaded");
		listeners.addLog("TC_019", "Cruise Selection page Loaded");
		
		WebCtrls.PerfectClick(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage);
		WebCtrls.PerfectClick(cruiseSelectionPage.ContinueButtonOnTheAlertPopup);
		WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
		WebCtrls.PerfectClick(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
		WebCtrls.PerfectClick(selectCabinPage.InfoTabOnTheCabinSelectionPage);
		WebCtrls.PerfectClick(selectCabinPage.IdentifiersTabOnTheCabinSelectionPage);
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.RatePlanValidation(ExcelHelperMap.get("RatePlan"))),"RatePlan is not verified");
		listeners.addLog("TC_019", "Rate Plan is Verified");

	}

//<summary>
/// Test Case Title : Verify that the user is able to narrow down the search for a particular cabin by 'Rate Plan' under Deals in a B2E itravel account on behalf of B2B.

/// Automation ID : 069
/// @Author : Thushara V T
/// </summary>
	@Test(enabled = false)
	public void TC_069() {
		ExcelHelperMap = ExcelHelper.getExcelData();
		Listeners listeners = new Listeners();

		getDriver().get(ExcelHelperMap.get("URL"));
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		SellingAppHomePage sellingAppHomePage = new SellingAppHomePage();
		CruiseSelectionPage cruiseSelectionPage = new CruiseSelectionPage();
		BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
		NewFITBookingPage newFITBookingPage = new NewFITBookingPage();
		SelectCabinPage selectCabinPage = new SelectCabinPage();
		BookingCartPage bookingCartPage = new BookingCartPage();
		PassengerInformationPage passengerInformationPage = new PassengerInformationPage();
		PaymentInformationPage paymentInformationPage = new PaymentInformationPage();
		WebCtrls.PerfectEditWithTimeOut(loginPage.UserNameAreaOnLoginPage, ExcelHelperMap.get("UserName"));
		WebCtrls.PerfectClick(loginPage.NextButtonOnLoginPage);
		WebCtrls.PerfectEditWithTimeOut(loginPage.PasswordAreaOnLoginPage, ExcelHelperMap.get("Password"));
		WebCtrls.PerfectClick(loginPage.LoginButtonOnLoginPage);
		WebCtrls.WaitForElement(homePage.SellingAppTileOnHomePage);
		WebCtrls.PerfectClick(homePage.SellingAppTileOnHomePage);
		WebCtrls.DeadWait(5000);
		WebCtrls.CloseCurrentWindow();
		WebCtrls.SwithToLastWindow();
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),"Selling App page is not Loaded");
		listeners.addLog("TC_069", "Selling App page Loaded");

		WebCtrls.WaitForElement(sellingAppHomePage.AgencyOnTheSellingAppHomePage);
		WebCtrls.PerfectEditWithTimeOut(sellingAppHomePage.AgencyOnTheSellingAppHomePage,ExcelHelperMap.get("AgencyCode"));
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(sellingAppHomePage.AgencyCodeSuggestionOnTheSellingAppHomePage),"Agency Code sugesstion not Loaded");
		listeners.addLog("TC_069", "Agency code displayed");

		WebCtrls.PerfectClick(sellingAppHomePage.AgencyCodeSuggestionOnTheSellingAppHomePage);
		WebCtrls.PerfectClick(sellingAppHomePage.LoadButtonAgencyOnTheSellingAppHomePage);
		WebCtrls.PerfectClick(sellingAppHomePage.AgencyMiniProfileIconOnMiniProfilePopup);
		WebCtrls.PerfectClick(newFITBookingPage.MonthSliderUnderNewFITBooking);
		WebCtrls.PerfectClick(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking);
		WebCtrls.Ctrl(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking).clear();
		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking,ExcelHelperMap.get("SailingMonthrange"));
		WebCtrls.DeadWait(2000);
		WebCtrls.JavascriptClick(newFITBookingPage.AdvanceSearchButton);
		WebCtrls.PerfectClick(newFITBookingPage.ClickOnDealsTab);
		WebCtrls.PerfectScroll(newFITBookingPage.RatePlanFieldUnderDealsTab);
		WebCtrls.PerfectClick(newFITBookingPage.RatePlanFieldUnderDealsTab);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab);
		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab,ExcelHelperMap.get("RatePlan"));
		WebCtrls.PerfectSendKeys(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab, Keys.ENTER);
		WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage),"Cruise selection page is not Loaded");
		listeners.addLog("TC_069", "Cruise Selection page Loaded");
		
		WebCtrls.PerfectClick(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage);
		WebCtrls.PerfectClick(cruiseSelectionPage.ContinueButtonOnTheAlertPopup);
		WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
		WebCtrls.JavascriptClick(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
		WebCtrls.JavascriptClick(selectCabinPage.InfoTabOnTheCabinSelectionPage);
		WebCtrls.JavascriptClick(selectCabinPage.IdentifiersTabOnTheCabinSelectionPage);
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.RatePlanValidation(ExcelHelperMap.get("RatePlan"))),"RatePlan is not verified");
		listeners.addLog("TC_069", "Rate Plan is Verified");

	}

//<summary>
/// Test Case Title : Verify that the user is able to narrow down the search for a particular cabin by 'Rate Plan' under Dealson a B2B itravel account.
/// Automation ID : 086
/// @Author : Thushara V T
/// </summary>
	@Test(enabled = false)
	public void TC_086() {
		ExcelHelperMap = ExcelHelper.getExcelData();
		Listeners listeners = new Listeners();

		getDriver().get(ExcelHelperMap.get("URL"));

		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		SellingAppHomePage sellingAppHomePage = new SellingAppHomePage();
		CruiseSelectionPage cruiseSelectionPage = new CruiseSelectionPage();
		BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
		NewFITBookingPage newFITBookingPage = new NewFITBookingPage();
		SelectCabinPage selectCabinPage = new SelectCabinPage();
		BookingCartPage bookingCartPage = new BookingCartPage();
		PassengerInformationPage passengerInformationPage = new PassengerInformationPage();
		PaymentInformationPage paymentInformationPage = new PaymentInformationPage();
		WebCtrls.PerfectEditWithTimeOut(loginPage.UserNameAreaOnLoginPage, ExcelHelperMap.get("UserNameB2B"));
		WebCtrls.PerfectClick(loginPage.NextButtonOnLoginPage);
		WebCtrls.PerfectEditWithTimeOut(loginPage.PasswordAreaOnLoginPage, ExcelHelperMap.get("Password"));
		WebCtrls.PerfectClick(loginPage.LoginButtonOnLoginPage);
		WebCtrls.WaitForElement(homePage.SellingAppTileOnHomePage);
		WebCtrls.PerfectClick(homePage.SellingAppTileOnHomePage);
		WebCtrls.DeadWait(5000);
		WebCtrls.CloseCurrentWindow();
		WebCtrls.SwithToLastWindow();
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),"Selling App page is not Loaded");
		listeners.addLog("TC_086", "Seeling App page Loaded");

		WebCtrls.PerfectClick(newFITBookingPage.FirstNameFieldUnderNewFITBooking);
		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.FirstNameFieldUnderNewFITBooking,ExcelHelperMap.get("PassengerFirstName"));
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectSendKeys(newFITBookingPage.FirstNameFieldUnderNewFITBooking, Keys.ENTER);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(sellingAppHomePage.LoadButtonOnTheSellingAppHomePage);
		WebCtrls.PerfectClick(sellingAppHomePage.MiniProfileOnSellingAppHomePage);
		WebCtrls.PerfectClick(newFITBookingPage.MonthSliderUnderNewFITBooking);
		WebCtrls.PerfectClick(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking);
		WebCtrls.Ctrl(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking).clear();
		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking,ExcelHelperMap.get("SailingMonthrangeB2B"));
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectSendKeys(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking, Keys.ENTER);
		WebCtrls.DeadWait(3000);
		WebCtrls.JavascriptClick(newFITBookingPage.AdvanceSearchButton);
		WebCtrls.PerfectClick(newFITBookingPage.ClickOnDealsTab);
		WebCtrls.PerfectScroll(newFITBookingPage.RatePlanFieldUnderDealsTab);
		WebCtrls.PerfectClick(newFITBookingPage.RatePlanFieldUnderDealsTab);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab);
		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab,ExcelHelperMap.get("RatePlan"));
		WebCtrls.DeadWait(3000);
		WebCtrls.PerfectSendKeys(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab, Keys.ENTER);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(newFITBookingPage.PassengerFieldUnderNewFITBooking);
		WebCtrls.PerfectClick(newFITBookingPage.AddCabinButtonUnderNewFITBooking);
		WebCtrls.PerfectClick(newFITBookingPage.DoneButtonOnPassengersAreaUnderCruiseTab);
		WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage),"Cruise selection page is not Loaded");
		listeners.addLog("TC_086", "Cruise Selection page Loaded");
		
		WebCtrls.PerfectClick(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage);
		WebCtrls.PerfectClick(cruiseSelectionPage.ContinueButtonOnTheAlertPopup);
		WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
		WebCtrls.PerfectClick(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
		WebCtrls.PerfectClick(selectCabinPage.InfoTabOnTheCabinSelectionPage);
		WebCtrls.PerfectClick(selectCabinPage.IdentifiersTabOnTheCabinSelectionPage);
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.RatePlanValidation(ExcelHelperMap.get("RatePlan"))),"RatePlan is not verified");
		listeners.addLog("TC_086", "Rate Plan is Verified");

	}
	
	//<summary>
	/// Test Case Title : Verify that the user is able to narrow down the search for a particular Cruise by Selecting category class,Promotion Code and date on a B2B itravel account.

	/// Automation ID : 089
	/// @Author : Thushara V T
	/// </summary>
		@Test(enabled =false)
		public void TC_089() throws ParseException {
			ExcelHelperMap = ExcelHelper.getExcelData();
			Listeners listeners = new Listeners();

			getDriver().get(ExcelHelperMap.get("URL"));

			LoginPage loginPage = new LoginPage();
			HomePage homePage = new HomePage();
			SellingAppHomePage sellingAppHomePage = new SellingAppHomePage();
			CruiseSelectionPage cruiseSelectionPage = new CruiseSelectionPage();
			BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
			NewFITBookingPage newFITBookingPage = new NewFITBookingPage();
			SelectCabinPage selectCabinPage = new SelectCabinPage();
			BookingCartPage bookingCartPage = new BookingCartPage();
			PassengerInformationPage passengerInformationPage = new PassengerInformationPage();
			PaymentInformationPage paymentInformationPage = new PaymentInformationPage();
			WebCtrls.PerfectEditWithTimeOut(loginPage.UserNameAreaOnLoginPage, ExcelHelperMap.get("UserNameB2B"));
			WebCtrls.PerfectClick(loginPage.NextButtonOnLoginPage);
			WebCtrls.PerfectEditWithTimeOut(loginPage.PasswordAreaOnLoginPage, ExcelHelperMap.get("Password"));
			WebCtrls.PerfectClick(loginPage.LoginButtonOnLoginPage);
			WebCtrls.WaitForElement(homePage.SellingAppTileOnHomePage);
			WebCtrls.PerfectClick(homePage.SellingAppTileOnHomePage);
			WebCtrls.DeadWait(5000);
			WebCtrls.CloseCurrentWindow();
			WebCtrls.SwithToLastWindow();
			Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),"Selling App page is not Loaded");
			listeners.addLog("TC_089", "Selling App page Loaded");

			WebCtrls.PerfectClick(newFITBookingPage.FirstNameFieldUnderNewFITBooking);
			WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.FirstNameFieldUnderNewFITBooking,ExcelHelperMap.get("PassengerFirstName"));
			WebCtrls.DeadWait(2000);
			WebCtrls.PerfectSendKeys(newFITBookingPage.FirstNameFieldUnderNewFITBooking, Keys.ENTER);
			WebCtrls.DeadWait(2000);
			WebCtrls.PerfectClick(sellingAppHomePage.LoadButtonOnTheSellingAppHomePage);
			WebCtrls.PerfectClick(sellingAppHomePage.MiniProfileOnSellingAppHomePage);
			WebCtrls.PerfectClick(newFITBookingPage.MonthSliderUnderNewFITBooking);
			WebCtrls.PerfectClick(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking);
			WebCtrls.Ctrl(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking).clear();
			WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking,ExcelHelperMap.get("SailingMonthrangeB2B"));
			WebCtrls.DeadWait(2000);
			WebCtrls.PerfectSendKeys(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking, Keys.ENTER);
			WebCtrls.DeadWait(3000);
			WebCtrls.JavascriptClick(newFITBookingPage.AdvanceSearchButton);
			WebCtrls.PerfectClick(newFITBookingPage.ShowAllTabUnderNewFITBooking);
			WebCtrls.PerfectScroll(newFITBookingPage.PromoCodeFieldUnderNewFITBooking);
			WebCtrls.JavascriptClick(newFITBookingPage.CategoryClassFieldUnderNewFITBooking);
			WebCtrls.JavascriptClick(newFITBookingPage.CategoryClassSearchBoxFieldUnderNewFITBooking);
			WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.CategoryClassSearchBoxFieldUnderNewFITBooking,ExcelHelperMap.get("CategoryClass"));
			WebCtrls.PerfectSendKeys(newFITBookingPage.CategoryClassSearchBoxFieldUnderNewFITBooking, Keys.ENTER);
			WebCtrls.PerfectClick(newFITBookingPage.PromoCodeFieldUnderNewFITBooking);
			WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.PromoCodeFieldUnderNewFITBooking,ExcelHelperMap.get("PromoCode"));
			WebCtrls.PerfectSendKeys(newFITBookingPage.PromoCodeFieldUnderNewFITBooking, Keys.ENTER);
			WebCtrls.DeadWait(2000);
			WebCtrls.PerfectClick(newFITBookingPage.PassengerFieldUnderNewFITBooking);
			WebCtrls.PerfectClick(newFITBookingPage.AddCabinButtonUnderNewFITBooking);
			WebCtrls.PerfectClick(newFITBookingPage.DoneButtonOnPassengersAreaUnderCruiseTab);
			WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
			Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage),"Cruise selection page is not Loaded");
			listeners.addLog("TC_089", "Cruise Selection page Loaded");
			
			String SailingStartDate=ExcelHelperMap.get("SailingStartDateB2B");
			String SailingEndDate = ExcelHelperMap.get("SailingEndDateB2B");
			String Startdate = WebCtrls.GetTextWithTimeOut(cruiseSelectionPage.DateValidation);
		    Date DSailingStartDate=new SimpleDateFormat("MM/dd/yyyy").parse(SailingStartDate);  
		    Date DSailingEndDate=new SimpleDateFormat("MM/dd/yyyy").parse(SailingEndDate);  
		    Date DStartdate=new SimpleDateFormat("MM/dd/yyyy").parse(Startdate);  
		    Assert.assertTrue(DSailingStartDate.before(DStartdate) || DSailingStartDate.equals(DStartdate) && DSailingEndDate.after(DStartdate) || DSailingEndDate.equals(DStartdate),"Cruise Startdate is not verified");
		  //  Assert.assertTrue(DSailingStartDate.before(DStartdate) ^ DSailingStartDate.equals(DStartdate) ^ DSailingEndDate.after(DStartdate) ^ DSailingEndDate.equals(DStartdate),"Cruise Startdate is not verified");
		    listeners.addLog("TC_089", "Cruise start date is displayed");
			
			WebCtrls.PerfectClick(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage);
			WebCtrls.PerfectClick(cruiseSelectionPage.ContinueButtonOnTheAlertPopup);
			WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
			Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.CabincategoryValidation(ExcelHelperMap.get("CategoryClass"))),"CategoryClass is not verified");
			listeners.addLog("TC_089", "Cabincategory class is displayed");

			WebCtrls.PerfectClick(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
			Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.PromocodeValidation(ExcelHelperMap.get("PromoCode"))),"Promocode is not Verified");
			listeners.addLog("TC_089", "Promocode is displayed");
			
			
		}
	
	
		
		
		
		
		//<summary>
		/// Test Case Title : Verify that the user is able to narrow down the search for a particular Cruise by Selecting category class,Promotion Code and date on a B2E itravel account.
		/// Automation ID : 090
		/// @Author : Thushara V T
		/// </summary>
			@Test(enabled = false)
			public void TC_090() throws ParseException {
				ExcelHelperMap = ExcelHelper.getExcelData();
				Listeners listeners = new Listeners();

				getDriver().get(ExcelHelperMap.get("URL"));

				LoginPage loginPage = new LoginPage();
				HomePage homePage = new HomePage();
				SellingAppHomePage sellingAppHomePage = new SellingAppHomePage();
				CruiseSelectionPage cruiseSelectionPage = new CruiseSelectionPage();
				BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
				NewFITBookingPage newFITBookingPage = new NewFITBookingPage();
				SelectCabinPage selectCabinPage = new SelectCabinPage();
				BookingCartPage bookingCartPage = new BookingCartPage();
				PassengerInformationPage passengerInformationPage = new PassengerInformationPage();
				PaymentInformationPage paymentInformationPage = new PaymentInformationPage();
				WebCtrls.PerfectEditWithTimeOut(loginPage.UserNameAreaOnLoginPage, ExcelHelperMap.get("UserName"));
				WebCtrls.PerfectClick(loginPage.NextButtonOnLoginPage);
				WebCtrls.PerfectEditWithTimeOut(loginPage.PasswordAreaOnLoginPage, ExcelHelperMap.get("Password"));
				WebCtrls.PerfectClick(loginPage.LoginButtonOnLoginPage);
				WebCtrls.WaitForElement(homePage.SellingAppTileOnHomePage);
				WebCtrls.PerfectClick(homePage.SellingAppTileOnHomePage);
				WebCtrls.DeadWait(5000);
				WebCtrls.CloseCurrentWindow();
				WebCtrls.SwithToLastWindow();
				Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),"Selling App page is not Loaded");
				listeners.addLog("TC_090", "Seeling App page Loaded");

				WebCtrls.PerfectClick(newFITBookingPage.FirstNameFieldUnderNewFITBooking);
				WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.FirstNameFieldUnderNewFITBooking,ExcelHelperMap.get("PassengerFirstName"));
				WebCtrls.DeadWait(2000);
				WebCtrls.PerfectSendKeys(newFITBookingPage.FirstNameFieldUnderNewFITBooking, Keys.ENTER);
				WebCtrls.DeadWait(2000);
				WebCtrls.PerfectClick(sellingAppHomePage.LoadButtonOnTheSellingAppHomePage);
				WebCtrls.PerfectClick(sellingAppHomePage.MiniProfileOnSellingAppHomePage);
				WebCtrls.PerfectClick(newFITBookingPage.MonthSliderUnderNewFITBooking);
				WebCtrls.PerfectClick(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking);
				WebCtrls.Ctrl(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking).clear();
				WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking,ExcelHelperMap.get("SailingMonthrange"));
				WebCtrls.DeadWait(2000);
				WebCtrls.PerfectSendKeys(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking, Keys.ENTER);
				WebCtrls.DeadWait(3000);
				WebCtrls.JavascriptClick(newFITBookingPage.AdvanceSearchButton);
				WebCtrls.PerfectClick(newFITBookingPage.ShowAllTabUnderNewFITBooking);
				WebCtrls.PerfectScroll(newFITBookingPage.PromoCodeFieldUnderNewFITBooking);
				WebCtrls.JavascriptClick(newFITBookingPage.CategoryClassFieldUnderNewFITBooking);
				WebCtrls.JavascriptClick(newFITBookingPage.CategoryClassSearchBoxFieldUnderNewFITBooking);
				WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.CategoryClassSearchBoxFieldUnderNewFITBooking,ExcelHelperMap.get("CategoryClass"));
				WebCtrls.PerfectSendKeys(newFITBookingPage.CategoryClassSearchBoxFieldUnderNewFITBooking, Keys.ENTER);
				WebCtrls.PerfectClick(newFITBookingPage.PromoCodeFieldUnderNewFITBooking);
				WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.PromoCodeFieldUnderNewFITBooking,ExcelHelperMap.get("PromoCode"));
				WebCtrls.PerfectSendKeys(newFITBookingPage.PromoCodeFieldUnderNewFITBooking, Keys.ENTER);
				WebCtrls.DeadWait(2000);
				WebCtrls.PerfectClick(newFITBookingPage.PassengerFieldUnderNewFITBooking);
				WebCtrls.PerfectClick(newFITBookingPage.AddCabinButtonUnderNewFITBooking);
				WebCtrls.PerfectClick(newFITBookingPage.DoneButtonOnPassengersAreaUnderCruiseTab);
				WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
				Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage),"Cruise selection page is not Loaded");
				listeners.addLog("TC_090", "Cruise Selection page Loaded");
				
				String SailingStartDate=ExcelHelperMap.get("SailingStartDate");
				String SailingEndDate = ExcelHelperMap.get("SailingEndDate");
				String Startdate = WebCtrls.GetTextWithTimeOut(cruiseSelectionPage.DateValidation);
			    Date DSailingStartDate=new SimpleDateFormat("dd/MM/yyyy").parse(SailingStartDate);  
			    Date DSailingEndDate=new SimpleDateFormat("dd/MM/yyyy").parse(SailingEndDate);  
			    Date DStartdate=new SimpleDateFormat("dd/MM/yyyy").parse(Startdate);  
			    Assert.assertTrue(DSailingStartDate.before(DStartdate) || DSailingStartDate.equals(DStartdate) && DSailingEndDate.after(DStartdate) || DSailingEndDate.equals(DStartdate),"Cruise Startdate is not verified");
			   // Assert.assertTrue(DSailingStartDate.before(DStartdate) ^ DSailingStartDate.equals(DStartdate) ^( DSailingEndDate.after(DStartdate) ^ DSailingEndDate.equals(DStartdate)),"Cruise Startdate is not verified");
			    listeners.addLog("TC_091", "Cruise start date is displayed");
				
				WebCtrls.PerfectClick(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage);
				WebCtrls.PerfectClick(cruiseSelectionPage.ContinueButtonOnTheAlertPopup);
				WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
				Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.CabincategoryValidation(ExcelHelperMap.get("CategoryClass"))),"CategoryClass is not verified");
				listeners.addLog("TC_090", "Category class is displayed");

				WebCtrls.PerfectClick(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
				Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.PromocodeValidation(ExcelHelperMap.get("PromoCode"))),"Promocode is not Verified");
				listeners.addLog("TC_090", "Promocode is displayed");

		
			}
		
		
		
			
			//<summary>
			/// Test Case Title :Verify that the user is able to narrow down the search for a particular Cruise by Selecting category class,Promotion Code and date on a B2E on Behalf of agency itravel account.
			/// Automation ID : 091
			/// @Author : Thushara V T
			/// </summary>
				@Test(enabled = true)
				public void TC_091() throws ParseException {
					ExcelHelperMap = ExcelHelper.getExcelData();
					Listeners listeners = new Listeners();

					getDriver().get(ExcelHelperMap.get("URL"));

					LoginPage loginPage = new LoginPage();
					HomePage homePage = new HomePage();
					SellingAppHomePage sellingAppHomePage = new SellingAppHomePage();
					CruiseSelectionPage cruiseSelectionPage = new CruiseSelectionPage();
					BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
					NewFITBookingPage newFITBookingPage = new NewFITBookingPage();
					SelectCabinPage selectCabinPage = new SelectCabinPage();
					BookingCartPage bookingCartPage = new BookingCartPage();
					PassengerInformationPage passengerInformationPage = new PassengerInformationPage();
					PaymentInformationPage paymentInformationPage = new PaymentInformationPage();
					WebCtrls.PerfectEditWithTimeOut(loginPage.UserNameAreaOnLoginPage, ExcelHelperMap.get("UserName"));
					WebCtrls.PerfectClick(loginPage.NextButtonOnLoginPage);
					WebCtrls.PerfectEditWithTimeOut(loginPage.PasswordAreaOnLoginPage, ExcelHelperMap.get("Password"));
					WebCtrls.PerfectClick(loginPage.LoginButtonOnLoginPage);
					WebCtrls.WaitForElement(homePage.SellingAppTileOnHomePage);
					WebCtrls.PerfectClick(homePage.SellingAppTileOnHomePage);
					WebCtrls.DeadWait(5000);
					WebCtrls.CloseCurrentWindow();
					WebCtrls.SwithToLastWindow();
					Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),"Selling App page is not Loaded");
					listeners.addLog("TC_091", "Seeling App page Loaded");					
					
					WebCtrls.WaitForElement(sellingAppHomePage.AgencyOnTheSellingAppHomePage);
					WebCtrls.PerfectEditWithTimeOut(sellingAppHomePage.AgencyOnTheSellingAppHomePage,ExcelHelperMap.get("AgencyCode"));
					Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(sellingAppHomePage.AgencyCodeSuggestionOnTheSellingAppHomePage),"Agency Code sugesstion not Loaded");
					listeners.addLog("TC_091", "Agency code displayed");

					WebCtrls.PerfectClick(sellingAppHomePage.AgencyCodeSuggestionOnTheSellingAppHomePage);
					WebCtrls.PerfectClick(sellingAppHomePage.LoadButtonAgencyOnTheSellingAppHomePage);
					WebCtrls.PerfectClick(sellingAppHomePage.AgencyMiniProfileIconOnMiniProfilePopup);
					
					
					
					
//					
//					String date,month,year;
//					String caldt,calmonth,calyear;
//					String SailingStartDateTest = ExcelHelperMap.get("SailingStartDate");
//					String dateArray[]= SailingStartDateTest.split("/");
//					date=dateArray[0];
//					month=dateArray[1];
//					year=dateArray[2];
//					WebCtrls.PerfectClick(newFITBookingPage.MonthSliderUnderNewFITBooking);
//					WebCtrls.PerfectClick(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking);
//					WebCtrls.PerfectClick(newFITBookingPage.YearFieldUnderNewFITBooking1);
//					WebCtrls.PerfectClick(newFITBookingPage.YearOptionUnderNewFITBooking1);
//					WebCtrls.PerfectClick(newFITBookingPage.MonthFieldUnderNewFITBooking1);
//					WebCtrls.PerfectClick(newFITBookingPage.MonthOptionUnderNewFITBooking1);
//					WebCtrls.PerfectClick(newFITBookingPage.DateOptionUnderNewFITBooking1);
//
//					
//					WebCtrls.PerfectClick(newFITBookingPage.YearFieldUnderNewFITBooking2);
//					WebCtrls.PerfectClick(newFITBookingPage.YearOptionUnderNewFITBooking2);
//					WebCtrls.PerfectClick(newFITBookingPage.MonthFieldUnderNewFITBooking2);
//					WebCtrls.PerfectClick(newFITBookingPage.MonthOptionUnderNewFITBooking2);
//					WebCtrls.PerfectClick(newFITBookingPage.DateOptionUnderNewFITBooking2);
//					
//					
//					WebCtrls.PerfectClick(newFITBookingPage.ApplyButtonUnderNewFITBooking2);
//					
//					
					
					
					
					
					WebCtrls.PerfectClick(newFITBookingPage.MonthSliderUnderNewFITBooking);
					WebCtrls.PerfectClick(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking);
					WebCtrls.Ctrl(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking).clear();
					WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking,ExcelHelperMap.get("SailingMonthrange"));
					WebCtrls.DeadWait(2000);
					WebCtrls.PerfectSendKeys(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking, Keys.ENTER);
					WebCtrls.DeadWait(3000);
					WebCtrls.JavascriptClick(newFITBookingPage.AdvanceSearchButton);
					WebCtrls.PerfectClick(newFITBookingPage.ShowAllTabUnderNewFITBooking);
					WebCtrls.PerfectScroll(newFITBookingPage.PromoCodeFieldUnderNewFITBooking);
					WebCtrls.JavascriptClick(newFITBookingPage.CategoryClassFieldUnderNewFITBooking);
					WebCtrls.JavascriptClick(newFITBookingPage.CategoryClassSearchBoxFieldUnderNewFITBooking);
					WebCtrls.DeadWait(3000);
					WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.CategoryClassSearchBoxFieldUnderNewFITBooking,ExcelHelperMap.get("CategoryClass"));
					WebCtrls.PerfectSendKeys(newFITBookingPage.CategoryClassSearchBoxFieldUnderNewFITBooking, Keys.ENTER);
					WebCtrls.PerfectClick(newFITBookingPage.PromoCodeFieldUnderNewFITBooking);
					WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.PromoCodeFieldUnderNewFITBooking,ExcelHelperMap.get("PromoCode"));
					WebCtrls.PerfectSendKeys(newFITBookingPage.PromoCodeFieldUnderNewFITBooking, Keys.ENTER);
					WebCtrls.DeadWait(2000);
					WebCtrls.PerfectClick(newFITBookingPage.PassengerFieldUnderNewFITBooking);
					WebCtrls.PerfectClick(newFITBookingPage.AddCabinButtonUnderNewFITBooking);
					WebCtrls.PerfectClick(newFITBookingPage.DoneButtonOnPassengersAreaUnderCruiseTab);
					WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
					Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage),"Cruise selection page is not Loaded");
					listeners.addLog("TC_091", "Cruise Selection page Loaded");
					
					String SailingStartDate=ExcelHelperMap.get("SailingStartDate");
					String SailingEndDate = ExcelHelperMap.get("SailingEndDate");
					String Startdate = WebCtrls.GetTextWithTimeOut(cruiseSelectionPage.DateValidation);
				    Date DSailingStartDate=new SimpleDateFormat("dd/MM/yyyy").parse(SailingStartDate);  
				    Date DSailingEndDate=new SimpleDateFormat("dd/MM/yyyy").parse(SailingEndDate);  
				    Date DStartdate=new SimpleDateFormat("dd/MM/yyyy").parse(Startdate);  
				    Assert.assertTrue(DSailingStartDate.before(DStartdate) || DSailingStartDate.equals(DStartdate) && DSailingEndDate.after(DStartdate) || DSailingEndDate.equals(DStartdate),"Cruise Startdate is not verified");
				  //  Assert.assertTrue(DSailingStartDate.before(DStartdate) ^ DSailingStartDate.equals(DStartdate) ^ DSailingEndDate.after(DStartdate) ^ DSailingEndDate.equals(DStartdate),"Cruise Startdate is not verified");
				    listeners.addLog("TC_091", "Cruise start date is displayed");
					
					WebCtrls.PerfectClick(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage);
					WebCtrls.PerfectClick(cruiseSelectionPage.ContinueButtonOnTheAlertPopup);
					WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);	
					Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.CabincategoryValidation(ExcelHelperMap.get("CategoryClass"))),"CategoryClass is not verified");
					listeners.addLog("TC_091", "Category class is displayed");

					WebCtrls.PerfectClick(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
					Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.PromocodeValidation(ExcelHelperMap.get("PromoCode"))),"Promocode is not Verified");
					listeners.addLog("TC_091", "Promocode is displayed");

				}
				
		
				//<summary>
				/// Test Case Title : "Verify that the user is able to narrow down the search for a particular deal by Selecting Rate Type,Rate Classification and Rate Plan in a B2E itravel account on behalf of B2B.
				/// Automation ID : 071
				/// @Author : Thushara V T
				/// </summary>
					@Test(enabled = false)
					public void TC_071() {
						ExcelHelperMap = ExcelHelper.getExcelData();
						Listeners listeners = new Listeners();

						getDriver().get(ExcelHelperMap.get("URL"));
						LoginPage loginPage = new LoginPage();
						HomePage homePage = new HomePage();
						SellingAppHomePage sellingAppHomePage = new SellingAppHomePage();
						CruiseSelectionPage cruiseSelectionPage = new CruiseSelectionPage();
						BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
						NewFITBookingPage newFITBookingPage = new NewFITBookingPage();
						SelectCabinPage selectCabinPage = new SelectCabinPage();
						BookingCartPage bookingCartPage = new BookingCartPage();
						PassengerInformationPage passengerInformationPage = new PassengerInformationPage();
						PaymentInformationPage paymentInformationPage = new PaymentInformationPage();
						WebCtrls.PerfectEditWithTimeOut(loginPage.UserNameAreaOnLoginPage, ExcelHelperMap.get("UserName"));
						WebCtrls.PerfectClick(loginPage.NextButtonOnLoginPage);
						WebCtrls.PerfectEditWithTimeOut(loginPage.PasswordAreaOnLoginPage, ExcelHelperMap.get("Password"));
						WebCtrls.PerfectClick(loginPage.LoginButtonOnLoginPage);
						WebCtrls.WaitForElement(homePage.SellingAppTileOnHomePage);
						WebCtrls.PerfectClick(homePage.SellingAppTileOnHomePage);
						WebCtrls.DeadWait(5000);
						WebCtrls.CloseCurrentWindow();
						WebCtrls.SwithToLastWindow();
						Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),"Selling App page is not Loaded");
						listeners.addLog("TC_071", "Selling App page Loaded");

						WebCtrls.WaitForElement(sellingAppHomePage.AgencyOnTheSellingAppHomePage);
						WebCtrls.PerfectEditWithTimeOut(sellingAppHomePage.AgencyOnTheSellingAppHomePage,ExcelHelperMap.get("AgencyCode"));
						Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(sellingAppHomePage.AgencyCodeSuggestionOnTheSellingAppHomePage),"Agency Code sugesstion not Loaded");
						listeners.addLog("TC_071", "Agency code displayed");

						WebCtrls.PerfectClick(sellingAppHomePage.AgencyCodeSuggestionOnTheSellingAppHomePage);
						WebCtrls.PerfectClick(sellingAppHomePage.LoadButtonAgencyOnTheSellingAppHomePage);
						WebCtrls.PerfectClick(sellingAppHomePage.AgencyMiniProfileIconOnMiniProfilePopup);
						WebCtrls.PerfectClick(newFITBookingPage.MonthSliderUnderNewFITBooking);
						WebCtrls.PerfectClick(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking);
						WebCtrls.Ctrl(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking).clear();
						WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking,ExcelHelperMap.get("SailingMonthrange"));
						WebCtrls.DeadWait(2000);
						WebCtrls.JavascriptClick(newFITBookingPage.AdvanceSearchButton);
						WebCtrls.PerfectClick(newFITBookingPage.ClickOnDealsTab);
						WebCtrls.PerfectScroll(newFITBookingPage.RateTypeFieldUnderNewFITBookingPage);
						WebCtrls.PerfectClick(newFITBookingPage.RateTypeFieldUnderNewFITBookingPage);
						WebCtrls.PerfectDropdownByText(newFITBookingPage.RateTypeDropdown,ExcelHelperMap.get("RateType"));
						WebCtrls.PerfectMouseClick(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab);
						WebCtrls.PerfectClick(newFITBookingPage.RateClassificationFieldUnderNewFITBookingPage);
						WebCtrls.PerfectDropdownByText(newFITBookingPage.RateClassificationDropdown,ExcelHelperMap.get("RateClassification"));
						WebCtrls.PerfectMouseClick(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab);
						WebCtrls.PerfectScroll(newFITBookingPage.RatePlanFieldUnderDealsTab);
						WebCtrls.PerfectClick(newFITBookingPage.RatePlanFieldUnderDealsTab);
						WebCtrls.DeadWait(2000);
						WebCtrls.PerfectClick(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab);
						WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab,ExcelHelperMap.get("RatePlan"));
						WebCtrls.PerfectSendKeys(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab, Keys.ENTER);
						WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
						Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage),"Cruise selection page is not Loaded");
						listeners.addLog("TC_071", "Cruise Selection page Loaded");
						
						WebCtrls.PerfectClick(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage);
						WebCtrls.PerfectClick(cruiseSelectionPage.ContinueButtonOnTheAlertPopup);
						WebCtrls.DeadWait(5000);
						WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
						Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.RateTypeValidation(ExcelHelperMap.get("RateType"))),"RateType is not verified");
						listeners.addLog("TC_071", "Rate Type is Verified");
						
						WebCtrls.JavascriptClick(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
						WebCtrls.JavascriptClick(selectCabinPage.InfoTabOnTheCabinSelectionPage);
						WebCtrls.JavascriptClick(selectCabinPage.IdentifiersTabOnTheCabinSelectionPage);
						Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.RatePlanValidation(ExcelHelperMap.get("RatePlan"))),"RatePlan is not verified");
						listeners.addLog("TC_071", "Rate Plan is Verified");
	
				
				
			
				
					}				
				
				
					//<summary>
					/// Test Case Title : "Verify that the user is able to narrow down the search for a particular deal by Selecting Rate Type,Rate Classification and Rate Plan on a B2B itravel account."

					/// Automation ID : 088
					/// @Author : Thushara V T
					/// </summary>
						@Test(enabled = true)
						public void TC_088() {
							ExcelHelperMap = ExcelHelper.getExcelData();
							Listeners listeners = new Listeners();

							getDriver().get(ExcelHelperMap.get("URL"));
							LoginPage loginPage = new LoginPage();
							HomePage homePage = new HomePage();
							SellingAppHomePage sellingAppHomePage = new SellingAppHomePage();
							CruiseSelectionPage cruiseSelectionPage = new CruiseSelectionPage();
							BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
							NewFITBookingPage newFITBookingPage = new NewFITBookingPage();
							SelectCabinPage selectCabinPage = new SelectCabinPage();
							BookingCartPage bookingCartPage = new BookingCartPage();
							PassengerInformationPage passengerInformationPage = new PassengerInformationPage();
							PaymentInformationPage paymentInformationPage = new PaymentInformationPage();
							WebCtrls.PerfectEditWithTimeOut(loginPage.UserNameAreaOnLoginPage, ExcelHelperMap.get("UserNameB2B"));
							WebCtrls.PerfectClick(loginPage.NextButtonOnLoginPage);
							WebCtrls.PerfectEditWithTimeOut(loginPage.PasswordAreaOnLoginPage, ExcelHelperMap.get("Password"));
							WebCtrls.PerfectClick(loginPage.LoginButtonOnLoginPage);
							WebCtrls.WaitForElement(homePage.SellingAppTileOnHomePage);
							WebCtrls.PerfectClick(homePage.SellingAppTileOnHomePage);
							WebCtrls.DeadWait(5000);
							WebCtrls.CloseCurrentWindow();
							WebCtrls.SwithToLastWindow();
							Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),"Selling App page is not Loaded");
							listeners.addLog("TC_088", "Selling App page Loaded");

							WebCtrls.PerfectClick(newFITBookingPage.FirstNameFieldUnderNewFITBooking);
							WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.FirstNameFieldUnderNewFITBooking,ExcelHelperMap.get("PassengerFirstName"));
							WebCtrls.DeadWait(2000);
							WebCtrls.PerfectSendKeys(newFITBookingPage.FirstNameFieldUnderNewFITBooking, Keys.ENTER);
							WebCtrls.DeadWait(2000);
							WebCtrls.PerfectClick(sellingAppHomePage.LoadButtonOnTheSellingAppHomePage);
							WebCtrls.PerfectClick(sellingAppHomePage.MiniProfileOnSellingAppHomePage);
							WebCtrls.PerfectClick(newFITBookingPage.MonthSliderUnderNewFITBooking);
							WebCtrls.PerfectClick(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking);
							WebCtrls.Ctrl(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking).clear();
							WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking,ExcelHelperMap.get("SailingMonthrangeB2B"));
							WebCtrls.DeadWait(2000);
							WebCtrls.JavascriptClick(newFITBookingPage.AdvanceSearchButton);
							WebCtrls.PerfectClick(newFITBookingPage.ClickOnDealsTab);
							WebCtrls.PerfectScroll(newFITBookingPage.RateTypeFieldUnderNewFITBookingPage);
							WebCtrls.PerfectClick(newFITBookingPage.RateTypeFieldUnderNewFITBookingPage);
							WebCtrls.PerfectDropdownByText(newFITBookingPage.RateTypeDropdown,ExcelHelperMap.get("RateType"));
							WebCtrls.PerfectMouseClick(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab);
							WebCtrls.PerfectClick(newFITBookingPage.RateClassificationFieldUnderNewFITBookingPage);
							WebCtrls.PerfectDropdownByText(newFITBookingPage.RateClassificationDropdown,ExcelHelperMap.get("RateClassification"));
							WebCtrls.PerfectMouseClick(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab);
							WebCtrls.PerfectScroll(newFITBookingPage.RatePlanFieldUnderDealsTab);
							WebCtrls.PerfectClick(newFITBookingPage.RatePlanFieldUnderDealsTab);
							WebCtrls.DeadWait(2000);
							WebCtrls.PerfectClick(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab);
							WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab,ExcelHelperMap.get("RatePlan"));
							WebCtrls.PerfectSendKeys(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab, Keys.ENTER);
							WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
							assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage),"Cruise selection page is not Loaded");
							listeners.addLog("TC_088", "Cruise Selection page Loaded");
							
							WebCtrls.PerfectClick(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage);
							WebCtrls.PerfectClick(cruiseSelectionPage.ContinueButtonOnTheAlertPopup);
							WebCtrls.DeadWait(5000);
							WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
							Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.RateTypeValidation(ExcelHelperMap.get("RateType"))),"RateType is not verified");
							listeners.addLog("TC_088", "Rate Type is Verified");
							
							WebCtrls.JavascriptClick(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
							WebCtrls.JavascriptClick(selectCabinPage.InfoTabOnTheCabinSelectionPage);
							WebCtrls.JavascriptClick(selectCabinPage.IdentifiersTabOnTheCabinSelectionPage);
							Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.RatePlanValidation(ExcelHelperMap.get("RatePlan"))),"RatePlan is not verified");
							listeners.addLog("TC_088", "Rate Plan is Verified");
		
					
					
				
					
						}				
					
						//<summary>
						/// Test Case Title : Verify that the user is able to narrow down the search for a particular deal by Selecting Rate Type,Rate Classification and Rate Plan in a B2E itravel account

						/// Automation ID : 021
						/// @Author : Thushara V T
						/// </summary>
							@Test(enabled = true)
							public void TC_021() {
								ExcelHelperMap = ExcelHelper.getExcelData();
								Listeners listeners = new Listeners();

								getDriver().get(ExcelHelperMap.get("URL"));
								LoginPage loginPage = new LoginPage();
								HomePage homePage = new HomePage();
								SellingAppHomePage sellingAppHomePage = new SellingAppHomePage();
								CruiseSelectionPage cruiseSelectionPage = new CruiseSelectionPage();
								BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
								NewFITBookingPage newFITBookingPage = new NewFITBookingPage();
								SelectCabinPage selectCabinPage = new SelectCabinPage();
								BookingCartPage bookingCartPage = new BookingCartPage();
								PassengerInformationPage passengerInformationPage = new PassengerInformationPage();
								PaymentInformationPage paymentInformationPage = new PaymentInformationPage();
								WebCtrls.PerfectEditWithTimeOut(loginPage.UserNameAreaOnLoginPage, ExcelHelperMap.get("UserName"));
								WebCtrls.PerfectClick(loginPage.NextButtonOnLoginPage);
								WebCtrls.PerfectEditWithTimeOut(loginPage.PasswordAreaOnLoginPage, ExcelHelperMap.get("Password"));
								WebCtrls.PerfectClick(loginPage.LoginButtonOnLoginPage);
								WebCtrls.WaitForElement(homePage.SellingAppTileOnHomePage);
								WebCtrls.PerfectClick(homePage.SellingAppTileOnHomePage);
								WebCtrls.DeadWait(5000);
								WebCtrls.CloseCurrentWindow();
								WebCtrls.SwithToLastWindow();
								Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),"Selling App page is not Loaded");
								listeners.addLog("TC_021", "Selling App page Loaded");

								WebCtrls.PerfectClick(newFITBookingPage.FirstNameFieldUnderNewFITBooking);
								WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.FirstNameFieldUnderNewFITBooking,ExcelHelperMap.get("PassengerFirstName"));
								WebCtrls.DeadWait(2000);
								WebCtrls.PerfectSendKeys(newFITBookingPage.FirstNameFieldUnderNewFITBooking, Keys.ENTER);
								WebCtrls.DeadWait(2000);
								WebCtrls.PerfectClick(sellingAppHomePage.LoadButtonOnTheSellingAppHomePage);
								WebCtrls.PerfectClick(sellingAppHomePage.MiniProfileOnSellingAppHomePage);				
								WebCtrls.PerfectClick(newFITBookingPage.MonthSliderUnderNewFITBooking);
								WebCtrls.PerfectClick(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking);
								WebCtrls.Ctrl(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking).clear();
								WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.SailingMonthrangeFieldUnderNewFITBooking,ExcelHelperMap.get("SailingMonthrange"));
								WebCtrls.DeadWait(2000);
								WebCtrls.JavascriptClick(newFITBookingPage.AdvanceSearchButton);
								WebCtrls.PerfectClick(newFITBookingPage.ClickOnDealsTab);
								WebCtrls.PerfectScroll(newFITBookingPage.RateTypeFieldUnderNewFITBookingPage);
								WebCtrls.PerfectClick(newFITBookingPage.RateTypeFieldUnderNewFITBookingPage);
								WebCtrls.PerfectDropdownByText(newFITBookingPage.RateTypeDropdown,ExcelHelperMap.get("RateType"));
								WebCtrls.PerfectMouseClick(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab);
								WebCtrls.PerfectClick(newFITBookingPage.RateClassificationFieldUnderNewFITBookingPage);
								WebCtrls.PerfectDropdownByText(newFITBookingPage.RateClassificationDropdown,ExcelHelperMap.get("RateClassification"));
								WebCtrls.PerfectMouseClick(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab);	
								WebCtrls.PerfectScroll(newFITBookingPage.RatePlanFieldUnderDealsTab);
								WebCtrls.PerfectClick(newFITBookingPage.RatePlanFieldUnderDealsTab);
								WebCtrls.DeadWait(2000);
								WebCtrls.PerfectClick(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab);
								WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab,ExcelHelperMap.get("RatePlan"));
								WebCtrls.PerfectSendKeys(newFITBookingPage.RatePlanFieldSearchBoxUnderDealsTab, Keys.ENTER);
								WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
								Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage),"Cruise selection page is not Loaded");
								listeners.addLog("TC_021", "Cruise Selection page Loaded");
								
								WebCtrls.PerfectClick(cruiseSelectionPage.ProceedButtonOnTheCruiseSelectionPage);
								WebCtrls.PerfectClick(cruiseSelectionPage.ContinueButtonOnTheAlertPopup);
								WebCtrls.DeadWait(5000);
								WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
								Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.RateTypeValidation(ExcelHelperMap.get("RateType"))),"RateType is not verified");
								listeners.addLog("TC_021", "Rate Type is Verified");

								WebCtrls.JavascriptClick(selectCabinPage.DetailsButtonOnTheCabinSelectionPage);
								WebCtrls.JavascriptClick(selectCabinPage.InfoTabOnTheCabinSelectionPage);
								WebCtrls.JavascriptClick(selectCabinPage.IdentifiersTabOnTheCabinSelectionPage);
								Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.RatePlanValidation(ExcelHelperMap.get("RatePlan"))),"RatePlan is not verified");
								listeners.addLog("TC_021", "Rate Plan is Verified");
			
						
						
					
						
							}				
	
}
