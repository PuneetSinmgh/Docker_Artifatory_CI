package com.sample.mvc.seleniumTests;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EmployeeEditSeleniumTest {
  private WebDriver driver;
  private String baseUrl;
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
   
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEdit() throws Exception {
 
    driver.get("http://localhost:5050/EmployeeApplicationSprint4-1.0-SNAPSHOT/");
	
	driver.findElement(By.linkText("List Employees")).click();
	
	driver.findElement(By.linkText("edit")).click();

	driver.findElement(By.name("name")).clear();
	driver.findElement(By.name("name")).sendKeys("pushpendraDEWANGAN");
	driver.findElement(By.id("EditEmployee")).click();
	
	driver.findElement(By.linkText("Back to Main")).click();
	
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
   
  }

 
}

 