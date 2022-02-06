package net.focltng.utils;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.focltng.pages.BaseTest;

public class WebCtrls extends BaseTest {

	// Find Element

	public static WebElement Ctrl(By by) {

		return getDriver().findElement(by);
	}

	// Send Keys with try catch
	private static boolean TrySendKeys(By by, String value) {

		try {
			Ctrl(by).clear();
			Ctrl(by).sendKeys(value);
			return true;
		} catch (Exception ex) {

			return false;
		}
	}

	// Text input
	public static void PerfectEditWithTimeOut(By by, String value) {
		boolean IsPerformed = false;
		int timeout = 0;

		while (timeout < 30 && !IsPerformed) {

			IsPerformed = WebCtrls.TrySendKeys(by, value);
			timeout++;
			try {
				if (!IsPerformed)
					Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Dropdown by Text
	public static void PerfectDropdownByText(By by, String value) {

		WaitForElement(by);
		List<WebElement> values = Ctrls(by);
		for (WebElement dropdownItem : values) {
			if (dropdownItem.getText().split("\\(")[0].equals(value)) {
				dropdownItem.click();
				break;
			}
		}
	}

	// Select by Text
	public static void PerfectSelectByText(By by, String value) {
		Select selectElement = new Select(Ctrl(by));
		selectElement.selectByVisibleText(value);
	}

	// Get Elements into List
	public static List<WebElement> Ctrls(By by) {
		return getDriver().findElements(by);
	}

	// Click
	public static void PerfectClick(By by) {
		boolean isPerformed = false;
		int i = 0;
		while (i < 30 && !isPerformed) {

			isPerformed = TryClick(by);
			i++;
			try {
				if (!isPerformed)
					Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Get Text with Timeout
	public static String GetTextWithTimeOut(By by) {
		String Text = null;
		int timeout = 1;

		while (timeout < 30 && (Text == null || Text.isEmpty())) {
			Text = GetText(by);
			if (Text == null || Text.isEmpty()) {
				DeadWait(2000);
				timeout++;
			}

		}

		return Text;
	}

	// Get Text
	public static String GetText(By by) {
		try {
			return Ctrl(by).getAttribute("innerText");
		} catch (Exception e) {
			return null;
		}

	}

	// Element isDisplayed
	public static boolean PerfectDisplayedWithTimeOut(By by) {
		boolean IsDisplayed = false;
		int timeout = 1;

		while (timeout < 30 && !IsDisplayed) {
			IsDisplayed = WebCtrls.TryDisplay(by);
			if (!IsDisplayed) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				timeout++;
			}

		}

		return IsDisplayed;
	}

	// Wait
	public static void DeadWait(long timeInMilliseconds) {
		long aCurrentTime = System.currentTimeMillis();
		boolean isTimeUp = true;
		while (isTimeUp) {
			if (aCurrentTime + timeInMilliseconds == System.currentTimeMillis()) {
				isTimeUp = false;
			}
		}
	}

	//Javascript Click
	public static void JavascriptClick(By by) {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", Ctrl(by));
	}

	//Text Input 
	public static void PerfectEdit(By by, String value) {
		Ctrl(by).clear();
		Ctrl(by).sendKeys(value);
	}
	
	// Send Keys
	public static void PerfectSendKeys(By by, Keys key) {
		WaitForElement(by);
		Ctrl(by).sendKeys(key);
	}

	//Mouse click
	public static void PerfectMouseClick(By by) {

		Actions action = new Actions(getDriver());
		action.moveToElement(getDriver().findElement(by)).click().build().perform();
	}

	//Wait for Element
	public static void WaitForElement(By by) {
		boolean isDisplayed = false;
		int i = 0;
		while (i < 10 && !isDisplayed) {
			isDisplayed = TryDisplay(by);
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Try Display
	public static boolean TryDisplay(By by) {
		try {
			Ctrl(by).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	//Try Click
	public static boolean TryClick(By by) {
		try {
			Ctrl(by).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//Switch to Last Window
	public static void SwithToLastWindow() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> tabs = new ArrayList<String>(BaseTest.getDriver().getWindowHandles());
		BaseTest.getDriver().switchTo().window(tabs.get(tabs.size() - 1));
	}

	// Close current window
	public static void CloseCurrentWindow() {

		BaseTest.getDriver().close();
	}

	//Scroll
	public static void PerfectScroll(By by) {
		WaitForElement(by);
		JavascriptExecutor js = (JavascriptExecutor) BaseTest.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", Ctrl(by));
	}
	
	
	public static void PerfectScrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) BaseTest.getDriver();
		js.executeScript("window.scrollBy(0,-500)", "");
	}

}
