package net.focltng.pages;

import org.openqa.selenium.By;


public class CruiseSelectionPage {

	
	public By ProceedButtonOnTheCruiseSelectionPage = By.xpath("(//button[text()='PROCEED'])[1]");

	public By ContinueButtonOnTheAlertPopup = By.xpath("//button[@ng-click='navigateToCategoryScreen(detailsObj,selectedCruiseDataObj,selectedCruiseIndex)']");

}
