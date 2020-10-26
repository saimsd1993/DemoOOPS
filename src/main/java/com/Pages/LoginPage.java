package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Basepage{
	
	//Locators
	private By Signin = By.xpath("//a[contains(text(),'Sign in')]");
	private By Username= By.id("email");
	private By Password = By.id("passwd");
	private By Loginbutton = By.id("SubmitLogin");
	private By Pagetitle=By.xpath("//h1[contains(text(),'My account')]");

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	public WebElement getSignin() {
		return getElement(Signin);
	}

	public WebElement getUsername() {
		return getElement(Username);
	}

	public WebElement getPassword() {
		return getElement(Password);
	}

	public WebElement getLoginbutton() {
		return getElement(Loginbutton);
	}

	public WebElement getPagetitle() {
		return getElement(Pagetitle);
	}
	
	public LoginPage doLogin(String uname,String Pwd)
	{
		getSignin().click();
		getUsername().sendKeys(uname);
		getPassword().sendKeys(Pwd);
		getLoginbutton().click();
		return getInstance(LoginPage.class);
	}
	
	public LoginPage doLogin()
	{
		getSignin().click();
		getUsername().sendKeys("");
		getPassword().sendKeys("");
		getLoginbutton().click();
		return getInstance(LoginPage.class);
	}
	public String gettitle()
	{
		return getPagetitle().getText().trim();
	}
	
	//getters
	
	
	

}
