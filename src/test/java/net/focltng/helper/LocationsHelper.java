package net.focltng.helper;

public class LocationsHelper {
	
	private static final String USER_DIR = System.getProperty("user.dir");
	private static final String locaionEdgeDriver = USER_DIR + "/src/test/resources/drivers/MicrosoftWebDriver.exe";
	private static final String locaionChromeDriver = USER_DIR + "/src/test/resources/drivers/chromedriver.exe";
	private static final String locationScreenShots = USER_DIR + "/test-output/reports/screenshots/";
	private static final String locationTestOutput = USER_DIR + "/test-output/reports/index.html";
	private static final String locationTestData = USER_DIR + "/src/test/resources/testdata/TestData.xlsx";
	private static final String locationTestOutputFolder = USER_DIR + "/test-output/reports";
		
	public static String getLocaionEdgeDriver() {
		return locaionEdgeDriver;
	}
	
	public static String getLocaionChromeDriver() {
		return locaionChromeDriver;
	}
	
	public static String getLocationScreenShots() {
		return locationScreenShots;
	}
	public static String getLocationTestOutput() {
		return locationTestOutput;
	}
	public static String getLocationTestData() {
		return locationTestData;
	}
	public static String getLocationTestOutputFolder() {
		return locationTestOutputFolder;
	}
}
