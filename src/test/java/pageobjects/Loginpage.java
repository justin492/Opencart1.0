package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage1 {

	public Loginpage(WebDriver driver)
	{
		
		super(driver);
		//PageFactory.initElements(driver,this);
		
	}
	@FindBy (xpath = "//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy (xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy (xpath = "//button[normalize-space()='Login']")
	WebElement btnLogin;


public void setEmail(String email)
{
	txtEmailAddress.sendKeys(email);

  }

public void setPassword(String pwd)
{
	txtPassword.sendKeys(pwd);

  }
public void clickLogin()
{
	btnLogin.click();;

  }
}