package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public TestBase() throws IOException
	{
		String property=System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties";

		FileInputStream fis= new FileInputStream(property);
		prop= new Properties();
		prop.load(fis);
	}
	public void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			File f = new File("chromedriver.exe");
		    System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
		    System.out.println(f.getAbsolutePath());
			driver= new ChromeDriver();
			driver.manage().window().maximize();
		}
	}

}
