package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationpage1 extends Basepage1 {
	//public WebDriver driver;
	JavascriptExecutor js;
	public AccountRegistrationpage1(WebDriver driver)
	{
		
		super(driver);
		this.js=(JavascriptExecutor)driver;
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkpolicy;
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btncontinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;
	
	public void setfirstname(String fname)
	{
		txtFirstname.sendKeys(fname);	
	}
	public void setlastname(String lname)
	{
		txtLastname.sendKeys(lname);	
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);	
	}
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);	
	}
	public void setPrivacypolicy()
	{
	
		js.executeScript("arguments[0].click();",chkpolicy);
	}
	public void clickcontinue()
	{
		
		js.executeScript("arguments[0].click();",btncontinue);
	}
	public String getconfirmationmsg()
	{
		try {
		return (msgconfirmation.getText());
		}
		catch (Exception e) {
		
			return (e.getMessage());	
		}
	}

}
