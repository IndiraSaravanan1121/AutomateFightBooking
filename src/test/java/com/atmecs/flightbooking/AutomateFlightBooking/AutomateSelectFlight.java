package com.atmecs.flightbooking.AutomateFlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AutomateSelectFlight extends FlightBooking {
	
	@Test
	public void AutomateSelectFlight() {
	driver.findElement(By.name(pro1.getProperty("loc_passfirstname1_txt")))
	.sendKeys(pro2.getProperty("passFirst0"));
driver.findElement(By.name(pro1.getProperty("loc_passlastname1_txt"))).sendKeys(pro2.getProperty("passLast0"));

WebElement preference1 = driver.findElement(By.name("pass.0.meal"));
Select pref1 = new Select(preference1);
pref1.selectByValue("HNML");

driver.findElement(By.name(pro1.getProperty("loc_passfirstname2_txt")))
	.sendKeys(pro2.getProperty("passFirst1"));
driver.findElement(By.name(pro1.getProperty("loc_passlastname2_txt"))).sendKeys(pro2.getProperty("passLast1"));

WebElement preference2 = driver.findElement(By.name("pass.1.meal"));
Select pref2 = new Select(preference2);
pref2.selectByValue("HNML");

WebElement cardType = driver.findElement(By.name("creditCard"));
Select card = new Select(cardType);
card.selectByIndex(2);

driver.findElement(By.name(pro1.getProperty("loc_creditcardno_txt")))
	.sendKeys(pro2.getProperty("creditnumber"));

WebElement expDate = driver.findElement(By.name("cc_exp_dt_mn"));
Select expdate = new Select(expDate);
expdate.selectByIndex(2);

WebElement expYear = driver.findElement(By.name("cc_exp_dt_yr"));
Select expyear = new Select(expYear);
expyear.selectByIndex(7);

driver.findElement(By.name("ticketLess")).click();
driver.findElement(By.name("buyFlights")).click();

}

}
