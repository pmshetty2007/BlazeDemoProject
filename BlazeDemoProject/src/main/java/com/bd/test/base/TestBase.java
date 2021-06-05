package com.bd.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bd.test.utils.TestUtils;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public WebDriverWait wait;
	public Actions action;

	public TestBase() throws IOException {
		try {

			prop = new Properties();
			FileInputStream f = new FileInputStream(
					"C:\\Work_Amadeus\\Pradeesh\\Personal\\viewMRSK\\BlazeDemoProject-master\\BlazeDemoProject\\src\\main\\java\\com\\bd\\test\\config\\config.properties");
			prop.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\shettyp\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\\\Work_Amadeus\\\\Pradeesh\\\\Selenium_Training\\\\softwares\\\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}
}
