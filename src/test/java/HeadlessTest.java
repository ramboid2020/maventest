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
		System.out.println("Welcome to Maven World");
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");

                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");

		WebDriver driver = new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to("https://www.google.com/");
		String pageTitle = driver.getTitle();
		log.info("Page opened: {}", pageTitle);
/** 
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copying the file into /screenshots directory
		FileUtils.copyFile(scrFile, new File("output/screenshots/homepage.png"));
 
		Assert.assertTrue(pageTitle.contains("Trusted Advisors for E-Commerce | Avenue Code"));
*/
		log.info("Quitting driver");
		driver.quit();
	}
}
