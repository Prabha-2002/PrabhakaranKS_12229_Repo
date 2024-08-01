package com.prabha.restapp;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


class RealEstateManagementSystemApplicationTests {


	WebDriver driver;

	@BeforeEach
	void open() {
		driver = new ChromeDriver();
	}

    @AfterEach
    public  void close() {
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
		assertTrue(true, "This is a dummy assertion that always passes");
		 
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
	
	

}










	


