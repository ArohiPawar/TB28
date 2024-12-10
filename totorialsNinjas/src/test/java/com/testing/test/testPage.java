package com.testing.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.pages.loginPage;
import com.testing.pages.registerPage;



public class testPage {
	WebDriver driver;
	
	@BeforeSuite
	public void  openBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Documents\\Jar Files\\131\\chromedriver-win64\\chromedriver.exe");
		 driver=new ChromeDriver();
		
	}
	@BeforeTest
	public void enterUrl() {
		driver.get("https://tutorialsninja.com/demo/");
	}
	@BeforeClass
	public void HandleWindow() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void HandleCookies() {
		Set cookies=driver.manage().getCookies();
		int cookie=cookies.size();
		System.out.println(cookie);	
	}
	@Test(priority = 1)
	@Parameters({"fname","lname","email","phone","pass","cpass"})
	public void registerP(String fn,String ln,String em,String ph,String ps,String cps) throws InterruptedException {
		registerPage re=PageFactory.initElements(driver, registerPage.class);
		re.register(fn, ln, em, ph, ps, cps);
		System.out.println("register successfully");
	}
	
	
	@Test(priority = 2,dataProvider = "getData")
	public void loginTest(String em,String  ps) throws InterruptedException {
		loginPage l=PageFactory.initElements(driver, loginPage.class);
		l.login(em, ps);
		System.out.println("login successfully");
	}
	@AfterMethod
	public void captureScreen() throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("C:\\Users\\HP\\eclipse-workspace\\Testing\\seleniumProject\\img\\demoBlazewithPOM.png"));
		System.out.println("After Method");
	}
	@AfterClass
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
		System.out.println("After Class");
	}
	@AfterTest
	public void dbClose() {
		System.out.println("DB Closed");
		System.out.println("After Test");
	}
	@AfterSuite
	public void browserClose() {
		driver.close();
		System.out.println("After Suite");
	}
	@DataProvider
	public Object getData() {
		return new Object[][] {
			new  Object[] {"aarav22@gmail.com","12345678"}
					
			
		};
	}


}
