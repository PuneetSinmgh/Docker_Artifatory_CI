package com.sample.mvc.seleniumTests;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EmployeeAddSeleniumTest {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//baseUrl = "http://172.27.59.18:8090/EmployeeApplication/jsp/add.jsp";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCheck() throws Exception {
		driver.get("http://localhost:5050/EmployeeApplicationSprint4-1.0-SNAPSHOT/");
				driver.findElement(By.id("AddEmployeeLink")).click();
		
		driver.findElement(By.name("code")).clear();
		driver.findElement(By.name("code")).sendKeys("534");
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("sudhanshu");
		driver.findElement(By.name("city")).clear();
		driver.findElement(By.name("city")).sendKeys("lucknow");
		driver.findElement(By.id("SubmitEmployee")).click();
		
		driver.findElement(By.linkText("Back to Main")).click();
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}

}
