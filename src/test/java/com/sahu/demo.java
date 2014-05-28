package com.sahu;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
@Test
public class demo {

	WebDriver driver=null;
	@Test
	public void startTest()
	{
		URL hubUrl = null;
		try {
			hubUrl = new URL("http://localhost:4444/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.WINDOWS);
		WebDriver driver = new RemoteWebDriver(hubUrl, capabilities);
		driver.get("http://www.youtube.com");
		driver.findElement(By.xpath("//input[@id='masthead-search-term']")).sendKeys("selenium");
		
	}
	
	@AfterTest
	public void teardown()
	{
		if(driver!=null)
		driver.close();
	}
	
}
