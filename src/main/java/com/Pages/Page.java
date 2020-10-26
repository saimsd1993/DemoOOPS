package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait Wait;
	
	public Page(WebDriver driver)
	{
		this.driver=driver;
		this.Wait=new WebDriverWait(driver,20);
		
	}
	//abstract methods
	
	public abstract String getPageurl();
	
	public abstract String getPageTitle(By locator);
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitforElementdisplay(By locator);
	
	
	public<Bpage extends Basepage> Bpage getInstance(Class<Bpage>pageClass) {
		try
		{
		return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
	

}
