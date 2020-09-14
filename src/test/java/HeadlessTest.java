package ac;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.junit.Test;
import org.junit.Assert;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class HeadlessTest {
	Logger log = LoggerFactory.getLogger(HeadlessTest.class);
 
	@Test
	public void HeadlessFirefoxDriverTest() throws IOException {
		System.out.println("Welcome to Maven World ....");
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");

                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");

		WebDriver driver = new FirefoxDriver(options);

		try {
 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.navigate().to("http://localhost:88");
			String pageTitle = driver.getTitle();
			log.info("Page opened: {}", pageTitle);
                	//Assert.assertTrue(pageTitle.contains("It Works"));

			if ( pageTitle.contains("Intellipaat")) {
				Assert.assertTrue(true);
			} else {
				try { Assert.fail("Failed to open website"); } catch(Exception oaf){}
			}
		} catch(Exception eek) {
			try { Assert.fail("Failed to open website"); } catch(Exception oaf){}
		} finally {
			log.info("Quitting driver");
			try { driver.quit(); } catch(Exception oaf){}
		}
	}
}
