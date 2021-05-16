package com.Mytest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BasetTest{
	
	@Test
	public void verifylogin()
	{
		logger2=extent.startTest("Login Page Verification");
		page.getInstance(LoginPage.class).doLogin();
		logger2.log(LogStatus.PASS, "Login scenario Passed");
		System.out.println("Invalid login succes");
		page.getInstance(LoginPage.class).doLogin("sri120@gmail.com", "Test12345");
		logger2.log(LogStatus.PASS, "Valid Login scenario Passed");
		System.out.println("Login success");
		String title=page.getInstance(LoginPage.class).gettitle();
		logger2.log(LogStatus.PASS, "Login Page title Verified");
		Assert.assertEquals(title,"MY ACCOUNT");
	}

}
