package com.atmecs.flightbooking.AutomateFlightBooking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlightBooking {
	static WebDriver driver = null;
	static FileInputStream fis;
	static FileInputStream fis1;
	static FileInputStream fis2;
	Properties pro1 = new Properties();
	Properties pro2 = new Properties();

	@BeforeTest
	public void setup() throws Exception {

		fis = new FileInputStream(
				"C:\\Users\\indira.saravanan\\eclipse-workspace\\AutomateFlightBooking\\src\\main\\resources\\TestData\\config.properties");

		Properties obj = new Properties();
		obj.load(fis);
		String browserName1 = obj.getProperty("browserName");

		String url = obj.getProperty("url");

		switch (obj.getProperty("browserName1")) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\indira.saravanan\\eclipse-workspace\\AutomateFlightBooking\\lib\\chromedriver.exe");

			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\indira.saravanan\\eclipse-workspace\\AutomateFlightBooking\\lib\\geckodriver.exe");

			driver = new FirefoxDriver();

			break;

		case "IEdriver":
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\indira.saravanan\\eclipse-workspace\\AutomateFlightBooking\\lib\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();

			break;

		}
		driver.get(url);
	}

	@Test
	void AutomateLogin() throws Exception {
		fis1 = new FileInputStream(
				"C:\\Users\\indira.saravanan\\eclipse-workspace\\AutomateFlightBooking\\src\\main\\resources\\Locator\\locator.properties");

		pro1.load(fis1);

		fis2 = new FileInputStream(
				"C:\\Users\\indira.saravanan\\eclipse-workspace\\AutomateFlightBooking\\src\\main\\resources\\Locator\\data.properties");
		Properties pro2 = new Properties();
		pro2.load(fis2);

		driver.findElement(By.name(pro1.getProperty("loc_username_txt"))).sendKeys(pro2.getProperty("userName"));
		driver.findElement(By.name(pro1.getProperty("loc_password_txt"))).sendKeys(pro2.getProperty("password"));
		driver.findElement(By.name("login")).click();

		driver.findElement(By.name("tripType")).click();

		WebElement passengerCount = driver.findElement(By.name("passCount"));
		Select passCount = new Select(passengerCount);
		passCount.selectByIndex(1);

		WebElement departFrom = driver.findElement(By.name("fromPort"));
		Select depFrom = new Select(departFrom);
		depFrom.selectByValue("London");

		WebElement fromMonth = driver.findElement(By.name("fromMonth"));
		Select monthFrom = new Select(fromMonth);
		monthFrom.selectByIndex(10);

		WebElement fromDay = driver.findElement(By.name("fromDay"));
		Select dayFrom = new Select(fromDay);
		dayFrom.selectByIndex(28);

		WebElement arriveIn = driver.findElement(By.name("toPort"));
		Select arrIn = new Select(arriveIn);
		arrIn.selectByValue("Paris");

		WebElement toMonth = driver.findElement(By.name("toMonth"));
		Select monthTo = new Select(toMonth);
		monthTo.selectByIndex(0);

		WebElement toDay = driver.findElement(By.name("toDay"));
		Select dayTo = new Select(toDay);
		dayTo.selectByIndex(23);

		driver.findElement(By.xpath(pro1.getProperty("loc_service_btn"))).click();

		WebElement airline = driver.findElement(By.name("airline"));
		Select airLine = new Select(airline);
		airLine.selectByIndex(1);

		driver.findElement(By.name("findFlights")).click();

		driver.findElement(By.xpath(pro1.getProperty("loc_outflight_btn"))).click();

		driver.findElement(By.xpath(pro1.getProperty("loc_inflight_btn"))).click();

		driver.findElement(By.name("reserveFlights")).click();
	}

		
	/*
	 * 
	 * @Test void AutomateSelectFlight() {
	 * 
	 * 
	 * 
	 * driver.findElement(By.name(pro1.getProperty("loc_passfirstname1_txt")))
	 * .sendKeys(pro2.getProperty("passFirst0"));
	 * driver.findElement(By.name(pro1.getProperty("loc_passlastname1_txt"))).
	 * sendKeys(pro2.getProperty("passLast0"));
	 * 
	 * WebElement preference1 = driver.findElement(By.name("pass.0.meal")); Select
	 * pref1 = new Select(preference1); pref1.selectByValue("HNML");
	 * 
	 * driver.findElement(By.name(pro1.getProperty("loc_passfirstname2_txt")))
	 * .sendKeys(pro2.getProperty("passFirst1"));
	 * driver.findElement(By.name(pro1.getProperty("loc_passlastname2_txt"))).
	 * sendKeys(pro2.getProperty("passLast1"));
	 * 
	 * WebElement preference2 = driver.findElement(By.name("pass.1.meal")); Select
	 * pref2 = new Select(preference2); pref2.selectByValue("HNML");
	 * 
	 * WebElement cardType = driver.findElement(By.name("creditCard")); Select card
	 * = new Select(cardType); card.selectByIndex(2);
	 * 
	 * driver.findElement(By.name(pro1.getProperty("loc_creditcardno_txt")))
	 * .sendKeys(pro2.getProperty("creditnumber"));
	 * 
	 * WebElement expDate = driver.findElement(By.name("cc_exp_dt_mn")); Select
	 * expdate = new Select(expDate); expdate.selectByIndex(2);
	 * 
	 * WebElement expYear = driver.findElement(By.name("cc_exp_dt_yr")); Select
	 * expyear = new Select(expYear); expyear.selectByIndex(7);
	 * 
	 * driver.findElement(By.name("ticketLess")).click();
	 * driver.findElement(By.name("buyFlights")).click();
	 * 
	 * }
	 */
}