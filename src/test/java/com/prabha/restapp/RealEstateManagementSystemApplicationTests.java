package com.prabha.restapp;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prabha.restapp.service.OwnerService;

class RealEstateManagementSystemApplicationTests {
	@Autowired
	private OwnerService impl;

	WebDriver driver;

	@BeforeEach
	void open() {
		driver = new ChromeDriver();
	}

	@AfterAll
	void close() {
		driver.quit();
	}

	@Test
	void testAddOwner1() {
		driver.get("http://localhost:3000/addowner");
		driver.findElement(By.id("name")).sendKeys("Kiran");
		driver.findElement(By.id("phone")).sendKeys("9876543678");
		driver.findElement(By.id("aadhaar")).sendKeys("9087656");
		driver.findElement(By.id("nooflands")).sendKeys("23");
		driver.findElement(By.id("submit")).submit();
		driver.navigate().to("http://localhost:3001/viewowner");
	}
	@Test
	void testAddOwner2() {
		driver.get("http://localhost:3000/addowner");
		driver.findElement(By.id("name")).sendKeys("");
		driver.findElement(By.id("phone")).sendKeys("25346567");
		driver.findElement(By.id("aadhaar")).sendKeys("5436879");
		driver.findElement(By.id("nooflands")).sendKeys("76");
		driver.findElement(By.id("submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		assertEquals("Enter the name ", txt);
	}

	@Test
	void testAddOwner3() {
		driver.get("http://localhost:3000/addowner");
		driver.findElement(By.id("name")).sendKeys("Kiran");
		driver.findElement(By.id("phone")).sendKeys("");
		driver.findElement(By.id("aadhaar")).sendKeys("5436879");
		driver.findElement(By.id("nooflands")).sendKeys("76");
		driver.findElement(By.id("submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		assertEquals("Enter the correct format of phone", txt);
	}

	@Test
	void testAddOwner4() {
		driver.get("http://localhost:3000/addowner");
		driver.findElement(By.id("name")).sendKeys("Kiran");
		driver.findElement(By.id("phone")).sendKeys("25346567");
		driver.findElement(By.id("aadhaar")).sendKeys("");
		driver.findElement(By.id("nooflands")).sendKeys("76");
		driver.findElement(By.id("submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		assertEquals("Enter the correct format of aadhaar", txt);
	}

	@Test
	void testAddOwner5() {
		driver.get("http://localhost:3000/addowner");
		driver.findElement(By.id("name")).sendKeys("Kiran");
		driver.findElement(By.id("phone")).sendKeys("25346567");
		driver.findElement(By.id("aadhaar")).sendKeys("5436879");
		driver.findElement(By.id("nooflands")).sendKeys("");
		driver.findElement(By.id("submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		assertEquals("Enter the number of lands", txt);
	}

	@Test
	void testAddOwner6() {
		driver.get("http://localhost:3000/addowner");
		driver.findElement(By.id("name")).sendKeys("");
		driver.findElement(By.id("phone")).sendKeys("");
		driver.findElement(By.id("aadhaar")).sendKeys("");
		driver.findElement(By.id("nooflands")).sendKeys("");
		driver.findElement(By.id("submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		assertEquals("Enter the name ", txt);
	}

	@Test
	void testUpdateOwner1() throws InterruptedException {
		driver.get("http://localhost:3001/editowner/1");
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Arun");
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys("34678973");
		driver.findElement(By.id("aadhaar")).clear();
		driver.findElement(By.id("aadhaar")).sendKeys("43568976");
		driver.findElement(By.id("nooflands")).clear();
		driver.findElement(By.id("nooflands")).sendKeys("82");
		driver.findElement(By.id("upd")).submit();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}
	@Test
	void testDeleteOwner() {
	 driver.get("http://localhost:3001/viewowner");
	    driver.findElement(By.cssSelector("tr:nth-child(1) .ms-1").id("delete")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		assertEquals("Do you want to delete the owner records?", txt);
}

	@Test
	void testAddLand1() {
		driver.get("http://localhost:3001/add");
		driver.findElement(By.id("landsqft")).sendKeys("574");
		driver.findElement(By.id("landaddress")).sendKeys("Plot no:156, kanaga nagar");
		driver.navigate().to("http://localhost:3001/view");
	}
	@Test
	void testAddLand2() {
		driver.get("http://localhost:3001/add");
		driver.findElement(By.id("landsqft")).sendKeys("");
		driver.findElement(By.id("landaddress")).sendKeys("");

		driver.findElement(By.id("add")).submit();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		assertEquals("Enter a valid land square feet", txt);//
	}
	@Test
	void testAddLand3() {
		driver.get("http://localhost:3001/add");
		driver.findElement(By.id("landsqft")).sendKeys("");
		driver.findElement(By.id("landaddress")).sendKeys("Plot no:572, ajl nagar");
		
		driver.findElement(By.id("add")).submit();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		assertEquals("Enter a valid land square feet", txt);
		
	}
	
	
	
	@Test
	void testAddLand4() {
		driver.get("http://localhost:3001/add");
		driver.findElement(By.id("landsqft")).sendKeys("564");
		driver.findElement(By.id("landaddress")).sendKeys("");
		
		driver.findElement(By.id("add")).submit();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		assertEquals("Enter the land address", txt);
		
	}
	
	
	@Test
	void testUpdateLand() {
		driver.get("http://localhost:3001/edit/2");
		driver.findElement(By.name("landsqft")).clear();
		driver.findElement(By.name("landsqft")).sendKeys("564");
		driver.findElement(By.name("landaddress")).clear();
		driver.findElement(By.name("landaddress")).sendKeys("Plot no:123, Kaih nagar");
		driver.findElement(By.id("upd")).submit();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		assertEquals("Land Details Updated Successfully !!!!", txt);
		
	}
	
	
	@Test
	void testDeleteLand() {
	 driver.get("http://localhost:3001/view");
	    driver.findElement(By.cssSelector("tr:nth-child(1)").id("delete")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		assertEquals("Do you want to delete the Land details?", txt);
}
}
	











	


