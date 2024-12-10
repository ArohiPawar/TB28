package com.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {

	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement account;
	
	
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
    WebElement logout;
    
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
    WebElement account2;
    
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    WebElement login;
    
    @FindBy(xpath = "//*[@id=\"input-email\"]")
    WebElement email;
    
    @FindBy(xpath = "//*[@id=\"input-password\"]")
    WebElement pass;
    
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
    WebElement btn;
    
    public loginPage(WebDriver driver) {
    	this.driver=driver;
    }
    
    public void login(String em,String ps) throws InterruptedException {
    	Thread.sleep(2000);
    	account.click();
    	Thread.sleep(2000);
    	logout.click();
    	Thread.sleep(2000);
    	account2.click();
    	Thread.sleep(2000);
    	login.click();
    	Thread.sleep(2000);
    	email.sendKeys(em);
    	pass.sendKeys(ps);
    	Thread.sleep(2000);
    	btn.click();
    	
    	
    }
}
