package net.focltng.testcases;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import net.focltng.helper.ExcelHelper;
import net.focltng.helper.Listeners;
import net.focltng.pages.BaseTest;
import net.focltng.pages.BookingCartPage;
import net.focltng.pages.BookingConfirmationPage;
import net.focltng.pages.HomePage;
import net.focltng.pages.LoginPage;
import net.focltng.pages.NewFITBookingPage;
import net.focltng.pages.PassengerInformationPage;
import net.focltng.pages.PaymentInformationPage;
import net.focltng.pages.SelectCabinPage;
import net.focltng.pages.SellingAppHomePage;
import net.focltng.utils.WebCtrls;

//<summary>
/// Test Scenario :  Booking made from a Guest who would like to book a cabin with a Twin bed and cot.
//                  Booking cabin with twin beds (occupancy) and Cot added as a Facility.
public class TestCases extends BaseTest {
	private static Map<String, String> ExcelHelperMap = new HashMap<String, String>();

// <summary>
/// Test Case Title : Verify whether a user should be able to book a cabin with a twin bed and add a cot as a facility from the Cabin selection page
/// Automation ID : 045
/// @Author : Thushara
/// </summary>

	@Test
	public void TC_045() {
		ExcelHelperMap = ExcelHelper.getExcelData();
		Listeners listeners = new Listeners();

		getDriver().get(ExcelHelperMap.get("URL"));

		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		NewFITBookingPage newFITBookingPage = new NewFITBookingPage();
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
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),
				"Selling App page is not Loaded");
		listeners.addLog("TC_045", "Selling App page Loaded");

		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab,
				ExcelHelperMap.get("CruiseId"));
		WebCtrls.PerfectSendKeys(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab, Keys.BACK_SPACE);
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.DropdownListUnderCruiseTab),
				"Cruise Id list has not shown in Dropdown");
		listeners.addLog("TC_045", "Cruse Id list has shown");

		WebCtrls.PerfectDropdownByText(newFITBookingPage.DropdownListUnderCruiseTab, ExcelHelperMap.get("CruiseId"));
		WebCtrls.PerfectScroll(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
		WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
		Assert.assertTrue(
				WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.SelectOccupanyCabinFromTheCabinList("2")),
				"Max occupancy in  Cabin catagory not displayed");
		listeners.addLog("TC_045", " occupancy in  Cabin catagory  displayed");

		WebCtrls.PerfectScroll(
				newFITBookingPage.SelectOccupanyCabinFromTheCabinList(ExcelHelperMap.get("BedPreference")));
		WebCtrls.PerfectClick(
				newFITBookingPage.SelectOccupanyCabinFromTheCabinList(ExcelHelperMap.get("BedPreference")));
		WebCtrls.PerfectClick(selectCabinPage.SelectCabinButton);
		WebCtrls.PerfectScroll(selectCabinPage.SelectFacilityUnderCabinSelectionBox);
		WebCtrls.PerfectClick(selectCabinPage.SelectFacilityUnderCabinSelectionBox);
		WebCtrls.PerfectClick(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox);
		WebCtrls.Ctrl(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox)
				.sendKeys(ExcelHelperMap.get("FirstFacility"));
		WebCtrls.DeadWait(500);
		WebCtrls.PerfectSendKeys(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox, Keys.ENTER);
		WebCtrls.PerfectScrollUp();
		String InitialCount = WebCtrls
				.GetTextWithTimeOut(selectCabinPage.InitialCountOnSelectionCabinDirectCustomerLogin);
		int initialcnt = Integer.parseInt(InitialCount);
		String InitialCountofWaitlistFacility = WebCtrls
				.GetTextWithTimeOut(selectCabinPage.InitialWaitlistCountOnCabinSelectionPageOfFirstfacility);
		int initialcntofwaitlistfacility = Integer.parseInt(InitialCount);
		WebCtrls.PerfectScroll(selectCabinPage.CheckFaclitynum("A1"));
		WebCtrls.PerfectClick(selectCabinPage.CheckFaclitynum("A1"));
		WebCtrls.WaitForElement(selectCabinPage.AddToCartButton);
		Assert.assertTrue(
				WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.SelectOccupanycabinfromcabindetailspage("2")),
				"Maximum Occupancy is not there");
		listeners.addLog("TC_045", "Max Occupancy shown");

		WebCtrls.PerfectClick(selectCabinPage.AddToCartButton);
		WebCtrls.PerfectClick(selectCabinPage.EnterTheFirstNameOfthePassenger);
		WebCtrls.PerfectEditWithTimeOut(selectCabinPage.EnterTheFirstNameOfthePassenger,
				ExcelHelperMap.get("PassengerFirstName"));
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.FirstNameOfthePassengerList),
				"In Booking Contact Info page Passenger suggestion has not shown");
		listeners.addLog("TC_045", "Passenger Suggestion shown");

		WebCtrls.PerfectSendKeys(selectCabinPage.EnterTheFirstNameOfthePassenger, Keys.ENTER);
		WebCtrls.PerfectClick(selectCabinPage.SaveButtonOnBookingContactInfoPopup);
		WebCtrls.DeadWait(2000);
		WebCtrls.JavascriptClick(selectCabinPage.AddToCartButton);
		WebCtrls.PerfectScroll(selectCabinPage.AssociatedTravellerFirstNameField);
		WebCtrls.PerfectEditWithTimeOut(selectCabinPage.AssociatedTravellerFirstNameField,
				ExcelHelperMap.get("AssociatedTraveller"));
		WebCtrls.PerfectSendKeys(selectCabinPage.AssociatedTravellerFirstNameField, Keys.ENTER);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(selectCabinPage.ContinueButtonOnSelectPassengerPopup);
		WebCtrls.PerfectClick(selectCabinPage.ReviewCartButtonOnMiniCartSideMenu);
		WebCtrls.PerfectClick(bookingCartPage.ProceedToBookingButton);
		WebCtrls.WaitForElement(bookingCartPage.RadioButtonOnTermsAndConditionsPopup);
		WebCtrls.JavascriptClick(bookingCartPage.RadioButtonOnTermsAndConditionsPopup);
		WebCtrls.PerfectClick(bookingCartPage.OkButtonOnTermsAndConditionsPopup);
		WebCtrls.PerfectClick(bookingCartPage.ProceedToBookingButton);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectScroll(passengerInformationPage.SaveAndContinueButton);
		WebCtrls.PerfectClick(passengerInformationPage.SaveAndContinueButton);
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(paymentInformationPage.PaymentInformationPageHeader),
				"payment Information Page has not loaded");
		listeners.addLog("TC_045", "Payement informatoin page has loaded");

		WebCtrls.PerfectScroll(paymentInformationPage.CashPaymentTabOnThePaymentPage);
		WebCtrls.PerfectClick(paymentInformationPage.CashPaymentTabOnThePaymentPage);
		String TotalAmount = WebCtrls.GetTextWithTimeOut(paymentInformationPage.TotalAmountOnPaymentForBookingArea);
		WebCtrls.PerfectEditWithTimeOut(paymentInformationPage.AmountInputAreaOnCashTab,
				TotalAmount.replaceAll(",", ""));
		WebCtrls.PerfectScroll(paymentInformationPage.ProceedToBookingButton);
		WebCtrls.PerfectClick(paymentInformationPage.ProceedToBookingButton);
		WebCtrls.PerfectClick(paymentInformationPage.ConfirmButtonOnOverPaymentWarningPopup);
		Assert.assertTrue(
				WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.BookingConfirmationStatus).contains("CONFIRMED"),
				"Booking Id has not confimed");
		listeners.addLog("TC_045", "Booking Id has confirmed");

		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(bookingConfirmationPage.FacilityFieldUnderConfirmationpage);
		WebCtrls.DeadWait(1000);
		String StatusOfFacility = WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.StatusOfFacilitySelected);
		if (StatusOfFacility == "CNF") {
			Assert.assertEquals(StatusOfFacility, "CNF");
			listeners.addLog("TC_045", "Facility status shown");

		} else if (StatusOfFacility == "WL") {
			Assert.assertEquals(StatusOfFacility, "WL");
			listeners.addLog("TC_045", "Facility status shown");

		}

		Assert.assertTrue(
				WebCtrls.PerfectDisplayedWithTimeOut(bookingConfirmationPage.ViewCotDetailsUnderConfirmationpage),
				"Infant Cot Facility is not added");
		listeners.addLog("TC_045", "Correct Facility Selected shown");

		WebCtrls.PerfectClick(bookingConfirmationPage.ViewDetailsButtonUnderConfirmationpage);
		WebCtrls.DeadWait(5000);
		String FinalCount = WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.FinalCountOnBookingConfirmationPage);
		String FinalCountofWaitlistFacility = WebCtrls
				.GetTextWithTimeOut(bookingConfirmationPage.FinalWaitlistCountOnBookingConfirmationPageOfFirstfacility);
		if (initialcnt > 0) {
			int finalcnt = Integer.parseInt(FinalCount);
			Assert.assertEquals(initialcnt - 1, finalcnt, "COUNT IS NOT VERIFIED");
			listeners.addLog("TC_045", "Facility count verified");

		} else {
			int finalCountofWaitlistFacility = Integer.parseInt(FinalCountofWaitlistFacility);
			Assert.assertEquals(initialcntofwaitlistfacility - 1, finalCountofWaitlistFacility,
					"COUNT IS NOT VERIFIED");
			listeners.addLog("TC_045", "Waitlist Facility count verified");

		}

		Assert.assertTrue(WebCtrls.Ctrl(bookingConfirmationPage.CnfButtonForSecondPassenger).isEnabled(),
				"Passenger not selected properly");
		listeners.addLog("TC_045", "Correct passenger status shown");

	}

