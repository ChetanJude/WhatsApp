package com.whatsapp.msg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.collections4.iterators.ObjectArrayIterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.whatsapp.objectrepositoryutility.HomePageUtility;

public class SendingMsgTest {
	
	@Test(dataProvider = "object")
	public void sendMsg(String number, String msg) throws Throwable {
		
		/* Fetching the current time using date class */
		Date dateobj = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
		String time = sdf.format(dateobj);
		
		/* Lunching the browser and entering the URL url */
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://web.whatsapp.com/");
		
		//driver.findElement(By.xpath("(//*[local-name()='svg']/*[name()='title'])[6]")).click();
		
		/* Created a POM class to handle staleelement reference exception as 44 stmt is not working */
		
		HomePageUtility hpu= new HomePageUtility(driver); 
		hpu.getNewchat().click();
		 
		/* Click on search box in new chat page and entering the number to search */
		WebElement search = driver.findElement(By.xpath("//div[text()='Search name or number']"));
		search.sendKeys(number);
		Thread.sleep(6);
		search.sendKeys(Keys.ENTER);
		
		/* Click on text box and entering the msg and sending to respective number */
		driver.findElement(By.xpath("//p[contains(@class,'selectable-text') and contains(@style,'text-indent:')]")).sendKeys(msg+Keys.ENTER);
	
	}
	
	/*Using Data provider annotation to execute the above code to with different
	 set of data*/
	
	@DataProvider
	public Object[][] object() throws Throwable{
		
		/*Fetching the data from excel sheet by providing the excel path*/
		
		FileInputStream fis= new FileInputStream("./Test_Data/WhatsappTesting.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int count = wb.getSheet("Sheet1").getLastRowNum();
			
		/* two-dimensional array to add the data and send to primary code */
		Object[][] obj= new Object[count][2];
		for (int i = 0; i <count; i++) {
		obj[0][0]= wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
		obj[0][1]= wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
		}
		return obj;
	} 

}
