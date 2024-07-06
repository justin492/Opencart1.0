package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationpage1;
import pageobjects.Homepage1;
import testBase.BaseClass;

public class Tc001_AccountRegistrationTest1 extends BaseClass {
	
	
		@Test(groups={"Regression", "Master"})
		public void verifyaccount() throws InterruptedException
		{
			
			logger.info("*** starting TA_001AccountRegistrationTest1 ****");
			try {
			Homepage1 hp=new Homepage1(driver);
			hp.clicklnkMyaccount();
			
			logger.info("Clicked on Myaccount link..");
			
			hp.clickRegister();
			logger.info("Clicked on Register link..");
			
			AccountRegistrationpage1 regpg=new AccountRegistrationpage1(driver);
			
			logger.info("Providing customer details...");
			
			regpg.setfirstname(randomstring().toUpperCase());
			
			regpg.setlastname(randomstring().toUpperCase());
			
			regpg.setEmail(randomstring()+"@gmail.com");
			
			regpg.setPassword(randomAlphaNumberic());
			
			regpg.setPrivacypolicy();
			
			regpg.clickcontinue();
			
			logger.info("Validating expected Message...");
			
			String confirmsg=regpg.getconfirmationmsg();
			if(confirmsg.equals("Your Account Has Been Created!"))
					{
						Assert.assertTrue(true);
					}
					else
					{
						logger.error("Test failed");
						Assert.assertTrue(false);
					}
					
			
			//Assert.assertEquals(confirmsg, "Your Account Has Been Created!");
			
			}
			catch(Exception e)
			{
				Assert.fail();
			}
			logger.info("****Finished TA_001AccountRegistrationTest1****");
		
		}
		
}
