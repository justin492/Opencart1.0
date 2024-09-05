package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.ForgetPasswordpage;
import pageobjects.Homepage1;
import pageobjects.Loginpage;
import pageobjects.Logoutpage;
import pageobjects.MyaccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class Tc002_LoginTest extends BaseClass{
	Homepage1 hp;
	Loginpage lp;
	MyaccountPage macc;
	ForgetPasswordpage forgetpg;
	Logoutpage Logout;
	@Test(priority = 1,groups={"Sanity", "Master"},dataProvider="LoginData" , dataProviderClass=DataProviders.class)
	public void verify_login(String email, String password, String exp)
	{
		logger.info("***Starting TC002_LoginTest***");
		//Homepage
		try {
		hp=new Homepage1(driver);
		hp.clicklnkMyaccount();
		hp.clickLogin();
		//Loginpage
		logger.info("***Trying both valid and invalid credential***");
		lp=new Loginpage(driver);
		//Getting data from properties files
		//lp.setEmail(p.getProperty("email"));
		//lp.setPassword(p.getProperty("password"));
		//lp.clickLogin();
		
		//Getting data from DataProviders
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		String errormsg=lp.getwarningpop();
		//boolean targetLink=lp.getforgetLink();
		//Myaccount page
		macc=new MyaccountPage(driver);
		boolean targetPage=macc.isMyaccountPageExists();
		/*Data is valid - login is success-test pass-logout
		login failed-test fail
Data is invalid - login is success-test fail -logout
			login failed-test pass*/
		if(exp.equalsIgnoreCase("Valid")) 
		{
            System.out.println(targetPage);
			if(targetPage==true) 
			{
				logger.info("Log-in Sucessfull for valid...");
				macc.clickLogout();
				Assert.assertTrue(true);
			}

			else 
			{
				logger.info("Test failed...");
				Assert.assertTrue(false);
			}

		}

		if(errormsg.equals(" Warning: No match for E-Mail Address and/or Password.") || exp.equalsIgnoreCase("Invalid"))
		{
			
			if(targetPage==true)
			{   logger.error("Test failed");
				macc.clickLogout();
				Assert.assertTrue(false);
			}

			else
			{
				Assert.assertTrue(true);	
			}
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	
		
		
	
		
	}
	@Test(priority = 2 ,groups={"Sanity", "Master"})
	public void CheckForgotpasswordpage ()
	{
		logger.info("Validating forget password link...");
		//lp=new Loginpage(driver);
		System.out.println(driver);
		boolean targetLink=lp.getforgetLink();
		if(targetLink==true)
		{
			logger.info("Forgot link lanched");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Forget link failed");
			Assert.fail();
		}  
		logger.info("Validating expected Message...");
		forgetpg=new ForgetPasswordpage(driver);
		String confirmsg=forgetpg.getconfirmationmsg();
		if(confirmsg.equals("Forgot Your Password?"))
		{
			logger.info("Got expected Message...");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Not got exp Message Test failed");
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 3,groups={"Sanity", "Master"})
	public void validate_bykeyboardkeys() {
		logger.info("Validating_bykeyboardkeys...");
		hp.clicklnkMyaccount();
		hp.clickLogin();
		lp.tabToEmailField();
		lp.setEmail(p.getProperty("email"));
		lp.tabToPasswordField();
		lp.setPassword(p.getProperty("password"));
		lp.tabToLoginbutton();
		lp.clickLogin();
		boolean targetPage=macc.isMyaccountPageExists();
		if(targetPage==true)
		{
			logger.info("Validating_bykeyboardkeys are Successful...");
			Assert.assertTrue(true);
			macc.clickLogout();
			
		}
		else
		{
			Assert.fail();
		}
		
		
  }
	@Test(priority = 4,groups={"Sanity", "Master"})
	public void validate_byPlaceholdertext() {
	logger.info("Validating_byPlaceholdertext...");
	hp.clicklnkMyaccount();
	hp.clickLogin();
	
	String Emailvalue=lp.EmailPlaceholdertext();
	String Passwordvalue=lp.PasswordPlaceholdertext();
	if(Emailvalue.equals("E-Mail Address") & Passwordvalue.equals("Password") )
	{
		logger.info("Value Retrived successfull...");
		Assert.assertTrue(true);
	}
	else
	{
		logger.info("Value Retrived failed...");
		Assert.fail();
	}
	
	}
	@Test(priority = 5,groups={"Sanity", "Master"})
	public void validate_usingbrowserbackbutton_Login() throws InterruptedException 	
		{
		logger.info("validate_usingbrowserbackbutton_wheather User Staying login or not");
		hp.clicklnkMyaccount();
		hp.clickLogin();
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		Thread.sleep(1000);
		logger.info("Navigating back...");
		macc.navigateback();
		Thread.sleep(1000);
		logger.info("Navigating forward...");
		lp.navigateforward();
		boolean targetpage=macc.isMyaccountPageExists();
		if(targetpage==true)
		{
			logger.info("My account page exists");
			Assert.assertTrue(true);
			macc.clickLogout();
		}
		else
		{
			logger.info("Page Not exists Test failed");
			Assert.fail();
		}
		
		}
	
	@Test(priority = 6,groups={"Sanity", "Master"})
	public void validate_Logoutfunctionality() throws InterruptedException 	
		{
		logger.info("validate_Logoutfunctionality");
		hp.clicklnkMyaccount();
		hp.clickLogin();
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		macc.clicklnkMyaccount();
		macc.clickLogout();
		logger.info("Navigating back from Logoutpage...");
		Logout=new Logoutpage(driver);
		Thread.sleep(1000);
		Logout.navigateback();
		logger.info("Page is refreshing...");
		Thread.sleep(1000);
		macc.Pagerefresher();
		logger.info("Page refresh success...");
		String targetpage=lp.CheckLoginPage();
		if(targetpage.equals("Returning Customer"))
		{
			logger.info("Logout is Successfull");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Page Not exists Test failed");
			Assert.fail();
		}
		
		}
	@Test(priority = 7,groups={"Sanity", "Master"})
	public void validate_no_of_unsuccesfull_login()
	{
		logger.info("validate_no_of_unsuccesfull_login");
		hp.clicklnkMyaccount();
		hp.clickLogin();
		lp.setEmail(p.getProperty("email2"));
		lp.setPassword(p.getProperty("password2"));
		int loginattempts=0;
		String expmsg="Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
		while(true)
		{
			
			lp.clickLogin();
			String errormsg=lp.getwarningpop();
			loginattempts++;
			System.out.println("Attempt"+loginattempts+" : "+errormsg);
			if(errormsg.equals(expmsg) && loginattempts==6)
			{
				logger.info("validate_no_of_unsuccesfull_login is successfull");
				Assert.assertTrue(true);
				break;	
				}
			else if(errormsg.equals(expmsg) && loginattempts<6)
			{
				logger.info("validate_no_of_unsuccesfull_login is failed");
				
				Assert.fail();
				break;
			}
		
			
		
		}
	}
		@Test(priority = 8,groups={"Sanity", "Master"})
		public void Validate_PasswordFieldVisibility() {
			
			logger.info("validate_testPasswordFieldVisibility");
			//Homepage
			hp.clicklnkMyaccount();
			hp.clickLogin();
			//Loginpage
			lp.setEmail(p.getProperty("email2"));
			lp.setPassword(p.getProperty("password2"));
			String type=lp.testPasswordFieldVisibility();
			if(type.equals("password"))
			{
				logger.info("validate_testPasswordFieldVisibility is Successfull");
				Assert.assertTrue(true);	
			}
			else
			{
				logger.info("validate_testPasswordFieldVisibility is failed");
				Assert.fail();
			}
		
		}
		
		
		
	}
	
		
		
		
		
		
	

	
	
	
	
	
		

		
		
		
		

