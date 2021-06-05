package com.bd.test.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bd.test.base.TestBase;
import com.bd.test.pagefactory.WelcomePage;
import com.bd.test.utils.TestUtils;

public class WelcomePageTest extends TestBase {

	public WelcomePage wcpage;

	public WelcomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void SetUp() throws IOException {
		initialization();
		wcpage = new WelcomePage();
	}

	@Test
	public void TitleTest() {
		String str = TestUtils.validatePageTitle();
		Assert.assertEquals(str, "BlazeDemo");
	}

	@Test
	public void SelectCities() throws InterruptedException, IOException {
		wcpage.chooseDepartureDestinationCity();

	}

	@AfterMethod
	public void QuitBrowser() {
		driver.quit();

	}

}
