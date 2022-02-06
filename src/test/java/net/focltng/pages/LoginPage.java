package net.focltng.pages;

import org.openqa.selenium.By;

public class LoginPage {

	public By UserNameAreaOnLoginPage = By.id("username");
	
	public By PasswordAreaOnLoginPage = By.id("password");
		
	public By NextButtonOnLoginPage = By.xpath("//button[text()='Next']");
	
	public By LoginButtonOnLoginPage = By.xpath("//button[text()='Login']");
	
}
