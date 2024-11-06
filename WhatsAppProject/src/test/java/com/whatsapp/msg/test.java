package com.whatsapp.msg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.whatsapp.objectrepositoryutility.HomePageUtility;

public class test {
	
	@Test
	public void test() throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://web.whatsapp.com/");
		
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(120));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[local-name()='svg']/*[name()='title'])[6]")));
		Thread.sleep(30);
		
		
		try {
		    WebElement element = driver.findElement(By.xpath("(//*[local-name()='svg']/*[name()='title'])[6]"));
		    element.click();
		} catch (StaleElementReferenceException e) {
		    WebElement element = driver.findElement(By.xpath("(//*[local-name()='svg']/*[name()='title'])[6]"));  // Re-locate the element
		    element.click();
		}
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		 * WebElement element =
		 * driver.findElement(By.xpath("(//*[local-name()='svg']/*[name()='title'])[6]")
		 * ); wait.until(ExpectedConditions.stalenessOf(element));
		 * 
		 * element.click();
		 */
		
		/*
		 * HomePageUtility hpu= new HomePageUtility(driver); WebElement svgElement =
		 * driver.findElement(By.xpath("(//*[local-name()='svg']/*[name()='title'])[6]")
		 * ); Actions a= new Actions(driver);
		 * a.moveToElement(svgElement).click().perform(); hpu.getNewchat().click();
		 */
		
		
		
		//JavascriptExecutor js= (JavascriptExecutor) driver;
		System.out.println("welcome to the whatsup");
		//WebElement svgElement = driver.findElement(By.xpath("(//*[local-name()='svg']/*[name()='title'])[6]"));
		//driver.findElement(By.xpath("//div[text()='Search name or number']")).sendKeys("812353789"+Keys.ENTER);
		//js.executeScript("arguments[0].click()", svgElement);
	}

}
