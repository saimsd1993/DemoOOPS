package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Homepage extends Basepage{
	
	private By logo= By.id("header_logo");
	private By Category3 = By.xpath("(//div[@id='block_top_menu']/descendant::a[contains(text(),'T-shirts')])[2]");
    private By proname=By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]");
    private By Price=By.xpath("(//span[contains(@class,'price product-price')])[1]");
    private By Availability=By.xpath("//span[contains(@class,'available-now')]");
	
	private By Quickview=By.xpath("//div[@class='product-image-container']//a[@class='quick-view']");
	private By name2=By.xpath("//div[@class='pb-center-column col-xs-12 col-sm-4']//h1");
	private By quantity=By.id("quantity_wanted");
	private By AddtoCart=By.xpath("//button[@name='Submit']");
	private By Successmsg=By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']/h2");
	private By Continue=By.xpath("//span[@class='continue btn btn-default button exclusive-medium']");
	
	
	public Homepage(WebDriver driver) {
		super(driver);
		
		//locators
		
		
		
		
	}

	public WebElement getLogo() {
		return getElement(logo);
	}
	public WebElement getCategory3() {
		return getElement(Category3);
	}
	
	public WebElement getproname()
	{
		return getElement(proname);
	}
	
	public WebElement getproprice()
	{
		return getElement(Price);
	}
	
	public WebElement getstock()
	{
		return getElement(Availability);
	}
	
	public String plpNavigation()
	{
		getLogo().click();
		getCategory3().click();
		return driver.getTitle();
	}
   
   public void getProductdetails()
   {
	   Actions act =new Actions(driver);
	   act.moveToElement(getproname()).build().perform();
	   String name=getproname().getText();
	   System.out.println(name);
	   String price=getproprice().getText();
	   System.out.println(price);
	   String stock= getstock().getText();
	   System.out.println(stock);
   }

    public WebElement getQuickview() {
	return getElement(Quickview);
   }



public WebElement getName2() {
	return getElement(name2);
}


public WebElement getQuantity() {
	return getElement(quantity);
}


public WebElement getAddtoCart() {
	return getElement(AddtoCart);
}


public WebElement getSuccessmsg() {
	return getElement(Successmsg);
}

public WebElement getContinue() {
	return getElement(Continue);
}

   
   //pop up details

   public void clickQuickview()
   {
	   Actions act =new Actions(driver);
	   act.moveToElement(getQuickview()).perform();
	   act.moveToElement(getQuickview()).click().perform();
   }
   
   public boolean verifypname()
   {
	   getName2().isDisplayed();
	   return true;
   }
   public void enterquantity(String data)
   {
	   getQuantity().clear();
	   getQuantity().sendKeys(data);
   }
   
   public String clickAddtocart()
   {
	   getAddtoCart().click();
	   if(getSuccessmsg().isDisplayed())
	   {
		   System.out.println("Product added to cart and succcess message displayed");
		   getContinue().click();
	   }
	   
	   else
	   {
		   System.out.println("error occured");
	   }
	   return getSuccessmsg().getText();
	  
   }
   
   
   

}
