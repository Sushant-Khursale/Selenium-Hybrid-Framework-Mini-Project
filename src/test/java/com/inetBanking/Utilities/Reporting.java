package com.inetBanking.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter  //Listener class, check in depth 
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger ;
	
	
	public void onStart(ITestContext testContext) 
	{		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YY.hh.mm");
		String timestamp = sdf.format(new Date());
		String fileName = "TestReport_"+timestamp+".html";
		
	
//		htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter = new ExtentHtmlReporter("TestReport31.html");
		String filegenpath = htmlReporter.getFilePath();
		System.out.println(filegenpath);
	
		
		//System.out.println(System.getProperty("user.dir"));
		
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Created By", "Sushant K");
		
		
		htmlReporter.config().setDocumentTitle("InetBanking Demo Project Test Report");
		htmlReporter.config().setReportName("InetBanking Functional Test Cases");
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	
	public void onTestSuccess(ITestResult tr) {
		System.out.println("Inside Listener Test Success Block: "+tr.getName());
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		logger.assignAuthor("Sushant K");
		
	}
	
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		logger.log(Status.FAIL, tr.getThrowable()); //check after failure
		
		String screenShotPath = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		File f = new File(screenShotPath);
		
		if(f.exists()) {
			try {
				logger.fail("Screenshot is here: "+logger.addScreenCaptureFromPath(screenShotPath));
			}
			catch(IOException e) {
				System.out.println("IOException: "+e);
			}
		}
		
	}
	
	public void onTestSkip(ITestResult tr) {
		logger= extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.BROWN));
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
		
}
