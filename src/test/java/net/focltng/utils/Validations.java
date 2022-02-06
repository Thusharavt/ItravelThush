package net.focltng.utils;

import org.openqa.selenium.By;
import net.focltng.pages.BaseTest;

public class Validations extends BaseTest{
	
	public static boolean isItemDisplayed(By by)
	{	
		return WebCtrls.Ctrl(by).isDisplayed();		
	}

}
