package net.focltng.helper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;

import net.focltng.pages.BaseTest;

public class ScreenshotHelper extends BaseTest
{
	
	public static String TakeScreenShot() {
		String screenshot = LocationsHelper.getLocationScreenShots() + GenerateRandomHelper.GenerateRandomStringWithDateTime()
				+ ".jpg";
		final TakesScreenshot takesscreenshot = ((TakesScreenshot) getDriver());
		File src = takesscreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(screenshot));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshot;
	}
	
	public static String TakeScreenShot(String location) {
		String screenshot = LocationsHelper.getLocationScreenShots() + "/" + location
				+ ".jpg";
		final TakesScreenshot takesscreenshot = ((TakesScreenshot) getDriver());
		File src = takesscreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(screenshot));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshot;
	}

}