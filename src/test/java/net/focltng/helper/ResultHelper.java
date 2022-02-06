package net.focltng.helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ResultHelper {

	static ExtentReports extent;

	public static ExtentReports getReportObject() {

		String path = LocationsHelper.getLocationTestOutput();
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("POC - SE - Parallel");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "se - poc");
		return extent;

	}

}
