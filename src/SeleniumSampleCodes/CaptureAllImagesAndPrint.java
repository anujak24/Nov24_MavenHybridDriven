package anujaK.SeleniumCodes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CaptureAllImagesAndPrint {
	static WebDriver driver;
	@BeforeMethod
 	public void setUp() {
 		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
 		driver.manage().window().maximize();
 	}
	@Test
 	public void captureScreenShot() {
	 List<WebElement> listofImages = driver.findElements(By.xpath("//img"));
	 for(WebElement e :listofImages) {
		System.out.println(e.getAttribute("src")) ;
	 }
 	}
}
