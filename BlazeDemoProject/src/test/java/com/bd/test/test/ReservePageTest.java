package com.bd.test.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bd.test.base.TestBase;
import com.bd.test.pagefactory.ReservePage;
import com.bd.test.pagefactory.WelcomePage;
import com.bd.test.utils.TestUtils;

public class ReservePageTest extends TestBase{
	
	public WelcomePage wcpage;
	public ReservePage respage;

	public ReservePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		wcpage = new WelcomePage();
		respage = wcpage.chooseDepartureDestinationCity();
	}

	
	public void TitleTest() {
		String str = TestUtils.validatePageTitle();
		Assert.assertEquals(str, "BlazeDemo - reserve");
	}

	
	@Test
	public void reserveFlight() throws IOException
	{
		respage.chooseFlight();
	}
	
	@Test
	public void verifyDepartCity()
	{
		String str = respage.verifyDepartsCity();
		Assert.assertTrue(str.contains(prop.getProperty("departurecity")));
	}
	
	@Test
	public void verifyArrivesCity()
	{
		String str1 = respage.verifyArrivesCity();
		Assert.assertTrue(str1.contains(prop.getProperty("destinationcity")));
	}

	@AfterMethod
	public void QuitBrowser() {
		driver.quit();

	}
	
	
}

	
	