// <summary>
/// Test Case Title : Verify whether a user should be able to book a cabin with a twin bed and add a cot as a facility from the Booking confirmation page
/// Automation ID : 046
/// @Author : Thushara
/// </summary>

	@Test
	public void TC_046() {
		ExcelHelperMap = ExcelHelper.getExcelData();
		Listeners listeners = new Listeners();

		getDriver().get(ExcelHelperMap.get("URL"));

		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		SellingAppHomePage sellingAppHomePage = new SellingAppHomePage();
		BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
		NewFITBookingPage newFITBookingPage = new NewFITBookingPage();
		WebCtrls.PerfectEditWithTimeOut(loginPage.UserNameAreaOnLoginPage, ExcelHelperMap.get("UserName"));
		WebCtrls.PerfectClick(loginPage.NextButtonOnLoginPage);
		WebCtrls.PerfectEditWithTimeOut(loginPage.PasswordAreaOnLoginPage, ExcelHelperMap.get("Password"));
		WebCtrls.PerfectClick(loginPage.LoginButtonOnLoginPage);
		WebCtrls.DeadWait(4000);
		WebCtrls.PerfectClick(homePage.SellingAppTileOnHomePage);
		WebCtrls.CloseCurrentWindow();
		WebCtrls.SwithToLastWindow();
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),
				"Selling App page is not Loaded");
		listeners.addLog("TC_046", "Selling App page Loaded");

		WebCtrls.PerfectScroll(sellingAppHomePage.MyRecentBookingsOrCartsUnderCruiseTab);
		WebCtrls.PerfectClick(sellingAppHomePage.MyRecentBookingsOrCartsUnderCruiseTab);
		WebCtrls.PerfectEdit(sellingAppHomePage.SearchKeywordUnderMyRecentBookingOrCarts,
				ExcelHelperMap.get("BookingId"));
		WebCtrls.PerfectScroll(sellingAppHomePage.RecentBookingsIdListUnderCruiseTab);
		WebCtrls.PerfectClick(sellingAppHomePage.RecentBookingsIdListUnderCruiseTab);
		Assert.assertTrue(
				WebCtrls.PerfectDisplayedWithTimeOut(
						bookingConfirmationPage.BookingIdValidation(ExcelHelperMap.get("BookingId"))),
				"Confirmation Page is not shown with the given booking Id");
		listeners.addLog("TC_046", "Correct Booking ID page shown");

		WebCtrls.PerfectScroll(bookingConfirmationPage.MoreOptionsButtonUnderConfirmationpage);
		WebCtrls.PerfectClick(bookingConfirmationPage.MoreOptionsButtonUnderConfirmationpage);
		WebCtrls.PerfectClick(bookingConfirmationPage.AddFacilitiesButtonUnderConfirmationpage);
		WebCtrls.PerfectScroll(bookingConfirmationPage.FacilityAdditionCheckboxUnderConfirmationpage);
		WebCtrls.PerfectClick(bookingConfirmationPage.FacilityAdditionCheckboxUnderConfirmationpage);
		String InitialCount = WebCtrls
				.GetTextWithTimeOut(bookingConfirmationPage.InitialCountOnBookingConfirmationPage);
		int initialcnt = Integer.parseInt(InitialCount);
		String InitialCountofWaitlistFacility = WebCtrls.GetTextWithTimeOut(
				bookingConfirmationPage.InitialWaitlistCountOnBookingConfirmationPageOfFirstfacility);
		int initialcntofwaitlistfacility = Integer.parseInt(InitialCountofWaitlistFacility);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(bookingConfirmationPage.SaveButtonUnderConfirmationpage);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(bookingConfirmationPage.FacilityFieldUnderConfirmationpage);
		WebCtrls.DeadWait(1000);
		String StatusOfFacility = WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.StatusOfFacilitySelected);
		if (StatusOfFacility == "CNF") {
			Assert.assertEquals(StatusOfFacility, "CNF");
			listeners.addLog("TC_046", "Facility status shown");

		} else if (StatusOfFacility == "WL") {
			Assert.assertEquals(StatusOfFacility, "WL");
			listeners.addLog("TC_046", "Facility status shown");

		}
		Assert.assertTrue(
				WebCtrls.PerfectDisplayedWithTimeOut(bookingConfirmationPage.ViewCotDetailsUnderConfirmationpage),
				"Infant Cot Facility is not added");
		listeners.addLog("TC_046", "Correct Facility Selected shown");

		WebCtrls.PerfectClick(bookingConfirmationPage.ViewDetailsButtonUnderConfirmationpage);
		WebCtrls.DeadWait(5000);
		String FinalCount = WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.FinalCountOnBookingConfirmationPage);
		String FinalCountofWaitlistfacility = WebCtrls
				.GetTextWithTimeOut(bookingConfirmationPage.FinalWaitlistCountOnBookingConfirmationPageOfFirstfacility);
		if (initialcnt > 0) {
			int finalcnt = Integer.parseInt(FinalCount);
			Assert.assertEquals(initialcnt - 1, finalcnt, "COUNT IS NOT VERIFIED");
			listeners.addLog("TC_045", "Facility count verified");

		} else {
			int finalcntofwaitlistfacility = Integer.parseInt(FinalCountofWaitlistfacility);
			Assert.assertEquals(initialcntofwaitlistfacility - 1, finalcntofwaitlistfacility, "COUNT IS NOT VERIFIED");
			listeners.addLog("TC_045", "Waitlist Facility count verified");

		}
		Assert.assertTrue(WebCtrls.Ctrl(bookingConfirmationPage.CnfButtonForSecondPassenger).isEnabled(),
				"Passenger not selected properly");
		listeners.addLog("TC_046", "Correct passenger status shown");

	}

