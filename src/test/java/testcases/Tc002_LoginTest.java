package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage1;
import pageobjects.Loginpage;
import pageobjects.MyaccountPage;
import testBase.BaseClass;

public class Tc002_LoginTest extends BaseClass{
	

	@Test(groups={"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("***Starting TC002_LoginTest***");
		//Homepage
		try {
		Homepage1 hp=new Homepage1(driver);
		hp.clicklnkMyaccount();
		hp.clickLogin();
		//Loginpage
		Loginpage lp=new Loginpage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		//Myaccount page
		MyaccountPage macc=new MyaccountPage(driver);
		boolean targetPage=macc.isMyaccountPageExists();
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Finished TC002_LoginTest***");
		
	}
}
