package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPasswordpage extends Basepage1 {

	public ForgetPasswordpage(WebDriver driver)
	{
		
		super(driver);
		
		
	}
	@FindBy (xpath = "//h1[normalize-space()='Forgot Your Password?']")
	WebElement msgconfirmation;
	
	@FindBy (xpath = "//a[@class='list-group-item'][normalize-space()='Login']")
	WebElement lnkLogin;
	
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