//<summary>
/// Test Case Title : Verify whether a user should be able to book a cabin with a twin bed and add a cot as a facility from the Cabin selection page.(Agency profile is loaded)
/// Automation ID : 047
/// @Author : Lekshmi
/// </summary>
	@Test
	public void TC_047() {
		ExcelHelperMap = ExcelHelper.getExcelData();
		Listeners listeners = new Listeners();

		getDriver().get(ExcelHelperMap.get("URL"));
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		SellingAppHomePage sellingAppHomePage = new SellingAppHomePage();
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
		assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),
				"Selling App page is not Loaded");
		listeners.addLog("TC_047", "Seeling App page Loaded");

		WebCtrls.WaitForElement(sellingAppHomePage.AgencyOnTheSellingAppHomePage);
		WebCtrls.PerfectEditWithTimeOut(sellingAppHomePage.AgencyOnTheSellingAppHomePage,
				ExcelHelperMap.get("AgencyCode"));
		assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(sellingAppHomePage.AgencyCodeSuggestionOnTheSellingAppHomePage),
				"Agency Code sugesstion not Loaded");
		listeners.addLog("TC_047", "Agency code displayed");

		WebCtrls.PerfectClick(sellingAppHomePage.AgencyCodeSuggestionOnTheSellingAppHomePage);
		WebCtrls.PerfectClick(sellingAppHomePage.LoadButtonAgencyOnTheSellingAppHomePage);
		WebCtrls.PerfectClick(sellingAppHomePage.AgencyMiniProfileIconOnMiniProfilePopup);
		WebCtrls.PerfectClick(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab);
		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab,
				ExcelHelperMap.get("CruiseId"));
		assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.DropdownListUnderCruiseTab),
				"Cruise Id list has not shown in Dropdown");
		listeners.addLog("TC_047", "Cruise Dropdown displayed");

		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab,
				ExcelHelperMap.get("CruiseId"));
		assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.DropdownListUnderCruiseTab),
				"Cruise Id list has not shown in Dropdown");
		listeners.addLog("TC_047", "Cruise id List displayed");

		WebCtrls.PerfectDropdownByText(newFITBookingPage.DropdownListUnderCruiseTab, ExcelHelperMap.get("CruiseId"));
		WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
		WebCtrls.PerfectClick(selectCabinPage.AutoAssignButtonOnCabinCategoryPage);
		WebCtrls.DeadWait(3000);
		WebCtrls.PerfectClick(selectCabinPage.SelectFacilityUnderCabinSelectionBox2);
		WebCtrls.PerfectClick(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox);
		WebCtrls.Ctrl(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox)
				.sendKeys(ExcelHelperMap.get("FirstFacility"));
		WebCtrls.PerfectSendKeys(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox, Keys.ENTER);
		String InitialCount = WebCtrls.GetTextWithTimeOut(selectCabinPage.InitialCountOnSelectionCabin);
		int initialcnt = Integer.parseInt(InitialCount);
		String InitialCountonWaitlist = WebCtrls
				.GetTextWithTimeOut(selectCabinPage.InitialWaitlistCountOnCabinSelectionPageForAutoAssign);
		int initialcntonwaitlistunderagencyloading = Integer.parseInt(InitialCountonWaitlist);
		WebCtrls.PerfectClick(selectCabinPage.SelectFacilityUnderCabinSelectionCheckBox);
		WebCtrls.PerfectScroll(selectCabinPage.ProceedButtonOnCabinSelectionPage);
		WebCtrls.PerfectClick(selectCabinPage.ProceedButtonOnCabinSelectionPage);
		WebCtrls.PerfectEditWithTimeOut(selectCabinPage.LeadTravellerFirstNameField,
				ExcelHelperMap.get("LeadTraveller"));
		WebCtrls.PerfectClick(
				selectCabinPage.LeadTravellerFirstNameFieldSuggestionList(ExcelHelperMap.get("LeadTraveller")));
		WebCtrls.PerfectScroll(selectCabinPage.AssociatedTravellerFirstNameField);
		WebCtrls.PerfectEditWithTimeOut(selectCabinPage.AssociatedTravellerFirstNameField,
				ExcelHelperMap.get("AssociatedTraveller"));
		WebCtrls.PerfectClick(selectCabinPage
				.AssociatedTravellerFirstNameFieldSuggestionList(ExcelHelperMap.get("AssociatedTraveller")));
		WebCtrls.PerfectClick(selectCabinPage.ContinueButtonOnSelectPassengerPopup);
		WebCtrls.PerfectClick(selectCabinPage.ReviewCartButtonOnMiniCartSideMenu);
		WebCtrls.PerfectClick(bookingCartPage.TermsAndConditionCheckBoxOnCartPage);
		WebCtrls.PerfectClick(bookingCartPage.ProceedToBookingButton);
		WebCtrls.PerfectClick(bookingCartPage.ProceedToBookingButton);
		WebCtrls.PerfectScroll(passengerInformationPage.SaveAndContinueButton);
		WebCtrls.PerfectClick(passengerInformationPage.SaveAndContinueButton);
		WebCtrls.DeadWait(3000);
		assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(paymentInformationPage.PaymentInformationPageHeader),
				"payment Information Page has not loaded");
		listeners.addLog("TC_047", "PaymentInformationPageLoaded");

		WebCtrls.PerfectClick(paymentInformationPage.CashPaymentTabOnThePaymentPage);
		String TotalAmount = WebCtrls.GetTextWithTimeOut(paymentInformationPage.TotalAmountOnPaymentForBookingArea)
				.replaceAll(",", "");
		WebCtrls.PerfectEditWithTimeOut(paymentInformationPage.AmountInputAreaOnCashTab,
				TotalAmount.replaceAll(",", ""));
		WebCtrls.PerfectScroll(paymentInformationPage.ProceedToBookingButton);
		WebCtrls.PerfectClick(paymentInformationPage.ProceedToBookingButton);
		WebCtrls.PerfectClick(paymentInformationPage.ConfirmButtonOnOverPaymentWarningPopup);
		WebCtrls.PerfectClick(bookingConfirmationPage.FacilityFieldUnderConfirmationpage);
		WebCtrls.DeadWait(1000);
		Assert.assertTrue(
				WebCtrls.PerfectDisplayedWithTimeOut(bookingConfirmationPage.ViewCotDetailsUnderConfirmationpage),
				"Infant Cot Facility is not added");
		listeners.addLog("TC_047", "Correct Facility Selected shown");

		WebCtrls.PerfectClick(bookingConfirmationPage.ViewDetailsButtonUnderConfirmationpage);
		WebCtrls.DeadWait(3000);
		String FinalCount = WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.FinalCountOnBookingConfirmationPage);
		int finalcnt = Integer.parseInt(FinalCount);
		String FinalCountonwaitlist = WebCtrls
				.GetTextWithTimeOut(bookingConfirmationPage.FinalWaitlistCountOnBookingConfirmationPageOfFirstfacility);
		int finalcntonwaitlistunderagencyloading = Integer.parseInt(FinalCountonwaitlist);
		if (initialcnt > 0) {
			Assert.assertEquals(initialcnt - 1, finalcnt, "COUNT IS NOT VERIFIED");
			listeners.addLog("TC_047", "Facility count verified");

		} else {
			Assert.assertEquals(initialcntonwaitlistunderagencyloading - 1, finalcntonwaitlistunderagencyloading,
					"COUNT IS NOT VERIFIED");
			listeners.addLog("TC_047", "Facility count verified");

		}

		String StatusOfFacility = WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.StatusOfFacilitySelected);
		if (StatusOfFacility == "CNF") {
			Assert.assertEquals(StatusOfFacility, "CNF");
			listeners.addLog("TC_047", "Facility status shown");

		} else if (StatusOfFacility == "WL") {
			Assert.assertEquals(StatusOfFacility, "WL");
			listeners.addLog("TC_047", "Facility status shown");

		}
		WebCtrls.PerfectScroll(bookingConfirmationPage.CnfButtonForSecondPassenger);
		Assert.assertTrue(WebCtrls.Ctrl(bookingConfirmationPage.CnfButtonForSecondPassenger).isEnabled(),
				"Passenger not selected properly");
		listeners.addLog("TC_047", "Correct passenger status shown");

	}

