import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

public class Alert1 {
	static WebDriver driver ;
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void script() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		driver.findElement(By.id("basicelements")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement alertLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Alert']")));
		js.executeScript("arguments[0].scrollIntoView(true)",alertLocator);
		alertLocator.click();
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		//alert.sendKeys("Anuja");
		alert.dismiss();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
