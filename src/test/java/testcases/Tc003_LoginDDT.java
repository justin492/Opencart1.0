package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage1;
import pageobjects.Loginpage;
import pageobjects.MyaccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class Tc003_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class, groups="Datadriven")
	public void verify_LoginDDT(String email, String password, String exp ) {
	logger.info("***Starting TC002_LoginTest***");
	//Homepage
	try 
	{
	Homepage1 hp=new Homepage1(driver);
	hp.clicklnkMyaccount();
	hp.clickLogin();
	Thread.sleep(5000);
	//Loginpage
	System.out.println(email);
	Loginpage lp=new Loginpage(driver);
	lp.setEmail(email);
	lp.setPassword(password);
	lp.clickLogin();
	//Myaccount page
	MyaccountPage macc=new MyaccountPage(driver);
	boolean targetPage=macc.isMyaccountPageExists();
	//System.out.println(exp);	
	/*Data is valid - login is success-test pass-logout
					login failed-test fail
	Data is invalid - login is success-test fail -logout
						login failed-test pass*/
	if(exp.equalsIgnoreCase("Valid")) 
	{
		System.out.println(exp);
	if(targetPage==true) 
	   {
		System.out.println(targetPage);
		macc.clickLogout();
		Assert.assertTrue(true);
	   }
	
	else 
	  {
		Assert.assertTrue(false);
	  }
	
	}
	
	if(exp.equalsIgnoreCase("Invalid"))
	{
		
		if(targetPage==true)
		{   
			macc.clickLogout();
			Assert.assertTrue(false);
		}
		
		else
		{
			Assert.assertTrue(true);	
		}
	}
	
	}catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("***Finished TC002_LoginTest***");
}
}
