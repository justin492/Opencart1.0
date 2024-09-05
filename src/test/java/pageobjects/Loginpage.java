package pageobjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage1 {
	JavascriptExecutor js;
	Actions act;
	public Loginpage(WebDriver driver)
	{
		
		super(driver);
		this.js=(JavascriptExecutor)driver;
		act=new Actions(driver);
		//PageFactory.initElements(driver,this);
		
	}
	@FindBy (xpath = "//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy (xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy (xpath = "//input[@value='Login']")
	WebElement btnLogin;

	@FindBy (xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement warningpop;
	
	@FindBy (xpath = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	WebElement forgetLink;
	
	@FindBy (xpath = "//h2[normalize-space()='Returning Customer']")
	WebElement Returningcustomer;
	
	
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
	//js.executeScript("arguments[0].click();",btnLogin);
	btnLogin.click();
  }

//warning pop-up for invalid credential
public String getwarningpop()
{
	try {
	return (warningpop.getText());
	}
	catch (Exception e) {
	
		return (e.getMessage());	
	}
}
   //method for validate forgetlink and forgetpage
	public boolean getforgetLink()
	{   
		
		try {
			
			js.executeScript("arguments[0].click();",forgetLink);
			return true;
		}
		catch (Exception e) {
		
			return false;	
		}
	
	}
	//method to get the currently focused element
	public WebElement getFocusedElement()
	{
		return driver.switchTo().activeElement();
	}
	
	//method to tab until reaching the email field
	public void tabToEmailField() {
		while(true) {
			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			WebElement focusedElement=getFocusedElement();
			if(focusedElement.equals(txtEmailAddress))
			{
				break;
			}
			//Adding short delay to allow focus to switch
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
					}
		}
	
		//method to tab until reaching the password field
		public void tabToPasswordField() {
			while(true) {
				act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
				WebElement focusedElement=getFocusedElement();
				if(focusedElement.equals(txtPassword))
				{
					break;
				}
				try {
					Thread.sleep(100);
				}
				catch (InterruptedException e){
					e.printStackTrace();
				}
						}
	}
	
		//method to tab until reaching the Login button
				public void tabToLoginbutton() {
					while(true) {
						act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
						WebElement focusedElement=getFocusedElement();
						if(focusedElement.equals(btnLogin))
						{
							break;
						}
						try {
							Thread.sleep(100);
						}
						catch (InterruptedException e){
							e.printStackTrace();
						}
								}
			}
				//method to check placeholder text
				public String EmailPlaceholdertext() {
				try {
				String EMailholder=txtEmailAddress.getAttribute("placeholder");
				return EMailholder;
				
				
				}
				catch (Exception e){
					
					return (e.getMessage());
				}
				
				
			}
				//method to check placeholder text
				public String PasswordPlaceholdertext() {
					try {
					String Passwordholder=txtPassword.getAttribute("placeholder");
					return Passwordholder;
					
					
					}
					catch (Exception e){
						
						return (e.getMessage());
					}
					
					
				}
				
				
				public void navigateforward() throws InterruptedException
				{
					
					driver.navigate().forward();
					
				}
				
				//method to check LoginPage
				public String CheckLoginPage()
				{   
					
					try {
						
						return	Returningcustomer.getText();
						
					}
					catch (Exception e) {
					
						return (e.getMessage());	
					}
				}
				
				public String testPasswordFieldVisibility()
				{
					try {
					 // Verify the password field type is "password"
			      return txtPassword.getAttribute("type");
					}
					catch(Exception e)
					{
						return (e.getMessage());	
					}
				}
				
			}

				
	