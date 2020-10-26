package com.Mytest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Pages.Basepage;
import com.Pages.Page;
import com.Utils.Helper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasetTest {
	public static ExtentReports extent;
	WebDriver driver;
	Page page;
	public static ExtentTest logger2;
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setup(String browser)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--headless");
			driver=new ChromeDriver();
			
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		page=new Basepage(driver);
		
	
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result)throws IOException 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger2.log(LogStatus.FAIL, "Test Case Failed is"+result.getName());//to add name in extent report
			logger2.log(LogStatus.FAIL, "Test Case Failed is"+result.getThrowable());  //to add exception message in extent reports
			String path= Helper.captureScreenshot(driver, result.getName());
			logger2.log(LogStatus.FAIL,logger2.addScreenCapture(path)); //to add screenshot in extent reports
			
			
			
		}
		
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger2.log(LogStatus.SKIP, "Test Case Skipped"+result.getName());
		}
	
	
	   extent.endTest(logger2);
	   System.out.println("Quitting the browser");
		driver.quit();
	}
	@BeforeTest
	public void config ()
    {
		
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/AutomationResultsNew.html",true);
		extent.addSystemInfo("Organization", "ABC");
		extent.addSystemInfo("Browser", "CHROME");
		extent.addSystemInfo("Environemnt","QA");
		extent.addSystemInfo("user","Sri Sairam");
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		
			
    }

	@AfterTest
	 public void onFinish() {
		 
	     extent.flush();
	     extent.close();
	 }
	

}
