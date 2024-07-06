package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage1 extends Basepage1 {
	//WebDriver driver;
	JavascriptExecutor js;
	
	public Homepage1(WebDriver driver)
	{
		//this.driver=driver;
		super(driver);
		this.js=(JavascriptExecutor)driver;
		//PageFactory.initElements(driver,this);
		
}
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	public void clicklnkMyaccount() {
		
	
		js.executeScript("arguments[0].click();",lnkMyaccount);
  }
	public void clickRegister(){
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",lnkRegister);
		
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
}
