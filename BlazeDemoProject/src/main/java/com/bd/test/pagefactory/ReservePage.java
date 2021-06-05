package com.bd.test.pagefactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bd.test.base.TestBase;

public class ReservePage extends TestBase {
	
	@FindBy(xpath = "//table[@class = 'table']//th[4]")
	WebElement depart;
	
	@FindBy(xpath = "//table[@class = 'table']//th[5]")
	WebElement arriv;
	
	@FindBy(xpath = "//tbody//tr[2]//input[@type = 'submit']")
	WebElement flightbutton;
	
	@FindBy(xpath ="//tbody//tr[2]//td[2]")
	WebElement flightnum;
	
	@FindBy(xpath ="//tbody//tr[2]//td[3]")
	WebElement airline;
	
	@FindBy(xpath ="//tbody//tr[2]//td[4]")
	WebElement flightdepartstiming;
	
	@FindBy(xpath ="//tbody//tr[2]//td[5]")
	WebElement flightarrivestiming;
	
	@FindBy(xpath ="//tbody//tr[2]//td[6]")
	WebElement flightprice;
	
	public ReservePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

//Actions
	
	public String verifyDepartsCity()
	{
		
		return depart.getText();
	}
	
	public String verifyArrivesCity()
	{
		return arriv.getText();
	}
	
	public PurchasePage chooseFlight() throws IOException
	{
		flightbutton.click();
		return new PurchasePage();
	}

	

}
