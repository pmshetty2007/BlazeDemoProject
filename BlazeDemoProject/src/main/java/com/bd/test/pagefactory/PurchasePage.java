package com.bd.test.pagefactory;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bd.test.base.TestBase;

public class PurchasePage extends TestBase {

	@FindBy(id = "inputName")
	WebElement paxName;
	
	@FindBy(id = "address")
	WebElement paxAddress;
	
	@FindBy(id = "city")
	WebElement paxCity;
	
	@FindBy(id = "state")
	WebElement paxState;
	
	@FindBy(id = "creditCardNumber")
	WebElement paxCCNumber;
			
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement purchaseFlights;
	
	@FindBy(xpath = "//div//p[5]//em")
	WebElement totalcost;
	
	
	public PurchasePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
//Actions
	
	
	public String getTotalCostPurchasePage() {
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]//p[5]//em")));
		System.out.println(totalcost.getText());
		return totalcost.getText();
		
	}
	
	public ConfirmationPage enterPassengerDetails() throws IOException
	{
		paxName.sendKeys(prop.getProperty("PaxName"));
		paxAddress.sendKeys(prop.getProperty("PaxAddress"));
		paxCity.sendKeys(prop.getProperty("PaxCity"));
		paxState.sendKeys(prop.getProperty("PaxState"));
		paxCCNumber.sendKeys(prop.getProperty("PaxCCNumber"));
		purchaseFlights.click();
		
		return new ConfirmationPage();
	}

}
