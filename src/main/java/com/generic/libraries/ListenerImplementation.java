package com.generic.libraries;


import java.io.IOException;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	JavaUtils jLib=new JavaUtils();
	ExtentReports reports;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = reports.createTest(methodName);
		Reporter.log("Execution Started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" pass");
		Reporter.log(methodName+" executed succesfully");
	}

	@Override 
	public void onTestFailure(ITestResult result) {
		String screenShotName = result.getMethod().getMethodName();
		WebDriverUtils wLib=new WebDriverUtils();
		try {
			String path = wLib.getScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
			test.log(Status.FAIL,screenShotName+" Failed");
			test.log(Status.FAIL, result.getThrowable());
			Reporter.log(screenShotName+" failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL,methodName+" Failed");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(methodName+" failed");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		
		//configure
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\extent\\report"+jLib.getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("TYProject");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Banko_Oversight");
		
		reports= new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("BasePlatorm", "os");
		reports.setSystemInfo("BaseBrowser", "chrome");
		reports.setSystemInfo("BaseURL", "http://rmgtestingserver/domain/Online_Banking_System/");
		reports.setSystemInfo("ReporterName", "Pragathi");
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	
}
