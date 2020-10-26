package com.Mytest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.Homepage;
import com.relevantcodes.extentreports.LogStatus;


public class HomeTest extends BasetTest{
	
	@Test(priority=1)
	public void Verifyplpdetails()
	{
		logger2=extent.startTest("PLP Page Verification");
		page.getInstance(Homepage.class).plpNavigation();
		logger2.log(LogStatus.PASS,"PLP page navigation done");
		System.out.println("PLP page clicked");
		Assert.assertTrue(true,"Test Passed");
	}
	@Test(priority=2)
	public void VerifyPLP()
	{
		logger2=extent.startTest("Product details page Verification");
		page.getInstance(Homepage.class).plpNavigation();
		logger2.log(LogStatus.PASS,"PLP page navigation done");
		System.out.println("PLP page clicked");
		page.getInstance(Homepage.class).getProductdetails();
		logger2.log(LogStatus.PASS,"Product details Verified");
		Assert.assertTrue(true,"Test Passed");
	}
	
	@Test(enabled=false)
	public void getquickviewdetails()
	{
		logger2=extent.startTest("Product details page Verification");
		page.getInstance(Homepage.class).plpNavigation();
		System.out.println("PLP page clicked");
		page.getInstance(Homepage.class).clickQuickview();
		page.getInstance(Homepage.class).verifypname();
		System.out.println("Product name verified");
		page.getInstance(Homepage.class).enterquantity("2");
		page.getInstance(Homepage.class).clickAddtocart();
		Assert.assertTrue(true,"Test Passed");
	}

}
