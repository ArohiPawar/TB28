package com.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registerPage {
WebDriver driver;

@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
WebElement account;

@FindBy(linkText = "Register")
WebElement regClick;

@FindBy(xpath = "//*[@id=\"input-firstname\"]")
WebElement fname;

@FindBy(xpath = "//input[@id=\"input-lastname\"]")
WebElement lastnm;

@FindBy(xpath = "//input[@id=\"input-email\"]")
WebElement eml;


@FindBy(xpath = "//input[@id=\"input-telephone\"]")
WebElement phn;


@FindBy(xpath = "//input[@id=\"input-password\"]")
WebElement passw;

@FindBy(xpath = "//input[@id=\"input-confirm\"]")
WebElement cpassw;

@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
WebElement check;

@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
WebElement regs;

public registerPage(WebDriver driver) {
	this.driver=driver;
}

public void register(String fn,String ln,String em,String ph,String ps,String cps) throws InterruptedException {
	Thread.sleep(2000);
	account.click();
	Thread.sleep(2000);
	regClick.click();
	Thread.sleep(2000);
	fname.sendKeys(fn);
	lastnm.sendKeys(ln);
	Thread.sleep(2000);
	eml.sendKeys(em);
	Thread.sleep(2000);
	phn.sendKeys(ph);
	Thread.sleep(2000);
	passw.sendKeys(ps);
	Thread.sleep(2000);
	cpassw.sendKeys(cps);
	Thread.sleep(2000);
	check.click();
	Thread.sleep(2000);
	regs.click();
}
}
