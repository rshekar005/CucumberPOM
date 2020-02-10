package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class AtlasAdminPage extends TestBase
{
	@FindBy(how=How.CSS, using="#userName")
	public  WebElement login;
	
	@FindBy(how=How.CSS, using="#password")
	public WebElement pass;
	
	@FindBy(how=How.XPATH, using="//*[text()='Log In']")
	public WebElement loginbutton;
	
	@FindBy(how=How.XPATH, using ="//h4[text()='Atlas']")
	public WebElement verifyHomePage;
	
	public AtlasAdminPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	

	public String getPageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public  void atlas_login(String username, String password) throws NullPointerException
	{
		login.sendKeys(username);
		pass.sendKeys(password);
		loginbutton.click();
	}
}
