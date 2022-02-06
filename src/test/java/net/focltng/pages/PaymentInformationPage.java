package net.focltng.pages;

import org.openqa.selenium.By;

public class PaymentInformationPage {

	public By TypeOfPaymentTabList = By.xpath("//a[contains(@ng-click,'selectFOP')]//span");

	public By TotalAmountOnPaymentForBookingArea = By.xpath("//label[contains(@sp-label,'totalAmount')]//following-sibling::span");

	public By AmountInputAreaOnCashTab = By.id("cashAmt");

	public By ProceedToBookingButton = By.xpath("//button[@sp-label='label.quote.ProceedToBooking']");

	public By ConfirmButtonOnOverPaymentWarningPopup = By.xpath("//button[contains(@ng-click,'confirmOverPayment')]");

	public By CashPaymentTabOnThePaymentPage = By.xpath("//a[contains(@ng-click,'selectFOP')]//span[text()='Cash']");

	public By PaymentInformationPageHeader = By.xpath("//h2[text()='Payment Information']");

	public By ChequeTabOnPaymentInformationPage = By.xpath("//span[text()='Cheque']");

	public By ChequeNumberFieldOnChequeTab = By.xpath("//input[@ng-model='chequeData.chequeNumber']");

	public By AmountInputAreaOnChequeTab = By.id("chequeAmtP1");

	public By AmountUnderMinimumAmountDue = By.xpath("//label[@sp-label=\"label.paymentWidget.minimumAmountDue\"]//..//span[@data-title=\"GBP\"]");

	public By PayerNameOnChequeTab = By.xpath("//input[@ng-required=\"chequeData.fopCodeAttributesVOs.PayerName\"]");

}
