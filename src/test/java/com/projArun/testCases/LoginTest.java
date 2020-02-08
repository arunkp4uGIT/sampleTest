package com.projArun.testCases;

import java.io.IOException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.projArun.base.TestBase;

public class LoginTest extends TestBase {

	@Test(dataProvider = "fromCityData")
	public void enterfromCity(String fromCity) throws IOException, InterruptedException {
		setUp();
//		WebElement we = wait.until(new Function<WebDriver, WebElement>() {
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.xpath(OR.getProperty("from_xpath")));
//			}
//		});
		driver.findElement(By.xpath(OR.getProperty("from_xpath"))).click();
		
		WebElement s=driver.findElement(By.xpath("//div[contains(@id,'originStation1')]"));
		WebElement t=driver.findElement(By.xpath(OR.getProperty("from_xpath")));
				
		//we.click();
		clickEnabled(s, t);
		
		log.debug("from city clicked");

		String frmCty = OR.getProperty("fromCity_xpath") + "'" + fromCity + "'])";
		System.out.println(frmCty);
		

		driver.findElement(By.xpath(frmCty)).click();
		log.debug("from city entered");
		// Thread.sleep(3000);
		// String toCty = OR.getProperty("toCity_xpath") + "'" + toCity + "'])[2]";
		// tearDown();

	}

	@DataProvider(name = "fromCityData")
	public Object[][] dataCity() {
		return new Object[][] { { "Ahmedabad (AMD)" }, { "Amritsar (ATQ)" } };

	}

	@Test(dataProvider = "toCityData")
	public void entertoCity(String toCity) throws IOException, InterruptedException {

		driver.findElement(By.xpath(OR.getProperty("to_xpath"))).click();
		log.info("To city clicked");

		String toCty = "(" + OR.getProperty("toCity_xpath") + "'" + toCity + "'])[2]";
		System.out.println(toCty);

		driver.findElement(By.xpath(toCty)).click();
		// driver.findElement(By.xpath(OR.getProperty("to_xpath"))).sendKeys(Keys.TAB);

		log.info("To city entered");
		Thread.sleep(3000);

	}

	@DataProvider(name = "toCityData")
	public Object[][] dataCity2() {
		return new Object[][] { { "Dehradun (DED)" }, { "Hyderabad (HYD)" } };

	}

}
