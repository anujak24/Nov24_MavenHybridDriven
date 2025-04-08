package anujaK.SeleniumCodes;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakeScreenShots {

	static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void takeScreenShot() {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMM_yyyy hh_mm_ ssss");
			String timeStamp = simpleDateFormat.format(date);
			String imageName = "image_" + timeStamp;

			File destPath = new File("./src/Screenshot/" + imageName + ".png"); 		

			FileUtils.copyFile(file, destPath);
			System.out.println(destPath.getAbsolutePath());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void script() {
		driver.get("https://javaconceptoftheday.com/java-exception-handling-cheat-sheet/");
		driver.findElement(By.xpath("acv"));// wrong xpath
		takeScreenShot();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			takeScreenShot();
			driver.quit();
			System.out.println("end");
		}
	}
}