//<summary>
/// Test Case Title : Verify whether a user should be able to book a cabin with a twin bed and add a cot as a facility from the Cart page
/// Automation ID : 048
/// @Author : Thushara
/// </summary>
	@Test
	public void TC_048() {
		ExcelHelperMap = ExcelHelper.getExcelData();
		Listeners listeners = new Listeners();

		getDriver().get(ExcelHelperMap.get("URL"));

		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		NewFITBookingPage newFITBookingPage = new NewFITBookingPage();
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
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),
				"Selling App page is not Loaded");
		listeners.addLog("TC_048", "Selling App page Loaded");

		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab,
				ExcelHelperMap.get("CruiseId"));
		WebCtrls.PerfectSendKeys(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab, Keys.BACK_SPACE);
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.DropdownListUnderCruiseTab),
				"Cruise Id list has not shown in Dropdown");
		listeners.addLog("TC_048", "Cruse Id list has shown");

		WebCtrls.PerfectDropdownByText(newFITBookingPage.DropdownListUnderCruiseTab, ExcelHelperMap.get("CruiseId"));
		WebCtrls.PerfectScroll(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
		WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
		Assert.assertTrue(
				WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.SelectOccupanyCabinFromTheCabinList("2")),
				"Max occupancy in  Cabin catagory not displayed");
		listeners.addLog("TC_048", " occupancy in  Cabin catagory  displayed");

		WebCtrls.PerfectScroll(
				newFITBookingPage.SelectOccupanyCabinFromTheCabinList(ExcelHelperMap.get("BedPreference")));
		WebCtrls.PerfectClick(
				newFITBookingPage.SelectOccupanyCabinFromTheCabinList(ExcelHelperMap.get("BedPreference")));

		WebCtrls.PerfectClick(selectCabinPage.SelectCabinButton);
		WebCtrls.DeadWait(3000);
		WebCtrls.WaitForElement(selectCabinPage.AddToCartButton);
		Assert.assertTrue(
				WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.SelectOccupanycabinfromcabindetailspage("2")),
				"Maximum Occupancy is not there");
		listeners.addLog("TC_048", "Max Occupancy shown");

		WebCtrls.PerfectClick(selectCabinPage.AddToCartButton);
		WebCtrls.PerfectClick(selectCabinPage.EnterTheFirstNameOfthePassenger);
		WebCtrls.PerfectEditWithTimeOut(selectCabinPage.EnterTheFirstNameOfthePassenger,
				ExcelHelperMap.get("PassengerFirstName"));
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.FirstNameOfthePassengerList),
				"In Booking Contact Info page Passenger suggestion has not shown");
		listeners.addLog("TC_048", "Passenger Suggestion shown");

		WebCtrls.PerfectSendKeys(selectCabinPage.EnterTheFirstNameOfthePassenger, Keys.ENTER);
		WebCtrls.PerfectClick(selectCabinPage.SaveButtonOnBookingContactInfoPopup);
		WebCtrls.DeadWait(4000);
		WebCtrls.JavascriptClick(selectCabinPage.AddToCartButton);
		WebCtrls.PerfectScroll(selectCabinPage.AssociatedTravellerFirstNameField);
		WebCtrls.PerfectEditWithTimeOut(selectCabinPage.AssociatedTravellerFirstNameField,
				ExcelHelperMap.get("AssociatedTraveller"));
		WebCtrls.PerfectSendKeys(selectCabinPage.AssociatedTravellerFirstNameField, Keys.ENTER);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(selectCabinPage.ContinueButtonOnSelectPassengerPopup);
		WebCtrls.PerfectClick(selectCabinPage.ReviewCartButtonOnMiniCartSideMenu);
		WebCtrls.PerfectScroll(bookingCartPage.MoreOptionsButtonUnderCartpage);
		WebCtrls.PerfectClick(bookingCartPage.MoreOptionsButtonUnderCartpage);
		WebCtrls.PerfectClick(bookingCartPage.AddFacilitiesButtonUnderCartpage);
		WebCtrls.PerfectScroll(bookingCartPage.FacilityAdditionCheckboxUnderCartpage);
		String InitialCount = WebCtrls.GetTextWithTimeOut(bookingCartPage.InitialCountOnBookingCartPage);
		int initialcnt = Integer.parseInt(InitialCount);
		String InitialCountofWaitlistUnderCartPage = WebCtrls
				.GetTextWithTimeOut(bookingCartPage.InitialWaitlistCountOnBookingConfirmationPageOfFirstfacility);
		int initialcntofwaitlistoncartpage = Integer.parseInt(InitialCountofWaitlistUnderCartPage);
		WebCtrls.PerfectClick(bookingCartPage.FacilityAdditionCheckboxUnderCartpage);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(bookingCartPage.SaveButtonUnderCartpage);
		WebCtrls.DeadWait(5000);
		WebCtrls.PerfectClick(bookingCartPage.TermsAndConditionCheckBoxOnCartPage);
		WebCtrls.PerfectClick(bookingCartPage.ProceedToBookingButton);
		WebCtrls.PerfectScroll(passengerInformationPage.SaveAndContinueButton);
		WebCtrls.PerfectClick(passengerInformationPage.SaveAndContinueButton);
		assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(paymentInformationPage.PaymentInformationPageHeader),
				"payment Information Page has not loaded");
		listeners.addLog("TC_048", "PaymentInformationPageLoaded");

		WebCtrls.PerfectClick(paymentInformationPage.CashPaymentTabOnThePaymentPage);
		String TotalAmount = WebCtrls.GetTextWithTimeOut(paymentInformationPage.TotalAmountOnPaymentForBookingArea)
				.replaceAll(",", "");
		WebCtrls.PerfectEditWithTimeOut(paymentInformationPage.AmountInputAreaOnCashTab,
				TotalAmount.replaceAll(",", ""));
		WebCtrls.PerfectScroll(paymentInformationPage.ProceedToBookingButton);
		WebCtrls.PerfectClick(paymentInformationPage.ProceedToBookingButton);
		WebCtrls.PerfectClick(paymentInformationPage.ConfirmButtonOnOverPaymentWarningPopup);
		Assert.assertTrue(
				WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.BookingConfirmationStatus).contains("CONFIRMED"),
				"Booking Id has not confimed");
		listeners.addLog("TC_048", "Booking Id has confirmed");

		WebCtrls.PerfectClick(bookingConfirmationPage.FacilityFieldUnderConfirmationpage);
		WebCtrls.DeadWait(1000);
		Assert.assertTrue(
				WebCtrls.PerfectDisplayedWithTimeOut(bookingConfirmationPage.ViewCotDetailsUnderConfirmationpage),
				"Infant Cot Facility is not added");
		listeners.addLog("TC_048", "Correct Facility Selected shown");

		WebCtrls.PerfectClick(bookingConfirmationPage.ViewDetailsButtonUnderConfirmationpage);
		WebCtrls.DeadWait(5000);
		String FinalCount = WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.FinalCountOnBookingConfirmationPage);
		int finalcnt = Integer.parseInt(FinalCount);
		String FinalCountofwaitlistunderconfirmationpage = WebCtrls
				.GetTextWithTimeOut(bookingConfirmationPage.FinalWaitlistCountOnBookingConfirmationPageOfFirstfacility);
		int finalcntofwaitlistunderconfirmationpage = Integer.parseInt(FinalCountofwaitlistunderconfirmationpage);

		if (initialcnt > 0) {
			Assert.assertEquals(initialcnt - 1, finalcnt, "COUNT IS NOT VERIFIED");
			listeners.addLog("TC_045", "Facility count verified");

		} else {
			Assert.assertEquals(initialcntofwaitlistoncartpage - 1, finalcntofwaitlistunderconfirmationpage,
					"COUNT IS NOT VERIFIED");
			listeners.addLog("TC_045", "Waitlist Facility count verified");

		}

		WebCtrls.PerfectScroll(bookingConfirmationPage.CnfButtonForSecondPassenger);
		Assert.assertTrue(WebCtrls.Ctrl(bookingConfirmationPage.CnfButtonForSecondPassenger).isEnabled(),
				"Passenger not selected properly");
		listeners.addLog("TC_048", "Correct passenger status shown");

		String StatusOfFacility = WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.StatusOfFacilitySelected);
		if (StatusOfFacility == "CNF") {
			Assert.assertEquals(StatusOfFacility, "CNF");
			listeners.addLog("TC_048", "Facility status shown");

		} else if (StatusOfFacility == "WL") {
			Assert.assertEquals(StatusOfFacility, "WL");
			listeners.addLog("TC_048", "Facility status shown");

		}

	}

