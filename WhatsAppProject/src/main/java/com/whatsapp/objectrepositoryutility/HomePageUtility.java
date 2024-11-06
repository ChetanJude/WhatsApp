package com.whatsapp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageUtility {
	
	@FindAll({@FindBy(xpath = "(//*[local-name()='svg']/*[name()='title'])[6]"), @FindBy(xpath = "//*[local-name()='svg']/*[name()='path']")})
	private WebElement newchat;
	
	public HomePageUtility(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewchat() {
		return newchat;
	}

	public void setNewchat(WebElement newchat) {
		this.newchat = newchat;
	}
	
	

}
