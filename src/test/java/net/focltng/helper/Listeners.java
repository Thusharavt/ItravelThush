package net.focltng.helper;

import java.io.File;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {

	private String pathFail;
	private String pathPass;
	private static boolean skip;
		
	ExtentTest report;
	ExtentReports extent=ResultHelper.getReportObject();
	
	
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	
	

	@Override
	public void onTestStart(ITestResult result) {
			
		if(checkIfFolderExists(LocationsHelper.getLocationTestOutputFolder()))
		{
			if(!skip) {
			File newDirName = new File(LocationsHelper.getLocationTestOutputFolder().replace("reports", "") + "/Backup" + GenerateRandomHelper.GenerateRandomStringWithDateTime());
			File dir = new File(LocationsHelper.getLocationTestOutputFolder());
			 dir.renameTo(newDirName);
			 skip = true;
			}
		}
		else
		{
			skip = true;
		}
		    
		report= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(report);					
	}

	@Override
	public void onTestSuccess(ITestResult result) {
			
		pathPass = ScreenshotHelper.TakeScreenShot();
		
		extentTest.get().log(Status.PASS, "Test Passed");	
		
		// Comment this if pass not required
		
		extentTest.get().addScreenCaptureFromPath(pathPass, result.getMethod().getMethodName());
		
		
		
		if(checkIfFolderExists(LocationsHelper.getLocationScreenShots() + "/" + result.getMethod().getMethodName()))
		{
			Iterator it = FileUtils.iterateFiles(new File(LocationsHelper.getLocationScreenShots() + "/" + result.getMethod().getMethodName()), null, false);
	        while(it.hasNext()){
	        	
	        	String FileName = ((File) it.next()).getName();
	        	String dec = FileName.replace(result.getMethod().getMethodName(), "").replace(".jpg", "");
	        	String path = LocationsHelper.getLocationScreenShots() + "/" + result.getMethod().getMethodName() + "/" + FileName;
	        	extentTest.get().addScreenCaptureFromPath(path, dec);	            
	        }
		}
		
		///-----------
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		pathFail = ScreenshotHelper.TakeScreenShot();
		
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());		
		extentTest.get().addScreenCaptureFromPath(pathFail, result.getMethod().getMethodName());
		
		if(checkIfFolderExists(LocationsHelper.getLocationScreenShots() + "/" + result.getMethod().getMethodName()))
		{
			Iterator it = FileUtils.iterateFiles(new File(LocationsHelper.getLocationScreenShots() + "/" + result.getMethod().getMethodName()), null, false);
	        while(it.hasNext()){
	        	
	        	String FileName = ((File) it.next()).getName();
	        	String dec = FileName.replace(result.getMethod().getMethodName(), "").replace(".jpg", "");
	        	String path = LocationsHelper.getLocationScreenShots() + "/" + result.getMethod().getMethodName() + "/" + FileName;
	        	extentTest.get().addScreenCaptureFromPath(path, dec);	            
	        }
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	
	
	
	
	public void addLog(String TestCase, String Log)
	{
		pathPass = ScreenshotHelper.TakeScreenShot(TestCase + "/" + Log);
				
	}
	
	public static boolean checkIfFolderExists(String folderName) {

		boolean found = false;
		
		try {
			File file = new File(folderName);
			if (file.exists() && file.isDirectory()) {
				found = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return found;
	}


	

}
