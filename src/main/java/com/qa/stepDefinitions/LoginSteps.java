package com.qa.stepDefinitions;

import java.io.IOException;

import com.qa.pages.AtlasAdminPage;
import com.qa.util.TestBase;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginSteps extends TestBase{

	AtlasAdminPage atlas;
	public LoginSteps() throws IOException {
		super();
	}
	
	@Before
	public void setUp()
	{
		initialization();
	}
	
	@After
	public void tearDown()
	{
		driver.close();
	}
	@Given("^user is on Atlas login screen\\.$")
	public void user_is_on_Atlas_login_screen() throws Throwable {
	    driver.get(prop.getProperty("url"));
	}

	@When("^user verifies page title$")
	public void user_verifies_page_title() throws Throwable {
		atlas= new AtlasAdminPage();
	    String actualTitle=atlas.getPageTitle();
	    Assert.assertEquals("Atlas - Service Provider Console", actualTitle);
	    System.out.println("Page Title is "+actualTitle);
	}

	@When("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		Thread.sleep(5000);
	   atlas.atlas_login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Then("^verify user is on homepage$")
	public void verify_user_is_on_homepage() throws Throwable {
		Thread.sleep(5000);
		String title1=atlas.verifyHomePage.getText();
	   Assert.assertEquals("Atlas", title1);
	}

}