//<summary>
/// Test Case Title : Verify whether a user should be able to book a cabin with a twin bed and add a multiple facilities from the Cabin selection page
/// Automation ID : 049
/// @Author : Thushara
/// </summary>
	@Test
	public void TC_049() {
		ExcelHelperMap = ExcelHelper.getExcelData();
		Listeners listeners = new Listeners();

		getDriver().get(ExcelHelperMap.get("URL"));
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		NewFITBookingPage newFITBookingPage = new NewFITBookingPage();
		SelectCabinPage selectCabinPage = new SelectCabinPage();
		BookingCartPage bookingCartPage = new BookingCartPage();
		BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
		PassengerInformationPage passengerInformationPage = new PassengerInformationPage();
		PaymentInformationPage paymentInformationPage = new PaymentInformationPage();
		WebCtrls.PerfectEditWithTimeOut(loginPage.UserNameAreaOnLoginPage, ExcelHelperMap.get("UserName"));
		WebCtrls.PerfectClick(loginPage.NextButtonOnLoginPage);
		WebCtrls.PerfectEditWithTimeOut(loginPage.PasswordAreaOnLoginPage, ExcelHelperMap.get("Password"));
		WebCtrls.PerfectClick(loginPage.LoginButtonOnLoginPage);
		WebCtrls.DeadWait(4000);
		WebCtrls.WaitForElement(homePage.SellingAppTileOnHomePage);
		WebCtrls.PerfectClick(homePage.SellingAppTileOnHomePage);
		WebCtrls.DeadWait(4000);
		WebCtrls.CloseCurrentWindow();
		WebCtrls.SwithToLastWindow();
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),
				"Selling App page is not Loaded");
		listeners.addLog("TC_049", "Selling App page Loaded");

		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab,
				ExcelHelperMap.get("CruiseId"));
		WebCtrls.PerfectSendKeys(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab, Keys.BACK_SPACE);
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.DropdownListUnderCruiseTab),
				"Cruise Id list has not shown in Dropdown");
		listeners.addLog("TC_049", "Cruse Id list has shown");

		WebCtrls.PerfectDropdownByText(newFITBookingPage.DropdownListUnderCruiseTab, ExcelHelperMap.get("CruiseId"));
		WebCtrls.PerfectScroll(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
		WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
		Assert.assertTrue(
				WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.SelectOccupanyCabinFromTheCabinList("2")),
				"Max occupancy in  Cabin catagory not displayed");
		listeners.addLog("TC_049", " occupancy in  Cabin catagory  displayed");

		WebCtrls.PerfectScroll(
				newFITBookingPage.SelectOccupanyCabinFromTheCabinList(ExcelHelperMap.get("BedPreference")));
		WebCtrls.PerfectClick(
				newFITBookingPage.SelectOccupanyCabinFromTheCabinList(ExcelHelperMap.get("BedPreference")));
		WebCtrls.PerfectClick(selectCabinPage.SelectCabinButton);
		WebCtrls.PerfectScroll(selectCabinPage.SelectFacilityUnderCabinSelectionBox);
		WebCtrls.PerfectClick(selectCabinPage.SelectFacilityUnderCabinSelectionBox);
		WebCtrls.PerfectClick(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox);
		WebCtrls.Ctrl(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox)
				.sendKeys(ExcelHelperMap.get("FirstFacility"));
		WebCtrls.DeadWait(500);
		WebCtrls.PerfectSendKeys(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox, Keys.ENTER);
		String InitialCount = WebCtrls
				.GetTextWithTimeOut(selectCabinPage.InitialCountOnSelectionCabinDirectCustomerLogin);
		int initialcnt = Integer.parseInt(InitialCount);
		String InitialCountofwaitlistunderFirstFacility = WebCtrls
				.GetTextWithTimeOut(selectCabinPage.InitialWaitlistCountOnCabinSelectionPageOfFirstfacility);
		int initialcntonwaitlistUnderfirstfacility = Integer.parseInt(InitialCountofwaitlistunderFirstFacility);
		WebCtrls.PerfectClick(selectCabinPage.CheckFaclitynum("A1"));
		WebCtrls.PerfectClick(selectCabinPage.FacilityAdditionAddButton);
		WebCtrls.PerfectClick(selectCabinPage.SelectFacilityUnderCabinSelectionBox);
		WebCtrls.PerfectScroll(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox);
		WebCtrls.PerfectClick(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox);
		WebCtrls.Ctrl(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox)
				.sendKeys(ExcelHelperMap.get("SecondFacility"));

		WebCtrls.DeadWait(500);
		WebCtrls.PerfectSendKeys(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox, Keys.ENTER);
		String InitialCountOfSecondFacility = WebCtrls
				.GetTextWithTimeOut(selectCabinPage.InitialCountOnSelectionCabinForSecondFacility);
		int initialcntofsecondfacility = Integer.parseInt(InitialCountOfSecondFacility);
		String InitialCountOfSecondFacilitywaitlist = WebCtrls
				.GetTextWithTimeOut(selectCabinPage.InitialWaitlistCountOnCabinSelectionPageOfSecondFacility);
		int initialcntofsecondfacilitywaitlist = Integer.parseInt(InitialCountOfSecondFacilitywaitlist);

		// WebCtrls.PerfectClick(selectCabinPage.CheckFacilitynumCheckbox);
		WebCtrls.WaitForElement(selectCabinPage.AddToCartButton);
		Assert.assertTrue(
				WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.SelectOccupanycabinfromcabindetailspage("2")),
				"Maximum Occupancy is not there");
		listeners.addLog("TC_049", "Max Occupancy shown");

		WebCtrls.PerfectClick(selectCabinPage.AddToCartButton);
		WebCtrls.PerfectClick(selectCabinPage.EnterTheFirstNameOfthePassenger);
		WebCtrls.PerfectEditWithTimeOut(selectCabinPage.EnterTheFirstNameOfthePassenger,
				ExcelHelperMap.get("PassengerFirstName"));
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(selectCabinPage.FirstNameOfthePassengerList),
				"In Booking Contact Info page Passenger suggestion has not shown");
		listeners.addLog("TC_049", "Passenger Suggestion shown");

		WebCtrls.PerfectSendKeys(selectCabinPage.EnterTheFirstNameOfthePassenger, Keys.ENTER);
		WebCtrls.PerfectClick(selectCabinPage.SaveButtonOnBookingContactInfoPopup);
		WebCtrls.DeadWait(4000);
		WebCtrls.JavascriptClick(selectCabinPage.AddToCartButton);
		WebCtrls.PerfectScroll(selectCabinPage.AssociatedTravellerFirstNameField);
		WebCtrls.PerfectEditWithTimeOut(selectCabinPage.AssociatedTravellerFirstNameField,
				ExcelHelperMap.get("AssociatedTraveller"));
		WebCtrls.PerfectSendKeys(selectCabinPage.AssociatedTravellerFirstNameField, Keys.ENTER);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(selectCabinPage.ContinueButtonOnSelectPassengerPopup);
		WebCtrls.PerfectClick(selectCabinPage.ReviewCartButtonOnMiniCartSideMenu);
		WebCtrls.PerfectClick(bookingCartPage.ProceedToBookingButton);
		WebCtrls.WaitForElement(bookingCartPage.RadioButtonOnTermsAndConditionsPopup);
		WebCtrls.JavascriptClick(bookingCartPage.RadioButtonOnTermsAndConditionsPopup);
		WebCtrls.PerfectClick(bookingCartPage.OkButtonOnTermsAndConditionsPopup);
		WebCtrls.PerfectClick(bookingCartPage.ProceedToBookingButton);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectScroll(passengerInformationPage.SaveAndContinueButton);
		WebCtrls.PerfectClick(passengerInformationPage.SaveAndContinueButton);
		Assert.assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(paymentInformationPage.PaymentInformationPageHeader),
				"payment Information Page has not loaded");
		listeners.addLog("TC_049", "Payement informatoin page has loaded");

		WebCtrls.PerfectScroll(paymentInformationPage.CashPaymentTabOnThePaymentPage);
		WebCtrls.PerfectClick(paymentInformationPage.CashPaymentTabOnThePaymentPage);
		String TotalAmount = WebCtrls.GetTextWithTimeOut(paymentInformationPage.TotalAmountOnPaymentForBookingArea);
		WebCtrls.PerfectEditWithTimeOut(paymentInformationPage.AmountInputAreaOnCashTab,
				TotalAmount.replaceAll(",", ""));
		WebCtrls.PerfectScroll(paymentInformationPage.ProceedToBookingButton);
		WebCtrls.PerfectClick(paymentInformationPage.ProceedToBookingButton);
		WebCtrls.PerfectClick(paymentInformationPage.ConfirmButtonOnOverPaymentWarningPopup);
		Assert.assertTrue(
				WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.BookingConfirmationStatus).contains("CONFIRMED"),
				"Booking Id has not confimed");
		listeners.addLog("TC_049", "Booking Id has confirmed");

		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectClick(bookingConfirmationPage.FacilityFieldUnderConfirmationpage);
		WebCtrls.DeadWait(1000);
		String StatusOfFacility = WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.StatusOfFacilitySelected);
		if (StatusOfFacility == "CNF") {
			Assert.assertEquals(StatusOfFacility, "CNF");
			listeners.addLog("TC_049", "Facility status shown");

		} else if (StatusOfFacility == "WL") {
			Assert.assertEquals(StatusOfFacility, "WL");
			listeners.addLog("TC_049", "Facility status shown");

		}
		String StatusOfSecondFacility = WebCtrls
				.GetTextWithTimeOut(bookingConfirmationPage.StatusOfSecondFacilitySelected);
		if (StatusOfSecondFacility == "CNF") {
			Assert.assertEquals(StatusOfFacility, "CNF");
			listeners.addLog("TC_049", "Facility status shown");

		} else if (StatusOfSecondFacility == "WL") {
			Assert.assertEquals(StatusOfFacility, "WL");
			listeners.addLog("TC_049", "Facility status shown");

		}
		Assert.assertTrue(
				WebCtrls.PerfectDisplayedWithTimeOut(bookingConfirmationPage.ViewCotDetailsUnderConfirmationpage),
				"Facilities are not added");
		listeners.addLog("TC_049", "Correct Facility Selected shown");

		WebCtrls.PerfectClick(bookingConfirmationPage.ViewDetailsButtonUnderConfirmationpage);
		WebCtrls.DeadWait(5000);
		String FinalCount = WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.FinalCountOnBookingConfirmationPage);
		int finalcnt = Integer.parseInt(FinalCount);
		String FinalCountofwaitlistonfirstfacility = WebCtrls
				.GetTextWithTimeOut(bookingConfirmationPage.FinalWaitlistCountOnBookingConfirmationPageOfFirstfacility);
		int finalcntofwaitlistonfirstfacility = Integer.parseInt(FinalCountofwaitlistonfirstfacility);

		String FinalCountOfSecondFacility = WebCtrls
				.GetTextWithTimeOut(bookingConfirmationPage.FinalCountOfSecondFacilityOnBookingConfirmationPage);
		int finalcntofsecondfacility = Integer.parseInt(FinalCountOfSecondFacility);
		String FinalWaitlistCountOfSecondFacility = WebCtrls.GetTextWithTimeOut(
				bookingConfirmationPage.FinalWaitlistCountOnBookingConfirmationPageOfSecondFacility);
		int finalwaitlistcntofsecondfacility = Integer.parseInt(FinalWaitlistCountOfSecondFacility);
		if (initialcnt > 0) {
			Assert.assertEquals(initialcnt - 1, finalcnt, "COUNT IS NOT VERIFIED");
			listeners.addLog("TC_049", "Facility count verified");

		} else if (initialcnt == 0) {
			Assert.assertEquals(initialcntonwaitlistUnderfirstfacility - 1, finalcntofwaitlistonfirstfacility,
					"COUNT IS NOT VERIFIED");
			listeners.addLog("TC_049", "Facility count verified");

		}

		if (initialcntofsecondfacility > 0) {
			Assert.assertEquals(initialcntofsecondfacility - 2, finalcntofsecondfacility, "COUNT IS NOT VERIFIED");
			listeners.addLog("TC_049", "Facility count verified");
		} else if (initialcntofsecondfacility == 0) {
			Assert.assertEquals(initialcntofsecondfacilitywaitlist - 2, finalwaitlistcntofsecondfacility,
					"COUNT IS NOT VERIFIED");
			listeners.addLog("TC_049", "Facility count verified");
		}
		WebCtrls.PerfectScroll(bookingConfirmationPage.CnfButtonForSecondPassenger);
		Assert.assertTrue(WebCtrls.Ctrl(bookingConfirmationPage.CnfButtonForSecondPassenger).isEnabled(),
				"Passenger not selected properly for first facility");
		listeners.addLog("TC_049", "Correct passenger status shown");

		WebCtrls.PerfectScroll(bookingConfirmationPage.CnfButtonForSecondfacility);
		Assert.assertTrue(WebCtrls.Ctrl(bookingConfirmationPage.CnfButtonForSecondfacility).isEnabled(),
				"Passenger not selected properly for second facility");
		listeners.addLog("TC_049", "Correct passenger status shown");

	}

