package com.bd.test.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bd.test.base.TestBase;
import com.bd.test.pagefactory.PurchasePage;
import com.bd.test.pagefactory.ReservePage;
import com.bd.test.pagefactory.WelcomePage;
import com.bd.test.utils.TestUtils;

public class PurchasePageTest extends TestBase{
	public PurchasePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public WelcomePage wcpage;
	public ReservePage respage;
	public PurchasePage purchasepage;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		wcpage = new WelcomePage();
		respage = wcpage.chooseDepartureDestinationCity();
		purchasepage = respage.chooseFlight();
	}
	
	@Test
	public void TitleTest() {
		String str = TestUtils.validatePageTitle();
		Assert.assertEquals(str, "BlazeDemo Purchase");
	}
	
	@Test
	public void purchaseFlight() throws IOException
	{
		purchasepage.enterPassengerDetails();
	}

	@AfterMethod
	public void QuitBrowser() {
	driver.quit();

	}

}
