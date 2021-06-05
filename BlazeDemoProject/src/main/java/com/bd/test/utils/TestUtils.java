package com.bd.test.utils;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.bd.test.base.TestBase;

public class TestUtils extends TestBase {

	public TestUtils() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;
	
	
	public static void fn_Select(WebElement WE, String VisibleText){
		Select selObj=new Select(WE);
		selObj.selectByVisibleText(VisibleText);
		}
	
	public static String validatePageTitle() {
		return driver.getTitle();
	}
}


