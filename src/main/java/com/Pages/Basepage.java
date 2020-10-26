package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Basepage extends Page{

	public Basepage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public String getPageurl() {
		
		return driver.getCurrentUrl();
	}

	@Override
	public String getPageTitle(By locator) {
		return getElement(locator).getText().trim();
		
		
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement ele=null;
		try
		{
			ele=driver.findElement(locator);
			return ele;
		}
		catch(Exception e) {
		System.out.println("Error in creating webelement"+locator.toString());
		e.printStackTrace();
		}
		return ele;
	}

	@Override
	public void waitforElementdisplay(By locator) {
		
		try
		{
			Wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e) {
			System.out.println("Exception occured"+locator.toString());
			e.printStackTrace();
		}
	}

}
