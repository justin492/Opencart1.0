package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends Basepage1{
	
	JavascriptExecutor js;
	public MyaccountPage(WebDriver driver) {
		super(driver);
		this.js=(JavascriptExecutor)driver;
		
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") //Myaccount page heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") 
	WebElement lnkLogout;

	
	
	public boolean isMyaccountPageExists()
	{
	try
	{
		return (msgHeading.isDisplayed());
	}
	catch(Exception e)
	{
		return false;
	}
	
  }
	public void clicklnkMyaccount() {
		
		
		js.executeScript("arguments[0].click();",lnkMyaccount);
  }
	
	public void clickLogout()
	{
		js.executeScript("arguments[0].click();",lnkLogout);
		//lnkLogout.click();
	}
	
	public void navigateback()
	{
		driver.navigate().back();
		
	}
	
	public void Pagerefresher()
	{
		driver.navigate().refresh();
		
	}
}
