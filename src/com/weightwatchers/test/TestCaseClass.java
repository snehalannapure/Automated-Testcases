package com.weightwatchers.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCaseClass {
	WebDriver driver;
	
	public void  invokeWebsite() {
		
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.navigate().to("https://www.weightwatchers.com/us/");
			
			WebsiteElements web = new WebsiteElements(driver);
			web.verifyPageTitle();
			web.findAMeeting();
			web.searchForMeetings("10011");
			web.verfiyDisplayedLocationName();
			web.printingHoursOfOperation();
	}
	
	public void closeWebsite() {
			try {
				Thread.sleep(3000);
				driver.close();
				System.out.println("Test cases successfully executed!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	}
	
	public static void main(String[] args) {
			TestCaseClass test = new TestCaseClass();
			test.invokeWebsite();
			test.closeWebsite();
	}

}