//<summary>
/// Test Case Title : Verify whether a user should be able to book a cabin with a twin bed and add a cot as a facility from the Cabin selection page.(B2B)
/// Automation ID : 089
/// @Author : Lekshmi
/// </summary>
	@Test
	public void TC_089() {
		ExcelHelperMap = ExcelHelper.getExcelData();
		Listeners listeners = new Listeners();

		getDriver().get(ExcelHelperMap.get("URL"));

		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		SellingAppHomePage sellingAppHomePage = new SellingAppHomePage();
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
		assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab),
				"Selling App page is not Loaded");
		listeners.addLog("TC_089", "Seeling App page Loaded");

		WebCtrls.PerfectClick(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab);
		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab,
				ExcelHelperMap.get("CruiseId"));
		assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.DropdownListUnderCruiseTab),
				"Cruise Id list has not shown in Dropdown");
		listeners.addLog("TC_089", "Cruise Dropdown displayed");

		WebCtrls.PerfectEditWithTimeOut(newFITBookingPage.CruiseCodeInputAreaUnderCruiseTab,
				ExcelHelperMap.get("CruiseId"));
		assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(newFITBookingPage.DropdownListUnderCruiseTab),
				"Cruise Id list has not shown in Dropdown");

		WebCtrls.PerfectDropdownByText(newFITBookingPage.DropdownListUnderCruiseTab, ExcelHelperMap.get("CruiseId"));
		WebCtrls.PerfectClick(newFITBookingPage.ShowVoyagesButtonUnderCruiseTab);
		WebCtrls.PerfectClick(selectCabinPage.AutoAssignButtonOnCabinCategoryPage);
		WebCtrls.DeadWait(3000);
		WebCtrls.PerfectClick(selectCabinPage.SelectFacilityUnderCabinSelectionBox2);
		WebCtrls.PerfectClick(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox);
		WebCtrls.Ctrl(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox)
				.sendKeys(ExcelHelperMap.get("FirstFacility"));
		WebCtrls.PerfectSendKeys(selectCabinPage.SelectFacilityUnderCabinSelectionSearchBox, Keys.ENTER);
		WebCtrls.PerfectClick(selectCabinPage.SelectFacilityUnderCabinSelectionCheckBox);
		String InitialCount = WebCtrls.GetTextWithTimeOut(selectCabinPage.InitialCountOnSelectionCabin);
		int initialcnt = Integer.parseInt(InitialCount);
		String InitialCountofWaitlistFacility = WebCtrls
				.GetTextWithTimeOut(selectCabinPage.InitialWaitlistCountOnCabinSelectionPageForAutoAssign);
		int initialcntofwaitlistfacilityunderB2Blogin = Integer.parseInt(InitialCountofWaitlistFacility);
		WebCtrls.DeadWait(2000);
		WebCtrls.PerfectScroll(selectCabinPage.ProceedButtonOnCabinSelectionPage);
		WebCtrls.PerfectClick(selectCabinPage.ProceedButtonOnCabinSelectionPage);
		WebCtrls.PerfectEditWithTimeOut(selectCabinPage.LeadTravellerFirstNameField,
				ExcelHelperMap.get("LeadTraveller"));
		WebCtrls.PerfectClick(
				selectCabinPage.LeadTravellerFirstNameFieldSuggestionList(ExcelHelperMap.get("LeadTraveller")));
		WebCtrls.PerfectScroll(selectCabinPage.AssociatedTravellerFirstNameField);
		WebCtrls.PerfectEditWithTimeOut(selectCabinPage.AssociatedTravellerFirstNameField,
				ExcelHelperMap.get("AssociatedTraveller"));
		WebCtrls.PerfectClick(selectCabinPage
				.AssociatedTravellerFirstNameFieldSuggestionList(ExcelHelperMap.get("AssociatedTraveller")));
		WebCtrls.PerfectClick(selectCabinPage.ContinueButtonOnSelectPassengerPopup);
		WebCtrls.PerfectClick(selectCabinPage.ReviewCartButtonOnMiniCartSideMenu);
		WebCtrls.PerfectClick(bookingCartPage.TermsAndConditionCheckBoxOnCartPage);
		WebCtrls.PerfectClick(bookingCartPage.ProceedToBookingButton);
		WebCtrls.PerfectClick(bookingCartPage.ProceedToBookingButton);
		WebCtrls.PerfectScroll(passengerInformationPage.SaveAndContinueButton);
		WebCtrls.PerfectClick(passengerInformationPage.SaveAndContinueButton);
		assertTrue(WebCtrls.PerfectDisplayedWithTimeOut(paymentInformationPage.PaymentInformationPageHeader),
				"payment Information Page has not loaded");
		listeners.addLog("TC_089", "PaymentInformationPageLoaded");

		WebCtrls.PerfectClick(paymentInformationPage.CashPaymentTabOnThePaymentPage);
		String TotalAmount = WebCtrls.GetTextWithTimeOut(paymentInformationPage.TotalAmountOnPaymentForBookingArea)
				.replaceAll(",", "");
		WebCtrls.PerfectEditWithTimeOut(paymentInformationPage.AmountInputAreaOnCashTab,
				TotalAmount.replaceAll(",", ""));
		WebCtrls.PerfectScroll(paymentInformationPage.ProceedToBookingButton);
		WebCtrls.PerfectClick(paymentInformationPage.ProceedToBookingButton);
		WebCtrls.PerfectClick(paymentInformationPage.ConfirmButtonOnOverPaymentWarningPopup);
		Assert.assertTrue(
				WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.BookingConfirmationStatus).contains("CONFIRMED"),
				"Booking Id has not confimed");
		listeners.addLog("TC_089", "Booking Id has confirmed");

		WebCtrls.PerfectClick(bookingConfirmationPage.FacilityFieldUnderConfirmationpage);
		WebCtrls.DeadWait(1000);
		Assert.assertTrue(
				WebCtrls.PerfectDisplayedWithTimeOut(bookingConfirmationPage.ViewCotDetailsUnderConfirmationpage),
				"Infant Cot Facility is not added");
		listeners.addLog("TC_089", "Correct Facility Selected shown");

		WebCtrls.PerfectClick(bookingConfirmationPage.ViewDetailsButtonUnderConfirmationpage);
		WebCtrls.DeadWait(5000);
		String FinalCount = WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.FinalCountOnBookingConfirmationPage);
		int finalcnt = Integer.parseInt(FinalCount);
		String FinalCountonwaitlist = WebCtrls
				.GetTextWithTimeOut(bookingConfirmationPage.FinalWaitlistCountOnBookingConfirmationPageOfFirstfacility);
		int finalcntonwaitlistunderB2Bloading = Integer.parseInt(FinalCountonwaitlist);
		if (initialcnt > 0) {
			Assert.assertEquals(initialcnt - 1, finalcnt, "COUNT IS NOT VERIFIED");
			listeners.addLog("TC_047", "Facility count verified");

		} else {
			Assert.assertEquals(initialcntofwaitlistfacilityunderB2Blogin - 1, finalcntonwaitlistunderB2Bloading,
					"COUNT IS NOT VERIFIED");
			listeners.addLog("TC_047", "Facility count verified");

		}
		WebCtrls.PerfectScroll(bookingConfirmationPage.CnfButtonForSecondPassenger);
		Assert.assertTrue(WebCtrls.Ctrl(bookingConfirmationPage.CnfButtonForSecondPassenger).isEnabled(),
				"Passenger not selected properly");
		listeners.addLog("TC_089", "Correct passenger status shown");

		String StatusOfFacility = WebCtrls.GetTextWithTimeOut(bookingConfirmationPage.StatusOfFacilitySelected);
		if (StatusOfFacility == "CNF") {
			Assert.assertEquals(StatusOfFacility, "CNF");
			listeners.addLog("TC_089", "Facility status shown");

		} else if (StatusOfFacility == "WL") {
			Assert.assertEquals(StatusOfFacility, "WL");
			listeners.addLog("TC_089", "Facility status shown");

		}

	}
}
