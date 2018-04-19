package com.weightwatchers.test;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class WebsiteElements {
	
	WebDriver driver;
	JavascriptExecutor jse;
	
	public WebsiteElements(WebDriver driver1) {
		this.driver = driver1;
	}
	
	
	//verifying loaded page title matches the expected string
	@Test
	public void verifyPageTitle() {
			String actualTitle = driver.getTitle();
			String expectedTitle = "Weight Loss Program, Recipes & Help | Weight Watchers";
			Assert.assertEquals(expectedTitle, actualTitle);
			System.out.println("Both titles matched!");	
		
	}
	
	//verifying loaded page title matches the expected string
	public void findAMeeting() {
			driver.findElement(By.className("find-a-meeting")).click();
			String actualTitle = driver.getTitle();
			Assert.assertTrue(actualTitle.contains("Get Schedules & Times Near You"));
			System.out.println("Title contains : Get Schedules & Times Near You!");
	}
	
	//search for meetings and printing the first search result name and distance
	public void searchForMeetings(String searchZipCode) {
			driver.findElement(By.id("meetingSearch")).sendKeys(searchZipCode);
			//Thread.sleep(3000);		
			driver.findElement(By.className("input-group-btn")).click();
			
			List<WebElement> titleOfFirstSearchResult = driver.findElements(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ui-view[1]/ui-view[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/result-location[1]/div[1]/div[1]/a[1]/location-address[1]/div[1]/div[1]/div[1]/div[1]/span[1]"));
			
			List<WebElement> distanceOfFirstSearch = driver.findElements(By.xpath("//div[@class='location__distance'][contains(text(),'0.49 mi.')]"));
			
			for(WebElement first : titleOfFirstSearchResult) {
				System.out.println("Title of first search result : "+ first.getText());
			}
			for(WebElement distance : distanceOfFirstSearch) {
				System.out.println("Distance of first search result : " + distance.getText());
			}						
	
	}
	
	//verifying displayed name matches the result
	public void verfiyDisplayedLocationName() {
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ui-view[1]/ui-view[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/result-location[1]/div[1]/div[1]/a[1]/location-address[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).click();
			
			String displayedLocationName = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ui-view[1]/ui-view[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/location-address[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).getText();
			
			String titleOfFirstSearchResult = "WEIGHT WATCHERS STORE 23RD ST-5TH AVE";
			
			if(titleOfFirstSearchResult.equals(displayedLocationName)) {
				System.out.println("Verification successful: Correct title displayed on webpage");
			}
			
			else {
				System.out.println("Verification unsuccessful : Incorrect title display ");
			}
			
	}
	
	//Displaying the today's hours of operation
	public void printingHoursOfOperation() {
			jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0,1000)");
			List<WebElement> currentHours = driver.findElements(By.xpath("//div[@class='hours-list-item-wrapper hours-list--currentday']"));
			for(WebElement hours: currentHours) {
				System.out.println("Today's hours : "+ hours.getText());
			}
	}
	

}
