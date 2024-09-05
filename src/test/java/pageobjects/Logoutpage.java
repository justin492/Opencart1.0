package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Logoutpage extends Basepage1 {
	JavascriptExecutor js;
	Actions act;
	public Logoutpage(WebDriver driver) {
	super(driver);
	this.js=(JavascriptExecutor)driver;
	act=new Actions(driver);
	}

	public void navigateback()
	{
		driver.navigate().back();
		
	}
}
