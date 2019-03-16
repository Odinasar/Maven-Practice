package com.dice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {

	
	
	
	public static void main(String[] args) {
		System.out.println("Test Started at - "+ LocalDateTime.now());
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://dice.com");
		String actualTitle="Find Jobs in Tech | Dice.com";
		String expectedTitle =driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Title verified");
		}else{
			System.out.println("Invalid title");

		}
		
		List<String> keywordlist=new ArrayList<>();
		keywordlist.add("SDET");
		keywordlist.add("Java Developer");
		keywordlist.add("automation engineer");
		keywordlist.add("manual tester");
		keywordlist.add("automation tester");
		keywordlist.add("ruby developer");
		keywordlist.add("javaScript");
		keywordlist.add("C developer");
		
		System.out.println(keywordlist.get(0));
		
		
		
		int	countResult=0;
		for (int i=0;i<keywordlist.size();i++ ) {
			
			driver.findElement(By.id("search-field-keyword")).sendKeys(keywordlist.get(i));
			driver.findElement(By.id("search-field-location")).clear();
			driver.findElement(By.id("search-field-location")).sendKeys("VA");
			driver.findElement(By.id("findTechJobs")).click();
			
			
			
			String titleAfterSearch =driver.getTitle();
			String count =driver.findElement(By.id("posiCountId")).getText();
			
			if(titleAfterSearch.contains(keywordlist.get(i))) {
				System.out.println(titleAfterSearch);
				System.out.println("Search result page is fully loaded and result number after search is displayed in the title");
			}else {
				System.out.println("result number after search is NOT displayed the title");
			}
			driver.navigate().back();
			
		}
		
		
		
	driver.close();
	
	System.out.println("Test complited - "+ LocalDateTime.now());

		
//		step 1. launch browser and navigate to https://dice.com
//			expected: dice home page should be displayed
//		step 2.	Insert search keyword and location then click find tech jobs
//			expected: -Search result page should be loaded.
//					  -page title should contain count of results,
//					  along with search keyword.
//					  -Count of results should be displayed on the page.
		
//		========================================================================
//		Steps to automate		
//		Make sure what functionality is being tested and each step. What is expected, what is being tested.
//		If dont undestand : ask manual tester/person who wrote it. BAs, Dev, Lead.
		
//		First test manually, make sure no bugs. if  it is passing manually,
//		than its qualify to automate. 
//		--> starts to automate:
//		Java + Selnium +Maven + Git> GitHub	

	}

}
