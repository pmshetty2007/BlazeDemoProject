package com.bd.test.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bd.test.base.TestBase;
import com.bd.test.pagefactory.ConfirmationPage;
import com.bd.test.pagefactory.PurchasePage;
import com.bd.test.pagefactory.ReservePage;
import com.bd.test.pagefactory.WelcomePage;
import com.bd.test.utils.TestUtils;

public class ConfirmationPageTest extends TestBase {

	public WelcomePage wcpage;
	public ReservePage respage;
	public PurchasePage purchasepage;
	public ConfirmationPage confpage;

	public ConfirmationPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		wcpage = new WelcomePage();
		respage = wcpage.chooseDepartureDestinationCity();
		purchasepage = respage.chooseFlight();
		confpage = purchasepage.enterPassengerDetails();

	}

	@Test
	public void TitleTest() {
		String title = TestUtils.validatePageTitle();
		Assert.assertEquals(title, "BlazeDemo Confirmation");
	}

	@Test
	public void getConfirmationId() {
		String confid = confpage.getConfirmationId();
		System.out.println("Confirmation ID of your booking is:" + confid);
	}

	@Test
	public void verifyFinalAmountcollected() throws InterruptedException {
		String amountstr = confpage.getAmountConfirmationPage();
		System.out.println(amountstr);
		driver.navigate().back();
		Thread.sleep(5000);
		String cost = purchasepage.getTotalCostPurchasePage();
		Assert.assertTrue(amountstr.contains(cost));
		System.out.println(amountstr+ " " +cost);
	}

	@AfterMethod
	public void QuitBrowser() {
		driver.quit();

	}
}
